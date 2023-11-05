package treeDataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RBTreeDataFileReader {
	
	public RBTreeDataFileReader() {

	}
	
	public RedBlackTree loadFile(String size) {
		String path = "./TreeDataSrc/DataX" + size + ".txt";
		File file = new File(path);
		RedBlackTree tree = new RedBlackTree();
		
		try {
			Scanner s = new Scanner(file);
			
			while(s.hasNext()) {
				String line = s.nextLine();
				int value = Integer.parseInt(line);
				
				tree.insert(value);

			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Data Src Datei nicht gefunden, TreeDataSrc prüfen.");
			e.printStackTrace();
			return null;
		}
		return tree;
	}
	
}
