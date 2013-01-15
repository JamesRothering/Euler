//A Pythagorean triplet is a set of three natural numbers,
//  a  b  c, for which,
//a^2 + b^2 = c^2
//For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//  Find the product abc.
//My first attempt was to systematically generate the pythagorean triplets
//  using Euclid's algorithm, which in turn requires coprime numbers. I got
//  the coprime generation going, which was well worth learning about, but then
//  I switched to a simpler algorithm.
//Second attempt: Berggren's algorithm, which generates 3 triplets for each
//  triplet, starting from a root of (3,4,5)
//  T1: new a= a-2b+2c; new b= 2a-b+2c; new c= 2a-2b+3c
//  T2: new a= a+2b+2c; new b= 2a+b+2c; new c= 2a+2b+3c
//  T3: new a=-a+2b+2c; new b=-2a+b+2c; new c=-2a+2b+3c
//So, I'll need to keep track of a tree of triplets, so I can use them
//  to recursively generate further triplets.
//Then I'll need to loop through the generated triplets looking for the
//  one that answers the constraint a+b+c=1000

import java.util.ArrayList;

public class P009v1
{
  public static void main(String[] argv)
  {
    Triple aTriple = new Triple();
    aTriple.generateTriples();

//    while (

    for (int i = Triple.aCounter-3;
         i < Triple.aCounter &&
         i < 100;
         i++)
    {
      Triple.sTriple[i].generateTriples();
    }//end-for-loop
  
    for (int i = 0; i < Triple.aCounter ; i++)
    {
      System.out.println( "generated triple...#" + i + ":");
      System.out.println( Triple.getTriple(i).aA + "," +
                          Triple.getTriple(i).aB + "," +
                          Triple.getTriple(i).aC
                        );
    }//end-for-loop

    for (int i=0; i < Triple.aCounter ; i++)
    {
      if (1000 == Triple.sTriple[i].aA +
                  Triple.sTriple[i].aB +
                  Triple.sTriple[i].aC)
      {
        System.out.println("Got a solution");
        System.exit(0);
      }
     
     
    }//end-for-loop
    System.out.println("checked everything in the array");
  }//end-main

}//end-class P9

class Triple
{
  //class variables
  //the line following left a bug in that the ArrayList didn't appear to expand 
  //static public ArrayList<Triple> sTriple ;
  //why doesn't the ArrayList work in a static variable?
  //static public ArrayList<Triple> sTriple = new ArrayList<Triple>();
  //static int works
  static int aCounter = 0;
  static Triple[] sTriple = new Triple[2000];


  //instance variables
  int aA = 3; //this is the root triplet for the algorithm
  int aB = 4;
  int aC = 5;

  //constructors
  Triple(int aA, int aB, int aC)
  { this.aA=aA; this.aB=aB; this.aC=aC; Triple.setNextTriple(this); }
  Triple()
  {this(3,4,5);}

  //class methods
  static public void setNextTriple(Triple aTriple)
  {
//    System.out.println("size=" + sTriple.size()  );
//    System.out.println("counter=" + aCounter);
//    Triple.aCounter++;
//    System.out.println("counter=" + aCounter);
    System.out.println("setting triple");
    Triple.sTriple[aCounter] = aTriple;
    Triple.aCounter++;
    System.out.println("size=" + aCounter  );
  }
  static public Triple getTriple(int aNum)
  { return Triple.sTriple[aNum]; }

  //instance methods
  public void generateTriples()
  {
    int aNewA =    (this.aA)- 2*(this.aB)+ 2*(this.aC);
    int aNewB =  2*(this.aA)- this.aB    + 2*(this.aC);
    int aNewC =  2*(this.aA)- 2*(this.aB)+ 3*(this.aC);

    Triple aNewTriple1 = new Triple(aNewA, aNewB, aNewC);

        aNewA =   (this.aA)   +2*(this.aB)+ 2*(this.aC);
        aNewB = 2*(this.aA)   +  (this.aB)+ 2*(this.aC);
        aNewC = 2*(this.aA)   +2*(this.aB)+ 3*(this.aC);

    Triple aNewTriple2 = new Triple(aNewA, aNewB, aNewC);

        aNewA =   -(this.aA)  +2*(this.aB)+ 2*(this.aC);
        aNewB = -2*(this.aA)  +  (this.aB)+ 2*(this.aC);
        aNewC = -2*(this.aA)  +2*(this.aB)+ 3*(this.aC);
    Triple aNewTriple3 = new Triple(aNewA, aNewB, aNewC);

  }//end-method generateTriples

}//end-class Triple
