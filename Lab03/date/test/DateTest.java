import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_tc01() {
    Date today = new Date(1700, 6, 20);
    Date expectedTomorrow = new Date(1700, 6, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc02() {
    Date today = new Date(2005, 4, 15);
    Date expectedTomorrow = new Date(2005, 4, 16);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc03() {
    Date today = new Date(1901, 7, 20);
    Date expectedTomorrow = new Date(1901, 7, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc04() {
    Date today = new Date(3456, 3, 27);
    Date expectedTomorrow = new Date(3456, 3, 28);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc05() {
    Date today = new Date(1500, 2, 17);
    Date expectedTomorrow = new Date(1500, 2, 18);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc06() {
    Date today = new Date(1700, 6, 29);
    Date expectedTomorrow = new Date(1700, 6, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc07() {
    Date today = new Date(1800, 11, 29);
    Date expectedTomorrow = new Date(1800, 11, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc08() {
    Date today = new Date(3453, 1, 29);
    Date expectedTomorrow = new Date(3453, 1, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc09() {
    Date today = new Date(444, 2, 29);
    Date expectedTomorrow = new Date(444, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc10() {
    Date today = new Date(2005, 4, 30);
    Date expectedTomorrow = new Date(2005, 5, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc11() {
    Date today = new Date(3453, 1, 30);
    Date expectedTomorrow = new Date(3453, 1, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc12() {
    Date today = new Date(3456, 3, 30);
    Date expectedTomorrow = new Date(3456, 3, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc13() {
    Date today = new Date(1901, 7, 31);
    Date expectedTomorrow = new Date(1901, 8, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc14() {
    Date today = new Date(3453, 1, 31);
    Date expectedTomorrow = new Date(3453, 2, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc15() {
    Date today = new Date(3456, 12, 31);
    Date expectedTomorrow = new Date(3457, 1, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_invalid_tc16() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 31)
    );
  }

  @Test
  void nextDate_invalid_tc17() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 29)
    );
  }

  @Test
  void nextDate_invalid_tc18() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(-1, 10, 20)
    );
  }

  @Test
  void nextDate_invalid_tc19() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1458, 15, 12)
    );
  }

  @Test
  void nextDate_invalid_tc20() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, 6, -50)
    );
  }


  //test added to achieve 100% condition for when day>31
  @Test
  void nextDate_invalid_tc21() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, 6, 32)
    );
  }
  //
  //test for when day>30 and isthirtyDayMonth()==true
   @Test
  void nextDate_invalid_tc22() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, 9, 31)
    );
  }
 
 //test for when month==2 and isLeapYear()==true and day>29
   @Test
  void nextDate_invalid_tc23() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2000, 2, 30)
    );
  }

//test for when month has a negative value
  @Test
  void nextDate_invalid_tc24() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2000, -1, 10)
    );
  }


//test for when month>12
  @Test
  void nextDate_invalid_tc25() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2000, 13, 10)
    );
  }


//test for when year is divisible by 400
    @Test
  void nextDate_tc26() {
    Date today = new Date(1600, 1, 1);
    Date expectedTomorrow = new Date(1600, 1, 2);
    assertEquals(expectedTomorrow, today.nextDate());
  }
 


  //test for the isEndMonth() method for when the year is a leap year and day==31

    @Test
  void nextDate_tc27() {
    Date today = new Date(2000, 1, 31);
    Date expectedTomorrow = new Date(2000, 2, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  //test for the isEndMonth() method for when the year is a leap year and day==30 and its a 30 day month

    @Test
  void nextDate_tc28() {
    Date today = new Date(2000, 9, 30);
    Date expectedTomorrow = new Date(2000, 10, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  //testing the toString method
   @Test
  void nextDate_tc29() {
    Date today = new Date(2000, 9, 30);
    String expectedDate =  "2000/September/30";
    assertEquals(expectedDate, today.toString());
  }

  //testing the isEndOfMonth method
  @Test
  void nextDate_tc30() {
    Date today = new Date(2000, 2, 29);
    Date expectedTomorrow = new Date(2000, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }
   //testing the isEndOfMonth method
  @Test
  void nextDate_tc31() {
    Date today = new Date(2001, 2, 28);
    Date expectedTomorrow = new Date(2001, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }


//testing the .equals method when both objects are not of type Date

   @Test
  void nextDate_tc32() {
    Date today = new Date(2001, 2, 28);
    String expectedDay = "2001/February/28";
    assertEquals(expectedDay.equals(today),false);
  }

//testing the .equals method when both objects are of type Date

   @Test
  void nextDate_tc33() {
    Date today = new Date(2001, 2, 28);
    Date expectedDay = new Date(2001, 2, 28);
    assertEquals(expectedDay.equals(today),true);
  }
} 
