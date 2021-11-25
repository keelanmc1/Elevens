import java.util.Scanner;

// TEST TO SEE IF CARDS IN DECK WILL PRINT: ALSO TEST REMOVE AND ADD OPERATIONS
public class DeckTest
{
    private static final int CARDNUM = 9;
    private static LinkedList<Card> cards = new LinkedList<>();

    //Testing the stack ADT for the replay feature.
    private static Stack<Card> replay = new Stack<>();
    private static Card [] cardRemoved;

    public static void main(String [] args)
    {
        Scanner input = new Scanner (System.in);
        Deck deck = new Deck();
        DeckTest game = new DeckTest();
        Card newCard = new Card(3,1);



        System.out.println("The deck: \n");

        for (int i=0; i < CARDNUM; i++)
        {
            cards.add(cards, deck.deal());


        }
        System.out.println(cards.printList(cards));
        //the current size of the deck is currently inaccurate
      //  System.out.println("Current size of the deck: " + .getSize());

            System.out.println("\nHow many cards would you like to remove?");
            int remove = input.nextInt();
            if(remove <1 || remove>2) System.out.println("Invalid choice! select between 2-3");

            for (int i = 0; i < remove; i++) {
                Card addCard;
                try {
                    System.out.println("which card to remove? ");
                    int choice = input.nextInt();


                    System.out.println("The card choosen is: " + cards.getElement(choice));
                    Card removed = new Card();
                    removed = cards.getElement(choice);
                    cardRemoved = new Card[choice];
                    cardRemoved[i] = cards.getElement(choice);


                    //checking to see if the removed card can be pushed to a stack for replay
                    replay.push(removed);
                   cards.remove(choice);

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("ERROR: Invalid index ");
                }


                //testing that the cards removed can be replaced by the same number removed
                //i.e. if 2 removed, 2 are added so long as the number going to be added is greater than deck size
                if (cards.getSize() > remove)
                {
                    addCard = new Card(i % 13, i / 13);
                    cards.add(cards, addCard);
                }
                //if no cards can be added anymore, the game is won
                else {
                    System.out.println("Deck is empty... You have won!!!");
                }

            }

        //test to add a new card to the deck
        Card aCard = new Card(1,2);

        System.out.println("new size of the deck: " + cards.getSize()); //checking that size updates

        cards.add(cards, aCard);
        System.out.println("Card added: " + aCard.toString());
        System.out.println("The updated deck: " + cards.printList(cards));
        System.out.println("new deck size: " + cards.getSize());

        while(!replay.isEmpty())
        {
            System.out.println("The replay cards are: " + replay.pop());
        }


    }

}
