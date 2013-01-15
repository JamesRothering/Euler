//A Pythagorean triplet is a set of three natural numbers,
//  a  b  c, for which,
//a^2 + b^2 = c^2
//For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//  Find the product abc.
//first systematically generate the pythagorean triplets
//  which in turn requires coprime numbers
public class P009
{
  public static void main(String[] argv)
  {
     
//     System.out.println("test 2,3   = " + isCoprime(2,3)   );
//     System.out.println("test 4,2   = " + isCoprime(2,4)   );
//     System.out.println("test 3,5   = " + isCoprime(3,5)   );
//     System.out.println("test 5,7   = " + isCoprime(5,7)   );
//     System.out.println("test 13,17 = " + isCoprime(13,17) );
//     System.out.println("test 9,24  = " + isCoprime(9,24)  );
    System.out.println("about to create a new FullGen");
    FullGen aFullGen = new FullGen();
    for (int i = 0; i < 10 ; i++)
    {
      Pair      aPair = aFullGen.getNextPair();
      System.out.println("aPair =" + aPair.getM() + ";" + aPair.getN()  );
    }
  }//end-main

  private static boolean isCoprime(int aNum1, int aNum2)
  {

    if ( aNum1 < aNum2)
    { //swap so that aNum1 is always >= aNum2
      int aNum3 = aNum1; //save aNum1, before it gets wiped out by aNum2
          aNum1 = aNum2;
          aNum2 = aNum3;
    }//end-if-then-construct
    int aRemainder = 0;
    while (aNum2 > 1)
    {
      aRemainder = aNum1 % aNum2;
      if (0 == aRemainder)
        return false; //aNum2 is the GCD of the pair
      //replace aNum1 by aNum2 & replace aNum2 by aRemainder
      aNum1 = aNum2;
      aNum2 = aRemainder;
    }//end-while
    return true;
  }//end-method isCoprime

}//end-class P9

class FullGen
{
  Generator aGen1;
  Generator aGen2;
  int aGenNum = 1; //round-robin between aGen1 and aGen2

  FullGen()
  {
    this.aGen1 = new Generator(2,1);
    this.aGen2 = new Generator(3,1);
    System.out.println("constructed FullGen");
  }//end-constructor

  public Pair getNextPair()
  {
    if (1 == aGenNum)
    {
      aGenNum = 2;
      return aGen1.getNextPair();
    }
    else if (2 == aGenNum)
         {
           aGenNum = 1;
           return aGen2.getNextPair();
         }//end-if-then
         else
           System.out.println("error: only two Generators are present");
           return aGen1.getNextPair(); //should never hit this
  }//end-method getNextPair

}//end-class FullGen

class Generator
{
  int aBranchNum = 1; //round-robin on branches 1, 2, and 3
 
  Pair aBranch1 ;
  Pair aBranch2 ;
  Pair aBranch3 ;

  Generator()
  {
    this(2,1); //generates even-odd pairs of coprimes
  }
  Generator(int aM, int aN)
  {
    this.aBranch1 = new Pair(aM,aN);
    this.aBranch2 = new Pair(aM,aN);
    this.aBranch3 = new Pair(aM,aN);
  }

  public Pair getNextPair()
  {
    if (1 == aBranchNum)
    {
      int aSaveM = aBranch1.getM();
      int aSaveN = aBranch1.getN();
      aBranch1.setM(  2 * aSaveM - aSaveN  );
      aBranch1.setN(  aSaveM  );
      this.aBranchNum=2;  //round-robin aBranchNum from 1-3
      return aBranch1; 
    }//end-if-then-construct
    if (2 == aBranchNum)
    {
      int aSaveM = aBranch2.getM();
      int aSaveN = aBranch2.getN();
      aBranch2.setM( 2 * aSaveM + aSaveN );
      aBranch2.setN( aSaveM );
      this.aBranchNum = 3;  //round-robin aBranchNum from 1-3
      return aBranch2;
    }//end-if-then-construct
    if (3 == aBranchNum)
    {
      int aSaveM = aBranch3.getM();
      int aSaveN = aBranch3.getN();
      aBranch3.setM( aSaveM + 2 * aSaveN );
      aBranch3.setN( aSaveN );
      this.aBranchNum = 1; //round-robin aBranchNum from 1-3, start over now at 1
      return aBranch3;
    }//end-if-then-construct
    return aBranch1; //never gets here
  }//end-method getNextPair
}//end-class Generator

class Pair
{
  int aM = 0;
  int aN = 0;
  Pair(int aM, int aN)
  {
    this.aM=aM;
    this.aN=aN;
    System.out.println("constructing aPair");
  }//end-constructor

  void setM(int aM)
  { this.aM = aM; }
  void setN(int aN)
  { this.aN = aN; }
  int getM()
  { return this.aM; }
  int getN()
  { return this.aN; }
}//end-class Pair
