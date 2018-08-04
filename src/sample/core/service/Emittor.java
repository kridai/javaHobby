package sample.core.service;

import sample.com.core.model.Particle;

import java.util.List;

/**
 * Created by Kridai on 04-08-2018.
 */
public interface Emittor {
     List<Particle> emit(double x, double y);
}
