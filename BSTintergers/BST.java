public class BST {
 
  public static Node root;
  
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
public void inOrder(Node node) { 
 if (node == null) 
   return;
 
 inOrder(node.getLeft()); 
 System.out.print(node.getData() + " "); 
 inOrder(node.getRight()); 
}

/** 
 Prints the node values in the "postorder" order.  
*/ 
public void postOrder(Node node) { 
   if (node == null) 
   return;
  
  postOrder(node.getLeft());
  postOrder(node.getRight());
  System.out.print(node.getData() + " ");
}

/** 
 Prints the node values in the "preorder" order.  
*/ 
public void preOrder(Node node) { 
   if (node == null) 
   return;
  
  System.out.print(node.getData() + " ");
  preOrder(node.getLeft());
  preOrder(node.getRight());
}

/** 
 Caclulates the number of nodes along the longest path
 from root to farthest leaf
*/ 
public int maxDepth(Node node) {
  if (node==null){
    return 0;
  }
  int leftDepth = maxDepth(node.getLeft());
  int rightDepth = maxDepth(node.getRight());
  
  if (leftDepth > rightDepth) {
    return(leftDepth+1); 
  }else{
    return(rightDepth+1); 
  }
}

public int maxValue(Node node) {
  Node current = node;
  while(current.getRight() != null) {
    current = current.getRight();
  }
  return current.getData();
 }

public int minValue(Node node) {
  Node current = node;
  while(current.getLeft() != null) {
    current = current.getLeft();
  }
  return current.getData();
 }
}