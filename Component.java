import javafx.scene.canvas.GraphicsContext;

public abstract class Component {
    int x, y, w, h;
    
    public Component() {

    }

    public abstract void Draw(GraphicsContext canvas);


}