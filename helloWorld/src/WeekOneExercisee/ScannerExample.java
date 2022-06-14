package WeekOneExercisee;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println(name);
        System.out.println("Nhap tuoi: ");
        int age = scanner.nextInt();
        System.out.println("tuoi ban la: "+ age);
    }
}
