class TwoLinkedList {
    public static void printList(Node head) {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.val + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public static Node add(Node one, Node two) {
        
        Node head = null;
        Node current = null;
        
        int carry = 0;
        while (one != null || two != null) {

            int sum = carry;
            if (one != null) {
                sum += one.val;
            }
            if (two != null) {
                sum += two.val;
            }
            carry = sum / 10;
            sum = sum % 10;

            Node node = new Node(sum, null);
            if (head == null) {
                current = head = node;
            } else {
                current.next = node;
                current = current.next;
            }

            if (one != null) {
                one = one.next;
            }
            if (two != null) {
                two = two.next;
            }
        }

        return head;
    }

    public static Node reverse(Node head) {
        Node out = null;
        Node current = head;
        
        while (current != null) {
            Node next = current.next;

            current.next = out;
            out = current;
            
            current = next;
        }

        return out;
    }

    public static Node addLists(Node one, Node two) {
        one = reverse(one);
        two = reverse(two);

        return reverse(add(one, two));
    }

    public static void main(String[] args) {
        int x = 321;
        int y = 1;
 
        // construct list `X` (5 —> 7 —> 3 —> 4) from number `x`
        Node one = null;
        while (x != 0)
        {
            one = new Node(x % 10, one);
            x = x/10;
        }
 
        // construct list `Y` (9 —> 4 —> 6) from number `y`
        Node two = null;
        while (y != 0)
        {
            two = new Node(y % 10, two);
            y = y/10;
        }

        Node result = addLists(one, two);
        printList(result);
    }
}
