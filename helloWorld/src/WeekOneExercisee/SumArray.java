package WeekOneExercisee;

import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so luong phan tu mang: ");
        int n = scanner.nextInt();
        int[] pointArray = new int[n];
        System.out.print("Nhap cac phan tu cua mang la: ");
        for (int i =0; i < n; i++) {
            pointArray[i] = scanner.nextInt();
        }
        System.out.print("Cac phan tu cua mang la: ");
        for (int i = 0; i < n; i++) {
            System.out.print(pointArray[i] +" ");
        }
        int sum = 0;
        System.out.print("\nTong mang la: ");
        for (int i = 0; i < n; i++) {
            sum += pointArray[i];
        }
        System.out.print(sum);

    }
}
