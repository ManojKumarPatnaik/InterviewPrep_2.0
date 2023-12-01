class LinkList {

    int data;
    LinkList next;

    LinkList() {
    }

    LinkList(int data, LinkList next) {
        this.data = data;
        this.next = next;
    }
}

public class ReverseLinkList {

    public static void main(String args[]) {

        LinkList node5 = new LinkList(5, null);
        LinkList node4 = new LinkList(4, node5);
        LinkList node3 = new LinkList(3, node4);
        LinkList node2 = new LinkList(2, node3);
        LinkList node1 = new LinkList(1, node2);

        LinkList node = node1;
        while(node != null) {
            System.out.print(node.data+" ");
            node=node.next;
        }

       LinkList head = reverseLinkList(node1);
        System.out.println(" ");

        node = head;
       while(node != null) {
           System.out.print(node.data+" ");
           node=node.next;
       }
    }

    private static LinkList reverseLinkList(LinkList head) {

        LinkList previous = null;
        LinkList current = head;
        LinkList next = null;

        while(current != null) {

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }

        return previous;

    }
}
