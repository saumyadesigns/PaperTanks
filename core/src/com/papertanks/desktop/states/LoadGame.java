package com.papertanks.desktop.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.papertanks.desktop.PaperTanks;

import java.awt.*;

public class LoadGame extends State {
    private Texture background;
    private Texture load_select;
    private Rectangle load1;
    private Rectangle load2;
    private Rectangle load3;

    protected LoadGame(GameStateManager gsm) {
        super(gsm);
        background = new Texture("paperTanks_assets/loadGame.png");
        load_select = new Texture("paperTanks_assets/ui_saves.png");
        load1 = new Rectangle(99, 310, 347, load_select.getHeight());
        load2 = new Rectangle(471, 310, 347, load_select.getHeight());
        load3 = new Rectangle(836, 310, 347, load_select.getHeight());
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            if (load1.contains(Gdx.input.getX(), PaperTanks.HEIGHT - Gdx.input.getY())) {
                gsm.select.play(0.1f);
                gsm.set(new Loading(gsm));
            } else if (load2.contains(Gdx.input.getX(), PaperTanks.HEIGHT - Gdx.input.getY())) {
                gsm.select.play(0.1f);
                gsm.set(new Loading(gsm));
            } else if (load3.contains(Gdx.input.getX(), PaperTanks.HEIGHT - Gdx.input.getY())) {
                gsm.select.play(0.1f);
                gsm.set(new Loading(gsm));
            }
        }
    }

    @Override
    protected void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb, float dt) {
        sb.begin();
        sb.draw(background, 0, 0, PaperTanks.WIDTH, PaperTanks.HEIGHT);
        sb.draw(load_select,0,310,load_select.getWidth(),load_select.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        gsm.select.dispose();
    }
}
