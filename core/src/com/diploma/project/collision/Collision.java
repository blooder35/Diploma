package com.diploma.project.collision;

public class Collision {
    private float x;
    private float y;
    private float r;
    private float width;
    private float height;
    private CollisionType type;

    /**
     * @param x of a left side
     * @param y of a down side
     */
    public Collision(float x, float y, float sideSize, CollisionType type) {
        this(x, y, sideSize, sideSize, type);
    }

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
                this.r = (float) Math.sqrt(width/2 * width/2 + height/2 * height/2);
        }
    }

    public boolean colides(Collision targetCollision) {
        if (distanceSquare(this, targetCollision) < ((this.r + targetCollision.r) * (this.r + targetCollision.r))) {
            return rectRectCollides(this, targetCollision);
        }
        return false;
    }

    public boolean inside(Collision targetCollision) {
        if (distanceSquare(this, targetCollision) < this.r * this.r) {
            return true;
        }
        return false;
    }

    private float distanceSquare(Collision first, Collision second) {
        return (first.x - second.x) * (first.x - second.x) + (first.y - second.y) * (first.y - second.y);
    }

    private boolean rectRectCollides(Collision firstRect, Collision secondRect) {
        if (Math.abs(firstRect.x - secondRect.x) > firstRect.width/2 + secondRect.width/2) {
            return false;
        } else {
            return (Math.abs(firstRect.y - secondRect.y) < firstRect.height/2 + secondRect.height/2);
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public CollisionType getType() {
        return type;
    }

    public void setX(float x) {
        this.x = x + width / 2;
    }

    public void setY(float y) {
        this.y = y + height / 2;
    }
}
