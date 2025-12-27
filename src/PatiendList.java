// We will use the LinkedList structure when creating the patient list because it is more efficient in systems that require constant
    //addition and removal. If we were going to make long lists with little change, we would use an ArrayList.
public class PatiendList {

    private Patient head;


    public void add(Patient newPatient) {

        // if list is empty
        if (head == null) {
            head = newPatient;
            return;
        }

        //list is not empty
        Patient current = head;

        while (current.getNextPatient() != null) {
            current = current.getNextPatient();
        }

        current.setNextPatient(newPatient);
    }


    public void remove(int id) {

        // list is empty
        if (head == null) {
            System.out.println("list is empty.");
            return;
        }

        // remove first patient
        if (head.getId() == id) {
            Patient removedPatient = head;
            head = head.getNextPatient();

            System.out.println("the patient named " + removedPatient.getName() + " (id:  " + removedPatient.getId() + ") has been deleted") ;
            return;
        }

        // remove in list
        Patient current = head;
        Patient before_current = null;

        while (current != null && current.getId() != id) {
            before_current = current;
            current = current.getNextPatient();
        }

        Patient removedPatient = current ;
        if (current != null) {
            before_current.setNextPatient(current.getNextPatient());
            System.out.println("the patient named " + removedPatient.getName() + " (id:  " + removedPatient.getId() + ") has been deleted");
        } else {
            System.out.println("patient not found.");
        }
    }



    public Patient find(int id) {

        Patient current = head;

        while (current != null) {
            if (current.getId() == id) {
                System.out.println("patient found: " + current.getName() + " (ID: " + current.getId() + ")");
                return current;
            }

            current = current.getNextPatient();
        }
        System.out.println("patient not found.");
        return null;
    }



    public void printList() {

        Patient current = head;

        if (current == null) {
            System.out.println("patient list is empty.");
            return;
        }

        System.out.println("--- Patient List ---");
        while (current != null) {
            System.out.println(current.patINFO());
            current = current.getNextPatient();
        }
    }
}
