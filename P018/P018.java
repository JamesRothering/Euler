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
//  public static final int aSizeR=15;
//  public static final int aSizeC=15;

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
        String[] sVals = aLine.split("\\s");
        for (int i =0; i< sVals.length; i++)
        {
          Node aNode = new Node(aCurrRow,
                                i, 
                                ( new Integer(sVals[i])).intValue() 
                               );
          aNode.print();
        }
        aCurrRow++;
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
  public static final int aSizeR=15;
  public static final int aSizeC=15;

  private  final int aRow;
  private  final int aCol;
  private  final int aVal;
  private  Node aLeftNode = null;
  private  Node aRightNode = null;
  static   private  Node[][]  allNodes = new Node[aSizeR][aSizeC];

  private  static void setNode(int aRow, int aCol, Node aNode)
  {
    allNodes[aRow][aCol]=aNode; //track them for later traversal 
  }

  private static Node getNode(int aRow, int aCol )
  {
    return allNodes[aRow][aCol];
  }

  Node(int aRow, int aCol, int aVal)
  {
    Node.setNode(aRow,aCol,this);
    this.aRow = aRow;
    this.aCol = aCol;
    this.aVal = aVal;
    Node.setNode(aRow,aCol,this);
    if (aRow>1)
    {
      this.aLeftNode  = getLeftNode(aRow,aCol);
      this.aRightNode = getRightNode(aRow,aCol);
    }
  }

  static Node getLeftNode(int aRow, int aCol)
  {
    if (0 == aCol)
      return null; //a left-most entry has no left node!
    else
    {
      int retRow = aRow-1;
      int retCol = aCol-1;
      return(allNodes[retRow][retCol]);
    }
  }

  static Node getRightNode(int aRow, int aCol)
  {
    if (0 == aRow)
      return null;
    else
    {
      if (aCol < allNodes[aRow-1].length)
      {
        return allNodes[aRow-1][aCol] ;
      }
      else
        return null; // last entry doesn't have a rightNode parent!
    }
  }

  void print()
  {
    System.out.println("aRow=" + aRow + " aCol=" + aCol + " aVal=" + aVal);
  }
}

