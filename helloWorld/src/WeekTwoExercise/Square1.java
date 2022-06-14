package WeekTwoExercise;

import java.util.Scanner;

public class Square1{
    public static void main(String[] args) {
        System.out.println("Nhap vao canh hinh vuong: ");
        Scanner scanner = new Scanner(System.in);
        float edge = scanner.nextFloat();
        Square square1 = new Square(edge);
        square1.showInfo();
    }
}
