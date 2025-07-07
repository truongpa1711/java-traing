package Interface_Abstract.student_management;

public class Student implements IStudent {
    private static int count=0;
    private int id;
    private String fullName;
    private String DateofBirth;
    private String Native;
    private String Class;
    private String PhoneNo;
    private int Mobile;

    public Student(){
        this.id=++count;
    }

    public void setFullName(String fullName){
        this.fullName=fullName;
    }
    public void setDateofBirth(String DateofBirth){
        this.DateofBirth=DateofBirth;
    }
    public void setNative(String Native){
        this.Native=Native;
    }
    public void setClass(String Class){
        this.Class=Class;
    }
    public void setPhoneNo(String PhoneNo){
        this.PhoneNo=PhoneNo;
    }
    public void setMobile(int Mobile){
        this.Mobile=Mobile;
    }
    public String getFullName(){
        return fullName;
    }

    @Override
    public void Display() {
        System.out.println("ID: "+id);
        System.out.println("Name: " + fullName);
        System.out.println("Date of Birth: " + DateofBirth);
        System.out.println("Native: " + Native);
        System.out.println("Class: " + Class);
        System.out.println("PhoneNo: " + PhoneNo);
        System.out.println("Mobile: " + Mobile);
    }

}
