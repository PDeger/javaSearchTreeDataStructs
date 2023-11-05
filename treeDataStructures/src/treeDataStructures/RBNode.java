package treeDataStructures;

public class RBNode {
    int value;
    RBNode leftChild;
    RBNode rightChild;
    RBNode parent;
    Color color;

    public RBNode(int value) {
        this.value = value;
        color = Color.RED;
        leftChild = rightChild = parent = null;
    }
}
