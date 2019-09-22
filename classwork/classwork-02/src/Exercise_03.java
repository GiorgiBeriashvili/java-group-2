import java.util.Scanner;

public class Exercise_03 {
    /*
     * შეიტანეთ სამი მთელი რიცხვი, გამოიტანეთ მათი ჯამი და ნამრავლი.
     * */
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int firstInt = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int secondInt = scanner.nextInt();

        System.out.print("Enter the third integer: ");
        int thirdInt = scanner.nextInt();

        System.out.println(String.format("%d + %d + %d = %d", firstInt, secondInt, thirdInt, firstInt + secondInt + thirdInt));
        System.out.println(String.format("%d * %d * %d = %d", firstInt, secondInt, thirdInt, firstInt * secondInt * thirdInt));
    }
}
