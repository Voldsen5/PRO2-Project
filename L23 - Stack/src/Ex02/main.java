package Ex02;

public class main {
    public static void main(String[] args) {
        System.out.println(matchingBrackets("(3+{5[99 {*}]}[23[{67}67]])"));
        System.out.println(matchingBrackets("(}){"));
    }

    public static boolean matchingBrackets(String s){
        //StackI<String> stack = new DequeStack<>();
        //StackI<String> stack = new LinkedStack<>();
        StackI<String> stack = new ArrayStack<>();
        String[] parentheses = s.replaceAll("[^()\\[\\]{}]","").split("");
        boolean matching = true;
        int i = 0;
        while(matching && i < parentheses.length){
            String e = parentheses[i];
            if(e.equals("(") || e.equals("[") || e.equals("{")){
                stack.push(e);
            } else{
                String peek = stack.peek();
                if(e.equals(")") && peek.equals("(")
                        || e.equals("]") && peek.equals("[")
                        || e.equals("}") && peek.equals("{")){
                    stack.pop();
                } else{
                    matching = false;
                }
            }
            i++;
        }
        return matching;
    }
}
