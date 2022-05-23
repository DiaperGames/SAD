package com.diapergamez.sad.actors.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Logo extends Actor{
    private int tw, th; //texture Width, and textureheight, to be used later.
    private Camera camera;
    Texture logo = new Texture(Gdx.files.internal("diapergames.jpg"));
    public Logo(Camera camera){
       this.camera = camera;
        tw = logo.getWidth(); th = logo.getHeight();


    }





    @Override
    public void draw(Batch batch, float parentAlpha){

        batch.draw(logo,camera.position.x - (tw/2), camera.position.y - (th/2),tw,th);

    }

}


