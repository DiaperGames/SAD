package com.diapergamez.sad.actors.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Logo extends Actor{
    Texture logo = new Texture(Gdx.files.internal("diapergames.jpg"));
    @Override
    public void draw(Batch batch, float parentAlpha){
        batch.draw(logo,0,0);
    }

}
