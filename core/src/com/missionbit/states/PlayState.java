package com.missionbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;;
import com.badlogic.gdx.math.Vector3;
import com.missionbit.sprites.Planets;

public class PlayState extends State implements InputProcessor {
    private ModelBatch modelBatch;
    private Planets planet;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        planet = new Planets();
        camera = new PerspectiveCamera(75, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 0f, 3f);
        camera.lookAt(0f, 0f, 0f);
        camera.near = 0.1f;
        camera.far = 300f;
        modelBatch = new ModelBatch();
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
       sb.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);

        camera.update();
        modelBatch.begin(camera);
        modelBatch.render(planet.getModelInstance(),planet.getEnvironment());
        modelBatch.end();
    }

    @Override
    public void dispose() {
        planet.dispose();
        modelBatch.dispose();
    }

    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT)
            camera.rotateAround(new Vector3(0f, 0f, 0f), new Vector3(0f, 1f, 0f), 20f);
        if(keycode == Input.Keys.RIGHT)
            camera.rotateAround(new Vector3(0f, 0f, 0f), new Vector3(0f, 1f, 0f), -20f);
        return true;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }
}

