class SLinkedList<T> implements List<T>{
  private Node head, tail;
  private int size;

  SLinkedList(){
    head = tail = null;
    size = 0;
  }

  SLinkedList(Node first){
    head = tail = first;
    size = 1;
  }

  public Node getHead(){
    if(head==null){return null;}
    return head;
  }

  public Node getTail(){
    if(tail==null){return null;}
    return tail;
  }

  private void setHead(Node head){
    this.head = head;
  }

  private void setTail(Node tail){
    this.tail = tail;
  }

  
  public T headData(){
      if(head==null){return null;}
      return (T)head.getData();
  }
  
  
  public void append(T x){
    addLast(x);
  }
  
  
  
  public void addLast(T x){
     if(size==0){
        Node<T> newNode = new Node<>(x);
        head=tail=newNode;
        size++;
        return;
     }
    Node<T> newNode = new Node<>(x);
    //System.out.println(tail.getData());
    tail.setNext(newNode);
    tail = newNode;
    size++;
  }
  public void remove(T target){
    Node location = get(target);
    remove(location);
  }
  public void remove(Node target){
    if(target==null){
        //System.out.println("No Such Element");
        return;
    }
    Node current = head;
    Node previous=null;
    while(current!=null){
        if(current==target){
            if(previous==null){
                //remove the head
                size--;
                this.setHead(head.getNext());
                return;
            }
            if(current==tail){
                //tail must be reset, other wise the append method would not work=>break list
                tail=previous;
                tail.setNext(null);
                size--;
                return;
            }
            
         previous.setNext(current.getNext());
         size--;
         return;
        }
        previous=current;
        current=current.getNext();
    }
   // System.out.println("No Such Element");
    
  }
  
 public void addHead(T data){
     if(size==0){
        Node<T> newNode = new Node<>(data);
        head=tail=newNode;
        size++;
        return;
     }
     Node<T> newNode = new Node<>(data);
     newNode.setNext(head);
     head=newNode;
     size++;
 
 } 
 
 public void removeHead(){
     if(size==0){
         return;
     }
     head=head.getNext();
     size--;
 }
 
 
  
  public Node get(T target){
    Node trav = head;
    while(trav!=null){
      if(trav.getData() == target){
        return trav;
      }
      trav=trav.getNext();
    }
    return trav;
  }

  public void set(T old, T replace){
    //Fill in
    Node location = get(old);
    if(location==null){
        this.append(replace);
        size++;
        return;
    }
    location.setData(replace); 
    return;
  }

  public String toString(){
    StringBuilder ans = new StringBuilder();
    Node trav = head;
    while(trav!=null){
      ans.append(trav.toString() + "->");
      trav = trav.getNext();
    }
    ans.append("null");
    return ans.toString();

  }
}