package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

public class Photon extends Floater{
    private Model photon;
    private Vector3 position;
    public Photon(float x, float y) {
        modelBuilder = new ModelBuilder();
        photon = modelBuilder.createBox(0.1f, 0.1f, 0.1f,
                new Material(ColorAttribute.createDiffuse(Color.GOLD)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        modelInstance = new ModelInstance(photon, x,y, -5);
        position = modelInstance.transform.getTranslation(new Vector3());
    }

    public void handleInput() {

    }

    public void update() {
        position = modelInstance.transform.getTranslation(new Vector3());
        modelInstance.transform.translate( 0, 0, (float) 0.05);

    }

    public void resetXY(){
        modelInstance.transform.translate( (float) (Math.random() * 4 - 2), (float) (Math.random() * 4 - 2), -5);
    }
    public float getZ(){
        return position.z;
    }

    public void dispose() {
        photon.dispose();
    }

}
