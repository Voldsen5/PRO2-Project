package Ex03_Strategy;

public class NumberEvaluator implements Evaluator {
    /** Returns true, if s contains a valid integer or decimal number. */
    @Override
    public boolean isValid(String s) {
        try{
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }
}
