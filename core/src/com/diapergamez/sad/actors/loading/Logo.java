package com.diapergamez.sad.actors.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Logo extends Actor{
    private int width = Gdx.graphics.getWidth(), height = Gdx.graphics.getHeight();
    private int tw, th;
    private Camera camera;
    Texture logo = new Texture(Gdx.files.internal("diapergames.jpg"));
    public Logo(Camera camera){
       this.camera = camera;
    }
    Logo(){};
    @Override
    public void draw(Batch batch, float parentAlpha){

        tw = logo.getWidth(); th = logo.getHeight();
        batch.draw(logo,camera.position.x - (tw/2), camera.position.y - (th/2));
    }

}


