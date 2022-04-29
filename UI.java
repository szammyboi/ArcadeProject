package ArcadeProject;
import java.util.function.Consumer;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UI {
    public static GraphicsContext gc = null;
    public static Stage stageRef;
    public static Pane container;

    public static void Init(Stage stage) {
        Canvas canvas = new Canvas(1920, 1080);

        // Get the graphics context of the canvas
        gc = canvas.getGraphicsContext2D();
        
        container = new Pane();
        // Add the Canvas to the Pane

        container.getChildren().add(new SearchView(200, 200).getCanvas());
        // Create the Scene
        Scene scene = new Scene(container);
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Set the Title of the Stage
        stage.setTitle("Suncoast Arcade");
        
        stageRef = stage;   
        
        EventSystem.setScene(scene);
    }

    public static void Resolution(int width, int height) {
        stageRef.setWidth(width);
        stageRef.setHeight(height);
    }

    public static void Show() {
        stageRef.show();
    }
}
