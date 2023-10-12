package ex00;

public class CitySingleLinkedListDemo {

    public static void main(String[] args) {
        City paris = new City("Paris", 12000000);
        City rom = new City("Rom", 900000);
        City london = new City("London", 900000);
        City amsterdam = new City("Amsterdam", 700000);
        City oslo = new City("Oslo", 12000);

        CitySingleLinkedList list = new CitySingleLinkedList();
        list.addFirst(oslo);
        list.addFirst(rom);
        list.addFirst(london);
        list.addFirst(amsterdam);
        list.addFirst(paris);

        System.out.println("Inhabitants of all the cities = " + list.totalInhabitants());

        System.out.println("COUNT: " + list.count());
        System.out.println();

        list.removeCity(rom);
        list.removeFirst();

        System.out.println("COUNT: " + list.count());
        System.out.println();
        System.out.println("Inhabitants of all the cities = " + list.totalInhabitants());
    }
}
