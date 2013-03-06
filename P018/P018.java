//question: why should an empty while loop without braces following
//  lead to the compiler "expecting a class" message?
//first off, we try to calculate the number of possible combos
//  given that we are told that there are 16,384 routes possible
//so my first step is to make sure that I'm calcualting all the routes
// possible, and so I need to be sure that I agree with the num routes
//  I'm told are possible
//This makes sense: given n rows of data there are 2^(n-1) paths,
// because there are binary possiblities for every node but the first
import java.io.*;

public class P018
{
  private static final String aFileName = "data1.txt"; 
  public static void main(String[] args)
  {
    System.out.println("loading up the data");
    try
    {
      FileReader aDataFile = new FileReader(aFileName);
      BufferedReader aData =  new BufferedReader(aDataFile);
      String         aLine;
      int            aCurrRow = 0;
      while ( (aLine = aData.readLine()) != null )
      {
        aCurrRow++;
        String[] sVals = aLine.split("\\s");
        for (int i =0; i< sVals.length; i++)
        {
          Node aNode = new Node(aCurrRow,
                                (new Integer(sVals[i])).intValue()
                               );
          aNode.print();
        }
        System.out.println();
      }//e-while
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}

class Node
{
  private  final int aRow;
  private  final int aVal;
  Node(int aRow, int aVal)
  {
    this.aRow = aRow;
    this.aVal = aVal;
  }

  void print()
  {
    System.out.println("aRow=" + aRow + " aVal=" + aVal);
  }
}

