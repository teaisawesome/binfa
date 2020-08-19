package tree;

import draw.Pen;

/**
 * Ez az osztály a binfa felépítését és megrajzoltatását végzi.
 */
public class Builder
{
    // gyökércsomópont
    protected Node root = null;

    // rajzolért felelős Pen osztálypéldány
    protected Pen pen;

    public Builder(Pen pen)
    {
        this.pen = pen;
    }

    /**
     * Ez a függvény építi fel a fát.
     *
     * @param array a bejövő értékek int tömbben
     */
    public void build(int[] array)
    {
        int i = 0;
        do
        {
            if(root != null)
            {
                travel(root, array[i]);
                i++;
            }
            else
            {
                root = new Node();
                root.setPosX(225);
                root.setPosY(70);
                root.setValue(array[0]);

                pen.drawParent(root.getPosX(), root.getPosY(), String.valueOf(array[i]));

                i++;
            }
        }
        while (i != array.length);
    }

    /**
     * Rekurzív módon bejárja a fát és rajzol.
     * @param node aktuálisan vizsgált csomópont
     * @param value az elhelyezendő érték
     */
    public void travel(Node node, int value)
    {
        if(node.getValue() >= value)
        {
            if(node.getLeftChild() !=  null)
            {
                travel(node.leftChild, value);
            }
            else
            {
                Node newChild = new Node();
                newChild.setPosX(node.getPosX() - 88);
                newChild.setPosY(node.getPosY() + 75);
                newChild.setValue(value);

                node.setLeftChild(newChild);

                pen.drawLeftChild(node.posX, node.posY, String.valueOf(value));
            }
        }
        else if(node.getValue() <= value)
        {
            if(node.getRightChild() !=  null)
            {
                travel(node.rightChild, value);
            }
            else
            {
                Node newChild = new Node();
                newChild.setPosX(node.getPosX() + 88);
                newChild.setPosY(node.getPosY() + 75);
                newChild.setValue(value);

                node.setRightChild(newChild);

                pen.drawRightChild(node.posX, node.posY, String.valueOf(value));
            }
        }
    }
}
