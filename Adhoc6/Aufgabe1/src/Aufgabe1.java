
class IntList {

    private ListNode head;
    //private ListNode tail;

    private class ListNode {
        int elem;
        ListNode next;
        ListNode prev;
        ListNode head;

        ListNode(int elem, ListNode next, ListNode prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }

        void add(int elem) {
            ListNode temp = new ListNode(elem, null, null);
            if (head == null) {
                head = temp;
            }
            while (elem < this.elem) {
                this.prev.elem = this.elem;
                this.elem = this.next.elem;
            }
            if (elem >= this.elem) {
            }
        }

        void removeIfGreaterThan(int n) {
            if (n != this.elem) {
                this.elem = this.next.elem;
                removeIfGreaterThan(n);
            }
            if (n == this.elem) {
                this.next = null;
            }
        }

        public String toString() {
            return this.elem + ((this.next == null) ? "-|" : "<->" + this.next);
        }

    }

    public boolean empty() {
        return this.head == null;
    }

    public void add(int elem) {
        ListNode node = new ListNode(elem, null, null);
        if (head == null) {
            head = node;
            return;
        }

    }

    public void removeIfGreaterThan(int n) {
        this.head.removeIfGreaterThan(n);
    }

    public String toString() {
        return "[->" + this.head + "]";
    }
}

public class Aufgabe1 {

    public static void main(String[] args) {

        IntList myList = new IntList();

        myList.add(10);
        myList.add(2);
        myList.add(5);
        myList.add(10);
        myList.add(2);
        myList.add(5);
        myList.add(1);
        myList.add(15);
        //myList.removeIfGreaterThan(5);

        System.out.println(myList);
    }
}
