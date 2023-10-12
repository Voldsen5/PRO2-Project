package Ex02_Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Customer c1 = new Customer(1,"Henrik");
        Customer c2 = new Customer(2,"Anders");
        Customer c3 = new Customer(3, "Jerry");
        ArrayList<Customer> list = new ArrayList<>(List.of(c1, c3, c2));
        System.out.println(list);

        Customer.setComp(new CompName());
        Collections.sort(list);
        System.out.println(list);

        Customer.setComp(new CompNumb());
        Collections.sort(list);
        System.out.println(list);



    }

}
