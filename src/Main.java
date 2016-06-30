import java.util.*;
import java.io.*;

public class Main 
{
  public static void main(String[] args) {
    
    //Create reference to BinarySearchTree
    BinarySearchTree tree = new BinarySearchTree();
    Scanner file = null;
    
    //Read in text file
    try{
      file = new Scanner(new BufferedReader(new FileReader("TextFile.txt")));
      while(file.hasNext()){
        tree.insert(file.next());
      }
    }catch (Exception ex) { 
    }
    file.close();
    
     System.out.println("Print out all elements in the tree:");
     tree.print();
  }
}