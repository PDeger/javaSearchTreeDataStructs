package treeDataStructures;

//Beispielimplementierung für den Binären Suchbaum

public class BinarySearchTreeExampleImplementation {
    BTNode root;

    public BinarySearchTreeExampleImplementation() {
        root = null;
    }
    
    public void insert(int value) {
        BTNode newNode = new BTNode(value);
        if (root == null) {
            root = newNode;
            return;
        }

        BTNode current = root;
        BTNode parent = null;
        while (current != null) {
            parent = current;
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                // Wert existiert bereits im Baum, füge ihn nicht ein
                return;
            }
        }

        if (value < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    
    public BTNode search(int value) {
    	BTNode current = root;
        while (current != null) {
            if (value == current.value) {
                return current; // Wert gefunden
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null; // Wert nicht gefunden
    }
}
