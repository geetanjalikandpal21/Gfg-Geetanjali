import java.util.Scanner;

public class DollarSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first dollar and cent values
        System.out.println("Enter the first dollar amount:");
        int dollar1 = scanner.nextInt();
        System.out.println("Enter the first cent amount:");
        int cent1 = scanner.nextInt();

        // Input for the second dollar and cent values
        System.out.println("Enter the second dollar amount:");
        int dollar2 = scanner.nextInt();
        System.out.println("Enter the second cent amount:");
        int cent2 = scanner.nextInt();

        // Calculate the total dollars and cents
        int totalDollars = dollar1 + dollar2;
        int totalCents = cent1 + cent2;

        // Adjust cents if it exceeds 100
        if (totalCents >= 100) {
            totalDollars += totalCents / 100;
            totalCents %= 100;
        }

        // Print the result
        System.out.println("Total amount: " + totalDollars + " dollars and " + totalCents + " cents");
    }
}
