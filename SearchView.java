package ArcadeProject;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import javafx.scene.paint.Paint;


// function that auto asytncs maybe
public class SearchView extends Component {
    int dragX, dragY;
    public ArrayList<Img> imgs = new ArrayList<>();

    public SearchView(int x, int y) {
        super(x, y, 500, 500);
        
        CompletableFuture load = CompletableFuture.runAsync(() -> this.Load());
        super.Render();
    }

    @Override
    public void Load() {
        for (int i = 0; i < 500; i++) {
            Img test = new Img("images/test.jpg", 0, 0);
            test.Load();
            test.SetScale(w/4, h/3);
            imgs.add(test);
        }

        int row = 0;
        int column = 0;
        for (Img img : imgs) {
            img.x = (row % 4)*(w/4);
            if (row % 4 == 0 && row != 0) column++;
            img.y = column*(h/3);
            AddComponent(img);
            row++;
        }
        
        Rectangle border = new Rectangle(0, 0, w, h);
        border.setStyle(Rectangle.Style.Outlined);
        
        AddComponent(border);

        loaded = true;
        Render();
    }
    
    @Override
    public void OnMouseClicked(int x, int y) {
        Render();
    }

    @Override
    public void OnMouseDown(int x, int y) {
      dragX = x - absoluteX;
      dragY = y - absoluteY;
    }

    @Override
    public void OnMouseDragged(int x, int y) {
        Position(x - dragX, y - dragY);
    }

    @Override
    public void OnScroll(int deltaY) {

        Clear();
        for (Img img : imgs) {
            img.y += deltaY;
            img.absoluteY += deltaY;
        }

        Render();
    }

}
