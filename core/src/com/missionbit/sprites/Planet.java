package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class Planet extends Floater{
    private Model planet;
    public Planet() {
        modelBuilder = new ModelBuilder();
        planet = modelBuilder.createSphere(0.5f, 0.5f, 0.5f, 100, 100,
                new Material(ColorAttribute.createDiffuse(Color.BLUE)),
                VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal);

        modelInstance = new ModelInstance(planet, 0, 2, 0);


//        Gdx.input.setInputProcessor(this);

    }

    public void handleInput() {

    }

    public void update(float dt) {

    }


    public void dispose() {
        planet.dispose();
    }
}
//
//
