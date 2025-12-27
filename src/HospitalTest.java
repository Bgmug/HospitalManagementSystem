public class HospitalTest {
    public static void main(String[] args) {

        HospitalSystem system = new HospitalSystem();


        system.addPatient(new Patient(1000000006, "begüm uğur", 5, 30, false));
        system.addPatient(new Patient(1000000002, "mustafa yılmaz", 8, 45, false));
        system.addPatient(new Patient(1000000007, "müge uğur", 3, 60, true));
        system.addPatient(new Patient(1000000004, "zeynep uğur", 9, 22, false));
        system.addPatient(new Patient(1000000005, "cansu bahçivan", 2, 18, false));
        system.addPatient(new Patient(1000000001, "pelin ata", 7, 50, true));
        system.addPatient(new Patient(1000000003, "ahmet yılmaz", 4, 35, false));
        system.addPatient(new Patient(1000000008, "melike kızıltepe", 6, 28, false));
        system.addPatient(new Patient(1000000009, "özgür uğur", 10, 40, true));
        system.addPatient(new Patient(1000000010, "kamil aytuğ atmaca", 1, 65, false));


        system.addTreatmentRequest(1000000006, false);
        system.addTreatmentRequest(1000000002, false);
        system.addTreatmentRequest(1000000007, true);
        system.addTreatmentRequest(1000000004, true);
        system.addTreatmentRequest(1000000005, false);
        system.addTreatmentRequest(1000000001, true);
        system.addTreatmentRequest(1000000003, false);
        system.addTreatmentRequest(1000000008, false);
        system.addTreatmentRequest(1000000009, false);
        system.addTreatmentRequest(1000000010, false);


        system.sortTreatmentQueue();

        system.processTreatment();
        system.processTreatment();
        system.processTreatment();
        system.processTreatment();

        system.printSystemState();


    }


}
