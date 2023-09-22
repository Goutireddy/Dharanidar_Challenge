import java.util.Scanner;
import java.util.regex.*;

public class CreditCardValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        while (n-- > 0) {
            String cardNumber = scanner.nextLine();
            if (isValidCreditCard(cardNumber)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
        scanner.close();
    }

    public static boolean isValidCreditCard(String cardNumber) {
        //regex pattern for a valid credit card
        String regex = "^(4|5|6)(\\d{3}-?\\d{4}-?\\d{4}-?\\d{4}|\\d{15})$";

        // Check if the input matches the regex pattern
        if (Pattern.matches(regex, cardNumber)) {
            // Remove hyphens and check for consecutive repeated digits
            String digitsOnly = cardNumber.replaceAll("-", "");
            return !hasConsecutiveRepeatedDigits(digitsOnly);
        }
        return false;
    }

    public static boolean hasConsecutiveRepeatedDigits(String cardNumber) {
        for (int i = 0; i < cardNumber.length() - 3; i++) {
            char currentDigit = cardNumber.charAt(i);
            boolean isRepeated = true;
            for (int j = i + 1; j < i + 4; j++) {
                if (cardNumber.charAt(j) != currentDigit) {
                    isRepeated = false;
                    break;
                }
            }
            if (isRepeated) {
                return true;
            }
        }
        return false;
    }
}
