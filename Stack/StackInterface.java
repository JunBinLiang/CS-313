public interface StackInterface<T>{
    public T pop();
    public void push(T x);
    public T peek();
    public int size();
    public boolean isEmpty();
}