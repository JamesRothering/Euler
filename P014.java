//longest Collatz sequence
import java.util.*;
class P014
{
  private static HashMap<Integer,Integer> sNumTerms = new HashMap<Integer,Integer>(); 

  public static void main(String[] argv)
  {
    ArrayList<Integer> sResults;
//    for (int i = 13; i < 14; i++)
    for (int i = 1; i < 4; i ++)
    {

      sResults = getCollatz(i);
System.out.println("sResults.size() = " + sResults.size());
      for (int j = sResults.size() - 1; j > -1; j--)
      { //memoize the answers here; first store the number of terms of the
        //  term that was found in the hashmap, to add onto the additional
        //  terms already computed by the ArrayList.
        //  But 1st, if this is the base term, we just add it
        if (0 == sNumTerms.size() )
        {
          sNumTerms.put(sResults.remove(sResults.size() - 1),
                        sResults.size() + 1 ); //regular indexing on my HashMap
        }
        else
        {
          if (1 == sNumTerms.size() )
          {
            //do nothing. We already put the base case when there was nothing
            // and now we found it again
          }
          else
          {
            int aLastTerm      = sResults.get(sResults.size() - 1);
System.out.println("aLastTerm =" + aLastTerm);
System.out.println("sNumTerm has " + sNumTerms.size());
            int aNumTermsFound = sNumTerms.get(aLastTerm);
System.out.println("^^^^^got a NumTermsFound of " + aNumTermsFound);
System.out.println("put the term in the memo:" +
                    sResults.get(sResults.size() - 1));
            sNumTerms.put( (sResults.remove(sResults.size() - 1)),
                           (sResults.size()) + 1);
          }
          
        }
//*****************************************************************
System.out.println("now going to see what we got in the HashMap");
        Set<Integer> sKeys  = sNumTerms.keySet();
        for (Integer aKey: sKeys)
        {
          System.out.println("HashMap has: " + aKey +
                              " : " + sNumTerms.get(aKey));
        }
//****************************************************************
      }//e-for
    }
  }

  protected static ArrayList<Integer> getCollatz(int aStartVal)
  {
    ArrayList<Integer> aPath = new ArrayList<Integer>();

    System.out.println("Starting at:" + aStartVal);
    int k = 1, j = aStartVal; // j==>current # in use; k==>num path elements, including this starting term
    //store aStartVal in aPath, else we lose this term
    aPath.add(aStartVal);
    while (j != 1)
    {
      k++;
      if (0 == j%2)
      {//when even take one path
        j = j/2;
        System.out.println("==> " + j);
        aPath.add(j);
        if ( sNumTerms.containsKey(j) )
        {
System.out.println("found a repeat in the HashMap");
          break;
        }
      }
      else
      {//when odd, take another
        j = 3*j + 1;
        System.out.println("==> " + j);
        aPath.add(j);
        if ( sNumTerms.containsKey(j) )
        {
System.out.println("found a repeat in the HashMap");
          break;
        }
      }
    }//e-while
    System.out.println("**** # of path elements:" + k);
    return aPath;
  }
}


