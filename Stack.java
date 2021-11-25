import java.util.EmptyStackException;

public class Stack <T> implements StackInterface <T>
{
    private MyNode<T> topNode;
    private static int size = 0;

    public Stack()
    {
        topNode = null;
    }

    public void push (T newEntry)
    {
        size++;
        MyNode<T> newNode = new MyNode<T>(newEntry);
        newNode.setNext(topNode);
        topNode = newNode;

    }

    public T pop()
    {
        size--;
        T dataToReturn = peek();
        topNode = topNode.getNext();
        return dataToReturn;

    }

    public T peek()
    {
        if(topNode ==null) throw new EmptyStackException();
        else return topNode.getData();

    }

    public boolean isEmpty()
    {
        return (topNode==null);
    }

    public void clear()
    {
        topNode =null;
    }
    public int getSize(){return size;}

    public static void main(String [] args)
    {
        Stack<Integer> stack = new Stack<Integer>();

        for(int j=0; j<10; j++)
        {
            stack.push(j);
            System.out.println(stack.pop());
        }
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for(int i=1; i<=4; i++)
        {
            try
            {
                System.out.println("peek = " +stack.peek());
                System.out.println("pop = " +stack.pop());
            }
            catch(EmptyStackException e)
            {
                System.out.println("Exception!");
            }

        }
        stack.push(4);
        stack.push(5);
        stack.push(6);


        System.out.println("Stack empty is "+stack.isEmpty());
        stack.clear();
        System.out.println("Stack empty is "+stack.isEmpty());
    }
}