package WeekTwoExercise;

public class SubjectEx1 {
    public String subjectId;
    public String subjectName;
    public int numberOfRegistryMax;
    public int numberOfRegistryCurrent;

    public void enrolStudent() {
        if (numberOfRegistryCurrent < numberOfRegistryMax) {
            numberOfRegistryCurrent += 1;
        } else System.out.println("Lop da du so luong, khong the dang ki");
    }

    public void unEnrolStudent() {
        if(numberOfRegistryCurrent != 0){
            numberOfRegistryCurrent -= 1;
        }else System.out.println("Khong the huy dang ki vi lop khong co SV");
    }

    public void displaySubjectInfo() {
        System.out.println("Ma mon: "+subjectId);
        System.out.println("Ten mon: "+subjectName);
        System.out.println("So luong dki hien tai: "+numberOfRegistryCurrent);
        System.out.println("So luong dki toi da: "+numberOfRegistryMax);
    }
}
