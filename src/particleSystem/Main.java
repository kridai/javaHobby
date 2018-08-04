package particleSystem;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import particleSystem.core.service.Emittor;
import particleSystem.core.service.FireEmittor;
import particleSystem.com.core.model.Particle;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main extends Application {

    private List<Particle> particles = new ArrayList<Particle>();

    private Emittor emittor = new FireEmittor();

    private GraphicsContext g;

    private void onUpdate () {
        g.setGlobalAlpha(1.0);
        g.setGlobalBlendMode(BlendMode.SRC_OVER);
        g.setFill(Color.BLACK);
        g.clearRect(0,0,600,600);
        particles.addAll(emittor.emit(300,300));
        ListIterator<Particle> iterator = particles.listIterator();
        while (iterator.hasNext()) {
            Particle particle = iterator.next();
            particle.update();
            if(!particle.isAlive()) {
                iterator.remove();
                continue;
            }
            particle.render(g);
        }
    }
    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(600,600);
        Canvas canvas = new Canvas(600,600);
        g = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
