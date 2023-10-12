package Ex03_Strategy;

public class FieldEvaluator {
    private Evaluator evaluator;

    public Evaluator getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    /** Returns true, if the evaluator accepts s as a valid string. */
    public boolean evaluate(String s) {
        return evaluator.isValid(s);
    }
}
