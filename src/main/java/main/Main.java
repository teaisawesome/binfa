package main;

import draw.Pen;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import tree.Builder;

public class Main extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {

        Group root = new Group();
        javafx.scene.canvas.Canvas canvas = new javafx.scene.canvas.Canvas(500, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pen pen = new Pen(gc);

        int[] szamok = {15, 9, 5, 10, 69};

        Builder builder = new Builder(pen);

        builder.build(szamok);

        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Binfa");
        stage.show();
    }
}
