package WeekOneExercisee;

public class ContinueAndBreak {
    public static void main(String[] args) {
        System.out.println("Day so can tim la: ");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println("\nDay so can tim la: ");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        outerFor: for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 6; j++) {
                if(i== 1 && j == 4) {
                    break outerFor;
                }
                System.out.print(j + " ");
            }
        }
    }
}
