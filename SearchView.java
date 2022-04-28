package ArcadeProject;
import java.util.ArrayList;

import javafx.scene.paint.Paint;

public class SearchView extends RenderGroup {

    public SearchView() {
        super(500, 500);
        super.Position(200, 200);
        System.out.println(canvas);
        Render();
    }

    public void Load() {
        AddComponent(new ProductCard(50, 50));
        Rectangle border = new Rectangle(0, 0, width, height);
        border.setStyle(Rectangle.Style.Outlined);
        AddComponent(border);
    }

}
