public class DischargeRecord extends TreatmentRequest {

    private long dischargeTime;
    private DischargeRecord nextDischargeRecord;

    public DischargeRecord(int id, String name, int severity, int age, boolean vip, TreatmentRequest treatedPatient) {

        super(id, name, severity, age, vip);

        this.setEmergency(treatedPatient.isEmergency());
        this.setArrivalTime(treatedPatient.getArrivalTime());
        this.setPriorityScore(treatedPatient.getPriorityScore());

        this.setDischargeTime(System.currentTimeMillis());
        this.setNextDischargeRecord(null);
    }



    public String dischargeINFO() {
        return "id: " + getId() + " | name: " + getName() + " | discharged at: " + getDischargeTime();
    }



    public long getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(long dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    public DischargeRecord getNextDischargeRecord() {
        return nextDischargeRecord;
    }

    public void setNextDischargeRecord(DischargeRecord nextDischargeRecord) {
        this.nextDischargeRecord = nextDischargeRecord;
    }
}
