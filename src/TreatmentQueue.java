public class TreatmentQueue {

    private class Node{  //Each Node holds a TreatmentRequest.
        TreatmentRequest data;  // There is a treatment request at each Node
        Node next;              // connection to the next node (The next variable indicates the next request.)

        Node(TreatmentRequest data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;  //head of the queue (the first patient)
    private Node rear;   //end of the queue (the last patient to arrive)
    private int size;    // queue size



    //add treatment
    public void enqueue(TreatmentRequest request) {
        Node newNode = new Node(request);   // New Node
        if (rear == null) {
            front = rear = newNode; //first element is both the head and the tail.
        } else {
            rear.next = newNode; // The old last node connects to the new node
            rear = newNode; // The new Node is now the end of the queue
        }
        size++; // The queue list element, and therefore the size, increases by 1.
        System.out.println("Patient ID " + request.patientId + " adding queue.");
    }




    //dequeue
    public TreatmentRequest dequeue() {
        if (front == null) {
            System.out.println("The queue is currently empty. There are no patients to be discharged.");
            return null;
        }

        TreatmentRequest removed = front.data; // FIFO so, We will proceed with the first patient who arrives.
        front = front.next;                    //Move the head node to the next node
        if (front == null) rear = null;        //If the queue is empty, reset the rear as well
        size--;

        System.out.println("patient ID " + removed.patientId + "removed.");
        return removed;
    }


    //return the current length of the queue
    public int size() {
        return size;
    }



    //Print all patients in the queue (It traverses all the nodes from beginning to end.)
    public void printQueue() {
        if (front == null) {
            System.out.println("queue is empty");
            return;
        }

        System.out.println("\nTreatment Queue");
        Node current = front;  // Start over
        while (current != null) {
            System.out.println(current.data.treatmentINFO());
            current = current.next;
        }
        System.out.println("Total number of patients: " + size);
    }


}

