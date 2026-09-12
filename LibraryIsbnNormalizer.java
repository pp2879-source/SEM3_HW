import java.util.Scanner;

public class LibraryIsbnNormalizer {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return publisherCode + rest;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);

        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = year + catalogNumber;
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: code body must be digits";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(publisherCode).append("] ");
        sb.append("YEAR: ").append(year);
        sb.append(" | CATALOG: ").append(catalogNumber);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ISBN-style code: ");
        String raw = sc.nextLine();

        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);

        System.out.println(result);

        sc.close();
    }
}
