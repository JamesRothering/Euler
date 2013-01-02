//Problem 1
//  If we list all the natural numbers below 10
//  that are multiples of 3 or 5, we get 3, 5, 6 and 9.
//  The sum of these multiples is 23.
//  Find the sum of all the multiples of 3 or 5 below 1000.

//note: integers are always a pain, because they don't fit with
//      zero indexing. Here, I'm leaving the arrays with a zero element of 0
//      So, the array[1] element is the first element of interest.
//      This doesn't impact summing, since anything + 0 is unchanged.

public class P1
{
  static int given = 1000;
  public static void main (String[] args)
  {
    int sum = 0;
    for (int i=0; i<1000; i++)
    {
      if (0 == i%3 || 0 == i%5)
      {
        sum = sum+i; 
      }//end-if-clause
    }//end-for-loop
    System.out.println("total=" + sum);
  }//end-main

}//end-class P1
