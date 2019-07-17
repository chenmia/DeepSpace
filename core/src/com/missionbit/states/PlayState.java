package com.missionbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.missionbit.sprites.Photon;
import com.missionbit.sprites.Planet;
import com.missionbit.sprites.Spaceship;
import com.missionbit.sprites.Stars;

import java.util.ArrayList;

public class PlayState extends State implements InputProcessor {
    private ModelBatch modelBatch;
    private Planet planet;
    private Spaceship ship;
    private ArrayList<Photon> photons;
    private Array<ModelInstance> instances = new Array<ModelInstance>();
    private Array<Environment> environments = new Array<Environment>();
    private Stars starfield;
    private int shipState = 1;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        starfield = new Stars();
        planet = new Planet();
        ship = new Spaceship(0, 0, 0);
        photons = new ArrayList<Photon>();
        for(int i = 0; i<10; i++){
            photons.add(new Photon());
            instances.add(photons.get(i).getModelInstance());
        }
        camera = new PerspectiveCamera(75, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera.position.set(1f, 2f, 4f);
        camera.lookAt(0f, 0f, 0f);
        camera.near = 0.1f;
        camera.far = 300f;
        modelBatch = new ModelBatch();

        instances.add(planet.getModelInstance());
        instances.add(ship.getModelInstance());
        environments.add(planet.getEnvironment());

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        if(shipState == 0)
            ship.moveLeft();
        else if(shipState == 2)
            ship.moveRight();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);
        starfield.render();
        camera.update();
        modelBatch.begin(camera);
        modelBatch.render(instances, planet.getEnvironment());
        modelBatch.end();
    }

    @Override
    public void dispose() {
        planet.dispose();
        ship.dispose();
        starfield.dispose();
        for(int i = 0; i<10; i++){
            photons.get(i).dispose();
        }
        modelBatch.dispose();
        System.out.println("Play State Disposed");
    }

    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT)
            shipState = 0;

        else if(keycode == Input.Keys.RIGHT)
            shipState = 2;

        return true;
    }

    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.LEFT || keycode == Input.Keys.RIGHT)
            shipState = 1;
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

