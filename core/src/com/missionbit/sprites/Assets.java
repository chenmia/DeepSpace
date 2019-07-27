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
    public static final AssetDescriptor<Texture> gameover = new AssetDescriptor<Texture>("gameover.png", Texture.class);
    public static final AssetDescriptor<Texture> tryagain = new AssetDescriptor<Texture>("tryagain.png", Texture.class);
    public static final AssetDescriptor<Texture> finalscore = new AssetDescriptor<Texture>("finalscore.png", Texture.class);
    public static final AssetDescriptor<Texture> highscore = new AssetDescriptor<Texture>("highscore.png", Texture.class);


    public void load() {

        manager.load(title);
        manager.load(playbtn);
        manager.load(gameover);
        manager.load(tryagain);
        manager.load(finalscore);
        manager.load(highscore);
    }


    public void dispose(){
        manager.dispose();
    }


}
