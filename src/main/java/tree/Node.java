package tree;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Ez az osztály reprezentál egy csomópontot.
 */
@Data
@AllArgsConstructor
public class Node
{
    protected Node leftChild = null; // ball gyermek
    protected Node rightChild = null; // jobb gyermek

    protected int posX = 0; // a csomópont rajzteren lévő X pozíciója
    protected int posY = 0; // a csomópont rajzteren lévő Y pozíciója

    protected int value = 0; // a csomópont értéke

    public Node() {}
}
