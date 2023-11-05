package treeDataStructures;

public class BinarySearchTree {
	BTNode root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * Löscht einen Wert aus dem Binären Suchbaum.
     */
    public void insert(int value) {
    	// Hier muss die Implementierung der Einfügeoperation eingefügt werden.
    }

    
    /**
     * Löscht einen Wert aus dem Binären Suchbaum.
     */
    public void delete(int value) {
        // Hier muss die Implementierung der Löschoperation eingefügt werden.
    }
    
    //Diese Methode gibt den B-Baum in der Konsole aus
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
}
