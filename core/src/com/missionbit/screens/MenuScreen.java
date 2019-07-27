package com.missionbit.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.missionbit.deepspace.DeepSpace;
import com.missionbit.sprites.Assets;
import com.missionbit.sprites.Spaceship;

public class MenuScreen implements Screen {
    private Assets assets;
    private final DeepSpace game;
    private Texture playBtn;
    private Texture title;
    private Spaceship ship;



    public MenuScreen(final DeepSpace game, Assets gameAssets) {
        this.game = game;
        assets = gameAssets;
        playBtn = assets.manager.get(Assets.playbtn);
        title = assets.manager.get(Assets.title);
        ship = new Spaceship(0, -1, 0);
    }

    @Override
    public void show() {

    }

    public void handleInput() {
        if(Gdx.input.justTouched()) {
            game.setScreen(new PlayScreen(game, assets));
            this.dispose();
        }
    }

    @Override
    public void render(float delta) {
        handleInput();


        game.getStars().render();
        game.batch.begin();
        game.batch.draw(playBtn, 25, 100);
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