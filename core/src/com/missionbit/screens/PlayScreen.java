package com.missionbit.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.CollisionObjectWrapper;
import com.badlogic.gdx.physics.bullet.collision.btBoxBoxCollisionAlgorithm;
import com.badlogic.gdx.physics.bullet.collision.btCollisionAlgorithm;
import com.badlogic.gdx.physics.bullet.collision.btCollisionAlgorithmConstructionInfo;
import com.badlogic.gdx.physics.bullet.collision.btCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btCollisionDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.collision.btDefaultCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btDispatcherInfo;
import com.badlogic.gdx.physics.bullet.collision.btManifoldResult;
import com.badlogic.gdx.physics.bullet.collision.btSphereBoxCollisionAlgorithm;
import com.badlogic.gdx.utils.Array;
import com.missionbit.deepspace.DeepSpace;
import com.missionbit.sprites.Assets;
import com.missionbit.sprites.Particle;
import com.missionbit.sprites.Photon;
import com.missionbit.sprites.Planet;
import com.missionbit.sprites.Spaceship;
import com.badlogic.gdx.physics.bullet.Bullet;

import java.util.ArrayList;

public class PlayScreen implements Screen, InputProcessor {
    private final DeepSpace game;
    private ModelBatch modelBatch;
    private ArrayList<Planet> planet;
    private Spaceship ship;
    private ArrayList<Photon> photons;
    private ArrayList<Particle> shipParticles;
    private final int numShipParticles = 10;
    private Array<ModelInstance> instances = new Array<ModelInstance>();
    private int shipState = 1;
    private int PLANET_COUNT = 4;
    private Environment environment;
    private PerspectiveCamera camera;
    private btCollisionShape ballshape;
    private btCollisionConfiguration collisionConfig;
    private btDispatcher dispatcher;
    private Assets assets;
    private float time = 0;
    private int pointCounter;
    private static boolean hasSpeedIncreased;
    private BitmapFont points;
    private SpriteBatch batch;
    private OrthographicCamera fontCam;
    private ArrayList<Float> positionx = new ArrayList<Float>(Arrays.asList(2f, 1.42f, 0f,  -1.44f, -1.27f, -2f));
    private ArrayList<Float> positiony = new ArrayList<Float>(Arrays.asList(-1.398f, 1.418f, 2f, 1.388f, -1.545f, 0f));
    private ArrayList<Float> tempx = new ArrayList<Float>(Arrays.asList(2f, 1.42f, 0f,  -1.44f, -1.27f, -2f));
    private ArrayList<Float> tempy = new ArrayList<Float>(Arrays.asList(-1.398f, 1.418f, 2f, 1.388f, -1.545f, 0f));

