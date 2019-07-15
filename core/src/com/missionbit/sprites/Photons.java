package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class Photons extends Floater{
    private Model photon;
    public Photons() {
        modelBuilder = new ModelBuilder();
        photon = modelBuilder.createSphere(2f, 2f, 2f, 10, 10,
                new Material(ColorAttribute.createDiffuse(Color.YELLOW)),
                VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal);

        modelInstance = new ModelInstance(photon, 0, 2, 0);
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.8f, 0.8f, 0.8f, 1f));
//        Gdx.input.setInputProcessor(this);

    }

    public void handleInput() {

    }

    public void update(float dt) {

    }


    public void dispose() {
        photon.dispose();
    }

}
