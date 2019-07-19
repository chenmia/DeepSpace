package com.missionbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.sprites.Stars;

public class MenuState extends State {
    private Texture playBtn;
    private Texture title;
   // private Texture background;
    private Texture logo;
    private Stars starfield;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        playBtn = new Texture("playbtn.png");
        title = new Texture("title.png");
       // background = new Texture("background.png");
        logo = new Texture("logo.png");
        starfield = new Stars();

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
//            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb){
        //sb.setProjectionMatrix(camera.combined); //this makes textures not visible not sure why
        starfield.render();
        sb.begin();
        //sb.draw(background, 0 ,0);
        sb.draw(title, 75, 600);
        sb.draw(playBtn, 25, 100);
        sb.draw(logo, 100, 250);
        sb.end();
    }

    @Override
    public void dispose() {
        playBtn.dispose();
        title.dispose();
        logo.dispose();
        System.out.println("Menu State Disposed");
    }
}
