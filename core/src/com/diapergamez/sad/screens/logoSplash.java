package com.diapergamez.sad.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.diapergamez.sad.actors.loading.Logo;
import com.diapergamez.sad.gameMain;


public class logoSplash implements Screen {
    final gameMain game;
    OrthographicCamera camera;
    Actor logo;  // importing the actor class referring to the logo texture.
    Sound baby;
    Stage splashStage;
    int w, h;
    public logoSplash(gameMain game) {
        this.game = game;
        camera = game.camera;
        logo = new Logo(camera);
        splashStage = new Stage(game.stage.getViewport());
        splashStage.addActor(logo);
        logo.addAction(Actions.sequence(Actions.alpha(0.0F), Actions.fadeIn(1.25F),Actions.delay(1F), Actions.fadeOut(0.75F)));
        baby = Gdx.audio.newSound(Gdx.files.internal("baby.mp3"));
    }

    @Override
    public void show() {
        w = Gdx.graphics.getWidth(); h = Gdx.graphics.getHeight();
        camera = game.camera;
        camera.position.set(w/2,h/2,0);
        camera.update();
        splashStage = new Stage(game.stage.getViewport());
        splashStage.addActor(logo);
        logo.addAction(Actions.sequence(Actions.alpha(0.0F), Actions.fadeIn(2.25F),Actions.delay(2F), Actions.fadeOut(0.75F)));
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
            camera.update();
        logo.act(1);
        splashStage.draw();
        long id = baby.play(1.0F);
        baby.stop(id);


    }

    @Override
    public void resize(int width, int height) {
      game.stage.getViewport().update(width,height,true);
      //I pass true to this constructor to recenter the camera, making 0,0 the origin/center graph


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
    }
}
