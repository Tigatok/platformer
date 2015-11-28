package com.acrotm.platformer.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;

/**
 * Created by Tyler on 11/27/2015.
 */
public class Map {
    static int EMPTY = 0;
    static int TILE = 0xffffff;
    static int START = 0xff0000;
    static int END = 0xff00ff;
    static int DISPENSER = 0xff0100;
    static int SPIKES = 0x00ff00;
    static int ROCKET = 0x0000ff;
    static int MOVING_SPIKES = 0xffff00;
    static int LASER = 0x00ffff;

    int[][] tiles;
    public Bob bob;
    Cube cube;
    Array<Dispenser> dispensers = new Array<Dispenser>();
    Dispenser activeDispenser = null;
    Array<Rocket> rockets = new Array<Rocket>();
    Array<MovingSpikes> movingSpikes = new Array<MovingSpike>();
    Array<Laser> lasers = new Array<Laser>();
    public EndDoor endDoor;

    public Map(){
        loadBinary();
    }

    public void loadBinary(){
        Pixmap pixmap = new Pixmap(Gdx.files.internal("data/levels.png"));
        
    }
}
