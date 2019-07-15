package com.missionbit.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Stars {

     private SpriteBatch batch;
     private Animation<TextureRegion> animation;
     private float elapsed;

    public Stars() {
        batch = new SpriteBatch();
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("starfield.gif").read());
    }

    public void render(){
        elapsed += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(animation.getKeyFrame(elapsed), 0f, 0f);
        batch.end();

    }
}
