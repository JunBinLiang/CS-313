class LinkedStack<T> implements StackInterface<T>{
    private SLinkedList<T> stack;
    private int size;
    public LinkedStack() {
        stack = new SLinkedList<>();
        size = 0;
    }

    @Override
    public T pop() {
        if(size==0){
            System.out.println("No such element");
            return null;
        }
        T data=stack.headData();
        size--;
        stack.removeHead();
        return data;
    }

    @Override
    public void push(T x) {
       size++;
       stack.addHead(x);
    }

    @Override
    public T peek() {
        if(size==0){
            return null;
        }
        return stack.headData();
        
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    
    @Override
    public String toString(){
    
        return stack.toString();
    }
      
}
