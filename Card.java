
import java.util.Random;
public class Card extends MyNode
{
    private final int RANK, SUIT;
    private final String [] RANKS = {"2", "3","4","5","6","7","8","9","10","Ace","Jack","Queen","King"};
    private final String [] SUITS = {"Diamonds", "Clubs","Spades", "Hearts"};
    private final int [] POINTS ={2,3,4,5,6,7,8,9,10,1,11,12,13};

    private static final Random GENERATOR = new Random(100);

    public Card ()
    {
        RANK = GENERATOR.nextInt(RANKS.length);
        SUIT = GENERATOR.nextInt(SUITS.length);
    }

    public Card (int r, int s)
    {
        RANK = r;
        SUIT =s;
    }

    public String getRank()
    {
        return RANKS[RANK];
    }
    public String getSuit(){return SUITS[SUIT]; }
    public int getRankValue(){return RANK; }
    public int getPoints(){return POINTS[RANK];}

    public String toString(){return getRank() +" of " +getSuit(); }




}
