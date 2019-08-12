public class DLLTest {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
    DLinkedList<Integer> list = new DLinkedList<>(); 
    list.remove(4);
    System.out.println(list);
    list.remove(4);
    System.out.println(list);
    list.append(4);System.out.println(list);
    list.remove(4);
    System.out.println(list);
    
    list.append(5);
    list.append(4);
    list.append(8);
    list.append(9);
    System.out.println(list);

    DNode t = list.get(81);
    System.out.println(t);
    
    DNode t1 = list.get(8);
    System.out.println(t1);

    list.remove(4);
    System.out.println(list);
    
    list.remove(9);
    System.out.println(list);
    list.remove(5);
    System.out.println(list);
    list.append(8);
    list.append(1);System.out.println(list);
    list.set(1,3);System.out.println(list);
    list.set(7,4);System.out.println(list);
    
    
    //System.out.println(list.get(6));
  }
    
}
