package com.diploma.project.collision;

/**
 * Колизия объекта
 * Физическое представление объекта, для обработки столкновений
 */
public class Collision {
    private float x;
    private float y;
    private float r;
    private float width;
    private float height;
    private CollisionType type;

    /**
     * Конструктор, для колизии с одинаковой шириной и высотой
     *
     * @param x        координата x левой стороны колизии
     * @param y        координата y нижней стороны колизии
     * @param sideSize размер стороны
     * @param type
     */
    public Collision(float x, float y, float sideSize, CollisionType type) {
        this(x, y, sideSize, sideSize, type);
    }

    /**
     * Конструктор, для колизии с различными шириной и высотой
     *
     * @param x      координата x левой стороны колизии
     * @param y      координата y нижней стороны колизии
     * @param width  ширина колизии
     * @param height высота колизии
     * @param type   тип колизии
     */
    public Collision(float x, float y, float width, float height, CollisionType type) {
        this.x = x + width / 2;
        this.y = y + height / 2;
        this.type = type;
        this.width = width;
        this.height = height;
        switch (type) {
            case CIRCLE:
                this.r = width / 2;
                break;
            case RECTANGLE:
                this.r = (float) Math.sqrt(width / 2 * width / 2 + height / 2 * height / 2);
        }
    }

    /**
     * Метод, для определения произошло ли столкновение между двух объектов
     *
     * @param targetCollision колизия для осуществления проверки
     * @return true - произошло столкновение, false - столкновения не произошло
     */
    public boolean colides(Collision targetCollision) {
        if (distanceSquare(this, targetCollision) < ((this.r + targetCollision.r) * (this.r + targetCollision.r))) {
            return rectRectCollides(this, targetCollision);
        }
        return false;
    }

    /**
     * Метод, для определения того, что центр колизии находится внутри другой
     *
     * @param targetCollision колизия, для осуществления проверки - цель
     * @return true - колизия внутри цели, false - колизия не находится внутри цели
     */
    public boolean inside(Collision targetCollision) {
        if (distanceSquare(this, targetCollision) < this.r * this.r) {
            return true;
        }
        return false;
    }

    /**
     * Квадрат расстояния между колизиями
     *
     * @param first  первая колизия
     * @param second вторая колизия
     * @return расстояние
     */
    private float distanceSquare(Collision first, Collision second) {
        return (first.x - second.x) * (first.x - second.x) + (first.y - second.y) * (first.y - second.y);
    }

    /**
     * Проверка столкновения между двумя прямоугольниками
     *
     * @param firstRect  первая прямоугольная колизия
     * @param secondRect вторая прямоугольная колизия
     * @return
     */
    private boolean rectRectCollides(Collision firstRect, Collision secondRect) {
        if (Math.abs(firstRect.x - secondRect.x) > firstRect.width / 2 + secondRect.width / 2) {
            return false;
        } else {
            return (Math.abs(firstRect.y - secondRect.y) < firstRect.height / 2 + secondRect.height / 2);
        }
    }

    /**
     * @return x координата центра колизии
     */
    public float getX() {
        return x;
    }

    /**
     * @return y координата центра колизии
     */
    public float getY() {
        return y;
    }

    /**
     * @return радиус колизии (для прямоугольника, возвращает радиус описанной окружности)
     */
    public float getR() {
        return r;
    }

    /**
     * @return ширина колизии
     */
    public float getWidth() {
        return width;
    }

    /**
     * @return высота колизии
     */
    public float getHeight() {
        return height;
    }

    /**
     * @return тип колизии
     */
    public CollisionType getType() {
        return type;
    }

    /**
     * Установить новое значение левого края колизии
     *
     * @param x значение координаты x левого края колизии
     */
    public void setX(float x) {
        this.x = x + width / 2;
    }

    /**
     * Установить новое значение нижнего края колизии
     *
     * @param y значение координаты y нижнего края колизии
     */
    public void setY(float y) {
        this.y = y + height / 2;
    }
}
