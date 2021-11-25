
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private int choice;
    private int numCards;
    private LinkedList<Card> BOARD = new LinkedList<>();
    private Card[] cardsRemoved;
    private Stack<Card> replayCards = new Stack<Card>();
    private Card [] cardArr;
   // private Stack<Integer> removeCards = new Stack<>();
    int [] cardIndexes = new int [3];
    private int points = 0;
    private int sum =0;
    private Deck deck = new Deck();

    public Game() {
        int CARDNUM = 9;

        for (int i = 0; i < CARDNUM; i++) {
            BOARD.add(BOARD, deck.deal());
            cardArr = new Card[CARDNUM];
            cardArr[i] = BOARD.getElement(i);
        }
    }
    public void play() {
        //main menu
        System.out.println("***********************************");
        System.out.println("\t\t\tElevens");
        System.out.println("***********************************");
        System.out.println("1.Play");
        System.out.println("2.Demonstration mode");
        System.out.println("3.Exit\n");
        System.out.print("Your choice? >");

        Scanner input = new Scanner(System.in);                                                                        //Scanner declared for user input
        try {
            choice = input.nextInt();
        }                                                                                 // validation to ensure that user enters a number
        catch (InputMismatchException e) {
            System.out.println("ERROR: You must enter a number!");
        }                       //otherwise, error message prints

        System.out.print("\n");

        if (choice == 1)                                                                                                   //if the choice is one, the program will print 9 new cards from the new for user to choose
        {
            while (BOARD.getSize() >0) {
                System.out.println("Creating the Deck......\n\n " + BOARD.printList(BOARD));
                System.out.println("Current deck size: " + BOARD.getSize() + "\n");

                System.out.println("How many cards would you like to remove? -- hit 0 for a hint! ");
                choice = input.nextInt();
                cardsRemoved = new Card[choice];

                for (int i = 0; i < cardsRemoved.length; i++) {

                    System.out.println("Choose your cards (Remember, the values must add to 11)");


                        numCards = input.nextInt();

                    System.out.println("Card chosen: " + BOARD.getElement(numCards) + "\n");
                    cardsRemoved[i] = BOARD.getElement(numCards);
                    //removeCards.push(numCards);
                    sum+= cardsRemoved[i].getPoints();
                    cardIndexes[i] = numCards;
                   // System.out.println(cardIndexes[i]);
                }

                    boolean valid = (sum == 11 || sum == 36);


                if(valid)
                {
                    System.out.println(cardIndexes[0]);
                    System.out.println(cardIndexes[1]);
                    System.out.println(cardIndexes[2]);
                    System.out.println("HURRAY!!...VALID MOVE\n");
                    points += 10;
                    for(int j=0; j<choice; j++) {

                        //   BOARD.remove(removeCards.pop());
                        // replayCards.push(cardsRemoved[j]);
                        BOARD.remove(cardIndexes[j]);
                        BOARD.add(BOARD, deck.deal());

                    }
                }
                else {

                    System.out.println("\nUNLUCKY....INVALID MOVE!\n");
                    //  LIST.add(LIST, cardsRemoved[j]);
                    System.out.println("Game lost...... Aqcuired points: "+points);

                }
                //removeCards.clear();
                sum=0;
                cardIndexes[0]=0;
                cardIndexes[1] =0;
                cardIndexes[2] =0;
            }
        }
        //if the user chooses 3 as the menu item, the application ends
        else if (choice == 3) System.exit(0);
    }
    public static void main(String []args)
    {
        Game g = new Game();
        g.play();
    }

}
