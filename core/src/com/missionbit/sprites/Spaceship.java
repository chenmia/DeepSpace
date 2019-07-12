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

public class Spaceship {
    public ModelInstance ship;
    public Model model;
    public Environment environment;

    public Spaceship() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        ModelLoader loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("ship/ship.obj"));
        ship = new ModelInstance(model);
    }

    public ModelInstance getModelInstance(){
        return ship;
    }

    public Environment getEnvironment(){
        return environment;
    }
    public void dispose() {

    }
}
