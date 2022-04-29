package ArcadeProject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Img extends Entity {
    Image source = null;
    String src = null;

    public Img(String src, int x, int y) {
        super(x, y, 0, 0);
        this.src = src;
    }

    public void Load() {
        source = new Image(src);
        w = (int)source.getWidth();
        h = (int)source.getHeight();
    }

    @Override
    public void Render(GraphicsContext gc) {
        gc.drawImage(source, x, y, w, h);
    }

    public void SetScale(double ratio) {
        this.w *= ratio;
        this.h *= ratio;
    }

    public void SetScale(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public void OnMouseDown(int x, int y) {
        source = new Image("./images/ice.jpg");
    }
}
