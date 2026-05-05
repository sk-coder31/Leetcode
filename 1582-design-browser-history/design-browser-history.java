class BrowserHistory {
    Node head;
    Node curr;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        curr = head;
    }
    
    public void visit(String url) {
        curr.next = null;
        Node newNode = new Node(url);
        newNode.prev = curr;
        curr.next = newNode;
        curr = newNode;
    }
    
    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.data;
    }
    
    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.data;
    }
}

class Node{
    String data;
    Node prev;
    Node next;
    Node(String val){
        this.data = val;
        this.prev = null;
        this.next = null;
    }
    
}