package com.missionbit.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.missionbit.deepspace.DeepSpace;

public class Stars {
    private OrthographicCamera starCam;
     private SpriteBatch batch;
     private float elapsed;
     private Animation<TextureRegion> animation =  GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("starfield.gif").read());


    public Stars() {
        batch = new SpriteBatch();
        starCam = new OrthographicCamera();
        starCam.setToOrtho(false, DeepSpace.WIDTH,DeepSpace.HEIGHT);
    }

    public void render(){
        elapsed += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(starCam.combined);
        batch.begin();
        batch.draw(animation.getKeyFrame(elapsed), 0f, 0f);
        batch.end();


    }
    public void dispose(){
        batch.dispose();
    }

}
