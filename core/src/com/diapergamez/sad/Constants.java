package com.diapergamez.sad;

import com.badlogic.gdx.Gdx;

public class Constants {
 /** Screen Width **/
 public static final int SCREEN_W = Gdx.graphics.getWidth();
 /** Screen Height **/
 public static final int SCREEN_H = Gdx.graphics.getHeight();

 public static final String PETS_ATLAS = "pets.atlas";
 public static final String PETS_ATLAS_PNG = "pets.png";
 public static final String ITEMS_ATLAS = "items.atlas";
 public static final String ITEMS_ATLAS_PNG = "items.png";
 public static final String BABYCRY = "baby.mp3";
 public static final String DIAPERGAMES = "diapergames.jpg";
 public static final String PETCHOICE_ATLAS = "UI/PetChoice.atlas";
 public static final String PETCHOICE_JSON = "UI/petChoice.json";
 public static final String PETCHOICE_ATLAS_PNG = "UI/petchoice.png";
}
//TODO replace all instance uses of w and h to these statics