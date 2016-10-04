public class Main {
  
  public static void main(String[] args) {
    
    BST tree = new BST();
    
    tree.insert(6);
    tree.insert(4);
    tree.insert(8);
    tree.insert(2);
    tree.insert(3);
    tree.insert(5);
    
    System.out.println("Print items out using inOrder method:");
    tree.inOrder(BST.root);
    System.out.println();
    System.out.println("Print items out using postOrder method:");
    tree.postOrder(BST.root);
    System.out.println();
    System.out.println("Print items out using preOrder method:");
    tree.preOrder(BST.root);
    System.out.println();
    System.out.println("The max depth of the tree is: " + tree.maxDepth(BST.root));
    System.out.println("The max value in the tree is: " + tree.maxValue(BST.root));
    System.out.println("The min value in the tree is: " + tree.minValue(BST.root));
  }
}