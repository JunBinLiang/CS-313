public class QueueTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue queue=new Queue();
        queue.dequeue();
        queue.enqueue(1);queue.enqueue(2);queue.enqueue(3);
        //System.out.println(queue);
        queue.enqueue(4);
        
        queue.dequeue();System.out.println(queue);
        System.out.println(queue.peek());
        queue.enqueue(4);queue.dequeue();System.out.println(queue);
        queue.dequeue();queue.dequeue();System.out.println(queue);queue.enqueue(4);
        queue.enqueue(1);queue.enqueue(14);queue.enqueue(4);
        System.out.println(queue);
    }
    
}