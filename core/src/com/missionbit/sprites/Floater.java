package com.missionbit.sprites;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
//import com.badlogic.gdx.math.collision.BoundingBox;

public abstract class Floater {
    protected ModelBuilder modelBuilder;
    protected ModelInstance modelInstance;
    protected Environment environment;
    protected Vector3 position;
//    protected BoundingBox boxBounds;

    public ModelInstance getModelInstance(){
        return modelInstance;
    }
    public Environment getEnvironment(){
        return environment;
    }
//    public BoundingBox getBoxBounds(){
//        return boxBounds;
//    }
}
