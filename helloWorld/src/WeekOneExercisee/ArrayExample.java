package WeekOneExercisee;

public class ArrayExample {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 10;
        int[] pointArray = new int[ARRAY_LENGTH];
        pointArray[0] = 100;
        System.out.println("Phan tu dau tien: " + pointArray[0]);
        System.out.println("Phan tu cuoi cung: " + pointArray[pointArray.length - 1]);
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            System.out.print(pointArray[i]+" ");
        }

    }
}
