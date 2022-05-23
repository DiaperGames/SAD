package com.diapergamez.sad.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.diapergamez.sad.actors.loading.Logo;
import com.diapergamez.sad.gameMain;

public class logoSplash implements Screen {
    public final long screenStart; // primarily implemented for the purposes of timing the splashscreen
    private gameMain game;
    private Stage splashStage;
    private Camera orthocam;
    private int w, h;
    private Logo logo;
    private Sound cry;

    public logoSplash(gameMain gameMain) {
        cry = Gdx.audio.newSound(Gdx.files.internal("baby.mp3"));
        screenStart = System.currentTimeMillis();
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        FitViewport viewport = new FitViewport(w, h);
        orthocam = new OrthographicCamera();
        viewport.setCamera(orthocam);
        logo = new Logo(orthocam);
        splashStage = new Stage(viewport);
        splashStage.addActor(logo);
        Gdx.input.setInputProcessor(splashStage);
        logo.addAction(Actions.fadeIn(2f));
        game = new gameMain();

    }

    @Override
    public void show() {
        cry.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        splashStage.getBatch().getProjectionMatrix().setToOrtho2D(0, 0, 1, 1);
        splashStage.draw();
        //TODO fix the STUPID fucking baby and make it actually fade in cause I have no fucking clue why the actor won't work
        //
        orthocam.update();
        splashStage.act(Gdx.graphics.getDeltaTime());
       /*
       TODO put the assett manager stuff that is to be loaded here.
        */
        game.loadAssets();
        //if assetts are loaded, and the splash screen has been shown for longer than 10 seconds do
        if (game.manager.update() || TimeUtils.timeSinceMillis(screenStart)>= 10000){
           // game.setScreen(new mainMenu(game));

        }


    }

    @Override
    public void resize(int width, int height) {
        splashStage.getViewport().update(width, height, true);
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
        splashStage.dispose();
        cry.dispose();
    }
}