    public PlayScreen(final DeepSpace game, Assets gameAssets) {
        Bullet.init();
        collisionConfig = new btDefaultCollisionConfiguration();
        dispatcher = new btCollisionDispatcher(collisionConfig);
        this.game = game;
        hasSpeedIncreased = false;
        assets = gameAssets;
        pointCounter = 0;
        points = new BitmapFont();
        points.setColor(Color.GREEN);
        planet = new ArrayList<Planet>();
        for (int j = 0; j < PLANET_COUNT; j++) {
            //float planetAngle = (float)(Math.random()*360);
            int spawnNum = (int)(Math.random()*positionx.size());
            planet.add(new Planet((float) (Math.random() * 1.01) + 1, (int) (Math.random() * 8), positionx.get(spawnNum), positiony.get(spawnNum)));
            instances.add(planet.get(j).getModelInstance());
            positionx.remove(spawnNum);
            positiony.remove(spawnNum);
        }
        ship = new Spaceship(0, -1, 0);
        photons = new ArrayList<Photon>();
        for (int i = 0; i < 4; i++) {
            photons.add(new Photon(((float) (Math.random() * 4 - 2)), (float) (Math.random() * 4 - 2)));
            instances.add(photons.get(i).getModelInstance());
        }
        shipParticles = new ArrayList<Particle>();
        camera = new PerspectiveCamera(75, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera.position.set(0f, 0f, 6f);
        camera.lookAt(0f, 0f, 0f);
        camera.near = 0.1f;
        camera.far = 300f;
        modelBatch = new ModelBatch();

        for (int k = 0; k < PLANET_COUNT; k++)
            instances.add(planet.get(k).getModelInstance());

        instances.add(ship.getModelInstance());

        Gdx.input.setInputProcessor(this);

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.8f, 0.8f, 0.8f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        batch = new SpriteBatch();
        fontCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        fontCam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        addValues();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);

        Gdx.gl.glClear(GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.getStars().render();
        modelBatch.begin(camera);
        modelBatch.render(instances, environment);
        modelBatch.end();
        game.batch.end();

        batch.setProjectionMatrix(fontCam.combined);
        batch.begin();
        points.setColor(Color.GREEN);
        points.draw(batch, "Photons collected: " + String.valueOf(pointCounter), 75, 380);
        batch.end();


        if (shipState == 0)
            ship.moveLeft();
        else if (shipState == 2)
            ship.moveRight();
        ship.update();

        time += delta;
        if (shipParticles.size() < 10 && time >= 1) {
            time = 0;
            shipParticles.add(new Particle(ship.getPosition(), Color.YELLOW, (float) 0.15));
            instances.add(shipParticles.get(shipParticles.size() - 1).getModelInstance());
        }
        for (int i = 0; i < shipParticles.size(); i++) {
            shipParticles.get(i).update();
            if (shipParticles.get(i).getZ() > 4) {
                shipParticles.get(i).setPosition(ship.getAngle(), ship.getPosition());
            }
        }

        if (!hasSpeedIncreased && pointCounter != 0 && pointCounter % 3 == 0) {
            for (int l = 0; l < PLANET_COUNT; l++)
                planet.get(l).increaseRandomizeSpeed();
        }

    for (int l = 0; l < PLANET_COUNT; l++) {
        planet.get(l).update();
        if (planet.get(l).getZ() > 4) {
            planet.get(l).changeColor((int) (Math.random() * 8));
            int anotherSpawn = (int)(Math.random()*positionx.size());
            planet.get(l).resetXY(positionx.get(anotherSpawn), positiony.get(anotherSpawn));
            positionx.remove(anotherSpawn);
            positiony.remove(anotherSpawn);
            System.out.println(planet.get(l).getPosX());
            System.out.println(planet.get(l).getPosY());
        }
        if(checkPlanetCollision(l)){
            game.setScreen(new GameOverScreen(game, assets));
            this.dispose();
        }
    }
     addValues();
        for (int i = 0; i < 4; i++) {
            photons.get(i).update();

            if (photons.get(i).getZ() > 5) {
                photons.get(i).resetXY();
            }
            if (checkPhotonCollision(i) && !photons.get(i).getHitYet()) {
                photons.get(i).setHitYet(true);
                photons.get(i).resetXY();
                pointCounter++;
                hasSpeedIncreased = false;
                System.out.println("Points:" + pointCounter);
            }
        }


    }
    public static void setHasSpeedIncreased ( boolean boo){
        hasSpeedIncreased = boo;
    }
    @Override
    public void resize ( int width, int height){

    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void hide () {

    }

    @Override
    public void dispose () {
        for (int j = 0; j < PLANET_COUNT; j++) {
            planet.get(j).dispose();
        }
        for (int i = 0; i < 4; i++) {
            photons.get(i).dispose();
        }
        modelBatch.dispose();
        System.out.println("Play State Disposed");
    }

    public void addValues(){
        for(int i = 0; i < positionx.size(); i++){
            positionx.remove(i);
        }
        for(int j = 0; j < positiony.size(); j++){
            positiony.remove(j);
        }
        for(int z = 0; z < tempx.size(); z++){
            positionx.add(tempx.get(z));
        }for(int k = 0; k < tempy.size(); k++){
            positiony.add(tempy.get(k));
        }
    }

    public boolean keyDown ( int keycode){
        if (keycode == Input.Keys.LEFT)
            shipState = 0;

        else if (keycode == Input.Keys.RIGHT)
            shipState = 2;
        return true;
    }

    public boolean keyUp ( int keycode){
        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.RIGHT)
            shipState = 1;
        return false;
    }

    public boolean keyTyped ( char character){
        return false;
    }

    public boolean touchDown ( int screenX, int screenY, int pointer, int button){
        return false;
    }

    public boolean touchUp ( int screenX, int screenY, int pointer, int button){
        return false;
    }

    public boolean touchDragged ( int screenX, int screenY, int pointer){
        return false;
    }

    public boolean mouseMoved ( int screenX, int screenY){
        return false;
    }

    public boolean scrolled ( int amount){
        return false;
    }

    private boolean checkPlanetCollision ( int i){
        CollisionObjectWrapper co0 = new CollisionObjectWrapper(planet.get(i).getObject());
        CollisionObjectWrapper co1 = new CollisionObjectWrapper(ship.getObject());

        btCollisionAlgorithmConstructionInfo ci = new btCollisionAlgorithmConstructionInfo();
        ci.setDispatcher1(dispatcher);
        btCollisionAlgorithm algorithm = new btSphereBoxCollisionAlgorithm(null, ci, co0.wrapper, co1.wrapper, false);

        btDispatcherInfo info = new btDispatcherInfo();
        btManifoldResult result = new btManifoldResult(co0.wrapper, co1.wrapper);

        algorithm.processCollision(co0.wrapper, co1.wrapper, info, result);

        boolean r = result.getPersistentManifold().getNumContacts() > 0;

        result.dispose();
        info.dispose();
        algorithm.dispose();
        ci.dispose();
        co1.dispose();
        co0.dispose();

        return r;
    }
    private boolean checkPhotonCollision(int i){
        CollisionObjectWrapper co0 = new CollisionObjectWrapper(photons.get(i).getObject());
        CollisionObjectWrapper co1 = new CollisionObjectWrapper(ship.getObject());

        btCollisionAlgorithmConstructionInfo ci = new btCollisionAlgorithmConstructionInfo();
        ci.setDispatcher1(dispatcher);
        btCollisionAlgorithm algorithm = new btBoxBoxCollisionAlgorithm(null, ci, co0.wrapper, co1.wrapper);

        btDispatcherInfo info = new btDispatcherInfo();
        btManifoldResult result = new btManifoldResult(co0.wrapper, co1.wrapper);

        algorithm.processCollision(co0.wrapper, co1.wrapper, info, result);

        boolean r = result.getPersistentManifold().getNumContacts() > 0;

        result.dispose();
        info.dispose();
        algorithm.dispose();
        ci.dispose();
        co1.dispose();
        co0.dispose();

        return r;
    }
}
