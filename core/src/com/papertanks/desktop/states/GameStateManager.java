package com.papertanks.desktop.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    private Stack<State> states;
    public Sound select=Gdx.audio.newSound(Gdx.files.internal("paperTanks_assets/ui_select.mp3"));

    public GameStateManager(){
        states= new Stack<State>();
    }
    public void push(State state){
        states.push(state);
    }
    public void pop(){
        states.pop();
    }
    public void set(State state){
        states.pop();
        states.push(state);
    }
    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb , float dt){
        states.peek().render(sb , dt);
    }
}
