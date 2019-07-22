package com.missionbit.sprites;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Assets {
    public AssetManager manager = new AssetManager();

    public static final AssetDescriptor<Texture> title = new AssetDescriptor<Texture>("title.png", Texture.class);
    public static final AssetDescriptor<Texture> playbtn = new AssetDescriptor<Texture>("playbtn.png", Texture.class);


    public void load() {
        manager.load(title);
        manager.load(playbtn);
    }


    public void dispose(){
        manager.dispose();
    }


}
