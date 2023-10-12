package Ex02_Adapter;

public class AlcoAdapter extends Item{

    AlcoBev alcoBev;

    public AlcoAdapter(AlcoBev alcoBev) {
        super();
        this.alcoBev = alcoBev;
    }

    @Override
    public double getNetprice() {
        return alcoBev.getTheNetprice();
    }

    @Override
    public void setNetprice(double price) {
        alcoBev.setTheNetprice(price);
    }

    @Override
    public String getName() {
        return alcoBev.getTheDescription();
    }

    @Override
    public void setName(String name) {
        alcoBev.setTheDescription(name);
    }

    @Override
    public double calcVAT() {
        return alcoBev.getVat();
    }
}
