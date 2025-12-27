import java.util.Scanner;
// created the patient class that will hold the patient information.
public class Patient {

    // defining patient characters.
    private int id;          // patient's identification number
    private String name;     // patient's name
    private int severity;    // severity of the disease
    private int age;         // patient's age
    private boolean vip;
    private Patient nextPatient; //patient referance

    //constructor for default values.
    public Patient(){
        this.setId(0);
        this.setName("unknown");
        this.setSeverity(0);
        this.setAge(0);
        this.setVip(isVip());
        this.setNextPatient(null);

    }

    Scanner input = new Scanner(System.in);
    // created the parameterized constructor
    public Patient(int id, String name, int severity, int age, boolean vip){
        this.setId(id);
        this.setName(name);                 //this.id = id variable in the class
        this.setSeverity(severity);         //id = parameter (assigning the parameters to the class variables)
        this.setAge(age);
        this.vip = vip;
        this.setNextPatient(null);

        //severity control block
        boolean control = true;
        while(control){
            if(severity > 10 || severity < 1){
                System.out.println("invalid severity, (severity between 1-10.)");
                setSeverity(input.nextInt());
            }else{
                control = false;
            }
        }
    }

    // be able to see the patient object on the screen.
    public  String patINFO(){
        return ("id:" + getId() + " name:" + getName() + " age:" + getAge() + " severity:" + getSeverity() + "vip: " + vip);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public Patient getNextPatient() {
        return nextPatient;
    }

    public void setNextPatient(Patient nextPatient) {
        this.nextPatient = nextPatient;
    }
}


