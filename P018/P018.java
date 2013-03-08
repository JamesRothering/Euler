//question: why should an empty while loop without braces following
//  lead to the compiler "expecting a class" message?
//first off, we try to calculate the number of possible combos
//  given that we are told that there are 16,384 routes possible
//so my first step is to make sure that I'm calcualting all the routes
// possible, and so I need to be sure that I agree with the num routes
//  I'm told are possible
//This makes sense: given n rows of data there are 2^(n-1) paths,
// because there are binary possiblities for every node but the first
//So my "tuned" approach, to try to avoid brute-force is to
// load up the data into a 2-d array of nodes, where each node points
// to the upstream node on the left or right which might have choosen
// this child node as part of it's path.
// Then, by starting at the final row and memo-izing the best possible choices
// from the next higher row, we should have a more efficient algorithm.
import java.io.*;

public class P018
{

  private static final String aFileName = "data1.txt";
  public static void main(String[] args)
  {
    Node aRoot = loadData(); //store the root so we don't get GC network of nodes!
    setLinks(aRoot);         //create links from parent Node to Child node(left and right)
    processData(aRoot);      //  and end up with bugger-all for our trouble
  }

  public static void processData(Node aRootNode)
  {
System.out.println("++++++++starting the processing++++++++++");
    System.out.println(aRootNode.allNodes.length);
    for (int i = aRootNode.allNodes.length-1; i <aRootNode.allNodes.length-1; )
    {//for the last row only, set aBestCumPathTotal = aVal
      for (int j = aRootNode.allNodes[i].length-1; j >= 0; j--)
      {
        aRootNode.allNodes[i][j].setBestCumPathTotal
         (
          aRootNode.allNodes[i][j].getVal()
         );
      }
    }

    for (int i = aRootNode.allNodes.length-2; i >= 0; i--)
    {//length-1 for zero indexing adjustment; length-2 to skip the bottommost row
     //  this is a rollup of data to the layer above
      for (int j = (aRootNode.allNodes[i].length-1) ;
           j >= 0;
            j--
          )
      {//unfortunately we don't know how many columns are full &
       // how many are null
        Node curNode = aRootNode.allNodes[i][j]; //save retyping
        if (null == curNode )
        {/*do nothing*/}
        else 
        {
          System.out.println("i=" + i + " j=" + j);
          curNode.print();
          curNode.getLeftNode().getVal();

          System.out.println("got here");
          curNode.setBest(
                           (  (curNode.getLeftNode()).getBestCumPathTotal() >
                              (curNode.getRightNode()).getBestCumPathTotal()
                           )  ?
                             Side.LEFT
                           : Side.RIGHT
                         );
          curNode.setBestCumPathTotal(
                              (  (curNode.getLeftNode()).getBestCumPathTotal() >
                                 (curNode.getRightNode()).getBestCumPathTotal()
                              )  ?
                                 curNode.getLeftNode().getBestCumPathTotal()
                              :  curNode.getRightNode().getBestCumPathTotal()
                            );
          curNode.print();
        }
      }//e-for
    }//e-for
  }

  public static void setLinks(Node aRoot)
  { //re-traverse all the nodes and set up linkages 
System.out.println("========starting to do the linkage================");
    for (int i = 0; i <= aRoot.allNodes.length-2;  i++)
    {//length-1 for zero-indexing;length-2 to also avoid the last row
      for (int j = 0; j < aRoot.allNodes[i].length-1; j++)
      {
        if(null != aRoot.allNodes[i][j])
        { /*don't know how many entries are full; the end will be null*/
          aRoot.allNodes[i][j].setLeftNode(aRoot.allNodes[i+1][j]);
          aRoot.allNodes[i][j].setRightNode(aRoot.allNodes[i+1][j+1]);
//aRoot.allNodes[i][j].print();
        }
      }
    }
  }

  public static Node loadData()
  {
    System.out.println("loading up the data into a network of Nodes"
                      +" indexed by a 2-d array");
    int aCurrRow;
    try
    {
      FileReader aDataFile = new FileReader(aFileName);
      BufferedReader aData =  new BufferedReader(aDataFile);
      String aLine;
      aCurrRow = 0;
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
  return Node.getNode(0,0); //return the root to retain visibility and avoid GC
  }
}

enum Side {LEFT, RIGHT, NULL};

class Node
{
  public static final int aSizeR = 4;
  public static final int aSizeC = 4;

  private  final int aRow;
  private  final int aCol;
  private  final int aVal;
  private  Node aLeftNode = null;
  private  Node aRightNode = null;
  static   protected  Node[][]  allNodes = new Node[aSizeR][aSizeC];
  private  Side   aBestDownStreamChoice = Side.NULL;
  private  int      aBestCumPathTotal = 0;


  private  static void setNode(int aRow, int aCol, Node aNode)
  {
    allNodes[aRow][aCol]=aNode; //track them for later traversal 
  }

  protected static Node getNode(int aRow, int aCol )
  {
    return allNodes[aRow][aCol];
  }

  protected Node getNode()
  {
    return this;
  }

  protected void setLeftNode(Node aNode)
  {
    this.aLeftNode=aNode;
  }

  protected void setRightNode(Node aNode)
  {
    this.aRightNode=aNode;
  }

  Node(int aRow, int aCol, int aVal)
  {

    this.aRow = aRow;
    this.aCol = aCol;
    this.aVal = aVal;
    Node.setNode(aRow,aCol,this);
  }

  protected Node getLeftNode()
  {
    return this.aLeftNode;
  }

  protected Node getRightNode()
  {
    return this.aRightNode;
  }

  public int getVal()
  {
    return aVal;
  }

  public Side getBest()
  {
    return aBestDownStreamChoice;
  }

  public void setBest(Side aSide)
  {
    aBestDownStreamChoice = aSide;
  }

  public void setBestCumPathTotal(int aVal)
  {
    this.aBestCumPathTotal = aBestCumPathTotal+aVal;
  }

  public int getBestCumPathTotal()
  {
    return this.aBestCumPathTotal;
  }

  void print()
  {
    System.out.println("aRow=" + aRow + " aCol=" + aCol + " aVal=" + aVal);
    System.out.println("=====> LeftNode = " + aLeftNode);
    System.out.println("======>RightNode = " + aRightNode);
    System.out.println("=====> best choice=" +aBestDownStreamChoice);
    System.out.println("=====> best cum total=" + aBestCumPathTotal);
  }
}
