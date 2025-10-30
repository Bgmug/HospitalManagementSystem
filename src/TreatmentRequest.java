public class TreatmentRequest {
    int patientId;      //the patient's ID
    long arrivalTime;   //the time when your request hits the system in milliseconds

    //Constructor
    public TreatmentRequest(int patientId) {
        this.patientId = patientId; //patient ID is assigned
        this.arrivalTime = System.currentTimeMillis(); //It gets the time in milliseconds from the computer's clock.
    }

    public String treatmentINFO() {
        return "Patient ID:" + patientId + " arrival time:" + arrivalTime;
    }

}
