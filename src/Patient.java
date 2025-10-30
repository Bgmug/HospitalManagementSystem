// created the patient class that will hold the patient information.
public class Patient {

    // defining patient characteristics.
    int id;          // patient's identification number
    String name;     // patient's name
    int severity;    // severity of the disease
    int age;         // patient's age

    // created the constructor
    public Patient(int id, String name, int severity, int age){
        this.id = id;
        this.name = name;                 //this.id = id variable in the class
        this.severity = severity;         //id = parameter (assigning the parameters to the class variables)
        this.age = age;
    }

    // be able to see the patient object on the screen.
    public  String patINFO(){
        return ("ID:" + id + " NAME:" + name + " AGE:" + age + " SEVERİTY:" + severity);
    }

}
