package actions;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class CaptchaText {
    public String text (File captcha) {
        Tesseract tesseract = new Tesseract();
        try {
            return tesseract.doOCR(captcha);
        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error al procesar el captcha: " + e.getMessage());
            return "";
        }
    }
}