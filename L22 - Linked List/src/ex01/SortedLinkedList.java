package ex01;

import ex00.CitySingleLinkedList;

import java.util.ArrayList;

public class SortedLinkedList  {
        // TODO: choose relevant fields
        private Node first;


        public SortedLinkedList() {
            first = null;
        }

        /**
         * Add the element to the list.
         * The list is still sorted after the element is added.
         */
        public void add(String element) {
            Node newNode = new Node(element);
            boolean placed = false;
            Node node = first;

            if (first == null || first.data.compareTo(element) > 0) {
                newNode.next = first;
                first = newNode;
                return;
            }

            while(!placed && node.next != null){
                if(node.next.data.compareTo(element) >= 0){ // place in front of greater or strings equal to element
                    newNode.next = node.next;
                    node.next = newNode;
                    placed = true;
                }
                node = node.next;
            }
            if(!placed){
                node.next = new Node(element);
            }
        }
        /**
         * Remove the last element from the list.
         * The list is still sorted after the element is removed.
         * Return true, if the element was removed, otherwise false.
         */

        public boolean removeLast(){
            if (first == null){
                return false;
            }

            if (first.next == null){
                first = null;
                return true;
            }

            Node node = first;

            while (node.next != null){
                if (node.next.next == null){
                    node.next = null;
                    return true;
                }
                node = node.next;
            }
            return false;
        }
        /**
         * Remove the first instance of the element from the list.
         * The list is still sorted after the element is removed.
         * Return true, if the element was removed, otherwise false.
         */
        public boolean remove(String element){
            if (first == null)
                return false;

            if (first.data.equals(element)) {
                first = first.next;
                return true;
            }

            // update node to reference the node BEFORE the node
            // containing the city (if such a node exists)
            SortedLinkedList.Node node = first;
            while (node.next != null && !node.next.data.equals(element)) {
                node = node.next;
            }
            if (node.next != null) {
                node.next = node.next.next;
            }
            return true;
        }

        /**
         * Print all elements in alphabetical order.
         */
        public void printElements() {
            SortedLinkedList.Node node = first;
            StringBuilder sb = new StringBuilder("[");
            while (node != null){
                sb.append(node.data).append(", ");
                node = node.next;
            }
            sb.append("]");
            System.out.println(sb);
        }

        /**
         * Return the count of elements in the list.
         */
        public int count() {
            int count = 0;
            SortedLinkedList.Node node = first;
            while (node != null) {
                count++;
                node = node.next;
            }
            return count;

        }

        private class Node {
                private String data;
                private Node next;
                public Node(String data) {
                        this.data = data;
                        this.next = null;
                }
        }
}
