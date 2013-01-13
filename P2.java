//author: James Rothering
//email: jr@jamesrothering.com
//Project Euler Problems
import java.math.BigInteger;

public class P2
{
  public static void main(String[] args)
  {
    int          max    = 1000;
    BigInteger   aTot  = BigInteger.valueOf(0);
    BigInteger[] sFib = new BigInteger[max];

    sFib[0] = BigInteger.valueOf(1);
    sFib[1] = BigInteger.valueOf(1);

    //load array with Fibonacci series 4MM and lower
    for (int i = 1;  sFib[i].intValue() <= 4000000; i++)
    {
      sFib[i+1] = sFib[i].add(sFib[i-1]);
    }//end-for

    for (int i=0; i< max && sFib[i].intValue() <= 4000000; i++)
    {
      //consider even values

//!!!Why did this work? I accidentally left in "==" !!!
      if (BigInteger.valueOf(0) == sFib[i].remainder(BigInteger.valueOf(2)))
//      if (BigInteger.valueOf(0).equals(sFib[i].remainder(BigInteger.valueOf(2)  )    )        );
      {
        aTot = aTot.add(sFib[i]);
        System.out.println("Even Fib number " + sFib[i] + " ");

      }//end-if
    }//end-for
    System.out.println(" Total = " + aTot);

  }//end-method main
}//end-class P2

