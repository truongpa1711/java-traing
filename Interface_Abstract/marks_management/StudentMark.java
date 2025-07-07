package Interface_Abstract.marks_management;

public class StudentMark implements IStudentMark {
    private static int count = 0;
    private String FullName;
    private int ID;
    private String Class;
    private int Semester;
    private float AverageMark;
    private float[] SubjectMarkList;

    public void setFullName(String fullName) {
        FullName = fullName;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setClass(String Class) {
        this.Class = Class;
    }
    public void setSemester(int Semester) {
        this.Semester = Semester;
    }
    public void setSubjectMarkList(float[] SubjectMarkList) {
        this.SubjectMarkList = SubjectMarkList;
    }
    public StudentMark(){
        this.ID = count++;
    }
    @Override
    public void Display() {
        System.out.println("ID: "+ID);
        System.out.println("Full Name: " + FullName);
        System.out.println("Class: " + Class);
        System.out.println("Semester: " + Semester);
        System.out.print("List mark: ");
        for (int i = 0; i < SubjectMarkList.length; i++) {
            System.out.print(SubjectMarkList[i]);
            System.out.print(", ");
        }
        System.out.println();
        System.out.println("AverageMark: " + AverageMark);
    }

    public void AveCal(){
        float sum=0;
        for (int i=0;i<SubjectMarkList.length;i++){
            sum+=SubjectMarkList[i];
        }
        AverageMark=(float)sum/SubjectMarkList.length;
    }
}
