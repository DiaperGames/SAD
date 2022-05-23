package com.diapergamez.sad;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.diapergamez.sad.screens.logoSplash;

public class gameMain extends Game{
public AssetManager manager = new AssetManager();
public OrthographicCamera orthocam;



	@Override
	public void create() {
		int w = Gdx.graphics.getWidth(); int h = Gdx.graphics.getHeight();
		orthocam = new OrthographicCamera(w,h);
		setScreen(new logoSplash(gameMain.this));


	}
	public void render(){
		super.render();
	}
	public void dispose(){
		//put dispose stuff here?
	}

	public void loadAssets(){
		//TODO put assett loading shit here
		manager.update();
	}
}