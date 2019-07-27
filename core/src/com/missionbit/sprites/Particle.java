package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector3;

public class Particle extends Floater{
    private Model particle;
    private Vector3 position;
    private Vector3 spawnPos;
    private float direction;
    private float radius = 2;

    public Particle(Vector3 pos, Color color, float dir){
        modelBuilder = new ModelBuilder();
        particle = modelBuilder.createSphere((float)0.05, (float)0.05, (float)0.05,
                10, 10, new Material(ColorAttribute.createDiffuse(color)),
                VertexAttributes.Usage.Position| VertexAttributes.Usage.Normal);
        modelInstance = new ModelInstance(particle, pos.x, pos.y - (float)0.2, pos.z + 1);

        direction = dir;
        position = new Vector3();
        spawnPos = new Vector3();
    }

    public void update(){
        modelInstance.transform.translate(0, 0, direction);
        modelInstance.transform.getTranslation(position);
    }

    public float getZ(){
        return position.z;
    }

    public void setPosition(float angle, Vector3 pos){
        float random = (float)(Math.random() * 0.3 - 0.15);
        spawnPos.x = radius * (float)Math.cos(angle + random);
        spawnPos.y = radius * (float)Math.sin(angle + random);
        spawnPos.z = pos.z + (float)1.5;

        modelInstance.transform.setToTranslation(spawnPos);
    }
}