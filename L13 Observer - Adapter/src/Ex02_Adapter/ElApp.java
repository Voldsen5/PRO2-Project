package Ex02_Adapter;

public class ElApp extends Item{

    public ElApp() {
        super();
    }

    @Override
    public double calcVAT() {
        return getNetprice() * 1.3 < 3 ? 3 : getNetprice()*1.3;
    }
}
