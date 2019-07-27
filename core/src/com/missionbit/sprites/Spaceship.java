package com.missionbit.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.Bullet;
import com.badlogic.gdx.physics.bullet.collision.btBoxShape;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;

import java.util.ArrayList;

import sun.security.provider.certpath.Vertex;


public class Spaceship extends Floater {
    private Model ship;
    private float angle = 80;
    private float radius = 2;
    private double rotationAngle;
    private double increment;
    btCollisionObject shipObject;
    btCollisionShape shipShape;

    public Spaceship(int x, int y, int z) {
        Bullet.init();
        ModelLoader loader = new ObjLoader();
        ship = loader.loadModel(Gdx.files.internal("ship/ship.obj"));
        modelInstance = new ModelInstance(ship);
        position = new Vector3(x, y, z);
        modelInstance.transform.setToRotation(Vector3.Y, 180);
        modelInstance.transform.translate(position);

        shipShape = new btBoxShape(new Vector3((float)0.6,(float)0.1,(float)0.5));
        shipObject = new btCollisionObject();
        shipObject.setCollisionShape(shipShape);
        shipObject.setWorldTransform(modelInstance.transform);

    }

    public void dispose() {

    }

    public Vector3 getPosition(){
        return position;
    }

    public void setIncrement(double inc){
        increment = inc;
    }
    public double getIncrement(){
        return increment;
    }
    public float getAngle(){
        return angle;
    }
    public void update(){
        angle += increment;
        position.x = radius * (float)Math.cos(angle);
        position.y = radius * (float)Math.sin(angle);
        rotationAngle = Math.atan2(position.x, position.y);

        modelInstance.transform.setToTranslation(position);
        modelInstance.transform.rotate(Vector3.X, 20);
        modelInstance.transform.rotate(Vector3.Y, 180);
        modelInstance.transform.rotate(Vector3.Z, (float)(rotationAngle*180/Math.PI) + 180);
        shipObject.setWorldTransform(modelInstance.transform);

    }

    public btCollisionObject getObject(){
        return shipObject;
    }
}