public class BST {
 
  public Node root;
  
/**
 * Method to insert a new node in order
 * in our binary search tree
 */
  public void insert(int data) {
   root = insert(root, data);
  }
  
  public Node insert(Node node, int data){
    
    if(node==null){
      node = new Node(data);
    }else if (data < node.getData()){
      node.setLeft(insert(node.getLeft(), data));
    }else{
      node.setRight(insert(node.getRight(), data));
    }
    return node;
  }
  
/** 
 Prints the node values in the "inorder" order.  
*/ 
public void inOrder() { 
 inOrder(root); 
 System.out.println(); 
}

private void inOrder(Node node) { 
 if (node == null) 
   return;
 
 inOrder(node.getLeft()); 
 System.out.print(node.getData() + " "); 
 inOrder(node.getRight()); 
} 
}