package WeekTwoExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectEx2Main {
    public static void main(String[] args) {
        SubjectEx2 subjectEx2 = new SubjectEx2();

        List<SubjectEx2> subjectEx2List = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nguoi dung co muon tao mon hoc khong? Y: tiep tuc");
        String inputYN = scanner.nextLine();

        if (inputYN.equalsIgnoreCase("Y")) {

            System.out.println("Nhap ten mon hoc: ");
            subjectEx2.setSubjectName(scanner.nextLine());
            System.out.println("Nhap ma mon hoc: ");
            subjectEx2.setSubjectId(scanner.nextLine());
            System.out.println("Nhap so luong dki max: ");
            subjectEx2.setNumberOfRegistryMax(scanner.nextInt());
            System.out.println("Nhap so luong dki hien tai: ");
            subjectEx2.setNumberOfRegistryCurrent(scanner.nextInt());

            subjectEx2List.add(subjectEx2);
        }

        System.out.println("Nguoi dung co muon dki them sv khong? Y: tiep tuc");
        String inputYN1 = scanner.nextLine();
        scanner.nextLine();
        if (inputYN1.equalsIgnoreCase("Y")) {
            subjectEx2.enrolStudent();
        } else
            subjectEx2.displaySubjectInfo();

        System.out.println("Nguoi dung co muon tiep tuc khong? Y: tiep tuc");
        String inputYN2 = scanner.nextLine();
        scanner.nextLine();
        if (inputYN2.equalsIgnoreCase("Y")) {
            subjectEx2.unEnrolStudent();
        } else
            subjectEx2.displaySubjectInfo();
    }
}


