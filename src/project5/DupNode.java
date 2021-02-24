
package project5;

class DupNode {
    private int position;
    private DupNode next;

    public DupNode(int position) {
        this.position = position;
        this.next = new DupNode(this.position);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public DupNode getNext() {
        return next;
    }

    public void setNext(DupNode next) {
        this.next = next;
    }
    
    
}
