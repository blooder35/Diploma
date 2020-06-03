package com.diploma.project.collision;

/**
 * Пустая колизия
 */
public class EmptyCollision extends Collision {

    /**
     * Конструктор пустой колизии
     */
    public EmptyCollision() {
        super(0, 0, 0, CollisionType.CIRCLE);
    }
}
