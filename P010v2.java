//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17
//Find the sum of all the sPrime below two million.
import java.math.BigInteger;
import java.util.*;
public class P010v2
{
  private static int aBelowParm = 2000000;
  private static int[] sPrime = new int[aBelowParm]; //room 4 every int
  private static int aNext = 0;

  public static void main(String[] argv)
  {
    sPrime[0]=2;
    aNext++;
    boolean isPrime;
    for (int i = 3; i < aBelowParm; i++)
    {
      if (0 == i%10000)
        System.out.println("calculated the first " + i + " primes");//progress status
      isPrime = true; //assume it is
      for (int j = aNext-1; j >= 0; j--)
      {
// System.out.println("i=" + i + "j=" + j + " sPrime[j]=" + sPrime[j]);
        if(0 == i%sPrime[j])
          isPrime = false;       //disproven assumption
      }//end-for
      //if still indivisible, then it's prime
      if (isPrime)
      {
         sPrime[aNext] = i;
        aNext++;
      }//end-if-then-construct
    }//end-for
System.out.println("loaded up all the prime numbers");

    BigInteger aTotal = new BigInteger("0");
    for (int i =0; i < aNext ; i++)
    {
//      System.out.println("got... " + sPrime.get(i) );
      aTotal = aTotal.add(new BigInteger( new Integer(sPrime[i]).toString() ));
    }//end-for
    System.out.println("got a Total of: " + aTotal );
  }//end-main
}//end-class P10
