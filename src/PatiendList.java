// We will use the LinkedList structure when creating the patient list because it is more efficient in systems that require constant
    //addition and removal. If we were going to make long lists with little change, we would use an ArrayList.
public class PatiendList {

    // Each node holds patient information and the address of the next node.
    private class Node{ //It's private because we don't want others to change it.

        //  head → [data: hasta1 | next →] → [data: hasta2 | next →] → [data: hasta3 | null]
            //head: indicates the first box of the list (the first patient)
            //null: shows the end of the list
        Patient data;    //patient information
        Node next;       // address of the next node

        // constructor of the node
        Node(Patient data){
            this.data = data;  //the place where patient information is kept
            this.next = null;  //The node after the second patient arrives cannot be discussed.
        }

    }

    //Variable that will hold the head of the LinkedList
    private  Node head; //top of the list (first patient) (It's private because we don't want others to change it.)

    //the function we added to the patient
    public void  addPatiend(Patient p){

        // created a new node
        Node newNode = new Node(p); // With "new", an object is created in memory

        //if list's is empty
        if(head == null){
            head = newNode; // The first patient will be the one we add here.
            return;
        }

        // if list's is not empty (We need to go to the last node.)
        Node current = head; // starting from the beginning of the list...
        while (current.next != null) {    // current: represents the node that we are currently checking in the list
            current = current.next;  //... to the last elements
        }

        // Add the new node to the next of the last node
        current.next = newNode;
    }




    //the method we del. the patient (remove one by ID)
    public void removePatient(int id){

        // if list is empty...
        if(head == null){
            System.out.println("There is no patient to delete"); //... do nothing
            return;
        }

        //if the patient to be deleted is at the beginning
        if(head.data.id == id){   // if the id at the beginning of the list matches the id we want to delete...
            System.out.println("deleted patient information: " + head.data); // Patient information will appear on the delete screen
            head = head.next;     // We set head equal to the second patient's node. (Since the first patient is no longer kept with a reference, it is automatically deleted.)
            System.out.println("The patient has been deleted!!! (ID: " + id + ")" ); // Only the deleted patient's ID is visible
            return;
        }

        // If the patient to be deleted is not at the beginning, we should traverse the nodes to search.
        Node current = head;      //At the beginning, we start from the very top of the list.
        Node prev = null;         // prev: holds a previous Node from current
        // We need 'prev' because when deleting a Node, we need to change the next link of the Node before it.

        while (current != null && current.data.id != id) { // When (current.data.id == id), the loop ends
            prev = current;                 //The area we progressed in the list (if current is not null and there is no..
            current = current.next;             //..ID match, prev is updated to current, and current becomes newcurrent)
        }

        // if the patient is found
        if (current != null) {
            prev.next = current.next; // the row where we disconnected the connection(!)
            System.out.println("The patient was deleted (ID: " + id + ")");
        } else {
            System.out.println("No patient found with this ID: " + id);
        }
    }




    //patient search method
    public Patient findPatient(int id) {
        Node current = head;

        // We will traverse all the nodes from start to finish
        while (current != null) {
            if (current.data.id == id) { // If the ID matches, it means we have found the patient.
                return current.data;
            }else{
                current = current.next; // if it doesn't match, to the next patient...
            }
        }
        System.out.println("No patient was found with the ID you searched for.");
        return null; //If the patient cannot be found, it returns null
    }




    //method to print the list
    public void printList() {
        Node current = head;

        if (current == null) {
            System.out.println("The list is currently empty.");
            return;
        }else{
            System.out.println("\nPatient List:");
            while (current != null) {
                System.out.println(current.data.patINFO());
                current = current.next;
            }
        }
    }









}
