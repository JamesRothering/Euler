//author: James Rothering
//email:  jr@jamesrothering.com
//to build: javac P4.java
//to run:   java P4

//Project Euler Problem #4
//A palindromic number reads the same both ways.
//The largest palindrome made from the product of two 2-digit numbers is:
//   9009 = 91 99.
//Find the largest palindrome made from the product of two 3-digit numbers.

import java.util.*;

public class P4
{
  public static void main(String[] argv)
  {
    int aProd;
    ArrayList<Integer> sPalindrome = new ArrayList<Integer>();

    for  ( int aNum1 = 999;
           aNum1 > 99 ;
           aNum1--
         )
    {
      for (int aNum2 =999; aNum2 > 99; aNum2--)
      {
        aProd = aNum1 * aNum2;
//System.out.println("aProd =" + aProd);
        if (isPalindrome(aProd) )
        {
//System.out.println("palindrome found is " + aProd + " = " + aNum1 + " * " + aNum2);
          sPalindrome.add(aProd);
        }//end-if-then-construct
      }//end-for
    }//end-for

    //now we look at all the array elements to get the biggest
    int aMax = 0;
    for(int i = 0; i < sPalindrome.size(); i++)
    {
//      System.out.println("Palindrome found is: " + sPalindrome.get(i) );
      if (sPalindrome.get(i).intValue() > aMax)
      { aMax = sPalindrome.get(i).intValue(); }
    }//end-for

    System.out.println("***********************************");
    System.out.println("largest palindrome found = " + aMax);
  }//end-main
  private static boolean isPalindrome(int aNum)
  {
    StringBuffer aStr = new StringBuffer(Integer.toString(aNum) );
//    System.out.println("got " + aStr);
//    System.out.println("rev=" + aStr.reverse() );
    if (aStr.toString().equals( aStr.reverse().toString() )   )
    {
      return true;
    }//end-if-then-construct
    else
      return false;
  }//end-method isPalindrome
}//end-class P4

