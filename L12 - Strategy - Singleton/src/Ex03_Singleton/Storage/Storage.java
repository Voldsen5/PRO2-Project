package Ex03_Singleton.Storage;

public class Storage {
    private static Storage uniqueInstance;

    private Storage(){}

    public static Storage getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Storage();
        }
        return uniqueInstance;
    }
}
