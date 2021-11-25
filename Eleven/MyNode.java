package Eleven;
import Eleven.*;
public class MyNode<Card> {
    protected String data;
    protected Card next;
    protected Card head;
    protected int size = 0;

    public MyNode() {
        data = null;
        next = null;
    }

    public MyNode(Card c) {
        next = null;
        size++;
    }

    public MyNode(int rank, int suit){

    }

    public void increaseSize() {
        size++;
    }

    public void decreaseSize() {
        size--;
    }


    public Card getNext() {
        return next;
    }

    public void setNext(Card nextCard) {
        next = nextCard;
    }


    public void test() {
        Card c1 = new Card(1, 1);
        MyNode<Card> node1 = new MyNode<Card>(c1);
        MyNode<Card> node2 = new MyNode<Card>(c1);
        MyNode<Card> node3 = new MyNode<Card>(c1);


    }


    public static void main(String[] args) {
        MyNode node = new MyNode();
        node.test();
    }


}