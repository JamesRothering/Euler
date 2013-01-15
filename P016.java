import java.math.BigInteger;
public class P016
{
  private static BigInteger aNum = new BigInteger("2"); 
  public static void main(String[] argv)
  {
    aNum = aNum.pow(1000);
    System.out.println("num=" + aNum);
//why doesn't toByteArray create a byte array with the digits in it?
//    byte[] aNum2 = aNum.toByteArray();
    String aNum2 = aNum.toString();
    int aTot = 0;
    for (int i = 0;
         i < aNum2.length();
         i++)
    {
      System.out.println(aNum2.charAt(i));
//why doesn't this correctly take the char and cast it as an int?
//      aTot= aTot + (int) aNum2.charAt(i);
        aTot = aTot + Character.getNumericValue(aNum2.charAt(i));
    }
    System.out.println("Total =" + aTot);
  }//end-main
}//end-class P16

