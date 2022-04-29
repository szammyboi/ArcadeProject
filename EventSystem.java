package ArcadeProject;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.Scene;

public class EventSystem {
   private static Scene sceneRef = null;
   public static int mouseX, mouseY;
   
   public static void setScene(Scene scene) {
      sceneRef = scene;
      
      scene.setOnMouseMoved(e -> MouseMoved(e));
      scene.setOnMouseClicked(e -> MouseClicked(e));
      scene.setOnMouseDragged(e -> MouseDragged(e));
      scene.setOnMousePressed(e -> MouseDown(e));
      scene.setOnScroll(e -> MouseScroll(e));
   }
   
   public static void MouseMoved(MouseEvent mouse) {
      mouseX = (int)mouse.getX();
      mouseY = (int)mouse.getY();

      for (Entity e : Entity.getList()) {
         if (e.loaded)
            if (e.InBounds((int)mouse.getX(), (int)mouse.getY()))
               e.OnMouseMoved((int)mouse.getX(), (int)mouse.getY());
      }
   }
   
   public static void MouseClicked(MouseEvent mouse) {
      for (Entity e : Entity.getList()) {
         if (e.loaded)
            if (e.InBounds((int)mouse.getX(), (int)mouse.getY()))
               e.OnMouseClicked((int)mouse.getX(), (int)mouse.getY());
      }
   }

   public static void MouseDown(MouseEvent mouse) {
      for (Entity e : Entity.getList()) {
         if (e.loaded)
            if (e.InBounds((int)mouse.getX(), (int)mouse.getY()))
               e.OnMouseDown((int)mouse.getX(), (int)mouse.getY());
      }
   }
   
   public static void MouseDragged(MouseEvent mouse) {
      for (Entity e : Entity.getList()) {
         if (e.loaded)
            if (e.InBounds((int)mouse.getX(), (int)mouse.getY()))
               e.OnMouseDragged((int)mouse.getX(), (int)mouse.getY());
      }
   }

   public static void MouseScroll(ScrollEvent scroll) { 
      for (Entity e : Entity.getList()) {
         if (e.loaded)
            if (e.InBounds((int)mouseX, (int)mouseY))
               e.OnScroll((int)scroll.getDeltaY());
      }
   }
  
}