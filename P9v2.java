//A Pythagorean triplet is a set of three natural numbers,
//  a  b  c, for which,
//a^2 + b^2 = c^2
//For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//  Find the product abc.
// This next attempt is just to begin incrementing a,b,&c
// then testing to see two constraints are true:
//  1) a+b+c=1000
//  2) a^2 + b^2 = c^2

import java.util.ArrayList;

public class P9v2
{
  public static void main(String[] argv)
  {
    for (int a = 1; a <= 1000; a++)
    {
      for (int b = 1; b <= 1000; b++)
      {
        for (int c = 1; c <= 1000; c++)
        {
          if (1000     == a+b+c &&
              a*a +b*b == c*c   &&
              a < b             &&
              b < c
             )
           {
             System.out.println ("Got an answer. The triple is: " + a + "," + b + "," + c);
             System.out.println (" ...");
             System.out.println("And the product of a*b*c=" + a*b*c);
           }//end-if
        }//end-for
      }//end-for
    }//end-for
  }//end-main  
}//end-class P9v2
