package com.missionbit.sprites;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public abstract class Floater {
    protected ModelBuilder modelBuilder;
    protected ModelInstance modelInstance;
    protected Environment environment;


    public ModelInstance getModelInstance(){
        return modelInstance;
    }
    public Environment getEnvironment(){
        return environment;
    }
}