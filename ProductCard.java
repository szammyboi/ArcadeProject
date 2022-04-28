package ArcadeProject;
import javafx.scene.canvas.GraphicsContext;

public class ProductCard extends Component {
    public ProductCard(int x, int y) {
        super(x, y, 100, 200);
    }

    public void Draw(GraphicsContext canvas) {
        canvas.fillRect(x, y, w, h);
    }

}
