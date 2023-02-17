package main;

import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {

    public static void main(String[] args) {
        //PApplet.main("main.Main",args);
        String[] a = {"MAIN"};
        PApplet.runSketch(a, new Main());
    }


    int num = 50;
    Particle[] p = new Particle[num];

    @Override
    public void settings() {
        //size(1220,720);
        fullScreen();
    }

    @Override
    public void setup() {
        colorMode(HSB);
        for(int i=0; i < num; i++){
            p[i] = new Particle(new PVector(random(width),random(height)),10,140, this);
        }
        stroke(450);
    }

    @Override
    public void draw() {
        background(0);

        for(int i=0; i < num; i++){
            p[i].update(p,i);
        }

    }
}