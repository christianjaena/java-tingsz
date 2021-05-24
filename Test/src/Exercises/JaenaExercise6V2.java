public class Node {
    Node left, right;
    String value;
    Node(String value) {
        this.value = value;
    }
    
    public void insert(String parent, String value) {
        if (value.equals(parent)) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(parent, value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(parent, value);
            }
        }
    }
    
    
    public void recursivePrint() {
        if (left != null) {
            left.recursivePrint();
        }
        if (right != null) {
            right.recursivePrint();
        }
        System.out.println(value);
    }
    public static void main(String[] args) {
        Node t = new Node("Cherry");
        t.insert("Cherry", "Apple");
        t.insert("Apple", "Nectarine");
        t.insert("Apple", "Lemon");
        t.insert("Nectarine", "Mango");
        t.insert("Lemon", "Imbe");
        t.recursivePrint();
    }
}