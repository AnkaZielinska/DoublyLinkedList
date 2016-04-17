class Node {
    private String exampleStr;
    private Node previous;
    private Node next;

    public Node() {
        previous = null;
        next = null;
    }

    public Node(String exampleStr, Node previous, Node next) {
        this.exampleStr = exampleStr;
        this.previous = previous;
        this.next = next;
    }

    public String getExampleStr()
    {
        return exampleStr;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}

public class DoublyLinkedList {

    private Node start;
    private Node end;

    public DoublyLinkedList() {
        start = null;
        end = null;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void sizeDoublyLinkedList() {
        Node tmp = start;
        int numberOfElementsOnList = 0;
        while (tmp != null) {
            numberOfElementsOnList++;
            tmp = tmp.getNext();
        }
        System.out.println("Rozmiar listy: " + numberOfElementsOnList);
    }

    public void addElementToList(String exampleStr) {
        Node node = new Node(exampleStr, null, null);
        if(isEmpty())
        {
            start = node;
            end = node;
        }
        else
        {
            Node tmp = start;
            while( tmp != null)
            {
                if(tmp.getExampleStr().compareToIgnoreCase(exampleStr) < 0)
                {
                    tmp = tmp.getNext();
                }
                else {
                    if(tmp == start) {
                        node.setNext(tmp);
                        tmp.setPrevious(node);
                        start = node;
                        break;
                    }
                    else {
                        node.setNext(tmp);
                        node.setPrevious(tmp.getPrevious());
                        tmp.getPrevious().setNext(node);
                        tmp.setPrevious(node);
                        break;
                    }
                }
            }
            if (tmp == null)
            {
                end.setNext(node);
                node.setPrevious(end);
                end = node;
            }
        }
    }

    public void deleteElementFromList(String exampleStr) {
        Node tmp = start;
        while (tmp != null) {
            if(tmp.getExampleStr() == exampleStr) {
                if(tmp == start) {
                    start = tmp.getNext();
                    break;
                }
                else if (tmp == end) {
                    end = tmp.getPrevious();
                    break;
                }
                else {
                    tmp.getPrevious().setNext(tmp.getNext());
                    tmp.getNext().setPrevious(tmp.getPrevious());
                    break;
                }
            }
            tmp = tmp.getNext();
        }
        if (tmp == null){
            System.out.println(exampleStr + " nie jest elementem listy");
        }
    }

    public void showAllElementsFromStart() {
        Node tmp = start;
        System.out.print("Elementy listy (w kolejnosci od poczatku): ");
        while(tmp != null) {
            System.out.print(tmp.getExampleStr() + ", ");
            tmp = tmp.getNext();
        }
    }

    public void showAllElementsFromEnd() {
        Node tmp = end;
        System.out.print("Elementy listy (w kolejnosci od konca): ");
        while(tmp != null) {
            System.out.print(tmp.getExampleStr() + ", ");
            tmp = tmp.getPrevious();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addElementToList("front squat");
        list.addElementToList("overhead press");
        list.addElementToList("thruster");
        list.showAllElementsFromEnd();
        list.sizeDoublyLinkedList();
        list.deleteElementFromList("front squat");
        list.showAllElementsFromStart();
        list.sizeDoublyLinkedList();
    }
}