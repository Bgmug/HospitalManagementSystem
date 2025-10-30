public class DischargeRecord {
    int patientId;        // The discharged patient's identification number
    long dischargeTime;   // Discharge time (in milliseconds)

    //Constructor
    public DischargeRecord(int patientId) {
        this.patientId = patientId;
        this.dischargeTime = System.currentTimeMillis();
    }

    // Method that returns patient discharge information
    public String dischargeINFO() {
        return "Patiend ID:" + patientId + " Discharge Time:" + dischargeTime;
    }
}
