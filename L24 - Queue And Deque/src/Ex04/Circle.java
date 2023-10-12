package Ex04;


import java.util.Random;

public class Circle {

    // first points to the node at the front of the queue
    // (= the first node in the singly-linked list)
    private Node first;

    // last points to the node at the back of the queue
    // (= the last node in the singly-linked list)
    private Node last;
    private Node current;
    private int size;

    public Circle() {
        first = null;
        last = null;
        size = 0;
    }

    public void addPerson(Person p){
        Node newNode = new Node(p);
        if(first == null){
            first = newNode;
            current = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        last.next = first;
        size++;
    }

    public void printPersons(){
        if(size == 0){
            System.out.println("[]");
        } else {
            StringBuilder sb = new StringBuilder("[" + current.entry.toString());
            Node node = current.next;
            for(int i = 0; i < size-1; i++){
                sb.append(",").append(node.entry.toString());
                node = node.next;
            }
            sb.append("]");
            System.out.println(sb);
        }
    }

    public Person removeFirst(){
        Node node = first;
        Random rd = new Random();
        int rdNumber = rd.nextInt(size+1);
        System.out.println(rdNumber);
        Person popped;
        if(rdNumber == 0){
            popped = first.entry;
            last.next = first.next;
            current = last;
        }else{
            for(int i = 0; i < rdNumber-1; i++){
                node = node.next;
            }
            popped = node.next.entry;
            node.next = node.next.next;
            current = node;
        }
        size--;
        return popped;
    }

    public Person removeNext(int count){
        Node node = current;
        int i = 1;
        while(i < count){
            node = node.next;
            i++;
        }
        Person popped = node.next.entry;
        node.next = node.next.next;
        current = node;
        size--;
        return popped;
    }

    public int getSize(){
        return size;
    }


    //--------------------------------------------------

    private class Node {
        private Person entry;
        private Node prev;
        private Node next;

        public Node(Person entry) {
            this.entry = entry;
            this.prev = null;
            this.next = null;
        }
    }
}
