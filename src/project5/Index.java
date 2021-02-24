package project5; 
import java.util.*;
public class Index <K extends Comparable<K>>{ 
    
    private  Node<K> root;
    private K key;
    private int position;
    private Node<K> left, right;  
    private DupNode center;
     

    public Index( K key, int position, Node<K> left, Node<K> right, DupNode center) {
         this.key = key;
        this.position = position;
        this.left = left;
        this.right = right;
        this.center = center;
        
        this.root = new Node<K>(this.key,this.position);
    }
    
    public  void add(){
         add(this.key, this.position, this.root);
    }
       
    public  Node<K> add(K key, int position, Node<K> startNode){
    if (this.root == null) {  
            return this.root; 
        } 
        //traverse the tree
        if (this.left.getPosition() < this.root.getPosition())     //insert in the left subtree
            this.left.setKey(key); 
       if (this.left.getPosition() > this.root.getPosition())    //insert in the right subtree
            this.right = add(key,position,this.right); 
           
        return root;  
    }
    public int get(K key){
        get(key, this.root);
        return get(key);
    }
    public int get(K key, Node<K> startNode){
        //initially minval = root
        int minval = startNode.getPosition(); 
        //find minval
        while (this.left != null)  { 
            minval = this.left.getPosition(); 
            root = this.left; 
        } 
        return minval;  
    }
    public int[] getAll(K key){ 
        
        return getAll(key);
    }
    public int[] getAll(K key, Node<K> startNode){
        
        return getAll(key,startNode);
    }
    public boolean contains(K key){
        
        return contains(key);
    }
    public boolean contains(K key, Node<K> startNode){
        
        return contains(key,startNode);
    }
    
    public int size(K key){
        
        return size(key);
    }
    public boolean size( Node<K> startNode){
        
        return size(startNode);
    }
    public int[] toPositionsArray(){
        
        return toPositionsArray();
    }
    public int generatePositionsArray(int[] array, Node<K> startNode, int startIndex){
        
        return generatePositionsArray(array,startNode,startIndex);
    }
    public K[] toKeyArray(K[] array){
        
        return toKeyArray(array);
    }
    public int generateKeyArray(K[] array, Node<K> startNode, int startIndex){
        
        return generateKeyArray(array,startNode,startIndex);
    }
    public String toString(){
        return "";
    }
    public String generateString(StringBuilder str, Node<K> startNode){
        return "";
    }
}
