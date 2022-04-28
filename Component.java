package ArcadeProject;
import javafx.scene.canvas.GraphicsContext;

public abstract class Component {
    int x, y, w, h;
    
    public Component(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void Draw(GraphicsContext canvas);


}