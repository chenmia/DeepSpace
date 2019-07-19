package com.missionbit.states;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.missionbit.sprites.Stars;

public class Assets {
    public AssetManager assetManager;

    public  final AssetDescriptor<Texture> PLAYBTN;
    public  final AssetDescriptor<Texture> TITLE;
//    public  final AssetDescriptor<Texture> LOGO = new AssetDescriptor<Texture>("logo.png", Texture.class);
//    public static final AssetDescriptor<Stars> STARS = new AssetDescriptor<Stars>("assets/starfield.gif", Stars.class);
    public  final AssetDescriptor<Music> MUSIC = new AssetDescriptor<Music>("deepmusic.mp3", Music.class);

    public Assets(){
        assetManager = new AssetManager();
        PLAYBTN = new AssetDescriptor<Texture>("/Users/missionbit/AndroidStudioProjects/DeepSpace/android/assets/playbtn.png", Texture.class);
        TITLE  = new AssetDescriptor<Texture>("/Users/missionbit/AndroidStudioProjects/DeepSpace/android/assets/title.png", Texture.class);
    }





    public void load()
    {
        assetManager.load(PLAYBTN);
        assetManager.load(TITLE);
//        assetManager.load(LOGO);
//        assetManager.load(STARS);
        assetManager.load(MUSIC);
    }

    public void dispose(){
        assetManager.dispose();
    }

}
