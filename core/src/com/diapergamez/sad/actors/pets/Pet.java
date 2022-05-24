package com.diapergamez.sad.actors.pets;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;


public class Pet extends Actor {
    Sprite sprite;

    public Pet()
    {
        setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        setTouchable(Touchable.enabled);
        setVisible(false);

        }
    }
//TODO implement rest of pet constructor(maybe make action listener) and add the rest of parameters like video :D
//https://www.youtube.com/watch?v=A_-rxTO5138


