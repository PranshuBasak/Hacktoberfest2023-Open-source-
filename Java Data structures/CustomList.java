package CustomLinkedList;

class Node{
    public int data;
    public Node next = null;

    public Node(int data){
        this.data = data;
    }

    public String toString(){
        return String.valueOf(data);
    }
}



class CustomList{
    public Node head;
    public Node tail;
    public CustomList(){
        head = null;
        tail = null;
    }


    public Node jump(){
        Node jump = head.next.next;
        return jump;
    }
    public void customInsert(int value){
        Node node = new Node(value);
        if(isEmpty()){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public void setHead(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            customInsert(value);
            return;
        }
        node.next = head;
        head = node;
    }

    public void insertAtIndex(int index, int value) {

        if(index < 0){
            throw new IllegalArgumentException("Index cannot be negative");
        }
        if (isEmpty()) throw new IllegalArgumentException("List is Empty `Custom Message`, Line 46");
        if(index == 0){
            setHead(value);
            return;
        }
        Node node = new Node(value);
        Node current = head;
        Node prev = null;
        while(index > 0 && current != null){
            prev = current;
            current = current.next;
            index--;
        }

        prev.next = node;
        node.next = current;

    }

    public void removeNthNodeFromEnd(int n) {

        Node fast = head, prev = null , current = head;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            prev = current;
            current = current.next;
        }
        if (prev == null){
            head = current.next;
            return;
        }
        tail = prev;
        prev.next = current.next;
        current.next = null;
    }

    public String toString(){
        Node current = head;
        StringBuilder result = new StringBuilder();
        while(current != null){
            result.append(current.data);
            if(current.next != null)
                result.append(",");
            current = current.next;
        }

        return result.toString();
    }



    public void PrintRecursively(Node head){
        if(head.next == null){
            System.out.print(head.data );
            System.out.println();
            return;
        }
        System.out.print(head.data + ",");
        PrintRecursively(head.next);
    }

    public void PrintRecursively(){
        PrintRecursively(head);
    }

    public void PrintReverseRecursively(Node head){
        if(head.next == null){
            System.out.print(head.data );

            return;
        }
        PrintReverseRecursively(head.next);
        System.out.print(","+head.data );
    }

    public void PrintReverseRecursively(){
        PrintReverseRecursively(head);
    }

    public Node reverseRecursivey(Node head){
        if(head == null || head.next == null) return head;

        Node rest = reverseRecursivey(head.next);

        Node next = head.next;
        next.next = head;
        head.next = null;

        return rest;
    }

    public void reverseRecursivey(){
        head = reverseRecursivey(head);
    }
    public int customSum(){
        Node current = head;
        int sum = 0;
        while(current != null){
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public Node swapPairs(Node head) {
        if(head == null || head.next == null) return head;

        Node rest = swapPairs(head.next.next);

        Node next = head.next;
        next.next = head;
        head.next = rest;

        return next;
    }
    public void swapPairs() {
        head = swapPairs(head);
    }
    public int customIndexOf(int value){
        Node current = head;
        int index = 0;
        while(current != null){
            if(current.data == value) return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    public void reverse() {
        if(isEmpty() || head.next == null) return;
        Node prev = null;
        Node current = head;
        Node Next = head.next;
        tail = head;
        while(Next != null){
            current.next = prev;
            prev = current;
            current = Next;
            Next = Next.next;
        }
        current.next = prev;
        head = current;
    }

    public void removeFirstNode() {
        if (isEmpty()) return;
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    public void removeLastNode() {
        if (isEmpty()) return;
        if(head == tail) {
            head = tail = null;
            return;
        }

        Node current = head;
        while(current.next != tail){
            current = current.next;
        }

        current.next = null;
        tail = current;
    }


public Node reverseKGroup(Node head, int k) {
    Node curr = head;
    int count = 0;

    // First, check if there are k nodes left in the list
    while (curr != null && count != k) {
        curr = curr.next;
        count++;
    }

    // If we have k nodes, then we reverse them
    if (count == k) {
        Node prev = null ,Next = null,current = head;

        for(int i=0; i<k; i++){
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;
        }

        // Next, we reverse the rest of the list and attach it to the end of the current group
        if (Next != null) {
            head.next = reverseKGroup(Next, k);
        }

        // Finally, we return the new head
        return prev;
    } else {
        // If we don't have k nodes, then we return the head without reversing
        return head;
    }
}

public void reverseKGroup(int k) {
    head = reverseKGroup(head , k);
}

    public boolean isEmpty() {
        return head == null && tail == null;
    }
}
