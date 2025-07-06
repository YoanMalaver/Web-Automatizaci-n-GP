package utils;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleVisionOCR {

    static Dotenv dotenv = Dotenv.load();
    static String credentialsPath = dotenv.get("GOOGLE_CREDENTIALS_PATH");

    public static String detectText(String filePath) throws IOException {

        List<AnnotateImageRequest> requests = new ArrayList<>();
        ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));
        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);
        String texto = "";

        // 🔐 Ruta absoluta a tu archivo JSON de credenciales


        // Configurar las credenciales desde el archivo
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(credentialsPath));
        ImageAnnotatorSettings settings = ImageAnnotatorSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build();

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create(settings)) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                    return null;
                }
                texto = res.getTextAnnotationsList().get(0).getDescription();
            }
        }

        return texto;
    }

    public static void main(String[] args) throws IOException {
        String defaultDownloadFolderPath = DownloadHelper.getDefaultDownloadFolderPath();
        String texto = detectText(defaultDownloadFolderPath + "\\voucher.png");
        //System.out.println(defaultDownloadFolderPath + "\\voucher.png");
        System.out.println(texto);
    }
}




