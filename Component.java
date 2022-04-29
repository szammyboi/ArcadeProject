package ArcadeProject;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;


public class Component extends Entity {
    private Canvas canvasRef = null;
    protected GraphicsContext gc = null;
    protected ArrayList<Entity> entities = new ArrayList<>();

    public Component(int x, int y, int w, int h) {
        super(x, y, w, h);
        canvasRef = new Canvas(w, h);
        gc = canvasRef.getGraphicsContext2D();
        Position(x, y);

        //canvas.setOnMouseMoved(e -> mouseMoved(e));
    }

    // maybe it doesn't need to be abstract
    public void Load() {}
   
   /*
    public abstract void OnMouseMove();
    public abstract void OnMouseMove(Component c);
    public abstract void OnClick();
    public abstract void OnClick(Component c);
*/
    public void Render() {
        for (Entity c : entities) {
            c.Render(gc);
        }
    }

    public void Clear() {
        gc.clearRect(0, 0, w, h);
    }

    public void Position(int x, int y) {
        canvasRef.setLayoutX(x);
        canvasRef.setLayoutY(y);
        super.absoluteX = x;
        super.absoluteY = y;
    }

    public void AddComponent(Entity c) {
        c.absoluteX = c.x + this.absoluteX;
        c.absoluteY = c.y + this.absoluteY;
        entities.add(c);
    }


    public Canvas getCanvas() {
    
      return canvasRef;
    }
    

    

}