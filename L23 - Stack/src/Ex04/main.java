package Ex04;

public class main {
    public static void main(String[] args) {
        System.out.println(evaluate("12 2 5 + - 4 * 2 /"));
    }

    /**
     * calculates the value of a given postfix expression
     * @throws RuntimeException if the postfix expression isn't valid
     * @param input
     * @return
     */
    public static int evaluate(String input){
        LinkedStack<String> stack = new LinkedStack<>();
        String[] split = input.split(" ");
        int i = 0;
        int num1;
        int num2;
        while(i < split.length){
            if(split[i].matches("[0-9]*")){
                stack.push(split[i]);
            } else if(split[i].equals("+")){
                if(stack.size <= 1){
                    throw new RuntimeException();
                } else {
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    num1 = num2 + num1;
                    stack.push("" + num1);
                }
            } else if (split[i].equals("-")){
                if(stack.size <= 1){
                    throw new RuntimeException();
                } else {
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    num1 = num2 - num1;
                    stack.push("" + num1);
                }
            } else if (split[i].equals("*")){
                if(stack.size <= 1){
                    throw new RuntimeException();
                } else {
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    num1 = num2 * num1;
                    stack.push("" + num1);
                }
            } else if (split[i].equals("/")){
                if(stack.size <= 1){
                    throw new RuntimeException();
                } else {
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    num1 = num2 / num1;
                    stack.push("" + num1);
                }
            } else {
                throw new RuntimeException();
            }
            i++;
        }
        return Integer.parseInt(stack.pop());
    }
}
