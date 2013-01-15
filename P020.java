import java.math.BigInteger;
public class P020
{
  private static int aNum = 100;
  public static void main(String[] argv)
  {
    BigInteger aAnswer = getFactorial(aNum);
    int        aTotal  = 0;
    for (int i = 0; i < aAnswer.toString().length(); i++)
    {
      aTotal = aTotal + Character.getNumericValue(aAnswer.toString().charAt(i) );  
      System.out.println("got=" + aTotal);
    }//end-for
    System.out.println("Digit Sum of the Factorial: " + aTotal);
  }//end-main

  private static BigInteger getFactorial(int aNum)
  {
    BigInteger aTotal = new BigInteger("1"); 
    for (int i = aNum; i > 1; i--)
    {
      aTotal = aTotal.multiply(new BigInteger( new Integer(i).toString() ));
//      System.out.println(i + "*");
    }//end-for
    System.out.println("aTotal=" + aTotal);
    return aTotal;
  }//end-method
}//end-class
