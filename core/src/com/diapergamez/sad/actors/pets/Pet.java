package com.diapergamez.sad.actors.pets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.diapergamez.sad.Items;

import java.lang.reflect.Array;

public class Pet extends Actor {
    public int tw, th;
    private Texture petPic;
    private ParticleEffect itemEffect;
    private byte health,attack; //0-50 range
    private boolean hasHouse, hasMaxVal, hasParallel, hasPi, hasSemicolon, hasSwitch, hasTicTacToe;
    private byte turn;
    public TextureAtlas items;
    private ParticleEmitter particleEffects[];
    //below bool is for the maxValue item
    //TODO We'd likely have to do stat checking of the units at the start of each turn
    private boolean isStrongest;
    private byte level;
    /**
    * X & Y, coordinates as to where you want texture to be drawn
    * (is drawn from bottom left)
    * Implement texture parameter in subclass, push texture parameter to super.
     */
    public Pet(float x, float y, Texture texture) {
        petPic = texture;
        setBounds(x,y, petPic.getWidth(), petPic.getHeight());
        setTouchable(Touchable.enabled);
        setVisible(true);
        items = new TextureAtlas(Gdx.files.internal("items.atlas"));
        itemEffect.load(Gdx.files.internal("/items/items.particle"),items);
        particleEffects = itemEffect.getEmitters().toArray();

        }

    /*
     this is probably more efficient than building a bunch of item classes.
     TODO: depending on how we implement turns in the game, we'll refactor/format our code
         here to reflect what turn it is, my best bet, is to constantly update the pets
         with what turn it is in the stages render method, which get's called each frame.
    */
    /**
    *
    *
    *
    *
    * ONLY CALL MAXVALUE IF This.isStrongest= true
    *
     */
    public void giveItem(Items item){
            switch (item) {
                case HOUSE:
                    health+=2;
                    //loading the particle file, and it's associated item

                  if(!hasHouse) {
                      particleEffects[0] = itemEffect.findEmitter("House");
                      hasHouse = true;
                  }
                    break;
                case MAXVALUE:
                   //TODO someone else implement maxvalue in a memory conscious way cause this shit sucks to implement
                    //TODO implement the stat changes, and a way to figure out what turn it is
                    if(!hasMaxVal){

                        particleEffects[1] = itemEffect.findEmitter("MaxValue");
                        hasMaxVal = true;
                    }
                    break;
                case PARALELL:
                    //TODO implement stat changes
                    if(!hasParallel){

                        //TODO implement stat changes
                        particleEffects[2] = itemEffect.findEmitter(("Parallel Lines"));
                        hasParallel = true;
                    }
                    break;
                case PI:
                    if(!hasPi){
                        //TODO implement stat changes

                        particleEffects[3] = itemEffect.findEmitter("Pi");
                        hasPi = true;
                    }
                    break;
                case SEMICOLON:
                    //TODO implement stat changes
                    if(!hasSemicolon){

                        particleEffects[4] = itemEffect.findEmitter("Semicolon");
                        hasSemicolon = true;
                    }
                    break;
                case SWITCH:
                    //TODO implement stat changes
                    if(!hasSwitch){

                        particleEffects[5] = itemEffect.findEmitter("Switch");
                       hasSwitch = true;
                    }
                    break;
                case TICTACTOE:
                    //TODO implement stat changes
                    if(!hasTicTacToe){

                        particleEffects[6] = itemEffect.findEmitter("TicTacToe");
                        hasTicTacToe = true;
                    }
                    break;
            }

        }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (hasParallel || hasPi ||hasSwitch || hasSemicolon || hasHouse || hasMaxVal || hasTicTacToe){
            for (ParticleEmitter emitter: particleEffects) {
                emitter.draw(batch);}
        }
        super.draw(batch, parentAlpha);
    }










    public byte getHealth() {
        return health;
    }

    public void setHealth(byte health) {
        this.health = health;
    }

    public byte getAttack() {
        return attack;
    }

    public void setAttack(byte attack) {
        this.attack = attack;
    }

    public byte getTurn() {
        return turn;
    }

    public void setTurn(byte turn) {
        this.turn = turn;
    }

    public boolean isStrongest() {
        return isStrongest;
    }

    public void setStrongest(boolean strongest) {
        isStrongest = strongest;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }
}
