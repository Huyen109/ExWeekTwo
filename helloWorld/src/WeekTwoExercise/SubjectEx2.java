package WeekTwoExercise;

public class SubjectEx2 {

    private String subjectId;
    private String subjectName;
    private int numberOfRegistryMax;
    private int numberOfRegistryCurrent;

    public String getSubjectId() {
        return subjectId;
    }

    public String setSubjectId(String subjectId) {
        this.subjectId = subjectId;
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String setSubjectName(String subjectName) {
        this.subjectName = subjectName;
        return subjectName;
    }

    public int getNumberOfRegistryMax() {
        return numberOfRegistryMax;
    }

    public int setNumberOfRegistryMax(int numberOfRegistryMax) {
        this.numberOfRegistryMax = numberOfRegistryMax;
        return numberOfRegistryMax;
    }

    public int getNumberOfRegistryCurrent() {
        return numberOfRegistryCurrent;
    }

    public int setNumberOfRegistryCurrent(int numberOfRegistryCurrent) {
        this.numberOfRegistryCurrent = numberOfRegistryCurrent;
        return numberOfRegistryCurrent;
    }

    public void enrolStudent() {
        if (numberOfRegistryCurrent < numberOfRegistryMax) {
            numberOfRegistryCurrent += 1;
            System.out.println("Dki thanh cong, so sinh vien hien tai: "+numberOfRegistryCurrent);
        } else System.out.println("Lop da du so luong "+numberOfRegistryCurrent+ ", khong the dang ki");
    }

    public void unEnrolStudent() {
        if(numberOfRegistryCurrent <= numberOfRegistryMax){
            numberOfRegistryCurrent -= 1;
            System.out.println("Huy dang ki thanh cong, so sinh vien hien tai: "+numberOfRegistryCurrent);
        }else if(numberOfRegistryCurrent == 0) {
            System.out.println("Khong the huy dang ki vi lop khong co SV");
        }
    }

    public void displaySubjectInfo() {
        System.out.println("Ma mon: "+subjectId);
        System.out.println("Ten mon: "+subjectName);
        System.out.println("So luong dki hien tai: "+numberOfRegistryCurrent);
        System.out.println("So luong dki toi da: "+numberOfRegistryMax);
    }
}
