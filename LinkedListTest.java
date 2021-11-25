//CLASS FOR TESTING THE ADDING AND REMOVAL OF CARD ELEMENTS FROM A LINKED LIST.
import java.util.Scanner;

public class LinkedListTest
{
    private final int CARDNUM =9;
    private final Card [] cards = new Card[CARDNUM];
    private LinkedList<Card> play = new LinkedList<>();

    public LinkedListTest()
    {
        Deck deck = new Deck();

        //play.add(play, 1);
        for(int i=0; i <CARDNUM; i++)
        {
            //cards being added to card array
            cards[i] = deck.deal();
            play.add(play, cards[i]);
        }
    }

    public static void main(String []args)
    {
        LinkedListTest game = new LinkedListTest();
        Scanner input = new Scanner (System.in);
        int remove=0;

        System.out.println("Deck: \n"+game.play.printList(game.play));

        //Need to validate this part to ensure 1-3 cards are picked: no more no less
        System.out.println("How many cards would you like to remove?");
        int num = input.nextInt();



        //this can be implemented so that when i remove the card from the list, I compare the two or three values that were removed.
        for(int i=0; i<num; i++)
        {
            System.out.println("What would you like to remove?... Please enter number from 0-8");
            try{ remove = input.nextInt();}
            catch(Exception e){System.out.println("ERROR!");}

            System.out.println("Card removed was, " + game.play.getElement(remove));
             game.play.getElement(remove);
            System.out.println("The card ranks is: " + game.play.getElement(remove).getRank()+"\n");

          //  play.remove(remove);

        }

        Card aCard = new Card(1,2);
       game.play.addLast(game.play,aCard );
        System.out.println("Card card added to last: " +game.play.printList(game.play));
        //After i remove the elements by index, Look up cards value using the getElement method
        //then compare the two if equal 11, valid move otherwise invalid move -- then they dont get removed






    }
}
