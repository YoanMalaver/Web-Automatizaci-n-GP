package utils;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadHelper {

    public static String getDefaultDownloadFolderPath() {
        // Obtener la carpeta de descargas predeterminada en Windows
        String userHome = System.getProperty("user.home");
        Path defaultDownloadsFolder = Paths.get(userHome, "Downloads");

        return defaultDownloadsFolder.toString();
    }

    public static void deleteFile(String rutaArchivo) {
        try {
            Path archivoPath = Paths.get(rutaArchivo);
            Files.deleteIfExists(archivoPath);
            System.out.println("Archivo eliminado: " + rutaArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de cómo usar la función getDefaultDownloadFolderPath
        String defaultDownloadFolderPath = DownloadHelper.getDefaultDownloadFolderPath();
        System.out.println("Carpeta de Descargas por Defecto: " + defaultDownloadFolderPath);
    }
}