public class P012
{
//  private static int aNum = 15;

  public static void main(String[] argv)
  {

    int i; 
    int aNumDivisors = 0;
    for (i =1; aNumDivisors < 600; i++)
    {
      aNumDivisors = getDivisors(getTriangularNumber(i));
      //this is to monitor progress
      if (aNumDivisors>100)
      {System.out.println("aNumDivisors=" + aNumDivisors);}
      //this is when we hit the answer
      if (aNumDivisors>500)
      {
        System.out.println("!!!Got the answer: " + getTriangularNumber(i) );
        System.out.println("!!! Number of divisors: " + aNumDivisors);
        System.exit(0); //terminate the loop
      }//end-then
    }//end-for

    System.out.println("aNumDivisors=" + aNumDivisors  );
    System.out.println( "answer =" + getTriangularNumber(i) );
  }//end-main

  private static int getTriangularNumber(int aNum)
  {
    if (0 == aNum%1000) {System.out.println("getting triangular #" + aNum);}
    int aAnswer = (  (aNum)*(aNum+1)/2  );
    return aAnswer;  
  }//end-method getTriangularNumber

  private static int getDivisors(int aNum)
  {
    int aNumDivisors = 1;
    int aSaveLastFactor = 0;
    for (int i =aNum; i> 1; i--)
    {
      if (0 == aNum%i)
      {
        aNumDivisors++;
      }
     }//end-for-loop
    return aNumDivisors;
  }//end-method getDivisors

}//end-class P12
