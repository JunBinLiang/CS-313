 */
public class SLL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SLinkedList<Integer> list = new SLinkedList<>();
        
         list.remove(8);
         System.out.println(list);
         System.out.println(list.get(8));
        
         list.append(5);
         list.append(4);
         list.append(4);
         list.append(8);
         list.append(1);
         System.out.println(list);
          //list.set(4,5);
         // Node t = list.get(8);
         //System.out.println(t);

        list.remove(8);System.out.println(list);

       // System.out.println(list.get(6));
        list.append(8);System.out.println(list);
        list.remove(1);System.out.println(list);
        list.remove(8);System.out.println(list);
        list.append(8);System.out.println(list);
        list.append(8);System.out.println(list);
        list.remove(70);
        list.set(8,1);System.out.println(list);
        //no 10, append it
        list.set(10,10);System.out.println(list);
        list.remove(1);System.out.println(list);
        list.remove(1);System.out.println(list);
        list.remove(10);System.out.println(list);
        list.append(80);System.out.println(list);
        list.append(80);System.out.println(list);
        list.set(80,10);System.out.println(list);
        System.out.println(list.get(80));
        System.out.println(list.get(10));
        System.out.println(list.get(18));
        System.out.println(list);

    }
    
}