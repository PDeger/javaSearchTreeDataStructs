package treeDataStructures;

public class BinarySearchTree {
	BTNode root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * L�scht einen Wert aus dem Bin�ren Suchbaum.
     */
    public void insert(int value) {
    	// Hier muss die Implementierung der Einf�geoperation eingef�gt werden.
    }

    
    /**
     * L�scht einen Wert aus dem Bin�ren Suchbaum.
     */
    public void delete(int value) {
        // Hier muss die Implementierung der L�schoperation eingef�gt werden.
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
