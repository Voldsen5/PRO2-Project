package ex01;

import java.time.LocalDate;

public class Ex01 {
    /*
 Returns the amount of the fine according to the table above.
 Pre: calculatedDate < actualDate
      (calculatedDate is the expected return date and
       actualDate is the day you actually return the book)
*/
    public int calculateFine(LocalDate calculatedDate, LocalDate actualDate, boolean adult) {
        int x = calculatedDate.until(actualDate).getDays();
        if (adult) {
            if (x < 1) {
                return 0;
            } else if (x <= 7 && x >= 1) {
                return 20;
            } else if (x <= 14 && x >= 8) {
                return 60;
            } else if (x >= 15) {
                return 90;
            }
        } else {
            if (x < 1) {
                return 0;
            } else if (x <= 7 && x > 1) {
                return 10;
            } else if (x <= 14 && x >= 8) {
                return 30;
            } else if (x >= 15) {
                return 45;
            }
        }
        return 0;
    }
}
