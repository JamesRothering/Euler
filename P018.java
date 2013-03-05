//first off, we try to cal
// culate the number of possible combos
//  given that we are told that there are 16,384 routes possible

//so my first step is to make sure that I'm calcualting all the routes
// possible, and so I need to be sure that I agree with the num routes
//  I'm told are possible

//

public class P018
{
  static int aTotal = 1;
  public static void main(String[] args)
  {
    System.out.println("Calculating the number of routes possible");
    for (int i =15; i>0; i--)
    {
      System.out.println("i=" + i + " i!=" + getCombos(i) + " aTotal=" +
                          aTotal);
    }
  }

  public static int getCombos(int i)
  {
    int aReturn = i-1;
     i--;
     aReturn = aReturn*2;
     aTotal = aTotal*aReturn;
     return aReturn;
  }
}
/*

      1      2          3            5
     1      2          3            5
    1      2          3              5
   1      2          1 3            5 
  1        2        1 3 4          5 6

*/
