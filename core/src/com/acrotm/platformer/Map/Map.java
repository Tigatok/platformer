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
        tiles = new int[pixmap.getWidth()][pixmap.getHeight()];
        for(int y = 0; y < 35; y++){
            for(int x=0; x<150;x++){
                int pix = (pixmap.getPixel(x, y) >>> 8) & 0xffffff;
                if(match(pix, START)){
                    Dispenser dispenser = new Dispenser(x, pixmap.getHeight() - 1 - y);
                    dispensers.add(dispenser);
                    activeDispenser = dispenser;
                    bob = new Bob(this, activeDispenser.bounds.x, activeDispenser.bounds.y);
                    cube.state=Cube.DEAD;
                }
            }
        }
    }
}
