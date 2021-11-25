public class CardTest

{
    public static void main(String [] args)
    {
        //creating new Card objects
        for (int i=0; i <4; i++)
        {
            Card aCard = new Card(i,i);
            System.out.println(aCard);

        }
    }
}
