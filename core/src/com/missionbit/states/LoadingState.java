package com.missionbit.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadingState extends State {
    private Assets assets;

    public LoadingState(GameStateManager gsm) {
        super(gsm);
        assets = new Assets();
        assets.load();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {


        handleInput();
    }

    @Override
    public void render(SpriteBatch ab) {
        if(assets.assetManager.update()){
            System.out.println("loaded");
            gsm.set(new MenuState(gsm));
            dispose();
        }
    }

    @Override
    public void dispose() {
        assets.dispose();
    }
}
