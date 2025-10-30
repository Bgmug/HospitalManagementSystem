public class Main {
    public static void main(String[] args) {

        //patient list
        PatiendList hospitalList = new PatiendList();

        //patients
        int[] ids = {1000, 1001, 1002, 1003, 1004}; // ID'S
        String[] names = {"Zeynep Uğur", "Özgür uğur", "Mustafa Yıldırım", "Begüm Uğur", "Mustafa Kemal Binli"};
        int[] severities = {5, 7, 1, 3, 1};
        int[] ages = {49, 48, 22, 21, 25};

        // Loop to add patients
        for (int i = 0; i < ids.length; i++) {

            int id = ids[i];
            String name = names[i];
            int severity = severities[i];
            int age = ages[i];

            //We are checking the information
            if (name.isEmpty()) {
                System.out.println("Error: Name information is missing. Patient was not added.");
                continue; // if there is missing information, do not add that patient, move on to the next patient
            }
            if (severity <= 0 || severity > 10) {
                System.out.println("Error: Disease severity is incorrect. Patient was not added.");
                continue;
            }
            if (age <= 0) {
                System.out.println("Error: Age is incorrect. Patient was not added.");
                continue;
            }

            //If there is no problem, create the new patient.
            hospitalList.addPatiend(new Patient(id, name, severity, age));
        }

        // I am printing the initial list for control
        System.out.println("\nInitial List:");
        hospitalList.printList();

        //Remove one by ID
        System.out.println("\npatient deletion process....");
        int removeID = 1001;
        hospitalList.removePatient(removeID);

        //Search for one by ID
        System.out.println("\npatient search process....");
        int searchID = 1004;
        Patient found = hospitalList.findPatient(searchID);
        if (found != null) {
            System.out.println("patient found: ID=" + found.id + ", name=" + found.name + ", severity=" + found.severity + ", age=" + found.age);
        } else {
            System.out.println("paintent with ID " +searchID+ "not found.");
        }

        // Print the final list
        System.out.println("\nFinal List:");
        hospitalList.printList();


        System.out.println("------------------------------------------------------------------");

        TreatmentQueue queue = new TreatmentQueue();

        //8 treatment requests are being added (enqueue)
        for (int i = 1; i <= 8; i++) {
            queue.enqueue(new TreatmentRequest(100 + i)); // patient ID's
        }

        // 3 patients are being discharged in an ordinary manner (dequeue)
        System.out.println("\n3 patients are discharged as ordinary");
        for (int i = 0; i < 3; i++) {
            queue.dequeue();
        }

        //The remaining patients are being printed
        System.out.println("\nremaining queue status");
        queue.printQueue();


        System.out.println("------------------------------------------------------------------");










    }
}