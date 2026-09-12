import java.util.Scanner;

public class ProductInventoryCsvParser {

    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV line: ");
        String input = sc.nextLine();

        parseInventoryRecord(input);

        sc.close();
    }
}
