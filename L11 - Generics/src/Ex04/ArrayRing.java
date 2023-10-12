package Ex04;

import java.util.ArrayList;

public class ArrayRing<E> implements Ring<E>{

    private final ArrayList<E> items = new ArrayList<>();
    private E currentItem;

    public ArrayRing() {
        currentItem = null;
    }

    @Override
    public void advance() {
        if(!isEmpty()){
            currentItem = items.indexOf(currentItem) == size() - 1 ? items.get(0) : items.get(items.indexOf(currentItem));
        }
    }

    @Override
    public E getCurrentItem() {
        if(isEmpty()){
            throw new EmptyRingException("Ring is empty");
        }
        return currentItem;
    }

    @Override
    public void add(E item) {
        items.add(item);
        currentItem = item;
    }

    @Override
    public boolean removeItem(E item) {
        if(items.contains(item)){
            if(item.equals(getCurrentItem())){
                advance();
            }
            items.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public E removeCurrentItem() {
        if(isEmpty()){
            throw new EmptyRingException("Ring is empty");
        } else{
            E oldCurrent = items.remove(items.indexOf(currentItem));
            advance();
            return oldCurrent;
        }
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }
}
