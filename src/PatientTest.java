import java.util.Scanner;

public class PatientTest {

    public static void main(String[] args) {

        PatiendList patientS = new PatiendList();

        // add to normal
        Patient p1 = new Patient(1001, "begüm uğur", 8, 21, false);
        Patient p2 = new Patient(1005, "mustafa yıldırım", 4, 22, false);
        Patient p3 = new Patient(1009, "ahmet yılmaz", 9, 40, false);
        Patient p4 = new Patient(1004, "müge uğur", 5, 10, true);
        Patient p5 = new Patient(1003, "latife pembe", 3, 55, false);
        Patient p6 = new Patient(1008, "arda vapur", 1, 72, true);
        Patient p7 = new Patient(1006, "mavi mor", 10, 30, false);

        patientS.add(p1);
        patientS.add(p2);
        patientS.add(p3);
        patientS.add(p4);
        patientS.add(p5);
        patientS.add(p6);
        patientS.add(p7);

        System.out.println("initial patient list:");
        patientS.printList();


        System.out.println("------------------------------------------------");


        // add to scanner
        Scanner input = new Scanner(System.in);

        System.out.println("patient ID: ");
        int id = input.nextInt();
        input.nextLine(); //ChatGPT explained that it causes problems when you take a string after an int. That's why I added this line :(

        System.out.println("name: ");
        String name = input.nextLine();

        System.out.println("severity: ");
        int severity = input.nextInt();

        System.out.println("age: ");
        int age = input.nextInt();

        System.out.println("you are in vip patient chatagories? (true/false)");
        boolean vip = input.nextBoolean();

        Patient newPatient = new Patient(id, name, severity, age, vip);
        patientS.add(newPatient);


        System.out.println("add scanner patient list:");
        patientS.printList();

        System.out.println("------------------------------------------------");

        patientS.remove(1006);
        patientS.find(1005);

        System.out.println("final patient list:");
        patientS.printList();

    }
    //patients are kept on the heap as long as the program is running. (!!! do not forgot !!!)
}
