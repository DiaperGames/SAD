package com.diapergamez.sad.actors.pets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.diapergamez.sad.Items;
import java.util.ArrayList;

public class Pet extends Actor {
    @SuppressWarnings("FieldMayBeFinal")
    private float myX,
                  myY,
                  tw,
                  th;

    private final Texture petPic;
    private ParticleEffect itemEffect;
    private byte
            level,
            ticTacToeCount,
            maxValCount,
            tier,
            health, //0-50 range
            attack; //0-50 range
    private boolean hasHouse;
    private boolean hasMaxVal;
    private boolean hasParallel;
    private boolean hasPi;
    private boolean hasSemicolon;
    private boolean hasSwitch;
    private boolean hasTicTacToe;
    private boolean isStrongest;
    private boolean isFirst;
    private boolean isLast;


    private boolean isHealthiest;

    private byte turn;
    public TextureAtlas items;
    private ArrayList<ParticleEmitter> particleEffects = new ArrayList<ParticleEmitter>();
    //below bool is for the maxValue item
    //TODO We'd likely have to do stat checking of the units at the start of each turn
    /**
    * X & Y, coordinates as to where you want texture to be drawn
    * (is drawn from bottom left)
    * Implement texture parameter in subclass, push texture parameter to super.
     */
    public Pet(float x, float y, Texture texture) {
        myX = x;
        myY = y;
        petPic = texture;
        tw = petPic.getWidth();
        th = petPic.getHeight();
        setBounds(x,y,tw,th);
        setTouchable(Touchable.enabled);
        setVisible(true);
        items = new TextureAtlas(Gdx.files.internal("items.atlas"));
        itemEffect = new ParticleEffect();
        itemEffect.load(Gdx.files.internal("items/items.particle"),items);
        }
    /* TODO !Important I haven't actually been able to test any of the particle effects/emitters outside of creating
    *       creating them, so they may not even draw properly/in the right place*/

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
    /**
     *
     * @param item
     */
//made this an if/else statement to improve readability
    public void removeItem(Items item){

        if (item == Items.MAXVALUE) {
            for (int i = 0; i < maxValCount; i++) {
                attack -= 3;
            }
            hasMaxVal = false;
            maxValCount = 0;
        } else if (item == Items.TICTACTOE) {
            for (int i = 0; i < ticTacToeCount; i++) {
                health--;
                attack--;
            }
            hasTicTacToe = false;
            ticTacToeCount = 0;
        }
    }


    /**
     * For MaxVal, only call if pet.isStrongest = True;
     * for Switch, only call if the pet infront is dead (check for this
     * @param item = Name of the item you want to give the pet, (see Items.java for ENUM data)
     *
     */
    public void giveItem(Items item){
            switch (item) {
                case HOUSE:
                    health+=2;
                  if(!hasHouse) {
                      particleEffects.add(0,itemEffect.findEmitter("House"));
                      hasHouse = true;
                  }
                    break;
                case MAXVALUE:
                   //TODO someone else implement maxvalue in a memory conscious way cause this shit sucks to implement
                    //TODO implement the stat changes, and a way to figure out what turn it is
                    attack+=3;
                    if(!hasMaxVal){
                        maxValCount++;
                        particleEffects.add(1,itemEffect.findEmitter("MaxValue"));
                        hasMaxVal = true;
                    }else{
                        maxValCount++;
                    }
                    break;
                case PARALELL:

                    byte average = (byte) ((health+attack)/2);
                    attack = average;
                    health = average;
                    if(!hasParallel){
                        particleEffects.add(2,itemEffect.findEmitter(("Parallel Lines")));
                        hasParallel = true;
                    }
                    break;
                case PI:
                    if(!hasPi){
                        switch(level)
                        {
                            case 1:
                                attack+=3;
                                health++;
                                break;
                            case 2:
                                attack+=4;
                                health++;
                                break;
                            case 3:
                                attack+=5;
                                health+=9;
                                break;
                        }
                        particleEffects.add(3,itemEffect.findEmitter("Pi"));
                        hasPi = true;
                    }
                    break;
                case SEMICOLON:
                    //todo implement semicolon as an item instead of a pet, as that is what LIAM intended
                    //todo maybe implement a way where you can only give semicolon to the last pet

                    health+=3;
                    attack+=3;
                    if(!hasSemicolon){
                        particleEffects.add(4,itemEffect.findEmitter("Semicolon"));
                        hasSemicolon = true;
                    }
                    break;
                case SWITCH:
                    //TODO implement a check for when the pet ahead faints in the screen method

                    if(!hasSwitch){

                        particleEffects.add(5,itemEffect.findEmitter("Switch"));
                       hasSwitch = true;
                    }
                    break;
                case TICTACTOE:

                    //TODO implement stat changes
                    if(!hasTicTacToe){
                        attack++;
                        health++;
                        ticTacToeCount++;
                        particleEffects.add(6,itemEffect.findEmitter("TicTacToe"));
                        hasTicTacToe = true;
                    }else{
                        attack++;
                        health++;
                        ticTacToeCount++;
                    }
                    break;
            }

        }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(petPic,myX,myY,tw,th);
        if (hasParallel || hasPi ||hasSwitch || hasSemicolon || hasHouse || hasMaxVal || hasTicTacToe && !particleEffects.isEmpty()){
            for (ParticleEmitter emitter: particleEffects) {
                emitter.start();
                emitter.setPosition(myX,myY);
                emitter.setAdditive(true);
                emitter.setContinuous(true);
                emitter.draw(batch,Gdx.graphics.getDeltaTime());}
        }

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

    public byte getTier() {
        return tier;
    }
    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public boolean isHealthiest() {
        return isHealthiest;
    }

    public void setHealthiest(boolean healthiest) {
        isHealthiest = healthiest;
    }

    public void setTier(byte tier) {
        this.tier = tier;
    }
}
