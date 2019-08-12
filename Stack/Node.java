class Node<T>{
  private T data;
  private Node next;

  Node(){
    data = null;
    next = null;
  }

  Node(T data){
    this.data = data;
    next = null;
  }

  Node(T data, Node next){
    this.data = data;
    this.next = next;
  }

  public void setData(T data){
    this.data = data;
  }

  public void setNext(Node next){
    this.next = next;
  }

  public T getData(){
    return this.data;
  }

  public Node getNext(){
    return next;
  }

  @Override
  public String toString(){
    return String.format(""+this.data);
  }
}
