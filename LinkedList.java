import java.util.Random;

//implementation of a linked list ADT
public class LinkedList <T>
{
    Node head;

    private static int size = 52;
    Node last;

    public class Node {
        T data;
        Node next;
        Node previous;

      public Node(T d)
        {
            Node previous = null;

            data = d;
            next = null;
        }
    }
    //method to add new data to linked list PARAMS: the list to be added to then the data to be added
    public LinkedList <T>add (LinkedList list, T data) throws NullPointerException
    {
        Node newNode = new Node (data);
        newNode.next = null;

        if(list.head ==null) {
            list.head = newNode;
            head.previous = null;
        }
        else
        {
            last = list.head;
            while(last.next !=null)
            {
                last = last.next;


            }
            newNode.previous =last;
            last.next =null;
            last.next = newNode;
        }
        return list;
    }
    public LinkedList<T> addLast (LinkedList<T> list, T data)
    {
        Node newNode = new Node(data);
       newNode.next = null;
       last.next = newNode;
       last = newNode;

       return list;
    }
                                                                                                                        //method to print a string representation of the linked list
    public String printList(LinkedList <T> list)
    {
        Node currentNode = list.head;
        String str="";
        int c=0;
        while(currentNode !=null)
        {
            str+=c +". " +currentNode.data;
            str +="\n";
            currentNode = currentNode.next;
            c++;
        }
        return str;

    }
    //method for getting card at a specified index... this will be used for the removal of a card from the linked list.
    public T getElement(int index) throws NullPointerException
    {
        Node f = head;

        if(index >size || index<0) throw new IndexOutOfBoundsException("ERROR: Invalid index");

        if(index < size && index>0)
        {
            try {
                for (int i = 0; i < index; i++) {
                    f = f.next;
                }

                    return f.data;
                }
            catch (NullPointerException e){
                System.out.println("\nERROR: You must enter a valid index!\n");}
        }
        if(index ==0) return head.data;
        if(index == size) return last.data;
        return null;
     }
    public void shuffle(LinkedList<Card> list)
    {
        if(this.getSize()>4)
        {
            for(int i=0; i<this.getSize(); i++)
            {
                Node currentNode = head;
                Node next = head.next;

                for(int j=0; j<this.getSize()-1; j++)
                {
                    Node temp = currentNode;
                    currentNode = next;
                    next = temp;
                    currentNode = next;
                    next = next.next;
                }
            }

        }
    }

    public LinkedList  remove  (int index) throws NullPointerException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("ERROR: Invalid index!");
        Node newNode = head;
        for (int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        if (index == 0) head = newNode.next;

        else {
            newNode.previous.next = newNode.next;
        }
        size--;
        return null;
    }

    public  int getSize(){return size;}

}
