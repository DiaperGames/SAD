package com.diapergamez.sad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.diapergamez.sad.actors.pets.Pet;

//TODO adjust the javadocs as the click listener is implemented;
public class petListener extends ClickListener {
    private Pet pet;
    private Vector2 mousePos;
    //TODO might have to relocate this listener to the pet class itself as an instance method.
    /**
     * @param pet create a listener that primarily pays attention to the pet object
     * @param mousePos: 2DVector that is updated with mouseposition in render method
     */
    public petListener(Pet pet, Vector2 mousePos) {
        super();
        this.pet = pet;
        this.mousePos = mousePos;
        Gdx.app.log("Petlistener","Init");

    }

//    @Override
//    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//        Gdx.app.log("touchevent","TouchDown");
//        if(getTouchDownX() == x && getTouchDownY() == y){
//            return false;
//        }else{
//            Gdx.app.log("touchDown", "false");
//           return false;
//        }
//    }

    @Override

    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        event.toCoordinates(pet,mousePos);
        pet.setOrigin(pet.getX()-x,pet.getY()-mousePos.y);
        Gdx.app.log("Touchdrag","This was called. pet was moved too X:" + mousePos.x + " Y: " + mousePos.y);
    }

//    @Override
//    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//        super.touchUp(event, x, y, pointer, button);
//        Gdx.app.log("TouchUp", "Touch Up called");
//    }

}