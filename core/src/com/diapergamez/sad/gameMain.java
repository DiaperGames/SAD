package com.diapergamez.sad;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.diapergamez.sad.actors.loading.*;
import com.diapergamez.sad.screens.logoSplash;
import com.diapergamez.sad.screens.mainMenu;


public class gameMain extends Game {
	Texture logo;
	public OrthographicCamera camera;
	int w, h;
	public Stage stage;
 	public long startTime;
	@Override
	public void create () { //This is the method that is used to load game assets
		w = Gdx.graphics.getWidth(); h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(w,h);
		camera.position.set(w/2,h/2,0);
		camera.update();
		FitViewport viewport = new FitViewport(w, h, camera);
		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage); //keylistener! this allows you to call methods when the person clicks on a sprite etc





	}
	@Override
	public void render () {
		super.render();
	setScreen(new logoSplash(this));
	//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	//stage.draw();
	}
	public void resize (int width, int height){

		stage.getViewport().update(width,height,true);
		//I pass true to this constructor to recenter the camera, making 0,0 the origin/center graph
		w = width;
		h = height;
	}
	@Override
	public void dispose () {
		stage.dispose();
		logo.dispose();
	}



}
