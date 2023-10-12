package Ex04;

public class Word implements Comparable<Word>{
    private String word;
    private int amount;

    public Word(String word) {
        this.word = word;
        this.amount = 1;
    }

    public String getWord() {
        return word;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(){
        amount++;
    }

    @Override
    public String toString() {
        return word + ": " + amount + "\n";
    }

    @Override
    public int compareTo(Word o) {
        return this.word.compareTo(o.word);
    }
}
