package actions;

import java.util.Random;

public class RandomNumGenerator {
    public static String generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomDigit = random.nextInt(10); // Genera un dígito aleatorio entre 0 y 9
            number.append(randomDigit);
        }
        return number.toString();
    }
}
