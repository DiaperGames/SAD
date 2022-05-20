package com.diapergamez.sad.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.diapergamez.sad.actors.Animations;
import com.diapergamez.sad.actors.loading.Logo;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class logoSplash implements Screen{
    public final long screenStart;
    private Stage splashStage;
    private Camera orthocam;
    private int w, h;
    private Logo logo;
    public logoSplash(){
        screenStart = System.currentTimeMillis();
        w = Gdx.graphics.getWidth(); h = Gdx.graphics.getHeight();
        FitViewport viewport = new FitViewport(w,h);
        orthocam = new OrthographicCamera();
        viewport.setCamera(orthocam);
        logo = new Logo(orthocam);
        splashStage = new Stage(viewport);
        splashStage.addActor(logo);
        Gdx.input.setInputProcessor(splashStage);
        logo.addAction(Actions.fadeIn(2f));

    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.2f,1);
        orthocam.update();
       splashStage.act(Gdx.graphics.getDeltaTime());
       splashStage.draw();




    }

    @Override
    public void resize(int width, int height) {
        splashStage.getViewport().update(width, height,true);
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