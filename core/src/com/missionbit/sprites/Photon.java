package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btBoxShape;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;

public class Photon extends Floater{
    private Model photon;
    private Vector3 position;
    private int spawnNum;

    private float[] positionx = {2, 1.42f, 1.41f, 0,  -1.44f, -1.27f, -2};
    private float[] positiony = {0, -1.398f, 1.418f, 2, 1.388f, -1.545f, 0};

    private btBoxShape photonShape;
    private btCollisionObject photonObject;

    public Photon(float x, float y) {
        spawnNum = (int)(Math.random() * positionx.length);
        modelBuilder = new ModelBuilder();
        photon = modelBuilder.createBox(0.15f, 0.15f, 0.15f,
                new Material(ColorAttribute.createDiffuse(Color.GOLD)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        modelInstance = new ModelInstance(photon, positionx[spawnNum]*0.75f, positiony[spawnNum]*0.75f, -20);
        position = modelInstance.transform.getTranslation(new Vector3());

        photonShape = new btBoxShape(new Vector3(0.075f,0.075f,0.075f));
        photonObject = new btCollisionObject();
        photonObject.setCollisionShape(photonShape);
        photonObject.setWorldTransform(modelInstance.transform);
    }

    public void handleInput() {

    }

    public void update() {
        position = modelInstance.transform.getTranslation(new Vector3());
        modelInstance.transform.translate( 0, 0, (float)(Math.random()*0.3));
        photonObject.setWorldTransform(modelInstance.transform);

    }

    public void resetXY(){
        spawnNum = (int)(Math.random()*positionx.length);
        modelInstance.transform.setToTranslation(positionx[spawnNum]*0.25f, positiony[spawnNum]*0.25f, -5);
    }
    public float getZ(){
        return position.z;
    }

    public void dispose() {
        photon.dispose();
    }

    public btCollisionObject getObject(){
        return photonObject;
    }

}
