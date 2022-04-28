package ArcadeProject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class ProductCard extends Entity {

    public ProductCard(int x, int y) {
        super(x, y, 100, 200);
    }

    public void Render(GraphicsContext canvas) {
        canvas.fillRect(x, y, w, h);
    }
    
    @Override
    public void OnMouseMoved(int x, int y) {
      //System.out.println("CARD");
    }
    
    @Override
    public void OnMouseClicked(int x, int y) {
      System.out.println("CARD CLICKED");
    }

}
