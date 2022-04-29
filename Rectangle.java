package ArcadeProject;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Entity {
    private Style style = Style.Filled;

    public static enum Style {
        Filled,
        Outlined
    };

    public Rectangle(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void Render(GraphicsContext canvas) {
        if (style == Style.Filled) {
            canvas.fillRect(x, y, w, h);
        } else if (style == Style.Outlined) {
            canvas.strokeRect(x, y, w, h);
        }
        
    }
    
}
