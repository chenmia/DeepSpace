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
    private Vector3 position;
    private int spawnNum;
    private float[] positionx = {2, 1.42f, 1.41f, 0,  -1.44f, -1.27f, -2};
    private float[] positiony = {0, -1.398f, 1.418f, 2, 1.388f, -1.545f, 0};

    public Planet(float d, int r) {
        spawnNum = (int)(Math.random()*positionx.length);
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
        modelInstance = new ModelInstance(planet, positionx[spawnNum], positiony[spawnNum], -20);
        position = modelInstance.transform.getTranslation(new Vector3());

    }

    public void handleInput() {

    }

    public void update() {
        position = modelInstance.transform.getTranslation(new Vector3());
        modelInstance.transform.rotate( Vector3.Z, 180);
        modelInstance.transform.translate( 0, 0, (float)(Math.random()*0.3));

    }

    public void resetXY(){
        spawnNum = (int)(Math.random()*positionx.length);
        modelInstance.transform.setToTranslation(positionx[spawnNum], positiony[spawnNum], -50);
    }
    public float getZ(){
        return position.z;
    }

    public void dispose() {
        planet.dispose();
    }


}
//
//
