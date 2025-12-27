public class DischargeTest {

    public static void main(String[] args) {

        // Fake patients
        Patient p1 = new Patient(1001, "begüm uğur        ", 8, 21, false);
        Patient p2 = new Patient(1005, "mustafa yıldırım  ", 4, 22, false);
        Patient p3 = new Patient(1009, "ahmet yılmaz      ", 9, 40, false);
        Patient p4 = new Patient(1004, "müge uğur         ", 5, 10, true);
        Patient p5 = new Patient(1003, "latife pembe      ", 3, 55, false);
        Patient p6 = new Patient(1008, "arda vapur        ", 1, 72, true);
        Patient p7 = new Patient(1006, "mavi mor          ", 10, 30, false);
        Patient p8 = new Patient(1002, "cansu tekin       ", 2, 20, false);


        // Fake treatment requests
        TreatmentRequest t1 = new TreatmentRequest(p1, false);
        TreatmentRequest t2 = new TreatmentRequest(p2, true);
        TreatmentRequest t3 = new TreatmentRequest(p3, false);
        TreatmentRequest t4 = new TreatmentRequest(p4, true);
        TreatmentRequest t5 = new TreatmentRequest(p5, false);
        TreatmentRequest t6 = new TreatmentRequest(p6, true);
        TreatmentRequest t7 = new TreatmentRequest(p7, false);
        TreatmentRequest t8 = new TreatmentRequest(p8, false);

        // Create discharge records
        DischargeRecord r1 = new DischargeRecord(1001, p1.getName(), 2, 21, true, t1);
        DischargeRecord r2 = new DischargeRecord(1005, p2.getName(), 6, 29, false, t2);
        DischargeRecord r3 = new DischargeRecord(1009, p3.getName(), 4, 32, false, t3);
        DischargeRecord r4 = new DischargeRecord(1004, p4.getName(), 3, 51, true, t4);
        DischargeRecord r5 = new DischargeRecord(1003, p5.getName(), 1, 65, false, t5);
        DischargeRecord r6 = new DischargeRecord(1008, p6.getName(), 1, 72, true, t6);
        DischargeRecord r7 = new DischargeRecord(1006, p7.getName(), 10, 30, false, t7);
        DischargeRecord r8 = new DischargeRecord(1002, p8.getName(), 2, 20, false, t8);


        // Stack test
        DischargeStack stack = new DischargeStack();

        stack.push(r1);
        stack.push(r2);
        stack.push(r3);
        stack.push(r4);
        stack.push(r5);
        stack.push(r6);
        stack.push(r7);
        stack.push(r8);

        // Pop 3 patients
        stack.pop();
        stack.pop();
        stack.pop();

        // Final state
        stack.printStack();
    }

}