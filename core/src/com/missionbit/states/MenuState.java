package com.missionbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State {
    private Texture playBtn;
    private Texture title;
    private Texture background;
    private Texture logo;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        playBtn = new Texture("playbtn.png");
        title = new Texture("title.png");
        background = new Texture("background.png");
        logo = new Texture("logo.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb){
        //sb.setProjectionMatrix(camera.combined); //this makes textures not visible not sure why
        sb.begin();
        sb.draw(background, 0 ,0);
        sb.draw(title, 120, 600);
        sb.draw(playBtn, 45, 100);
        sb.draw(logo, 100, 250);
        sb.end();
    }

    @Override
    public void dispose() {
        playBtn.dispose();
        title.dispose();
        background.dispose();
        logo.dispose();
        System.out.println("Menu State Disposed");
    }
}
