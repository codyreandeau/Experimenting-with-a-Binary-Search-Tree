public class BST {
 
  public Node root;
  
/**
 * Insert method with one parameter
 */
  void insert(int data) {
    insert(root, data);
  }
  
/**
 * Method to insert a new node in order
 * in our binary search tree
 */
  Node insert(Node node, int data){
    if(root==null){
      node = new Node(data);
      return node;
    }
    if(data < root.getData()){
      node.setLeft(insert(node.getLeft(), data));
    }else if (data > root.getData()){
      node.setRight(insert(node.getRight(), data));
  }
    return node;
  }
}