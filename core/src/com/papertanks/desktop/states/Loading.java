package com.papertanks.desktop.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.papertanks.desktop.PaperTanks;

public class Loading extends State{
    private Texture background;
    private float elapsed;
    public Loading(GameStateManager gsm) {
        super(gsm);
        background= new Texture("paperTanks_assets/Loading.png");
    }

    @Override
    public void handleInput() {
        float elapsed=0;

        if (Gdx.input.justTouched()) {
            gsm.select.play(0.1f);
            gsm.set(new HomeScreen(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb , float delta) {
        sb.begin();
        sb.draw(background,0,0, PaperTanks.WIDTH, PaperTanks.HEIGHT);
        sb.end();
        elapsed += delta;
        if (elapsed > 5.0) {
            gsm.set(new HomeScreen(gsm));
            dispose();
        }

    }

    @Override
    public void dispose() {
    background.dispose();
    }

}
