package com.diapergamez.sad.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.diapergamez.sad.Items;
import com.diapergamez.sad.actors.pets.Pet;
import com.diapergamez.sad.gameMain;
import com.diapergamez.sad.petListener;

public class gameScreen implements Screen {
    private OrthographicCamera orthocam;
    private Stage gameStage;
    private Pet minion;
    private gameMain game;
    private AssetManager manager;
    private float w,h;
    private TextureAtlas pets, items;
    public gameScreen(gameMain game){
        this.game = game;
        pets = game.manager.get("pets.atlas");
        items = game.manager.get("items.atlas");
        w = game.w;
        h = game.h;
        gameStage = new Stage();
        orthocam = game.orthocam;
        FitViewport viewport = new FitViewport(w,h,orthocam);
        gameStage.setViewport(viewport);
        Gdx.input.setInputProcessor(gameStage);

        final Pet pet = new Pet(1,1,pets.createSprite("Minion"));
        pet.giveItem(Items.HOUSE);
      pet.addListener(new petListener(pet));
       gameStage.addActor(pet);

    }
    @Override

    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // huh?
        gameStage.act();
        gameStage.draw();

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
