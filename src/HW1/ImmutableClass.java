package HW1;

import java.util.Date;

public class ImmutableClass {
     public static void main(String[] args) {
         MyDateTime date = new MyDateTime();
         System.out.println(date.getDate().toString());
     }
}

class MyDateTime {
    private final Date DATE;

    public MyDateTime() {
        DATE = new Date();
    }

    public Date getDate() {
        return DATE;
    }
}

