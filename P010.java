//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17
//Find the sum of all the sPrime below two million.
import java.math.BigInteger;
import java.util.*;
public class P010
{
  private static int aBelowParm = 2000000;
  private static List<Integer> sPrime = new ArrayList<Integer>();
  public static void main(String[] argv)
  {
    sPrime.add(new Integer(2));
    boolean isPrime;
    for (int i = 3; i < aBelowParm; i++)
    {
      if (0 == i%1000)
        System.out.println("calculated the first " + i + " primes");
      isPrime = true; //assume it is
      for (int j = sPrime.size()-1; j >= 0; j--)
      {
        if(0 == i%sPrime.get(j))
          isPrime = false;
      }//end-for
      //if still indivisible, then it's prime
      if (isPrime)
        sPrime.add(new Integer(i));
    }//end-for
System.out.println("loaded up all the prime numbers");

    BigInteger aTotal = new BigInteger("0");
    for (int i =0; i < sPrime.size() ; i++)
    {
//      System.out.println("got... " + sPrime.get(i) );
      aTotal = aTotal.add(new BigInteger( new Integer(sPrime.get(i)).toString() ));
    }//end-for
    System.out.println("got a Total of: " + aTotal );
  }//end-main
}//end-class P10
