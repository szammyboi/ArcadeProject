package ArcadeProject;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;

public class EventSystem {
   private static Scene sceneRef = null;
   
   public EventSystem(Scene scene) {
      sceneRef = scene;
      
      scene.setOnMouseMoved(e -> MouseMoved(e));
      scene.setOnMouseClicked(e -> MouseClicked(e));
      scene.setOnMouseDragged(e -> MouseDragged(e));
   }
   
   public void setScene(Scene scene) {
      sceneRef = scene;
   }
   
   public void MouseMoved(MouseEvent mouse) {
      for (Entity e : Entity.getList()) {
         if (e.InBounds((int)mouse.getX(), (int)mouse.getY()))
            e.OnMouseMoved((int)mouse.getX(), (int)mouse.getY());
      }
   }
   
   public void MouseClicked(MouseEvent mouse) {
      for (Entity e : Entity.getList()) {
         if (e.InBounds((int)mouse.getX(), (int)mouse.getY()))
            e.OnMouseClicked((int)mouse.getX(), (int)mouse.getY());
      }
   }
   
   public void MouseDragged(MouseEvent mouse) {
      for (Entity e : Entity.getList()) {
         if (e.InBounds((int)mouse.getX(), (int)mouse.getY()))
            e.OnMouseClicked((int)mouse.getX(), (int)mouse.getY());
      }
   }
  
}