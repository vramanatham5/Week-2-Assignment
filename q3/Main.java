import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String csvLine = scanner.nextLine();
        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + fields[0]
                    + " | SKU: " + fields[1]
                    + " | Qty: " + fields[2]);
        }
    }
}
