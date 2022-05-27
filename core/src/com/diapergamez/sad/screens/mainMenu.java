package com.diapergamez.sad.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.diapergamez.sad.gameMain;


//balls
public class mainMenu implements Screen {
    final gameMain game;
    OrthographicCamera camera;
    private Stage menu;
    private Skin skin; //FUCK YOU NOLAN!!!!!!! WRITE THE FUCKING CODE YOU FUCKING PIECE OF SHIT!!!!!!!!
    /* TODO implement a Skin file (it's not like .skin i don't think) that will reference the font
    *   we want to use and whatever other stuff you put in that file;
    *
    * TODO whoever is gonna be the GUI guy (might be me >:(  ) please learn the rest of scene2d, and implement this in a way that looks nice
    *
     * */

    public mainMenu(gameMain game){
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        this.game = game;
        camera = new OrthographicCamera(w,h);
        FitViewport viewport = new FitViewport(w, h, camera);
        menu = new Stage(viewport);
        Gdx.input.setInputProcessor(menu);
        //i barely know what this shit does
        skin = new Skin(Gdx.files.internal("UI/skinui.json"));
        



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        menu.act(Gdx.graphics.getDeltaTime());
        menu.draw();
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
