import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine().trim();

        if (code.length() >= 3) {
            code = code.substring(0, 3).toUpperCase() + code.substring(3);
        }

        if (code.length() != 13) {
            System.out.println("Invalid: wrong length");
            return;
        }

        boolean validPublisher = true;
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                validPublisher = false;
                break;
            }
        }

        if (!validPublisher) {
            System.out.println("Invalid: non-letter publisher code");
            return;
        }

        boolean validBody = true;
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                validBody = false;
                break;
            }
        }

        if (!validBody) {
            System.out.println("Invalid: non-digit body");
            return;
        }

        StringBuilder display = new StringBuilder();
        display.append("[").append(code.substring(0, 3)).append("] YEAR: ")
                .append(code.substring(3, 7))
                .append(" | CATALOG: ")
                .append(code.substring(7));
        System.out.println(display);
    }
}
