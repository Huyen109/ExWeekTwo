package WeekTwoExercise;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectMain {
    static Subject subject = new Subject();

    public static void main(String[] args) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("Subject Management System\n" +
                    "-------------------------------------\n" +
                    "1. Append new subject\n" +
                    "2. Update subject\n" +
                    "3. Display the information of subject\n" +
                    "4. Enrol new student\n" +
                    "5. Unenrol student\n" +
                    "Your choice (1-4, other to quit): ");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();

            switch (n) {
                case 1:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Nhap vao so luong mon hoc muon them: ");
                    int m = scanner.nextInt();
                    subject.createSubject(m);
                    break;
                case 2:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Nhap vao ma mon hoc: ");
                    String subjectID = scanner3.nextLine();
                    subject.updateSubject(subjectID);
                    break;
                case 3:
                    subject.showListSubject();
                    break;
                case 4:
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Nhap vao ma mon hoc: ");
                    String subjectID1 = scanner4.nextLine();
                    subject.enrolStudent(subjectID1);
                    break;
                case 5:
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("Nhap vao ma mon hoc: ");
                    String subjectID2 = scanner5.nextLine();
                    subject.unenrolStudent(subjectID2);
                    break;
            }

        }

    }
}
