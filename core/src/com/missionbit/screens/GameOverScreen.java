package com.missionbit.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.deepspace.DeepSpace;
import com.missionbit.sprites.Assets;


public class GameOverScreen implements Screen {
    private final DeepSpace game;
    private Assets assets;
    private Texture gameOver;
    private Texture tryagain;
    //private OrthographicCamera textureCam;
    private SpriteBatch batch;
    private BitmapFont points;

    public GameOverScreen(final DeepSpace game, Assets gameAssets) {
        this.game = game;
        assets = gameAssets;
        gameOver = assets.manager.get(Assets.gameover);
        tryagain = assets.manager.get(Assets.tryagain);
        batch = new SpriteBatch();
        points = new BitmapFont();
        points.setColor(Color.GREEN);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        handleInput();
//        batch.setProjectionMatrix(textureCam.combined);
        game.getStars().render();
        batch.begin();
        batch.draw(gameOver, 60, 550);
        points.setColor(Color.RED);
        points.getData().setScale(3, 3);
        points.draw(batch, "FINAL SCORE: " + String.valueOf(PlayScreen.getPoints()), 70, 380);
        batch.draw(tryagain, 52, 100);
        batch.end();



    }
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            game.setScreen(new PlayScreen(game, assets));
            //            this.dispose(); this makes the text not show after you call gameover a second time

        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        gameOver.dispose();
        tryagain.dispose();
    }
}
