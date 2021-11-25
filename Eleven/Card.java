package Eleven;

import java.util.Random;

public class Card extends MyNode {
    protected int rank;
    protected int suit;
    protected boolean isFace = false;
    protected Card head;
    protected int cardValue;
    protected Random GENERATOR = new Random();

    public Card(int cardValue, int suit) {
        super(cardValue);
       if (isValidPoint(cardValue) == true){
           this.cardValue =cardValue;
       }
       if (isValidSuit(suit) == true){
           this.suit = suit;
       }
    }

    public void insertNewCard(Card c){
        if(size == 0){
            head = c;
            head.setNext(null);
        }
    }

    public boolean isValidPoint(int p){
        return (p >= 1 && p <= 13);
    }

    public boolean isValidSuit(int s){
        return (s == 0 || s == 1 || s == 2 || s ==3);
    }


    public Card getHead() {
        return head;
    }

    public int getRank() {return rank;}
    public int getSuit() {return suit;}
    public int getPoints() {return cardValue;}
    public String toString() {return getRank() + " of " + getSuit();}
}
