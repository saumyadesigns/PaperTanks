package com.papertanks.desktop.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.papertanks.desktop.PaperTanks;

public class SelectTwo extends State{
    private Texture background;
    private float elapsed;
    private Texture tanks;
    private Rectangle tank1;
    private Rectangle tank2;
    private Rectangle tank3;

    public SelectTwo(GameStateManager gsm) {
        super(gsm);
        background=new Texture("paperTanks_assets/select2.png");
        tanks=new Texture("paperTanks_assets/tankSelect_rev.png");
        tank1=new Rectangle(23,175,tanks.getWidth()*2/9,tanks.getHeight()*2/5);
        tank2=new Rectangle(492,175,tanks.getWidth()*2/9,tanks.getHeight()*2/5);
        tank3=new Rectangle(895,175,tanks.getWidth()*2/9,tanks.getHeight()*2/5);
    }

    @Override
    public void handleInput() {
    if(Gdx.input.justTouched()){
        if(tank1.contains(Gdx.input.getX() , PaperTanks.HEIGHT-Gdx.input.getY())){
            gsm.select.play(0.1f);
            gsm.set(new Loading(gsm));
        }
        else if(tank2.contains(Gdx.input.getX() , PaperTanks.HEIGHT-Gdx.input.getY())){
            gsm.select.play(0.1f);
            gsm.set(new Loading(gsm));
        }
        else if(tank3.contains(Gdx.input.getX() , PaperTanks.HEIGHT-Gdx.input.getY())){
            gsm.select.play(0.1f);
            gsm.set(new Loading(gsm));
        }
    }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb, float dt) {
        sb.begin();
        sb.draw(background,0,0,PaperTanks.WIDTH,PaperTanks.HEIGHT);
        sb.draw(tanks,20,0,tanks.getWidth(),tanks.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        gsm.select.dispose();


    }
}
