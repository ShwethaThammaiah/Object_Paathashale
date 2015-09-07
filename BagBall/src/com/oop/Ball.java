package com.oop;

/**
 * Created by shwethathammaiah on 27/05/15.
 */
public class Ball {

    private Color color;
    private Size size;

    public Ball(Color color, Size size){
        this.color = color;
        this.size = size;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
