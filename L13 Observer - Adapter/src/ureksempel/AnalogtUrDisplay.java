package ureksempel;

// Observer
public class AnalogtUrDisplay implements UrEngineObserver {

//    @Override
//    public void update(UrEngine ur) {
//        int tid = ur.getTid();
//        System.out.println("Analogt " + tid);
//    }

    @Override
    public void update(int tid) { // push
        System.out.println("Analogt " + tid);
    }
}
