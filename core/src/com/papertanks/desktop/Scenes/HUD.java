//package com.mygdx.tanksv2.Scenes;
package com.papertanks.desktop.Scenes;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
//import com.mygdx.tanksv2.papertanks;
import com.papertanks.desktop.papertanks2;

import java.awt.*;

public class HUD implements Disposable {
    public static Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label tankLabel;

    public HUD (SpriteBatch sb){
        worldTimer=300;
        timeCount=0;
        score=0;

        viewport=new FitViewport(papertanks2.V_WIDTH, papertanks2.V_HEIGHT,new OrthographicCamera());
        stage= new Stage(viewport,sb);

        Table table=new Table();
        table.top();
        table.setFillParent(true);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        countdownLabel =new Label(String.format("%03d",worldTimer),font);
        scoreLabel =new Label(String.format("%06d",score),font);
        timeLabel =new Label("TIME",font);
        levelLabel =new Label("1-1",font);
        worldLabel =new Label("WORLD",font);
        tankLabel =new Label("PAPERTANKS V2",font);

        table.add(tankLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);


    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
