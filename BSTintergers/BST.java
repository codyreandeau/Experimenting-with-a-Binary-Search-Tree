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
  
  public boolean remove(int data) {
    Node current = root;
    Node parent = root;
    boolean isLeft = true;
    
    while(current.getData() != data) {
      //parent node stays one node behind current
      parent = current;
    
      //Check if our node is on the left or right 
      //of the tree
      if(data < current.getData()) {
        isLeft = true;
        current = current.getLeft();
      } else {
          isLeft = false;
          current = current.getRight();
      }
      
      //If node was not found
      if(current == null) {
        return false;
      }
    }
      
    //If the node does not have any children
      if (current.getLeft() == null && current.getRight() == null){
        if (current == root) {
          root = null;
        } else if(isLeft) {
          parent.setLeft(null);
        } else {
          parent.setRight(null);
        }
      }
      
      //If we have a case where just the right child is null
     else if(current.getRight() == null) {
        if(current == root)
          root = current.getLeft();
      } else if (isLeft) {
        parent.setLeft(current.getLeft());
      } else {
        parent.setRight(current.getLeft());
      }
      
      //If we have a case where just the left child is null
      if(current.getLeft() == null) {
        if(current == root){
          root = current.getRight();
        }else if(isLeft){
          parent.setLeft(current.getRight());
        } else {
          parent.setRight(current.getRight());
        }
      }
        
      //If we are faced with two child nodes 
        else {
          
          Node replace = getReplaceNode(current);
          
          if(current == root) {
            root = replace;
          } else if (isLeft) {
            parent.setLeft(replace);
          } else {
            parent.setRight(replace);
          }
          
          replace.setLeft(current.getLeft());
  }
      return true;
  }
  
  public Node getReplaceNode(Node replace) {
    Node replaceParent = replace;
    Node replacement = replace;
    Node current = replace.getRight();
    
    //execute until no more left children
    while (current!= null) {
      replaceParent = replace;
      replacement = current;
      current = current.getLeft();
    }
     if(replacement != replace.getRight()) {
       replaceParent.setLeft(replacement.getRight());
       replacement.setRight(replace.getRight());
      }
        return replacement;     
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

/** 
 Finds the largest value in the tree
*/ 
public int maxValue(Node node) {
  Node current = node;
  while(current.getRight() != null) {
    current = current.getRight();
  }
  return current.getData();
 }

/** 
 Finds the smallest value in the tree
*/ 
public int minValue(Node node) {
  Node current = node;
  while(current.getLeft() != null) {
    current = current.getLeft();
  }
  return current.getData();
 }

/** 
 Adds up how many elements are in the 
 tree. This is the 'size' of the tree.
*/ 
public int size(Node node) { 
  if (node == null) {
    return(0); 
  }else { 
    return(size(node.getLeft()) + size(node.getRight()) + 1); 
  } 
} 

/**
 * See if the tree contatins
 * a specified element
 */
public boolean contains(int data, Node node) {
  
 if(node==null) {
  return false;
 } else if(data == node.getData()) {
    return true;
  } else if (data < node.getData()) {
    return contains(data, node.getLeft());
  } else {
    return contains(data, node.getRight());
  }
  }
}