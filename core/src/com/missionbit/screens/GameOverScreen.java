package com.missionbit.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.deepspace.DeepSpace;
import com.missionbit.sprites.Assets;


public class GameOverScreen implements Screen {
    private final DeepSpace game;
    private Assets assets;
    private Texture playBtn;
    public GameOverScreen(final DeepSpace game, Assets gameAssets) {
        this.game = game;
        assets = gameAssets;
        playBtn = assets.manager.get(Assets.playbtn);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        handleInput();
        game.getStars().render();
        game.batch.begin();
        game.batch.draw(playBtn, 400, 400);
        game.batch.end();
    }
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            game.setScreen(new PlayScreen(game, assets));
            this.dispose();
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
        playBtn.dispose();

    }
}
