package com.missionbit.screens;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.missionbit.deepspace.DeepSpace;
import com.missionbit.sprites.Assets;

public class LoadingScreen implements Screen {
    private final DeepSpace game;
    Assets assets;

    public LoadingScreen(final DeepSpace game) {
        this.game = game;
        assets = new Assets();
        assets.load();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        System.out.println(assets.manager.getLoadedAssets());
        if(assets.manager.update()){
            game.setScreen(new MenuScreen(game, assets));
            System.out.println("Loading Screen Disposed");
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

    }
}