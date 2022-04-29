package ArcadeProject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

interface Renderable {
   public abstract void Render(GraphicsContext gc);
}

// less structured make a list of all entities to render rather than separating by component
// component is kinda dupid
// make component a subclass of entity
public class Entity implements Renderable {
    private static ArrayList<Entity> entities = new ArrayList<Entity>();
    
    public int absoluteX = 0, absoluteY = 0;
    public int x, y, w, h;
    public boolean loaded = false;

    public Entity(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        
        entities.add(this);
    }

    public void Render(GraphicsContext canvas) {}


    public boolean InBounds(int x, int y) {
      if (x >= this.absoluteX && x <= this.absoluteX+this.w)
         if (y >= this.absoluteY && y <= this.absoluteY + this.h)
            return true;
      return false;
   }
   
   public void OnMouseMoved(int x, int y) {
   
   }
   
   public void OnMouseClicked(int x, int y) {
   
   }
   
   public void OnScroll(int deltaY) {
   
   }

   public void OnMouseDragged(int x, int y) {

   }

   public void OnMouseDown(int x, int y) {
      
   }
   
   public static ArrayList<Entity> getList() {
      return Entity.entities;
   }
}