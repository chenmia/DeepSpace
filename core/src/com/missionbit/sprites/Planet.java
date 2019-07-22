package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

public class Planet extends Floater{
    private Model planet;
    private Color color;
    public Planet(float x, float y, float z, float d, int r) {
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
        modelInstance = new ModelInstance(planet, x, y, z);
    }

    public void handleInput() {

    }

    public void update() {
        modelInstance.transform.rotate( Vector3.Z, 180);
        modelInstance.transform.translate( 0, 0, (float) 0.02);
    }


    public void dispose() {
        planet.dispose();
    }
}
//
//
