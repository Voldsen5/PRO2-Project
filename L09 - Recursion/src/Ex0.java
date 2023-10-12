import java.util.List;

public class Ex0 {
    public static void main(String[] args) {
        List<Integer> list = List.of(4,7,3,9,10,32);
        System.out.println(evenCount(list));
    }

    public static int evenCount(List<Integer> list){
        return evenCount(list,0, 0);
    }

    public static int evenCount(List<Integer> list, int counter, int index){
        if(index >= list.size()){
            return counter;
        }else{
            int number = list.get(index);
            return number % 2 == 0 ? evenCount(list, counter +1, index +1)
                                    :evenCount(list, counter, index +1);
        }
    }
}
