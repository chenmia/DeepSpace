package com.missionbit.deepspace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.screens.LoadingScreen;
import com.missionbit.sprites.Stars;


public class DeepSpace extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Deep Space";
	public SpriteBatch batch;
	private Music deepmusic;
	private Stars starfield;



	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new LoadingScreen(this));
		deepmusic = Gdx.audio.newMusic(Gdx.files.internal("deepmusic.mp3"));
		deepmusic.setLooping(true);
		deepmusic.setVolume(0.5f);
		deepmusic.play();
		starfield = new Stars();


	}

	@Override
	public void render () {
//		starfield.render();
		super.render();

	}

	public Stars getStars(){
		return starfield;
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}

}
