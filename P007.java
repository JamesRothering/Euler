//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
//  we can see that the 6th prime is 13.
//What is the 10 001st prime number?
//problem #7
import java.util.ArrayList;
public class P007
{
  static ArrayList<Integer> sPrime = new ArrayList<Integer>();
  static int aMax = 10002;
  static boolean isPrime = true;

  public static void main(String[] argv)
  {
    sPrime.add(2);
    for (int i = 3; sPrime.size() < aMax; i++)
    {
//      boolean isPrime = true; //assume it's prime & attempt to disprove
      for (int j = 0; j < sPrime.size(); j++ )
      {
        if (0 == i%(sPrime.get(j).intValue())  )    
        {
        isPrime = false;
//System.out.println("got here");
        } //we found an exception
//System.out.println("i%sPrime.get(j).intValue()=" +
//                      i% sPrime.get(j).intValue() );
      }//end-for
      if (isPrime)
      {
        sPrime.add(new Integer(i));
      }
      else
      {
        isPrime = true;
      }
    }//end-for

    System.out.println("got these primes:");
//    for (int k = 0; k < sPrime.size(); k++)
    int k = 10000;
    {
      System.out.println("The " + (k+1) + "th prime number is: " + sPrime.get(k) );
    }//end-for
  }//end-main
}//end-clas P7
