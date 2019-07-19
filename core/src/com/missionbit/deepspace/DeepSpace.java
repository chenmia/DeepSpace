package com.missionbit.deepspace;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.states.GameStateManager;
import com.missionbit.states.LoadingState;
import com.missionbit.states.MenuState;


public class DeepSpace extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Deep Space";
	private GameStateManager gsm;
	private SpriteBatch batch;
	private Music deepmusic;


	@Override
	public void create () {
		batch = new SpriteBatch();
		deepmusic = Gdx.audio.newMusic(Gdx.files.internal("deepmusic.mp3"));
		deepmusic.setLooping(true);
		deepmusic.setVolume(0.5f);
		deepmusic.play();
		gsm = new GameStateManager();
		gsm.push(new LoadingState(gsm));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}

}
