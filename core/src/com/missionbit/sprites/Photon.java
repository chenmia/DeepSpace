package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class Photon extends Floater{
    private Model photon;
    public Photon() {
        modelBuilder = new ModelBuilder();
        photon = modelBuilder.createBox(0.1f, 0.1f, 0.1f,
                new Material(ColorAttribute.createDiffuse(Color.GOLD)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        modelInstance = new ModelInstance(photon, 0,1, -5);
    }

    public void handleInput() {

    }

    public void update(float dt) {

    }


    public void dispose() {
        photon.dispose();
    }

}
