//The sum of the squares of the first ten natural numbers is,
//  12 + 22 + ... + 102 = 385
//The square of the sum of the first ten natural numbers is,
//  (1 + 2 + ... + 10)2 = 552 = 3025
//Hence the difference between the sum of the squares of the first ten
//  natural numbers and the square of the sum is 3025  385 = 2640.
//Find the difference between the sum of the squares of the first
//  one hundred natural numbers and the square of the sum.

import java.math.BigInteger;

public class P006
{
  static private int aSizeParm = 100; //number of natural numbers to compute with
  static private BigInteger aSumOfSquares;
  static private BigInteger aSquareOfSums;
  static private BigInteger aDiff;

  public static void main(String argv[])
  {
    aSumOfSquares = sumOfSquares(aSizeParm);
System.out.println("sumOf Squares: " + aSumOfSquares);
    aSquareOfSums = squareOfSums(aSizeParm);
System.out.println("squareOfSums=" + aSquareOfSums);

//note: the problem is misworded. The answer given is what they apparently mean
    aDiff = aSquareOfSums.subtract(aSumOfSquares);
    System.out.println("answer =" + aDiff.toString() );
  }//end-main

  private static BigInteger sumOfSquares(int aNum)
  {
    BigInteger aTotal = new BigInteger("0");
    for (int i=1; i <= aSizeParm; i++)
    {
      aTotal = aTotal.add(new BigInteger(new Integer(i).toString() ).pow(2)   );
    }
    return aTotal;
  }//end-method sumOfSquares

  private static BigInteger squareOfSums(int aNum)
  {
    BigInteger aTotal = new BigInteger("0");
    for (int i = 1; i <= aSizeParm; i++)
    {
      aTotal = aTotal.add(new BigInteger(Integer.toString(i) )   ) ;
    }//end-method squareOfSums
    aTotal = aTotal.pow(2);
    return aTotal;
  }//end-method squareOfSums
}//end-class

