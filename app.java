import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class app extends Application
{
    ArrayList<Image> images = new ArrayList<>();
    ArrayList<TextField> texts = new ArrayList<>();
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
     
    @Override
    public void start(Stage stage) 
    { 
        UI.Init(stage);
        UI.Resolution(1920, 1080);
        UI.Show();
    }
}