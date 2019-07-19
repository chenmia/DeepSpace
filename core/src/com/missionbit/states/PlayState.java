package com.missionbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.utils.Array;
import com.missionbit.sprites.Photon;
import com.missionbit.sprites.Planet;
import com.missionbit.sprites.Spaceship;
import com.missionbit.sprites.Stars;

import java.util.ArrayList;

public class PlayState extends State implements InputProcessor {
    private ModelBatch modelBatch;
    private ArrayList<Planet> planet;
    private Spaceship ship;
    private ArrayList<Photon> photons;
    private Array<ModelInstance> instances = new Array<ModelInstance>();
    private Stars starfield;
    private int shipState = 1;
    private int PLANET_COUNT = 4;
    private Environment environment;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        starfield = new Stars();
        planet = new ArrayList<Planet>();
        for(int j = 0; j <PLANET_COUNT; j++) {
            planet.add(new Planet((float)(Math.random() * 4.01) - 2, (float)(Math.random() * 6.01) - 3, (float)(Math.random() * 4.01) - 2, (float)(Math.random() * 1.01), (int)(Math.random() * 8)));
            instances.add(planet.get(j).getModelInstance());
        }

        ship = new Spaceship(0, -1, 0);
        photons = new ArrayList<Photon>();
        for(int i = 0; i<10; i++){
            photons.add(new Photon());
            instances.add(photons.get(i).getModelInstance());
        }

        camera = new PerspectiveCamera(75, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera.position.set(0f, 0f, 6f);
        camera.lookAt(0f, 0f, 0f);
        camera.near = 0.1f;
        camera.far = 300f;
        modelBatch = new ModelBatch();

        for(int k = 0; PLANET_COUNT<4; k++)
        instances.add(planet.get(k).getModelInstance());
        instances.add(ship.getModelInstance());

        Gdx.input.setInputProcessor(this);

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.8f, 0.8f, 0.8f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
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
        ship.update();

        for(int l = 0; l < PLANET_COUNT; l++)
        planet.get(l).update();
        //PLANET_COUNT = 0;
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);
        starfield.render();
        camera.update();
        modelBatch.begin(camera);
        modelBatch.render(instances, environment);
        modelBatch.end();
    }

    @Override
    public void dispose() {

        for(int j = 0; j<PLANET_COUNT; j++){
            planet.get(j).dispose();
        }
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