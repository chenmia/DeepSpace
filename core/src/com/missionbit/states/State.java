package com.missionbit.states;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public abstract class State {
    protected PerspectiveCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new PerspectiveCamera();
        mouse = new Vector3();
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch ab);
    public abstract void dispose();


}