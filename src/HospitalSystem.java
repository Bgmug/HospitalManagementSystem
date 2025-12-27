import java.util.HashMap;

public class HospitalSystem {

    private PatiendList patientList;
    private TreatmentQueue treatmentQueue;
    private DischargeStack dischargeStack;
    private HashMap<Integer, Patient> patientHashMap;

    public HospitalSystem() {
        patientList = new PatiendList();
        treatmentQueue = new TreatmentQueue();
        dischargeStack = new DischargeStack();
        patientHashMap = new HashMap<>();
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
        patientHashMap.put(patient.getId(), patient);
    }

    public void addTreatmentRequest(int patientId, boolean emergency) {

        Patient patient = patientHashMap.get(patientId);

        if (patient == null) {
            System.out.println("patient not found.");
            return;
        }

        TreatmentRequest request = new TreatmentRequest(patient, emergency);
        treatmentQueue.enqueue(request);
    }



    public void processTreatment() {

        TreatmentRequest treated = treatmentQueue.dequeue();

        if (treated == null) {
            System.out.println("no patients waiting.");
            return;
        }

        DischargeRecord record = new DischargeRecord(
                treated.getId(),
                treated.getName(),
                treated.getSeverity(),
                treated.getAge(),
                treated.isVip(),
                treated
        );

        dischargeStack.push(record);
    }



    public void sortTreatmentQueue() {

        if (treatmentQueue == null || treatmentQueue.size() <= 1) {
            return;
        }

        treatmentQueue = mergeSort(treatmentQueue);

        System.out.println("--- Sorted Treatment queue by priority ---");
        treatmentQueue.printQueue();
    }



    private TreatmentQueue mergeSort(TreatmentQueue queue) {

        if (queue.size() <= 1) {
            return queue;
        }

        TreatmentQueue left = new TreatmentQueue();
        TreatmentQueue right = new TreatmentQueue();

        int mid = queue.size() / 2;
        int index = 0;


        while (!queue.isEmpty()) {
            if (index < mid) {
                left.enqueue(queue.dequeue());
            } else {
                right.enqueue(queue.dequeue());
            }
            index++;
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }



    private TreatmentQueue merge(TreatmentQueue q1, TreatmentQueue q2) {

        TreatmentQueue result = new TreatmentQueue();

        while (!q1.isEmpty() && !q2.isEmpty()) {

            TreatmentRequest r1 = q1.getFront();
            TreatmentRequest r2 = q2.getFront();

            if (isHigherPriority(r1, r2)) {
                result.enqueue(q1.dequeue());
            } else {
                result.enqueue(q2.dequeue());
            }
        }

        while (!q1.isEmpty()) {
            result.enqueue(q1.dequeue());
        }

        while (!q2.isEmpty()) {
            result.enqueue(q2.dequeue());
        }

        return result;
    }



    private boolean isHigherPriority(TreatmentRequest a, TreatmentRequest b) {

        // priority order
        if (a.getPriorityScore() != b.getPriorityScore()) {
            return a.getPriorityScore() > b.getPriorityScore();
        }


        return a.getOrder() < b.getOrder();
    }


    public void printSystemState() {

        System.out.println("  ");
        System.out.println("  ");
        System.out.println("---------- HOSPITAL SYSTEM ----------");
        System.out.println("  ");

        System.out.println("----- Patient List -----");
        patientList.printList();

        System.out.println("----- Treatment Queue -----");
        treatmentQueue.printQueue();

        System.out.println("----- Discharge Stack -----");
        dischargeStack.printStack();
    }



    public PatiendList getPatientList() {
        return patientList;
    }

    public void setPatientList(PatiendList patientList) {
        this.patientList = patientList;
    }

    public TreatmentQueue getTreatmentQueue() {
        return treatmentQueue;
    }

    public void setTreatmentQueue(TreatmentQueue treatmentQueue) {
        this.treatmentQueue = treatmentQueue;
    }

    public DischargeStack getDischargeStack() {
        return dischargeStack;
    }

    public void setDischargeStack(DischargeStack dischargeStack) {
        this.dischargeStack = dischargeStack;
    }

    public HashMap<Integer, Patient> getPatientMap() {
        return patientHashMap;
    }

    public void setPatientMap(HashMap<Integer, Patient> patientMap) {
        this.patientHashMap = patientMap;
    }



}
