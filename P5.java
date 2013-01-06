//2520 is the smallest number that can be divided by each of the numbers
//  from 1 to 10 without any remainder.
//What is the smallest positive number that is evenly divisible
//  by all of the numbers from 1 to 20?
public class P5
{
  static int aMax = 20;
  static int aStart = 1;

  public static void main(String[] argv)
  {
    int aTest1 = 34;  //should fail with aMax=10
    int aTest2 =2520; //should work with aMax=20

//    System.out.println("should fail, and got: " + isDivisibleByAll(aTest2));

    for (int i=aStart; ;i++)
    {
      if (isDivisibleByAll(i) )
      {
        System.out.println("First number reached that was divisible by all: " +
          i);
        System.exit(0);
      }//end-if-then-construct
      

    }

  }//end-main
    private static boolean isDivisibleByAll(int aValue)
    {
      for (int i = aMax; i > 0; i--)
      {
        if(0 != aValue % i)
          return false;  //leave off testing and return false 
      }//end-for-loop
      return true; //otherwise, everything divides
    }//end-method isDivisibleByAll
}//end-class P5

