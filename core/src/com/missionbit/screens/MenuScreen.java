package com.missionbit.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.missionbit.deepspace.DeepSpace;
import com.missionbit.sprites.Assets;
import com.missionbit.sprites.Stars;

public class MenuScreen implements Screen {
    private Assets assets;
    private final DeepSpace game;
    private Texture playBtn;
    private Texture title;

    public MenuScreen(final DeepSpace game, Assets gameAssets) {
        this.game = game;
        assets = gameAssets;
        playBtn = assets.manager.get(Assets.playbtn);
        title = assets.manager.get(Assets.title);
    }

    @Override
    public void show() {

    }

    public void handleInput() {
        if(Gdx.input.justTouched()) {
            game.setScreen(new PlayScreen(game));
            this.dispose();
        }
    }

    @Override
    public void render(float delta) {
        handleInput();
//        game.batch.setProjectionMatrix(camera.combined); for some reason this doesn't work
        game.batch.begin();
        game.batch.draw(playBtn, 25, 100);
        game.batch.draw(title, 75, 600);
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
        title.dispose();
        System.out.println("Menu Screen Disposed");
    }
}