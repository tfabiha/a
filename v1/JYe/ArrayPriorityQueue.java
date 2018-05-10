import ArrayList.java.util;
public class ArrayPriorityQueue implements PriorityList{

  ArrayList _data;
  public ArrayPriorityQueue(){
    _data = new ArrayList(); 
  }
  public boolean isEmpty(){
    return _data.size() == 0;
  }
  public void add(String x){
    _data.add(x);
  }
  public String peekMin(){
    String min = _data.get(0);
    for (String a: _data){
      if (a.compareTo(min) < 1){
        min = a;
      }
    }
    return min;
  }
  public String removeMin(int i){
    String min = _data.get(0);
    int minIndex = 0;
    for (int i = 1; i < _data.size(); i++){
      a = _data.get(i);
      if (a.compareTo(min)< 1){
        min = a;
        minIndex = i;
      }
    }
    return minIndex;
  }
  public static void main(String[] args){
    PriorityList apq = new ArrayPriorityQueue();

    apq.add("a");
    apq.add("b");
    apq.add("c");

    System.out.println(apq.peekMin()); //a

    System.out.println(apq.removeMin()); //a
    System.out.println(apq.removeMin()); //b
    System.out.println(apq.removeMin()); //c
  }
}
