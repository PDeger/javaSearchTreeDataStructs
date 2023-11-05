package treeDataStructures;

public class RedBlackTree {
    private RBNode root;
    private RBNode nil; // sentinel node

    public RedBlackTree() {
        nil = new RBNode(0);
        nil.color = Color.BLACK;
        nil.leftChild = null;
        nil.rightChild = null;
        root = nil;
    }
    
    public RBNode getRoot() {
    	return this.root;
    }


    /**
     * Rotiert den Knoten x nach links.
     */
    public void leftRotate(RBNode n) {
        // Hier muss die Implementierung der linken Rotation eingefügt werden.
    }

    /**
     * Rotiert den Knoten x nach rechts.
     */
    public void rightRotate(RBNode n) {
        // Hier muss die Implementierung der rechten Rotation eingefügt werden.
    }

    /**
     * Fügt einen Wert in den Rot-Schwarz Baum ein.
     */
    public void insert(int value) {
        // Hier muss die Implementierung der Einfügeoperation eingefügt werden.
    }

    /**
     * Löscht einen Wert aus dem Rot-Schwarz Baum.

     */
    public void delete(int value) {
        // Hier muss die Implementierung der Löschoperation eingefügt werden.
    }
    
    
    //Diese Methode gibt den R-B Baum in der Konsole aus; eignet sich nur für einen groben Überblick   
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(RBNode root) {
        if (root != nil) {
            inorderRec(root.leftChild);
            System.out.print(root.value + "(" + (root.color == Color.RED ? "R" : "B") + ") ");
            inorderRec(root.rightChild);
        }
    }
}
