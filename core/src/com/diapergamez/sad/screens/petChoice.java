package com.diapergamez.sad.screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.diapergamez.sad.gameMain;

import static com.badlogic.gdx.Input.Keys.T;
import static com.badlogic.gdx.scenes.scene2d.Touchable.enabled;
import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.cell;
import static com.diapergamez.sad.Constants.SCREEN_H;
import static com.diapergamez.sad.Constants.SCREEN_W;

public class petChoice implements Screen {
    private Skin skin;
    private gameMain game;
    private AssetManager manager;
    private Stage stage;
    private Table table;
    private OrthographicCamera orthoCam = new OrthographicCamera(SCREEN_W,SCREEN_H);
    public petChoice(gameMain game) {
        manager = game.manager;
        this.game = game;
        Viewport fitviewport = new FitViewport(SCREEN_W,SCREEN_H);
        stage = new Stage(fitviewport);
        skin = new Skin(Gdx.files.internal("UI/petChoice.JSON"));
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.align(Align.topLeft);
        table.setName("Pets");
        table.setColor(skin.getColor("greenish"));
        table.setTouchable(enabled);
        table.setFillParent(true);
        //implementing the minion

        Button button = new Button(skin, "Minion");
        button.setName("Minion");
        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);

        button = new Button(skin, "NullMinion");
        button.setName("null");
        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);

        button = new Button(skin, "Taxes");
        button.setName("Taxes");
        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);

        button = new Button(skin, "Benzine");
        button.setName("Benzine");

        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);
        button = new Button(skin, "ProgramStructure");
        button.setName("ProgramStructure");
        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);


        table.row();



        button = new Button(skin, "Chorby");
        button.setName("Chorby");
        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);

        button = new Button(skin, "BaseCase");
        button.setName("BaseCase");
        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);

        button = new Button(skin, "Recursive");
        button.setName("Recursive");
        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);

        button = new Button(skin, "while");
        button.setName("While");
        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);

        button = new Button(skin, "Change");
        button.setName("Change");
        table.add(button).growX().minWidth(100.0f).prefWidth(100f).prefHeight(100f);
        stage.addActor(table);
    }

    public void show() {

    }
 @Override
    public void render(float delta) {
        //TODO Implement Act methods for all the buttons
        //TODO implement a second table at the bottom of the screen with your team
        //TODO implement array of pets
        //TODO implement Item Shop
        //TODO implement ^ as an extension of this class?
//        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//here I'm using newer java language features, for each lambda iterator
// and anonymyzed classes (the curly brackets) not sure how this will affect performance though.
        stage.act();
        stage.draw();
    }
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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

    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
