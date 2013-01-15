//Project Euler Problem #3:
// The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

import java.math.BigInteger;
//find the largest prime factor in a given number
public class P003
{
  public static void main(String[] argv)
  {
    BigInteger aTargetNum; //this is the number to prime factor
    BigInteger aTargetNumSave; //save area for the original number
    int        aSize = 1000; //size of the array to store prime factors
    int[]      sFactor;    //these are the prime factors
    int[]      sFactorNum; //  and the num of times they occur
    int        aLastVal = 1; //and the last used value of the parallel arrays

    try
    {
      System.out.println("Target number to prime-factor is " + argv[0]);
      aTargetNum = new BigInteger(argv[0]) ;
    }//end-try-clause

    catch(ArrayIndexOutOfBoundsException e)
    {
      System.out.println("You forgot to pass in a num, assuming 30");
      aTargetNum = new BigInteger("24");
      aTargetNumSave = new BigInteger(aTargetNum.toString() );
    }//end-try-catch-construction

    //ready to prime factor
// System.out.println("Target set to: " + aTargetNum.toString() );
    sFactor = new int[aSize];    //init the parallel arrays
    sFactorNum = new int[aSize];

    int aFactor = 2; //start checking from 2 ascending
    BigInteger aZero = new BigInteger("0");
    for (int i = 1;
         i <= aSize && aTargetNum.intValue() != 1;
         i++)
    {
      //if aTargetNum is many times divisibile by a factor, it will
      //  sit in this section racking up more and more instances. 
      if (aZero.equals(aTargetNum.remainder(new BigInteger(Integer.toString(aFactor) ) ) )    )
      {
        System.out.println("aTargetNum = " + aTargetNum + " divisible by " + aFactor);
        
        aTargetNum = aTargetNum.divide(new BigInteger(Integer.toString(aFactor) )   );
        sFactor[aLastVal] = aFactor;
        sFactorNum[aLastVal]++;
System.out.println("sFactorNum[i]=" + sFactorNum[i] + " aLastVal=" + aLastVal);
      }//end-if-clause
      else
      // two cases here...first time out of above section ==> aLastVal++
      //     or no divisibility for this aFactor ==> aLastVal remains the same
      {
        //need to increment aLastVal, if it's the first time out of the above section
        if (aFactor == sFactor[aLastVal])
        {
          aLastVal++;
        }//end-if
          aFactor++;  // now we go on to the next highest possible factor
          i--; //keep i at the same place, since we wrote no array element
             //  and this will counteract the loop incrementing
      }//end-if-then-else-construct
      
    }//end-for loop

    //now we pull out the last, and thus the largest factor from the array
    System.out.println("**************************************");
    System.out.println("The largest factor found ==> " +
                        sFactor[aLastVal]);

//System.out.println("aLastVal=" + aLastVal);

//this for loop can be made active if you want to see the whole prime factoring
//  array
  //    for (int i =1; i <= aLastVal; i++)
  //    {
  //      System.out.println("sFactor[" + i + "] = " + sFactor[i] +
  //                         "  sFactorNum[" + i +"] = " + sFactorNum[i]);
  //    }//end-for-loop
  }//end-main
}//end-class P3

