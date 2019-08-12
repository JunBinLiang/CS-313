public interface QueueInterface<T>{
    public void enqueue(T x);
    public T dequeue();
    public T peek();
    public int size();
    public boolean isEmpty();
}
