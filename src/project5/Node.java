
package project5; 
public class Node<K> { 
    private K key;
    private int position;
    private Node<K> left, right;  
    private DupNode center;

    public Node() {
    }

    public Node(K key, int position) {
        this.key = key;
        this.position = position;
        this.left = new Node(this.key,this.position);
        this.right = new Node(this.key,this.position);
        this.center = new DupNode(this.position);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Node<K> getLeft() {
        return left;
    }

    public void setLeft(Node<K> left) {
        this.left = left;
    }

    public Node<K> getRight() {
        return right;
    }

    public void setRight(Node<K> right) {
        this.right = right;
    }

    public DupNode getCenter() {
        return center;
    }

    public void setCenter(DupNode center) {
        this.center = center;
    }
    
    
}
