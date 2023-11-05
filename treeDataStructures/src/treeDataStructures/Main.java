package treeDataStructures;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Die Dateien Enthalten gemischte Zahlenreihen von 1 bis zu der im Folgenden angegebenen Maximal Anzahl 
		 * Datengrößen in den Dateien: 
		 * 
		 * DataXS 10 Werte - Kann zusammen mit den Tree Printern Verwendet werden um sich die Struktur des erstelten Baums visuell Darstellen zu lassen
		 * Die Printer Funktionieren mit Bäumen, die größer als ca 50 - 60 Knoten sind nicht mehr so gut, da kein Platz mehr in der Konsole ist.
		 * Daher diese Datei am besten nehmen um eure Methoden mit hilfe der Printer zu testen
		 * 
		 * DataS 1000 Werte
		 * DataM 1.000.000 Werte
		 * DataL 2.500.000 Werte
		 */
		
		RedBlackTreePrinter rbPrinter = new RedBlackTreePrinter();
		BinaryTreePrinter bstPrinter = new BinaryTreePrinter();
		
		 //Werwenden die Insert Methoden der Tree Klasse.
		RBTreeDataFileReader RbReader = new RBTreeDataFileReader();
		BinaryTreeDataFileReader BinReader = new BinaryTreeDataFileReader();
		
		//Für Auswahl der Quelldatei: "XS","S","M" oder "L" übergeben.
		String size = "S";
		RedBlackTree RBtree = RbReader.loadFile(size); 
		BinarySearchTree BinTree = BinReader.loadFile(size);
			
		
		//Anschaulichere Ausgabe - am besten nur mit dem kleinen Datensatz verwenden
		//bstPrinter.printNode(BinTree.root);
		//rbPrinter.printNode(RBtree.getRoot());

	}

}
