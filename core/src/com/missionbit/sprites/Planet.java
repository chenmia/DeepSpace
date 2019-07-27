package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.collision.btSphereShape;
import com.missionbit.screens.MenuScreen;
import com.missionbit.screens.PlayScreen;

public class Planet extends Floater{
    private Model planet;
    private Color color;
    private Vector3 position;
    private int spawnNum;
//    private boolean increased;
    private float[] positionx = {2, 1.42f, 1.41f, 0,  -1.44f, -1.27f, -2};
    private float[] positiony = {0, -1.398f, 1.418f, 2, 1.388f, -1.545f, 0};
    private float randomizeSpeed;
    btCollisionObject planetObject;
    btCollisionShape planetShape;

    public Planet(float d, int r) {
//        increased = false;
        spawnNum = (int)(Math.random()*positionx.length);
        randomizeSpeed = 0.4f;
        modelBuilder = new ModelBuilder();

        if(r == 0)
            color = Color.BLUE;
        else if(r==1)
            color = Color.RED;
        else if(r==2)
            color = Color.YELLOW;
        else if(r==3)
            color = Color.ORANGE;
        else if(r==4)
            color = Color.PINK;
        else if(r==5)
            color = Color.PURPLE;
        else if(r==6)
            color = Color.GREEN;
        else if(r==7)
            color = Color.GRAY;

        planet = modelBuilder.createSphere(d, d, d, 100, 100,
                new Material(ColorAttribute.createDiffuse(color)),
                VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal);
        modelInstance = new ModelInstance(planet, positionx[spawnNum], positiony[spawnNum], -20);
        position = modelInstance.transform.getTranslation(new Vector3());
        planetShape = new btSphereShape(d/2f);
        planetObject = new btCollisionObject();
        planetObject.setCollisionShape(planetShape);
        planetObject.setWorldTransform(modelInstance.transform);

    }
//    public boolean getIfIncreased(){
//        return increased;
//    }
    public void handleInput() {

    }

    public void update() {
        position = modelInstance.transform.getTranslation(new Vector3());
        modelInstance.transform.rotate( Vector3.Z, 180);
        modelInstance.transform.translate( 0, 0, (float)(Math.random()*randomizeSpeed));
        planetObject.setWorldTransform(modelInstance.transform);

    }

    public void resetXY(){
        spawnNum = (int)(Math.random()*positionx.length);
        modelInstance.transform.setToTranslation(positionx[spawnNum], positiony[spawnNum], -65);
    }
    public void increaseRandomizeSpeed(){
        randomizeSpeed+=0.2f;
        PlayScreen.setHasSpeedIncreased(true);
    }



    public float getZ(){
        return position.z;
    }

    public void dispose() {
        planet.dispose();
    }

    public void changeColor(int c){

        if(c == 0)
            color = Color.BLUE;
        else if(c==1)
            color = Color.RED;
        else if(c==2)
            color = Color.YELLOW;
        else if(c==3)
            color = Color.ORANGE;
        else if(c==4)
            color = Color.PINK;
        else if(c==5)
            color = Color.PURPLE;
        else if(c==6)
            color = Color.GREEN;
        else if(c==7)
            color = Color.GRAY;

        modelInstance.materials.get(0).set(ColorAttribute.createDiffuse(color));

    }

    public btCollisionObject getObject(){
        return planetObject;
    }

}
//
//
