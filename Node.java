public class Node {
  
  private String data;
  private Node left;
  private Node right;
  public int counter;
  
  public Node(String x) {
    data = x;
    left = null;
    right = null;
    counter = 1;
  }
  
public String getData() {
  return data;
 }
 public void setData(String data) {
  this.data = data;
 }
 public Node getLeft() {
  return left;
 }
 public void setLeft(Node left) {
  this.left = left;
 }
 public Node getRight() {
  return right;
 }
 public void setRight(Node right) {
  this.right = right;
 }
 public void print() {
  System.out.println(this.data + " " + this.counter);
  }
}