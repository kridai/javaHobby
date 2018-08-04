package sample.com.core.model;


import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Paint;

/**
 * Created by Kridai on 03-08-2018.
 */
public class Particle {
    private double x;
    private double y;
    private Point2D veocity;
    private double radius;
    private double life = 1.0;
    private double decay;
    private Paint color;
    private BlendMode blendMode;

    public Particle(double x, double y, Point2D veocity, double radius,
                    double expireTime, Paint color, BlendMode blendMode) {
        this.x = x;
        this.y = y;
        this.veocity = veocity;
        this.radius = radius;
        this.decay = 0.016/expireTime;
        this.color = color;
        this.blendMode = blendMode;
        this.decay = 0.016/expireTime;

    }
    public void update() {
        x+=veocity.getX();
        y+=veocity.getY();
        life -=decay;
    }
    public boolean isAlive()
    {
        return life >0;
    }
    public void render(GraphicsContext g) {
        g.setGlobalAlpha(life);
        g.setGlobalBlendMode(blendMode);
        g.setFill(color);
        g.fillOval(x,y,radius,radius);
    }
}