package com.missionbit.sprites;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;

public class Spaceship extends Floater {
    private Model ship;
    private boolean movingLeft;
    private boolean movingRight;

    public Spaceship(int x, int y, int z) {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        ModelLoader loader = new ObjLoader();
        ship = loader.loadModel(Gdx.files.internal("ship/ship.obj"));
        modelInstance = new ModelInstance(ship);
        //modelInstance.transform.rotate(180, 0);
        position = new Vector3(x, y, z);

        movingLeft = false;
        movingRight = false;
    }


    public void dispose() {

    }

    public Vector3 getPosition(){
        return position;
    }
    public void toggleMovingLeft(){
        movingLeft = !movingLeft;
    }

    public void toggleMovingRight(){
        movingRight = !movingRight;
    }
    public void moveLeft(){
        position.x -= 0.01;
        modelInstance.transform.translate(position);
    }
    public void moveRight(){
        position.x += 0.01;
        modelInstance.transform.translate(position);
    }
}
