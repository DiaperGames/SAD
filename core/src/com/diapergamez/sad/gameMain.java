package com.diapergamez.sad;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.diapergamez.sad.actors.loading.*;
public class gameMain extends ApplicationAdapter {
	private SpriteBatch batch;
	Texture logo;
	private OrthographicCamera camera;
	int w, h , tw, th;
	private	FitViewport viewport;
	Stage stage;

	@Override
	public void create () { //This is the method that is used to load game assets
		viewport = new FitViewport(1920,1080,camera);
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage); //keylistener! this allows you to call methods when the person clicks on a sprite etc
		Actor logo = new Logo();
		stage.addActor(logo);



	}
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
	}
	public void resize (int width, int height){
		stage.getViewport().update(width,height,true);
		w = width;
		h = height;
	}
	@Override
	public void dispose () {

		logo.dispose();
	}



}
