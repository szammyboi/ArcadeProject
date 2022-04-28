package ArcadeProject;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;


public abstract class RenderGroup extends Canvas {
    protected GraphicsContext canvas = null;
    protected int width, height;
    protected ArrayList<Component> components = new ArrayList<>();

    private void mouseMoved(MouseEvent e) {
        
    }

    public RenderGroup(int w, int h) {
        super(w, h);
        this.width = w;
        this.height = h;
        canvas = this.getGraphicsContext2D();
        Load();

        this.setOnMouseMoved(e -> mouseMoved(e));
    }

    // maybe it doesn't need to be abstract
    public abstract void Load();

    public abstract void OnMouseMove();
    public abstract void OnMouseMove(Component c);
    public abstract void OnClick();
    public abstract void OnClick(Component c);

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