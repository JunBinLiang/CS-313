public class StackTest {

 
    public static void main(String[] args) {

        
        LinkedStack<Integer> stack=new LinkedStack();
        stack.push(1);stack.push(2);stack.push(4);
        System.out.println(stack);System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.pop();System.out.println(stack);
        stack.pop();System.out.println(stack);
        stack.pop();System.out.println(stack);stack.push(1);stack.push(2);stack.push(4);
        System.out.println(stack);
    }
    
}