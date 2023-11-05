package treeDataStructures;

//Beispielimplementierung für den Rot Schwarz Baum

public class RedBlackTreeExampleImplementation {
	   private RBNode root;
	    private RBNode nil; // sentinel node

	    public RedBlackTreeExampleImplementation() {
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
	    public void leftRotate(RBNode x) {
	    	// setze y
	        RBNode y = x.rightChild; 
	        // bewege den linken Teilbaum von y zum rechten Teilbaum von x
	        x.rightChild = y.leftChild; 
	        if (y.leftChild != null) {
	            y.leftChild.parent = x;
	        }
	        // verbinde Eltern x mit y
	        y.parent = x.parent; 
	        if (x.parent == null) {
	            this.root = y;
	        } else if (x == x.parent.leftChild) {
	            x.parent.leftChild = y;
	        } else {
	            x.parent.rightChild = y;
	        }

	        y.leftChild = x; 
	        x.parent = y;
	    }

	    /**
	     * Rotiert den Knoten y nach rechts.
	     */
	    public void rightRotate(RBNode y) {
	    	//Funktionsweise identisch mit rotateLeft, nur mit vertauschen Richtungen 
	        RBNode x = y.leftChild;
	        y.leftChild = x.rightChild;
	        if (x.rightChild != null) {
	            x.rightChild.parent = y;
	        }
	        x.parent = y.parent;
	        if (y.parent == null) {
	            this.root = x;
	        } else if (y == y.parent.leftChild) {
	            y.parent.leftChild = x;
	        } else {
	            y.parent.rightChild = x;
	        }
	        x.rightChild = y;
	        y.parent = x;
	    }

	    /**
	     * Fügt einen Wert in den Rot-Schwarz Baum ein.
	     */
	    public void insert(int value) {
	        RBNode node = new RBNode(value);
	        RBNode y = null;
	        RBNode x = this.root;

	        // Finde die richtige Einfügeposition für den neuen Knoten
	        while (x != null) {
	            y = x;
	            if (node.value < x.value) {
	                x = x.leftChild;
	            } else {
	                x = x.rightChild;
	            }
	        }

	        // y ist jetzt der zukünftige Elternknoten für den neuen Knoten
	        node.parent = y;
	        if (y == null) {
	        	// Der Baum war leer, dieser Knoten (node) ist jetzt die Wurzel
	            root = node; 
	        } else if (node.value < y.value) {
	            y.leftChild = node;
	        } else {
	            y.rightChild = node;
	        }

	        // Der neue Knoten ist rot
	        node.color = Color.RED;

	        // Rot-Schwarz-Baum Logik nach Reparieren
	        fixInsert(node);
	    }

	    //Diese Methode wird benötigt um die Datenstruktur wieder konform mit den Regeln eines Rot-Schwarz Baums konform zu machen
	    private void fixInsert(RBNode node) {
	        RBNode parent;
	        RBNode grandParent;

	        // Fixiere den Baum, solange der Vater des Knotens existiert und rot ist
	        while (node != root && node.parent.color == Color.RED) {
	            parent = node.parent;
	            grandParent = parent.parent;

	            // Fall A: Der Vater des Knotens ist der linke Kind des Großvaters
	            if (parent == grandParent.leftChild) {
	                RBNode uncle = grandParent.rightChild; // Der Onkel des Knotens

	                // Fall 1: Der Onkel des Knotens ist auch rot
	                if (uncle != null && uncle.color == Color.RED) {
	                    // Rekolorierung
	                    parent.color = Color.BLACK;
	                    uncle.color = Color.BLACK;
	                    grandParent.color = Color.RED;
	                    node = grandParent; // Setze den Großvater als aktuellen Knoten und wiederhole die Schleife
	                } else {
	                    // Fall 2: Der Knoten ist das rechte Kind
	                    if (node == parent.rightChild) {
	                        // Linksdrehung benötigt
	                        node = parent;
	                        leftRotate(node);
	                        parent = node.parent;
	                    }

	                    // Fall 3: Der Knoten ist jetzt das linke Kind
	                    // Rechtsdrehung durchführen nach Rekolorierung
	                    parent.color = Color.BLACK;
	                    grandParent.color = Color.RED;
	                    rightRotate(grandParent);
	                }
	            } else { // Fall B: Der Vater des Knotens ist das rechte Kind des Großvaters
	                RBNode uncle = grandParent.leftChild; // Der Onkel des Knotens

	                // Fall 1: Der Onkel ist rot
	                if (uncle != null && uncle.color == Color.RED) {
	                    // Rekolorierung
	                    parent.color = Color.BLACK;
	                    uncle.color = Color.BLACK;
	                    grandParent.color = Color.RED;
	                    node = grandParent; // Bewege den Großvater nach oben für die nächste Iteration
	                } else {
	                    // Fall 2: Der Knoten ist das linke Kind
	                    if (node == parent.leftChild) {
	                        // Rechtsdrehung benötigt
	                        node = parent;
	                        rightRotate(node);
	                        parent = node.parent;
	                    }

	                    // Fall 3: Der Knoten ist das rechte Kind
	                    parent.color = Color.BLACK;
	                    grandParent.color = Color.RED;
	                    leftRotate(grandParent);
	                }
	            }

	            // Rekoloriere die Wurzel als schwarz
	            root.color = Color.BLACK;
	        }
	    }
	    

	    /**
	     * Löscht einen Wert aus dem Rot-Schwarz Baum.

	     */
	    public void delete(int value) {
	        // Hier muss die Implementierung der Löschoperation eingefügt werden.
	    }
	    
	    
	    //Beispiel einer rekursive Suche 
	    public RBNode search(int value) {
	        return searchRecursive(root, value);
	    }

	    private RBNode searchRecursive(RBNode node, int value) {
	    	// Der aktuelle Knoten ist null, der Wert wurde nicht gefunden
	        if (node == null || value == node.value) {
	            return node;
	        }

	        // Wenn der gesuchte Wert kleiner ist als der Wert des aktuellen Knotens, suche im linken Unterbaum
	        if (value < node.value) {
	            return searchRecursive(node.leftChild, value);
	        } else {
	        	// Wenn der gesuchte Wert größer ist, suche im rechten Unterbaum
	            return searchRecursive(node.rightChild, value);
	        }
	    }

	    public RBNode searchIterative(int value) {
	        RBNode current = this.root; // Starte mit der Wurzel des Baumes
	        while (current != null) {
	            if (value == current.value) {
	                // Wert gefunden, Knoten zurückgeben
	                return current;
	            } else if (value < current.value) {
	                // Gehe nach links, wenn der gesuchte Wert kleiner ist
	                current = current.leftChild;
	            } else {
	                // Gehe nach rechts, wenn der gesuchte Wert größer ist
	                current = current.rightChild;
	            }
	        }
	        // Wert wurde nicht gefunden, null zurückgeben
	        return null;
	    }
	    
	    //Diese Methode gibt den R-B Baum in der Konsole aus    
	    public void print() {
	        inorderRec(root);
	    }

	    private void inorderRec(RBNode root) {
	        if (root != null) {
	            inorderRec(root.leftChild);
	            System.out.println(root.value + "(" + (root.color == Color.RED ? "R" : "B") + ") ");
	            inorderRec(root.rightChild);
	        }
	    }
}
