public class TreatmentQueue {
    private TreatmentRequest front; //first entry
    private TreatmentRequest back;  //last entry
    private int size;

    public TreatmentQueue() {
        this.setFront(null);
        this.back = null;
        this.size = 0;
    }




    public boolean isEmpty() {
        return getFront() == null;
    }



    // FIFO
    public void enqueue(TreatmentRequest request) {

        // if queue is empty
        if (isEmpty()) {
            setFront(back = request);
        } else {
            back.setNextTreatmentRequest(request);
            back = request;
        }size++;

        //System.out.println("treatment request added -> " + request.getName() + " | Priority: " + request.getPriorityScore());
    }



    public TreatmentRequest dequeue() {

        TreatmentRequest into_treatment = getFront();

        if (isEmpty()) {
            System.out.println("patient row is empty.");
            return null;
        }

        setFront(getFront().getNextTreatmentRequest());

        if (getFront() == null) {
            back = null;
        }

        into_treatment.setNextTreatmentRequest(null); //disconnect
        size--;

        //System.out.println("treatment request removed -> " + into_treatment.getName() + " | priority: " + into_treatment.getPriorityScore());
        return into_treatment;
    }



    public int size() {
        return size;
    }



    public void printQueue() {

        if (isEmpty()) {
            System.out.println("patient row is empty.");
            return;
        }

        System.out.println("------ Patient Row ------");

        TreatmentRequest current = getFront();
        while (current != null) {
            System.out.println(current.treatmentINFO());
            current = current.getNextTreatmentRequest();
        }

        System.out.println("total requests: " + size);
    }

    public TreatmentRequest getFront() {
        return front;
    }

    public void setFront(TreatmentRequest front) {
        this.front = front;
    }
}

