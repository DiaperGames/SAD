package com.diapergamez.sad.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.diapergamez.sad.actors.pets.Pet;
import com.diapergamez.sad.gameMain;

public class gameScreen implements Screen {
    private OrthographicCamera orthocam;
    private Stage gameStage;
    private Pet minion;
    private gameMain game;
    private AssetManager manager;
    private float w,h;

    public gameScreen(gameMain game){
        this.game = game;
        w = game.w;
        h = game.h;
        this.manager = game.manager;
        orthocam = game.orthocam;
        FitViewport viewport = new FitViewport(w,h,orthocam);
        gameStage.setViewport(viewport);


    }
    @Override

    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
