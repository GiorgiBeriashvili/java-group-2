import java.util.Scanner;

public class Exercise_06 {
    /*
     * შეიტანეთ ნებისმიერი მთელი რიცხვი, დაბეჭდეთ რიცხვის ციფრთა ჯამი.
     * */
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int integer = scanner.nextInt();

        if (integer < 0) {
            integer = Math.abs(integer);
        }

        int sum = 0;

        while (integer > 0) {
            sum = sum + integer % 10;
            integer /= 10;
        }

        System.out.println(sum);
    }
}
