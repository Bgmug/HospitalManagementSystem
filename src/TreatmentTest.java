public class TreatmentTest {
    public static void main(String[] args) {

        Patient p1 = new Patient(1001, "begüm uğur        ", 8, 21, false);
        Patient p2 = new Patient(1005, "mustafa yıldırım  ", 4, 22, false);
        Patient p3 = new Patient(1009, "ahmet yılmaz      ", 9, 40, false);
        Patient p4 = new Patient(1004, "müge uğur         ", 5, 10, true);
        Patient p5 = new Patient(1003, "latife pembe      ", 3, 55, false);
        Patient p6 = new Patient(1008, "arda vapur        ", 1, 72, true);
        Patient p7 = new Patient(1006, "mavi mor          ", 10, 30, false);
        Patient p8 = new Patient(1002, "cansu tekin       ", 2, 20, false);


        TreatmentQueue queue = new TreatmentQueue();

        TreatmentRequest t1 = new TreatmentRequest(p1, false);
        TreatmentRequest t2 = new TreatmentRequest(p2, true);
        TreatmentRequest t3 = new TreatmentRequest(p3, false);
        TreatmentRequest t4 = new TreatmentRequest(p4, true);
        TreatmentRequest t5 = new TreatmentRequest(p5, false);
        TreatmentRequest t6 = new TreatmentRequest(p6, true);
        TreatmentRequest t7 = new TreatmentRequest(p7, false);
        TreatmentRequest t8 = new TreatmentRequest(p8, false);

        queue.enqueue(t1);
        queue.enqueue(t2);
        queue.enqueue(t3);
        queue.enqueue(t4);
        queue.enqueue(t5);
        queue.enqueue(t6);
        queue.enqueue(t7);
        queue.enqueue(t8);

        System.out.println("first queue");
        queue.printQueue();
        System.out.println("---------------------------------------------------");

        System.out.println("patients going into treatment: ");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("---------------------------------------------------");
        System.out.println("last queue");
        queue.printQueue();

    }
}
