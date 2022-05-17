package com.diapergamez.sad;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class gameMain extends ApplicationAdapter {
	private SpriteBatch batch;
	Texture logo;
	private OrthographicCamera camera;
	int w, h , tw, th;
	private	FitViewport viewport;
	
	@Override
	public void create () { //This is the method that is used to load game assets
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(w,h);
		camera.setToOrtho(false,w,h);
		camera.update();
		viewport = new FitViewport(w,h,camera);
		logo = new Texture("diapergames.jpg");
		tw = logo.getWidth();	//this will be used for drawing the logo at the center of the screen
		th = logo.getHeight(); 	//this will be used for drawing the logo at the center of the screen
		batch = new SpriteBatch();
	}
	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(logo, camera.position.x - tw/2,  camera.position.y - th/2);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		logo.dispose();
	}

}
