public class DischargeStack {

    private DischargeRecord top;
    private int stack_size;

    public DischargeStack() {
        this.top = null;
        this.stack_size = 0;
    }

    //adding
    public void push(DischargeRecord record) {

        if (record == null) {
            System.out.println("cannot push, null record");
            return;
        }

        record.setNextDischargeRecord(top);
        top = record;
        stack_size++;

        System.out.println("the patient " + record.getName() + " (id: " + record.getId() + ") is discharged.");
    }


    //removing
    public DischargeRecord pop() {

        if (top == null) {
            System.out.println("discharge stack is empty");
            return null;
        }

        DischargeRecord removed = top;

        top = top.getNextDischargeRecord();

        removed.setNextDischargeRecord(null);

        stack_size--;

        System.out.println("removed from discharge stack -> " + removed.getName() + " (id: " + removed.getId() + ")");

        return removed;
    }



    public DischargeRecord peek() {
        return top;
    }



    public int size() {
        return stack_size;
    }



    public boolean isEmpty() {
        return top == null;
    }



    public void printStack() {

        System.out.println("--- Discharge Record ---");

        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }



        DischargeRecord current = top;
        while (current != null) {
            System.out.println(current.getName() + " | discharged at: " + current.getDischargeTime());current = current.getNextDischargeRecord();

        }

        System.out.println("total discharged patients: " + stack_size);

    }



}
