package com.diapergamez.sad.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
    public  final Vector2 mouseInWorld2d = new Vector2();
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
        orthocam.update();
        Gdx.input.setInputProcessor(gameStage);
        Sprite temp = pets.createSprite("Minion");
        Pet pet = new Pet(1,1,pets.createSprite("Minion"));
        pet.giveItem(Items.HOUSE);
        gameStage.setKeyboardFocus(pet);
        petListener listener= new petListener(pet, mouseInWorld2d);
        gameStage.addTouchFocus(listener,pet,pet,0,0);
       gameStage.addActor(pet);
       pet.setBounds(temp.getOriginX(),temp.getOriginY(),temp.getWidth(),temp.getHeight());
       pet.addListener(listener);


    }
    @Override

    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // huh?
       //below code is my implementation for the mouse position.
        mouseInWorld2d.x = Gdx.input.getX();
        mouseInWorld2d.y = Gdx.input.getY();
        gameStage.act(Gdx.graphics.getDeltaTime());
        gameStage.draw();
        orthocam.update();

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
