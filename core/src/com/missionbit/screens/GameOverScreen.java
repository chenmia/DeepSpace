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
    private PerspectiveCamera camera;
    private Assets assets;
    private Texture playBtn;
    public GameOverScreen(final DeepSpace game, Assets gameAssets) {
        this.game = game;
        camera = new PerspectiveCamera(75, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera.position.set(0f, 0f, 6f);
        camera.lookAt(0f, 0f, 0f);
        camera.near = 0.1f;
        camera.far = 300f;
        assets = gameAssets;
        playBtn = assets.manager.get(Assets.playbtn);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(playBtn, 25, 100);
        game.batch.end();
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
