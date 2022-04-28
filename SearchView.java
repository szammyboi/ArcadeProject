package ArcadeProject;
import java.util.ArrayList;

import javafx.scene.paint.Paint;

public class SearchView extends Component {

    public SearchView(int x, int y) {
        super(x, y, 500, 500);
        Render();
    }

    public void Load() {
        AddComponent(new ProductCard(50, 50));
        Rectangle border = new Rectangle(0, 0, w, h);
        border.setStyle(Rectangle.Style.Outlined);
        AddComponent(border);
    }
    
    public void OnMouseClicked(int x, int y) {
      Position(x - 250, y - 250);
    }

}
