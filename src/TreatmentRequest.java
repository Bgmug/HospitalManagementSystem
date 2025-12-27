public class TreatmentRequest extends Patient {

    private long arrivalTime;   //the time when your request hits the system in milliseconds
    private boolean emergency;
    private int priorityScore;

    private static long orderCounter = 0;
    private long order;

    private TreatmentRequest nextTreatmentRequest ;


    public TreatmentRequest() {
        super();
        this.setEmergency(false);
        this.setPriorityScore(0);
        this.setArrivalTime(System.currentTimeMillis());
        this.setNextTreatmentRequest(null);

        calculatePriority();
    }

    public TreatmentRequest(int id, String name, int severity, int age, boolean vip) {

        super(id, name, severity, age, vip);
    }


    public TreatmentRequest(Patient patient, boolean emergency) {
        super(    patient.getId(),
                  patient.getName(),
                  patient.getSeverity(),
                  patient.getAge(),
                  patient.isVip()           );

        this.setEmergency(emergency);
        this.setArrivalTime(System.currentTimeMillis());
        this.setNextTreatmentRequest(null);

        this.setOrder(orderCounter++);

        calculatePriority();
    }


    private void calculatePriority() {
        int score = 0;

        if (isVip()) {score += 30;}
        if (isEmergency()) {score += 50;}

        this.setPriorityScore(score);
    }

    public String treatmentINFO() {
        return "id: " + getId() + " | name: " + getName() + " | vip: " + isVip() + " | emergency: " + isEmergency() + " | priority score: " + getPriorityScore() + " | arrival time: " + getArrivalTime();
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public int getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(int priorityScore) {
        this.priorityScore = priorityScore;
    }

    public TreatmentRequest getNextTreatmentRequest() {
        return nextTreatmentRequest;
    }

    public void setNextTreatmentRequest(TreatmentRequest nextTreatmentRequest) {
        this.nextTreatmentRequest = nextTreatmentRequest;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }
}
