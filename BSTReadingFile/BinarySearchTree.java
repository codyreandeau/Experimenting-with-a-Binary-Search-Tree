public class BinarySearchTree {

public Node root;

/**
 * Method to insert a new node in order
 * in our binary search tree
 */
public void insert(String x) {
      if (root == null) { 
         root = new Node(x);
         return;
      }
      Node current = root; 
      while (true) {
         if (x.compareTo(current.getData()) < 0) { 
           if (current.getLeft() != null) {
              current = current.getLeft();
           }else{ 
              current.setLeft(new Node(x));
              break; }
         }else if (x.compareTo(current.getData()) > 0) { 
           if (current.getRight() != null) {
              current = current.getRight();
           }else{ 
              current.setRight(new Node(x));
              break; }
         }else{
           current.counter++;
           break;
         }
      }
   }

  public void print() {
    this.print(this.root);
  }

/**
 * Method that prints out every node in the
 * Binary Search Tree
 */
public void print(Node temp){
    if (temp.getLeft() != null) {
      this.print(temp.getLeft());
    }
    temp.print();
    if (temp.getRight() != null){
      this.print(temp.getRight());
    } 
}
}
