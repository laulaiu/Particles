package main;

import processing.core.PVector;
import processing.core.PApplet;

import static processing.core.PApplet.*;

public class Particle  {
    PVector pos;
    PVector vel;
    float r, mr;

    float spd = 0.1F;
    float max = 2;
    Main p;

    Particle(PVector pos, float mr, float r, Main p){

        this.pos = pos;
        this.mr  = mr;
        this.r  = r;
        this.p = p;

        vel = new PVector( p.random(-1,1), p.random(-1,1));

    }

    int onOff= 0;
    void update(Particle[] prtc, int i){
        pos.add(vel);

        if(pos.x < -10) pos.x = p.width;
        if(pos.x > p.width + 10) pos.x = 0;
        if(pos.y < -10) pos.y = p.height;
        if(pos.y > p.height + 10) pos.y = 0;

        vel.x = constrain( vel.x + p.random(-spd,spd),-max, max);
        vel.y = constrain( vel.y + p.random(-spd,spd), -max, max);

        if(onOff == 0){

            for(int j=i+1; j<prtc.length; j++){
                float ang = p.atan2(pos.y - prtc[j].pos.y, pos.x - prtc[j].pos.x);
                float dist = pos.dist(prtc[j].pos);

                if(dist < r){
                    p.line(pos.x, pos.y, prtc[j].pos.x, prtc[j].pos.y);
                    float force = map(dist,0,r,10,0);
                    vel.x += force * cos(ang);
                    vel.y += force * sin(ang);

                }

            }

        }

        p.stroke(Math.round(p.random(254)),Math.round(p.random(254)),Math.round(p.random(254)));
        p.ellipse(pos.x, pos.y, 5,5);
    }
}
