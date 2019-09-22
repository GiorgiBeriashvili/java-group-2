import java.util.Scanner;

public class Exercise_04 {
    /*
     * შეიტანეთ სამნიშნა მთელი რიცხვი, დაბეჭდეთ რიცხვის ციფრები ცალ-ცალკე ხაზზე.
     * */
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a three-digit integer: ");
        int integer = scanner.nextInt();

        String digits = String.valueOf(integer);

        for (int index = 0; index < digits.length(); index++) {
            System.out.println(digits.charAt(index));
        }
    }
}
