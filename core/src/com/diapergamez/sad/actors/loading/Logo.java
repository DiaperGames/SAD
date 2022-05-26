package com.diapergamez.sad.actors.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


@SuppressWarnings("IntegerDivisionInFloatingPointContext")
public class Logo extends Actor {
    public int tw, th; //texture Width, and textureheight, to be used later.
    public float xBound, yBound;
    private Camera camera;
    Texture logo = new Texture(Gdx.files.internal("diapergames.jpg"));
    public Texture minion = new Texture(Gdx.files.internal("pets/minion.png"));
    public boolean secretminion = false;
    public Logo(Camera camera){
        //it's kinda silly I need this, but this does thing so that I can only click the baby
       this.camera = camera;
        tw = logo.getWidth(); th = logo.getHeight();
        setTouchable(Touchable.enabled);  // what the FUCK
        xBound = camera.position.x - (tw/2); yBound = camera.position.y - (th/2);
        /*
        this was hell to figure out, but now I know how to proccess inputs
        TODO (maybe) figure out how to implement this within the actor (logo) itself cause proper OOP principles
         */
        setBounds(camera.position.x + (tw/2),camera.position.y + (th/2),tw,th);
        this.addListener( new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(button == Input.Buttons.LEFT){
                    Gdx.app.log("input", "touch started at x" + x + " y "+ y + " with mouse button " + button);
                    Gdx.app.log("Crash","User Clicked the baby. User is stupid");
                    Gdx.app.exit();
                    return  true;
                }
                return false;
            }
            @Override
            //TODO get the minion to work?
            public boolean isOver(Actor actor, float x, float y) {
                secretminion = true;
                Gdx.app.log("easter egg", "MINION ACTIVE!!!!");
                return true;


            }
        });

    }


    @Override
    public void draw(Batch batch, float parentAlpha){
        batch.draw(logo, camera.position.x - (tw / 2), camera.position.y - (th / 2), tw, th);        //batch.draw(logo,tw/2,th/2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}


