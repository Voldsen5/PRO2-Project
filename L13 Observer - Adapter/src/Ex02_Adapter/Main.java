package Ex02_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item marabou = new Food();
        marabou.setName("Marabou");
        marabou.setNetprice(27.95);

        Item kontaktGrill = new ElApp();
        kontaktGrill.setName("KontaktGrill");
        kontaktGrill.setNetprice(1099.95);

        AlcoBev vodka = new AlcoBev(169.95, "Grey Goose");
        Item vodkaAdapter = new AlcoAdapter(vodka);

        ArrayList<Item> items = new ArrayList<>(List.of(marabou,kontaktGrill,vodkaAdapter));
        System.out.printf("%-14s | %-8s | %s\n", "Navn", "Net Pris", "VAT");
        System.out.println("-----------------------------------");
        for(Item e : items){
            System.out.printf("%-14s | %-8.2f | %.2f\n", e.getName(), e.getNetprice(), e.calcVAT());
        }
    }
}
