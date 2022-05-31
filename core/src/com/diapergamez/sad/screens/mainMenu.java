package com.diapergamez.sad.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.diapergamez.sad.gameMain;


//balls
public class mainMenu implements Screen {
    gameMain game;
    OrthographicCamera camera;
    private Stage menu;
    private Skin skin; //FUCK YOU NOLAN!!!!!!! WRITE THE FUCKING CODE YOU FUCKING PIECE OF SHIT!!!!!!!!
    /* TODO implement a Skin file (it's not like .skin i don't think) that will reference the font
    *   we want to use and whatever other stuff you put in that file;
    *
    * TODO whoever is gonna be the GUI guy (might be me >:(  ) please learn the rest of scene2d, and implement this in a way that looks nice
    *
     * */

    public mainMenu(final gameMain game){
        //I implemented a simple button for now so you guys can get an idea of scene2d
        Gdx.app.log("cock","FUCK"); //log message so that I could see that this method was called
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        this.game = game;
        camera = new OrthographicCamera(w,h);
        FitViewport viewport = new FitViewport(w, h, camera);
        menu = new Stage(viewport);
        Gdx.input.setInputProcessor(menu);
        Table table  = new Table();
        table.align(0);
        table.center();
        //i barely know what this shit does
        //update, this holds all the instructions for scene2d ui drawing tools to draw the skin
        skin = new Skin(Gdx.files.internal("UI/skinui.json"));
        //declaring a text button using the skin, and a declared "default style" in the skinui class
        final TextButton button = new TextButton("I am a placeholder, click me to enter the game", skin,"default");
        //using a table to draw the button in the center
        table.add(button);
        //the drawing is weird, and it draws everything from bottom left as if it was an origin on a coordinate graph
        //so I take the width of the screen over two, and the button width over two to get the center point and draw the button
        //at the center point
        button.setPosition(w/2 - button.getWidth()/2, h/2 - button.getHeight()/2);
        //button.setPosition(Gdx.graphics.getWidth()/2 - 100f, Gdx.graphics.getHeight()/2 - 10f);
        button.addListener(new ClickListener(){
            //implementing a click listener so that the user can click on the button
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //method for click listener
                game.setScreen(new gameScreen(game));
                //switching the screen
                mainMenu.this.hide();
            }

            @Override
            //called when this enters the box
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button.center();
                button.setText("go on, click me >:(");
            }

            @Override
            //called when this exits the box
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                button.setText("I am a placeholder, click me to enter the game");
            }

        });
        //add the button to the menu stage so that it can be drawn, and then filled in.
        menu.addActor(button);

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
    menu.dispose();
    }
}
