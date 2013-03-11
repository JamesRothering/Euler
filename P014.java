//longest Collatz sequence
import java.util.*;
class P014
{
  private TreeList<Integer,Integer> sNumTerms = new TreeList<Integer,Integer>(); //memoize

  public void updateNumTerms(Integer aValue, Integer aNumTerms)
  {
    sNumTerms.add(aValue.intValue(), aNumTerms);  
  }

  public static void main(String[] argv)
  {
    TracePath aCollatz;
    TreeList sResults;
    for (int i = 13; i < 14; i++)
    {
      aCollatz = new TracePath();
      aCollatz.doIt(i);
      sResults = aCollatz.getCollatz();
      for (int j = sResults.size() - 1; j > -1; j--)
      { //memoize the answers here
System.out.println("put the term in the memo:" +
                    sResults.get(sResults.size() - 1));
        sNumTerms.put(aResults.remove(sResults.size() -1));
      }

    }
  }
}

class TracePath
{
  TreeList<Integer,Integer> aPath = new TreeList<Integer,Integer>();

  public ArrayList<Integer> getCollatz();
  {
   return this.aPath;
  }

  public void doIt(int aStart)
  {
    System.out.println("Starting at:" + i);
    int j = aStart; // j==>current # in use; k==>num path elements
    k = 1; //to include the starting at number
    while (j != 1)
    {
      k++;
      if (0 == j%2)
      {//when even take one path

        j = j/2;
        System.out.println("==> " + j);
      }
      else
      {//when odd, take another
        j = 3*j + 1;
        System.out.println("==> " + j);
      }
    }//e-while
    System.out.println("**** # of path elements:" + k);
  }
}


