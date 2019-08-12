class DNode<T>{
  private T data;
  private DNode next;
  private DNode prev;

  DNode(){
    data = null;
    next = prev = null;
  }

  DNode(T data){
    this.data = data;
    next = prev = null;
  }

  DNode(T data, DNode next, DNode prev){
    this.data = data;
    this.next = next;
    this.prev = prev;
  }

  public void setData(T data){
    this.data = data;
  }

  public void setNext(DNode next){
    this.next = next;
  }

  public void setPrev(DNode prev){
    this.prev = prev;
  }

  public T getData(){
    return data;
  }

  public DNode getNext(){
    return next;
  }

  public DNode getPrev(){
    return prev;
  }

  @Override
  public String toString(){
    return String.format(""+data);
  }
}