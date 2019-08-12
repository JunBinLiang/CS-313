class Queue<T> implements QueueInterface<T>{
    private T data[];
    private int front, back, size, capacity; 

    public Queue() {
        capacity = 3;
        data = (T[]) new Object[capacity];
        front = back = size = 0;
     }

    public Queue(int c) {
        capacity = c;
        data = (T[]) new Object[capacity];
        front = back = size = 0;
    }

    public String toString() {
        int i, j;
        StringBuilder ans = new StringBuilder();
        ans.append("Queue:  ");
        for (i = 0, j = front; i < size; i++, j++) {
           if (j == capacity)
              j = 0;
           ans.append(data[j] + " -> ");
        }
        return ans.toString();
     }


    
    @Override
    public void enqueue(T x) {
       if(size==capacity){
           System.out.println("Queue is filled");
           return;
       }
       size++;
       data[back%capacity]=x;
       back++;
       if(back>capacity){
           back=back%capacity;
       }
    }

    @Override
    public T dequeue() {
        if(size==0){
            System.out.println("Queue is empty"); 
           return null;
        }
        size--;
        T element=data[front%capacity];
        front++;
        if(front>capacity){
           front=front%capacity;
       }
        return element;
        
    }

    @Override
    public T peek() {
         if(size==0){
             return null;
         }
         return data[front&capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
