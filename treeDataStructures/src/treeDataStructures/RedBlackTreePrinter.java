package treeDataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RedBlackTreePrinter {

    public static void printNode(RBNode root) {
        int maxLevel = RedBlackTreePrinter.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<RBNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || RedBlackTreePrinter.isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        RedBlackTreePrinter.printWhitespaces(firstSpaces);

        List<RBNode> newNodes = new ArrayList<>();
        for (RBNode node : nodes) {
            if (node != null) {
            	//Kommentar in dieser Zeile löschen um die Farbe des Knoten angezeigt zu bekommen. 
            	//Den Sysout mit node. value unterhalb auskommentieren sonst geht die Formatierung kaputt
                System.out.print(node.color == Color.RED ? "R" : "B");
                System.out.print(node.value);
                newNodes.add(node.leftChild);
                newNodes.add(node.rightChild);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            RedBlackTreePrinter.printWhitespaces(betweenSpaces - (node != null ? String.valueOf(node.value).length()  : 0));
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                RedBlackTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    RedBlackTreePrinter.printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).leftChild != null)
                    System.out.print("/");
                else
                    RedBlackTreePrinter.printWhitespaces(1);

                RedBlackTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).rightChild != null)
                    System.out.print("\\");
                else
                    RedBlackTreePrinter.printWhitespaces(1);

                RedBlackTreePrinter.printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }


        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(RBNode node) {
        if (node == null)
            return 0;

        return Math.max(RedBlackTreePrinter.maxLevel(node.leftChild), RedBlackTreePrinter.maxLevel(node.rightChild)) + 1;
    }

    private static boolean isAllElementsNull(List<RBNode> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}
