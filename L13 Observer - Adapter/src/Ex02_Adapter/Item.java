package Ex02_Adapter;

public abstract class Item {
    private double netprice = 0;
    private String name = "";

    public double getNetprice(){
        return netprice;
    }

    public void setNetprice(double price){
        this.netprice = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double calcVAT(){
        return 0;
    }
}
