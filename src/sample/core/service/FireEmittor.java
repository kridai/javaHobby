package sample.core.service;

import javafx.geometry.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import sample.com.core.model.Particle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kridai on 04-08-2018.
 */
public class FireEmittor implements Emittor {
    @Override
    public List<Particle> emit(double x, double y) {
         List<Particle> particles = new ArrayList<Particle>();
         int newParticles = 15;
        for (int i = 0; i < newParticles; i++) {
            particles.add(new Particle(x, y, new Point2D(Math.random() - 0.5, Math.random() * -4), 10, 2.0,
                    Color.rgb(215, 20, 65), BlendMode.ADD ));
            
        }
        return particles;

    }
}
