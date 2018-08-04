package particleSystem.core.service;

import particleSystem.com.core.model.Particle;

import java.util.List;

/**
 * Created by Kridai on 04-08-2018.
 */
public interface Emittor {
     List<Particle> emit(double x, double y);
}
