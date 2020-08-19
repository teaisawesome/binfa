package draw;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Ez az osztály felel a rajztérre való rajzolásért.
 */
public class Pen
{

    protected GraphicsContext gc;

    public Pen(GraphicsContext gc)
    {
        this.gc = gc;
        // Set line width
        this.gc.setLineWidth(2.0);
        // Set fill color
        this.gc.setFill(Color.RED);
    }

    // szülő csomópont megrajzolásáért felel. Csak a root csomópontnál használatos.
    public void drawParent(int x, int y, String label)
    {
        gc.strokeText(label, x + 16, y+30);
        gc.strokeOval(x, y, 50, 50);
    }

    // a szülőcsomópont bal gyermekének kirajzolásért felel.
    public void drawLeftChild(int parentX, int parentY, String  label)
    {
        gc.strokeLine(parentX + 5, parentY + 40, parentX - 45, parentY + 80);
        gc.strokeOval(parentX - 88 , parentY + 75, 50, 50);

        if(Integer.parseInt(label) < 10)
            gc.strokeText(label, (parentX - 88) + 20, (parentY + 75) + 30);
        else
            gc.strokeText(label, (parentX - 88) + 16, (parentY + 75) + 30);
    }

    // a szülőcsomópont jobb gyermekének kirajzolásért felel.
    public void drawRightChild(int parentX, int parentY, String label)
    {
        gc.strokeLine(parentX + 45, parentY + 40, parentX + 95, parentY + 80);
        gc.strokeOval(parentX + 88, parentY + 75, 50, 50);

        if(Integer.parseInt(label) < 10)
            gc.strokeText(label, (parentX + 88) + 20, (parentY + 75) + 30);
        else
            gc.strokeText(label, (parentX + 88) + 16, (parentY + 75) + 30);
    }
}
