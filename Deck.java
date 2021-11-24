
public class Deck extends LinkedList<Card>
{
    private static final int NUMCARDS = 52;
    private final Card[] CARDS = new Card[NUMCARDS];
    private final LinkedList<Card> LIST = new LinkedList<>();
    private int size;

    private int cardIndex;

    //builds a deck and adds to linked list
    public Deck() throws IndexOutOfBoundsException
    {
        for (int i = 0; i<NUMCARDS; i++)
        {
           this.CARDS[i] = new Card(i % 13, i/13);
           LIST.add(LIST, CARDS[i]);

        }
        this.cardIndex = NUMCARDS -1;
        this.shuffle();
    }


    private void shuffle()
    {

    }

    public String returnList(int CARDNUM)
    {
        String str ="";
        for(int i=0; i < CARDNUM; i++)
        {
            str+= LIST.printList(LIST);
        }
          return str;
    }

    public Card deal()
    {
        return LIST.getElement(cardIndex--);
        //return this.CARDS[cardIndex--];
    }


}
