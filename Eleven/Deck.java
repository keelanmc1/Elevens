package Eleven;
import java.util.Random;
public class Deck extends LinkedList {
    private static final int NUMCARDS = 52;
    private final int MAXSHUFFLE = 1;
    private  LinkedList LIST = new LinkedList<>();
    private Random rand = new Random();

    private int cardIndex;

    //builds a deck and adds to linked list
    public Deck() throws IndexOutOfBoundsException {
        for (int i = 0; i < 52; i++) {
           addNewEntry(new Card(i % 13, i / 13));
        }
        this.shuffle();
    }

    private void addNewEntry(Card c){
        Card card = c;
        head = c;
    }


    private void shuffle() {
        int size = NUMCARDS;
        for (int i = 0; i < MAXSHUFFLE; i++) {
            int randInt = rand.nextInt(size);

            for (int j = 0; j < randInt; j++) {

                if (j == randInt-1){

                }

            }
        }
    }

    public void listDeck(){

    }

    public String returnList(int CARDNUM) {
        String str = "";
        for (int i = 0; i < CARDNUM; i++) {
            str += LIST.printList(LIST);
        }
        return str;
    }

    public Card deal() {
        return (Card) LIST.getElement(cardIndex--);
        //return this.CARDS[cardIndex--];
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        String str = d.returnList(52);
        d.listDeck();
        //System.out.println(str);
    }


}
