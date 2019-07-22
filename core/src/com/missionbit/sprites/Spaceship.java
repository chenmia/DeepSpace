package com.missionbit.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.math.Vector3;

public class Spaceship extends Floater {
    private Model ship;
    private int health;
    private float radians = 270;
    private float radius = 2;
    private double rotationAngle;

    public Spaceship(int x, int y, int z) {
        ModelLoader loader = new ObjLoader();
        ship = loader.loadModel(Gdx.files.internal("ship/ship.obj"));
        modelInstance = new ModelInstance(ship);
        position = new Vector3(x, y, z);
        modelInstance.transform.setToRotation(Vector3.Y, 180);
        modelInstance.transform.translate(position);
    }


    public void dispose() {

    }

    public Vector3 getPosition(){
        return position;
    }

    public void moveLeft(){
        radians -= 0.1;
    }
    public void moveRight(){
        radians += 0.1;
    }

    public void setHealth(int inHealth){
        health = inHealth;
    }

    public void update(){
        position.x = radius * (float)Math.cos(radians);
        position.y = radius * (float)Math.sin(radians);
        rotationAngle = Math.atan2(position.x, position.y);

        modelInstance.transform.setToTranslation(position);
        modelInstance.transform.rotate(Vector3.X, 20);
        modelInstance.transform.rotate(Vector3.Y, 180);
        modelInstance.transform.rotate(Vector3.Z, (float)(rotationAngle*180/Math.PI) + 180);
    }
}