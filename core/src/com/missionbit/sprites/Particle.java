package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

public class Particle extends Floater{
    private Model particle;
    private float distance;
    private float direction;

    public Particle(Vector3 pos, Color color, float dir){
        modelBuilder = new ModelBuilder();
        particle = modelBuilder.createSphere((float)0.5, (float)0.5, (float)0.5,
                 10, 10, new Material(ColorAttribute.createDiffuse(color)),
                VertexAttributes.Usage.Position| VertexAttributes.Usage.Normal);
        modelInstance = new ModelInstance(particle, pos.x, pos.y, pos.z);

        direction = dir;
    }

    public void update(){
        //modelInstance.transform.translate(0, 0, (float)0.1);
    }
}
