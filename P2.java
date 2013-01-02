import java.math.BigInteger;

public class P2
{
  public static void main(String[] args)
  {
    int          max    = 1000;
    BigInteger   biTot  = BigInteger.valueOf(0);
    BigInteger[] biFibs = new BigInteger[max];

    biFibs[0] = BigInteger.valueOf(1);
    biFibs[1] = BigInteger.valueOf(1);

    //load array with Fibonacci series 4MM and lower
    for (int i = 1;  biFibs[i].intValue() <= 4000000; i++)
    {
      biFibs[i+1] = biFibs[i].add(biFibs[i-1]);
    }//end-for

    for (int i=0; i< max && biFibs[i].intValue() <= 4000000; i++)
    {
      //consider even values

//!!!Why did this work? I accidentally left in "==" !!!
      if (BigInteger.valueOf(0) == biFibs[i].remainder(BigInteger.valueOf(2)))
//      if (BigInteger.valueOf(0).equals(biFibs[i].remainder(BigInteger.valueOf(2)  )    )        );
      {
        biTot = biTot.add(biFibs[i]);
        System.out.println("Even Fib number " + biFibs[i] + " ");

      }//end-if
    }//end-for
    System.out.println(" Total = " + biTot);

  }//end-method main
}//end-class P2

