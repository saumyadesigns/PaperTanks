//package com.mygdx.tanksv2.Screens;
package com.papertanks.desktop.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
//import com.mygdx.tanksv2.Scenes.HUD;
//import com.mygdx.tanksv2.Sprites.Tank1;
//import com.mygdx.tanksv2.Sprites.Weapons.Bullet;
//import com.mygdx.tanksv2.Sprites.Weapons.BulletDef;
//import com.mygdx.tanksv2.Tools.WorldContactListener;
//import com.mygdx.tanksv2.Tools.b2WorldCreator;
//import com.mygdx.tanksv2.papertanks;
import com.papertanks.desktop.Scenes.HUD;
import com.papertanks.desktop.Sprites.Tank1;
import com.papertanks.desktop.Sprites.Weapons.Bullet;
import com.papertanks.desktop.Sprites.Weapons.BulletDef;
import com.papertanks.desktop.Tools.WorldContactListener;
import com.papertanks.desktop.Tools.b2WorldCreator;
//import com.papertanks.desktop.WorldContactListener;
import com.papertanks.desktop.papertanks2;

import java.util.PriorityQueue;

public class playScreen implements Screen {
    private papertanks2 game;
    private TextureAtlas atlas;
//    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private HUD hud;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private World world;
    private Box2DDebugRenderer b2dr;
    private Tank1 player1;
    private int Tank1Fuel=0;

    private Array<Bullet> bullets;
    private PriorityQueue<BulletDef> bulletsToSpawn;


    public  playScreen(papertanks2 game){
        atlas=new TextureAtlas("tankTanks.atlas");
        this.game=game;
//        texture=new Texture("badlogic.jpg");
        gamecam=new OrthographicCamera();
        gamePort=new FitViewport(papertanks2.V_WIDTH,papertanks2.V_HEIGHT,gamecam);
        hud=new HUD(game.batch);
        mapLoader=new TmxMapLoader();
        map=mapLoader.load("map.tmx");
        renderer=new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);

        world=new World(new Vector2(0,-600), true);
        b2dr =new Box2DDebugRenderer();
        new b2WorldCreator(world,map);
        player1= new Tank1(world, this);

        world.setContactListener(new WorldContactListener());

        bullets=new Array<Bullet>();
        bulletsToSpawn=new PriorityQueue<BulletDef>();

    }

    public void spawnBullet(BulletDef idef){
        bulletsToSpawn.add(idef);

    }
    public void handleSpawningBullets(){
        if(!bulletsToSpawn.isEmpty()){
            BulletDef idef=bulletsToSpawn.poll();
            if (idef.type==BulletDef.class){
                bullets.add(new Bullet(this, idef.position.x, idef.position.y) {
                    @Override
                    public void defineMissile() {

                    }

                    @Override
                    public void use() {

                    }
                });
            }
        }
    }
    public TextureAtlas getAtlas(){
        return atlas;
    }
    @Override
    public void show() {

    }
    public void handleInput(float dt){
        if(Tank1Fuel>=40){
            return;
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            player1.b2bod1.applyLinearImpulse(new Vector2(0,0f),player1.b2bod1.getWorldCenter(),true);
            Tank1Fuel++;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.D)&&player1.b2bod1.getLinearVelocity().x<=80&&player1.b2bod1.getLinearVelocity().y<=20){
            player1.b2bod1.applyLinearImpulse(new Vector2(80f,0),player1.b2bod1.getWorldCenter(),true);
            Tank1Fuel++;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.A)&&player1.b2bod1.getLinearVelocity().x>=-80&&player1.b2bod1.getLinearVelocity().y<=20){
            player1.b2bod1.applyLinearImpulse(new Vector2(-80f,0),player1.b2bod1.getWorldCenter(),true);
            Tank1Fuel++;
        }
    }
    public void update(float dt){
        handleInput(dt);
        handleSpawningBullets();
        world.step(1/60f,6,2);

        player1.update(dt);

        for(Bullet bullet:bullets){
            bullet.update(dt);}

        gamecam.position.x=player1.b2bod1.getPosition().x;
        gamecam.update();
        renderer.setView(gamecam);
    }
    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
//        b2dr.render(world,gamecam.combined);
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player1.draw(game.batch);
        for(Bullet bullet:bullets){
            bullet.draw(game.batch);
        }
        game.batch.end();
//        game.batch.setProjectionMatrix(HUD.stage.getCamera().combined);
//        HUD.stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
    }
    public World getWorld(){
        return world;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();
    }
}