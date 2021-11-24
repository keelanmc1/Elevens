package Eleven;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private  final int CARDNUM = 9;
    private  int choice;
    private  int numCards;
    private LinkedList LIST = new LinkedList<>();
    private static Card[] cardsRemoved;
    private Stack replayCards = new Stack<Card>();
    private Stack<Integer> removeCards = new Stack<Integer>();
    private  int points = 0;
    private  int sum = 0;

    public Game() {
        Deck deck = new Deck();
        for (int i = 0; i < CARDNUM; i++) {
            LIST.add(LIST, deck.deal());
            //LIST.shuffleList(LIST);
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
        Game game = new Game();

        if (choice == 1)//if the choice is one, the program will print 9 new cards from the new for user to choose
        {
            while (LIST.getSize() > 0) { // LIST == BOARD
                System.out.println("Creating the Deck......\n\n" + LIST.printList(LIST)); //print Board
                System.out.println("Current deck size: " + LIST.getSize() + "\n"); //deck size

                System.out.println("How many cards would you like to remove? ");
                choice = input.nextInt(); //i want 2 cards
                cardsRemoved = new Card[choice];    //create array to store 2 cards


                for (int i = 0; i < choice; i++) {

                    System.out.println("Choose your cards (Remember, the values must add to 11)");

                    try {
                        numCards = input.nextInt();
                    } catch (NullPointerException e) {
                        System.out.println("ERROR: You must enter a valid index!" + ".... Try again");

                    }

                    System.out.println("Card chosen: " + LIST.getElement(numCards) + "\n");
                    cardsRemoved[i] = (Card) LIST.getElement(numCards);
                    removeCards.push(numCards);

                    sum += cardsRemoved[i].getPoints();
                    System.out.println("Sum: " + sum);
                }
                //loop to check if the card values add to eleven
                for (int j = 0; j < cardsRemoved.length; j++) {

                    if (sum == 11 || sum == 39) {     //but it should give 36
                        System.out.println("VALID MOVE\n");
                        Card addCard;
                        LIST.remove(removeCards.pop());
                        replayCards.push(cardsRemoved[j]);
                        addCard = new Card(j % 13, j / 13);
                        LIST.add(LIST, addCard);

                        points += 10;
                    } else {

                        System.out.println("\nINVALID MOVE!\n");
                        //  LIST.add(LIST, cardsRemoved[j]);
                        System.out.println("Game lost...... Aqcuired points: " + points);

                        break;
                    }

                }

                sum = 0;
            }
        }
        //if the user chooses 3 as the menu item, the application ends
        else if (choice == 3) System.exit(0);
    }


    public static void main(String[] args) {
        Game g = new Game();
        g.play();


    }
}


