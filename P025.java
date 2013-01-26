//Author: James Rothering
import java.math.BigInteger;
public class P025
{
  private static BigInteger i = new BigInteger("1");
  private static BigInteger j = new BigInteger("1");
  private static BigInteger k = new BigInteger("1");

  public static void main(String[] argv)
  {
    int    i;
    String aFib ="";
    for (i = 3;
        i < 2000000 && aFib.length() < 1000 ;
        i++)
    {
      aFib = getFibonacci(i).toString() ;
    }//end-if-then-construct

    System.out.println("answer = " + (i-1));;
  }//end-main

  static BigInteger getFibonacci(int i)
  {
    P25.k = P25.i.add(j);
    P25.i = P25.j;
    P25.j = P25.k;
//System.out.println(i +"th Fib. # is: " + k);
    return P25.k;
  }//end-method BigInteger
}//end-class P25

