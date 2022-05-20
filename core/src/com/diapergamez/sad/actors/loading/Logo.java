package com.diapergamez.sad.actors.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;

public class Logo extends Actor{
    private int tw, th;
    private float drawX, drawY;
    private Camera camera;
    Texture logo = new Texture(Gdx.files.internal("diapergames.jpg"));
    public Logo(Camera camera){
       this.camera = camera;
        tw = logo.getWidth(); th = logo.getHeight();
        drawX = camera.position.x - (tw/2);
        drawY = camera.position.y - (th/2);


    }



    public Logo(){

    };



    @Override
    public void draw(Batch batch, float parentAlpha){
        batch.draw(logo,camera.position.x - (tw/2), camera.position.y - (th/2));

    }

}


