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
    
         int column = 0;
        for (int i = 0; i < 50; i++) {
            String link = ArcadeDB.getProductImage(Integer.toString(i));
            Img test = new Img(link, 0, 0);
            test.Load();
            test.SetScale(w/4, h/4);
            imgs.add(test);
            
            test.x = (i % 4)*(w/4);
            if (i % 4 == 0 && i != 0) column++;
            test.y = column*(h/4);
            
            test.absoluteX = test.x + this.x;
            test.absoluteY = test.y + this.y;
            AddComponent(test);
            Render();
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
        for (Img img : imgs) {
         img.absoluteX = this.absoluteX + img.x;
         img.absoluteY = this.absoluteY + img.y;
        }
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
