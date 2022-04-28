package ArcadeProject;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public abstract class RenderGroup extends Canvas {
    protected GraphicsContext canvas = null;
    protected int width, height;
    protected ArrayList<Component> components = new ArrayList<>();

    public RenderGroup(int w, int h) {
        super(w, h);
        this.width = w;
        this.height = h;
        canvas = this.getGraphicsContext2D();
        Load();
    }

    // maybe it doesn't need to be abstract
    public abstract void Load();

    public void Render() {
        for (Component c : components) {
            c.Draw(canvas);
        }
    }

    public void Clear() {

    }

    public void Position(int x, int y) {
        super.setLayoutX(x);
        super.setLayoutY(y);
    }

    public void AddComponent(Component c) {
        components.add(c);
    }

    

}