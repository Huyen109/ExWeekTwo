package WeekTwoExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subject {

    private String subjectId;
    private String subjectName;
    private int numberOfRegistryMax;
    private int numberOfRegistryCurrent;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getNumberOfRegistryMax() {
        return numberOfRegistryMax;
    }

    public void setNumberOfRegistryMax(int numberOfRegistryMax) {
        this.numberOfRegistryMax = numberOfRegistryMax;
    }

    public int getNumberOfRegistryCurrent() {
        return numberOfRegistryCurrent;
    }

    public void setNumberOfRegistryCurrent(int numberOfRegistryCurrent) {
        this.numberOfRegistryCurrent = numberOfRegistryCurrent;
    }

    List<Subject> subjectList = new ArrayList<>();

    public void createSubject(int amountOfSubject){
        for (int i = 0; i < amountOfSubject; i++) {
            Subject subject = new Subject();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap subject ID: ");
            subject.setSubjectId(scanner.nextLine());
            System.out.println("Nhap subject Name: ");
            subject.setSubjectName(scanner.nextLine());
            System.out.println("Nhap so luong dki MAX: ");
            subject.setNumberOfRegistryMax(scanner.nextInt());
            subjectList.add(subject);
        }
    }

    public Subject searchSubjectID(String subjectID) {
        for (Subject subject : subjectList) {
            if (subject.getSubjectId().equals(subjectID)) {
                return subject;
            }
        }
        return null;
    }

    public Subject updateSubject(String subjectID){
        Subject subject = searchSubjectID(subjectID);
        if(subject == null){
            System.out.println("Khong tim thay subject");
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Thay doi subject Name: ");
            subject.setSubjectName(scanner.nextLine());
            System.out.println("Thay doi so luong Max: ");
            subject.setNumberOfRegistryMax(scanner.nextInt());
            System.out.println("Thay doi so luong hien tai: ");
            subject.setNumberOfRegistryCurrent(scanner.nextInt());
            return subject;
        }
        return null;
    }

    public void showListSubject(){
        System.out.println("Display information of Subject: ");
        for (Subject subject: subjectList) {
            System.out.println();
            subject.toStrings();
        }
    }

    public void enrolStudent(String subjectID){
        Subject subject = searchSubjectID(subjectID);
        if(subject == null){
            System.out.println("Khong tim thay subject");
            return;
        }
        subject.setNumberOfRegistryCurrent(subject.getNumberOfRegistryCurrent() + 1);
    }

    public void unenrolStudent(String subjectID){
        Subject subject = searchSubjectID(subjectID);
        if(subject == null){
            System.out.println("Khong tim thay subject");
            return;
        }
        subject.setNumberOfRegistryCurrent(subject.getNumberOfRegistryCurrent() - 1);
    }

    public void toStrings() {
        System.out.println("subjectId='" + subjectId +"\n"+
                "subjectName='" + subjectName +"\n"+
                "numberOfRegistryMax=" + numberOfRegistryMax +"\n"+
                "numberOfRegistryCurrent=" + numberOfRegistryCurrent);
    }
}
