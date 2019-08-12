class DLinkedList<T> implements List<T>{
  private DNode<T> header, trailer;
  private int size;

  DLinkedList(){
    header = new DNode<T>();
    trailer = new DNode<T>(null, null, header);
    header.setNext(trailer);
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }    

  public String toString(){
    StringBuilder ans = new StringBuilder();
    DNode trav = header;
    ans.append("Header <--> ");
    trav = trav.getNext();
    while(trav!=trailer){
      ans.append(trav.toString() + " <--> ");
      trav = trav.getNext();
    }
    ans.append("Trailer");
    return ans.toString();

  }

    @Override
    public void append(T x) {
        
        DNode data=new DNode(x);
        DNode pre=trailer.getPrev();
        pre.setNext(data);
        data.setPrev(pre);
        data.setNext(trailer);
        trailer.setPrev(data);
        size++;
    }

    @Override
    public void remove(T target) {
       DNode beRemove=get(target);
       if(beRemove==null){
           System.out.println("No such element");
           return;
       }
       beRemove.getPrev().setNext(beRemove.getNext());
       beRemove.getNext().setPrev(beRemove.getPrev());
       beRemove.setNext(null);
       beRemove.setPrev(null);
       size--;
       
    }

    @Override
    public DNode get(T x) {
        if(size==0){
            System.out.println("No such element");
            return null;}
        DNode current=header;
        while(current!=null){
            if(current.getData()==x){
                return current;
            }
            current=current.getNext();
        }
        

        return current;
    }

    @Override
    public void set(T old, T replace) {
        DNode target=this.get(old);
        if(target==null){
            size++;
            this.append(replace);
            return;
        }
        target.setData(replace);
    }
}
