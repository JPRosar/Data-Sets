import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;



public class JohnRosarAssignment3 {


public static <Profile> Profile createProfile(Scanner lineScanner, JohnRosarBinarySearchTree MyJohnRosarBST) 
{

    String name = lineScanner.nextLine();
    int City1 = lineScanner.nextInt();
    int City2 = lineScanner.nextInt();
    int Distance = lineScanner.nextInt();
   

    <Profile> Profile p = new Profile(City1, City2, Distance);
    MyJohnRosarBST.insertProfile(p);
    return p;
}
public class BST {
private static BSTNode root;

BST(){

}

public void insertProfile(Profile p){
   BSTNode currentNode = new BSTNode(p);
   if(root == null){
       root = currentNode;
   }
   else{
       recursiveMethod(currentNode);
   }
}

private static void recursiveMethod(BSTNode currentNode){
   Profile p1 = root.getProfile();
   Profile p2 = currentNode.getProfile();
   if(p1.getName().compareTo(p2.getName()) < 0 && currentNode.getLeft() != null){
       recursiveMethod(currentNode.getLeft());
   }
   if(p1.getName().compareTo(p2.getName()) > 0 && currentNode.getLeft() !=null){
       recursiveMethod(currentNode.getRight());
   }
}
public class BSTNode {
private BSTNode left;
private BSTNode right;
private Profile data; 

public BSTNode(Profile data){
   this.data = data;
   setLeft(left);
   setRight(right);
}

public Profile getProfile(){
   return data;
}
public void setLeft(BSTNode l){
   this.left = l;
}
public BSTNode getLeft(){
   return left;
}
public void setRight(BSTNode r){
   this.right = r;
}
public BSTNode getRight(){
   return right;
}
}
}
@SuppressWarnings("rawtypes")
public static JohnRosarBinarySearchTree readProfiles(JohnRosarBinarySearchTree MyJohnRosarBST){
    File inputFile = new File("Assignment3Data.txt");
    JohnRosarAssignment3.readFileDate(inputFile, MyJohnRosarBST);
    return MyJohnRosarBST;
}

public static void readFileDate(File inputFile, JohnRosarBinarySearchTree MyJohnRosarBST){
    Scanner in = null;
    try 
    {
        in = new Scanner(inputFile);
    } 
    catch (FileNotFoundException e) 
    {
        System.out.println("Cannot open file");
        System.exit(0);
    }

    JohnRosarAssignment3.readLine(in, MyJohnRosarBST);

}
public static void readLine(Scanner in, JohnRosarBinarySearchTree MyJohnRosarBST) 
{
    while (in.hasNextLine()) 
    {
        String line = in.nextLine();
        if(line.isEmpty()){
            continue;
        }
        
    Scanner lineScanner = new Scanner(line);
    
    lineScanner.useDelimiter("\t");
    JohnRosarAssignment3.createProfile(lineScanner, MyJohnRosarBST);
    }
}}