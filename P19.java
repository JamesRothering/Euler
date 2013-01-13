public class P19
{
  private static String aDay   = "Monday";
  private static int    aDate  = 1;
  private static int    aMonth = 1;
  private static int    aYear  = 1900;

  public static void main(String[] argv)
  {
    addWeek();
    printDate();
  }//end-main

  private static void addWeek()
  {
    for (int i =0; i < 7; i++)
    {
      addDay();
    }//end-for
  }//end-method addWeek

  private static void addDay()
  { // April, June, September, and November
    switch (aMonth)
    {
      case 4:
      case 6:
      case 9:
      case 11: {if (aDate < 30) {aDate++;nextDay();}
                      else {aDate=1; nextDay();}
                     break;
                     }
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
                     {if (aDate < 31) {aDate++;nextDay();}
                      else {aDate=1; nextDay();}
                     break;
                     }
      case 2:        {
                       if (0 == aYear%4)
                       {
                         if (aDate < 29)
                         { aDate++;
                           nextDay();
                         }//end-if
                         else
                         { aDate = 1;
                           nextDay();
                         }
                       }//end-if
                       else //Feb normal year
                       {
                         if (aDate < 28)
                         { aDate++;
                           nextDay();
                         }
                         else
                         {
                           aDate=1;
                           nextDay();
                         }//end-else
        
                       }//end-else
                       break;
                     }//end-case
    }//end-switch
  }//end-addDay

  private static void nextDay()
  {
    switch (aDay)
    {
      case "Monday"    : { aDay = "Tuesday";   break; }
      case "Tuesday"   : { aDay = "Wednesday"; break; }
      case "Wednesday" : { aDay = "Thursday";  break; }
      case "Thursday"  : { aDay = "Friday";    break; }
      case "Friday"    : { aDay = "Saturday";  break; }
      case "Saturday"  : { aDay = "Sunday" ;   break; }
      case "Sunday"    : { aDay = "Monday" ;   break; }
    }//end-switch
  }//end-method

  private static void printDate()
  {
    System.out.println(aDay + " " + aDate + " " + aMonth + "," + aYear);
  }//end-method printDate
}//end-class P19
