package com.papertanks.desktop.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.papertanks.desktop.PaperTanks;

public class HomeScreen extends State {
    private Texture background_home;
    private Texture buttons_Home;
    private Rectangle new_Game;
    private Rectangle load_Game;

    public HomeScreen(GameStateManager gsm){
        super(gsm);
        background_home=new Texture("paperTanks_assets/homeScreen.png");
        buttons_Home=new Texture("paperTanks_assets/homeScreen_buttons.png");
        new_Game = new Rectangle(PaperTanks.WIDTH*4/7,PaperTanks.HEIGHT*2/7, buttons_Home.getWidth(), buttons_Home.getHeight()*3/8);
        load_Game = new Rectangle(PaperTanks.WIDTH*4/7,PaperTanks.HEIGHT*2/7, buttons_Home.getWidth(), buttons_Home.getHeight()*3/8);
    }
    @Override
    public void handleInput() {
        if (Gdx.input.justTouched())
        {
            if(new_Game.contains(Gdx.input.getX() , PaperTanks.HEIGHT-Gdx.input.getY()))
            {
                gsm.select.play(0.1f);
                gsm.set(new LoadGame(gsm));
            }
            if(load_Game.contains(Gdx.input.getX() , Gdx.input.getY()))
            {
                gsm.select.play(0.1f);
                gsm.set(new SelectOne(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb ,  float dt) {
        sb.begin();
        sb.draw(background_home,0,0, PaperTanks.WIDTH,PaperTanks.HEIGHT);
        sb.draw(buttons_Home,PaperTanks.WIDTH*4/7,PaperTanks.HEIGHT*2/7, buttons_Home.getWidth(), buttons_Home.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        gsm.select.dispose();

    }
}
