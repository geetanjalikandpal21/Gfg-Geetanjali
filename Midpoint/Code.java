import java.util.Scanner;
public class Midpoint
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coordinates of the first endpoint (x1, y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter the coordinates of the second endpoint (x2, y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // Calculate the midpoint
        double midX = (x1 + x2) / 2;
        double midY = (y1 + y2) / 2;

        // Display the midpoint
        System.out.println("The midpoint of the line is at (" + midX + ", " + midY + ")");
        scanner.close();
    }
}
