package com.acrotm.platformer.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Tyler on 11/27/2015.
 */
public class MainMenu extends PlatformerScreen{
    TextureRegion title;
    SpriteBatch batch;
    float time = 0;
    /**
     * We Extend the PlatFormer Screen so we can use the methods
     * that the Platformer screen has without having to implement Screen over
     * and over again.
     *
     * With this class extending PlatformerScreen we now
     * have access to all it's variables.
     *
     * note:
     *   We need a unit in the game. 1 Unit will be equal to 1 metre.
     *   Our main character (atm) will be 0.8x0.8metres.
     *   (cube is the same size, though not sure if we will
     *    be using him.)
     *
     *   We make the viewport (The portion visible at any time)
     *    24x16metres to make it easily mappable to pixels.
     *
     *   1 metre = 20 pixels. We multiple this value
     *   by our 24 width and 16 height to get our
     *   screen resolutions: 480x320px.
     *
     *   Our images, in a tile graphic will be arranged in a 20x20 grid.
     *   this enables us to adhere to the sizes chosen in world
     *   coordinates easily (e.g. 0.6x0.6m ~12x12px);
     *
     * @param game a Game object.
     */
    public MainMenu(Game game) {
        super(game);
    }

    @Override
    public void show(){
        title = new TextureRegion(new Texture(Gdx.files.internal("data/title.png")), 0, 0, 480, 320);
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);
    }

    @Override
    public void render (float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(title, 0, 0);
        batch.end();

        time += delta;
        if(time > 1){
            if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) || Gdx.input.justTouched()){
                game.setScreen(new IntroScreen(game));
            }
        }
    }

    @Override
    public void hide(){
        Gdx.app.debug("Platformer", "dispose main menu");
        batch.dispose();
        title.getTexture().dispose();
    }
}
