//package com.mygdx.tanksv2.Sprites;
package com.papertanks.desktop.Sprites;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
//import com.mygdx.tanksv2.Screens.playScreen;
//import com.mygdx.tanksv2.Sprites.Weapons.BulletDef;
//import com.mygdx.tanksv2.Sprites.Weapons.smallBullet;
//import com.mygdx.tanksv2.papertanks;
import com.papertanks.desktop.Screens.playScreen;
import com.papertanks.desktop.papertanks2;

import java.util.zip.CheckedInputStream;

public class Tank1 extends Sprite {
    private playScreen screen;
    public enum State{REVOLVE, MOVE, IDLE};
    public State currentState;
    public State previousState;
    public World world;
    public Body b2bod1;
    private TextureRegion tank1Default;
    private Animation tank1Revolve;
    private Animation tank1Move;
    private float stateTimer;
    private Boolean runningRight;
//    private Animation tank1Idle;
    public Tank1(World world, playScreen screen){
        super(screen.getAtlas().findRegion("Frame 1"));
        this.world=world;
        stateTimer=0;
        runningRight=true;

        defineTank1();
        tank1Default= new TextureRegion(getTexture(),9,9,180,108);
        setBounds(9,9,180,108);
        setRegion(tank1Default);
    }
    public void update(float dt){
        setPosition(b2bod1.getPosition().x-getWidth()/2,b2bod1.getPosition().y-getHeight()/1.3f);
    }
    public void defineTank1(){

        BodyDef bdef1=new BodyDef();
        bdef1.position.set(350,350);
        bdef1.type= BodyDef.BodyType.DynamicBody;
        b2bod1=world.createBody(bdef1);

        FixtureDef fdef1=new FixtureDef();
        CircleShape shape1=new CircleShape();
        shape1.setRadius(70);
        fdef1.filter.categoryBits= papertanks2.TANK1_BIT;
        fdef1.filter.maskBits= papertanks2.BULLET_BIT;
        fdef1.shape=shape1;
        b2bod1.createFixture(fdef1);

        EdgeShape head1=new EdgeShape();
        head1.set(new Vector2(-80,-30),new Vector2(60,-30));
        fdef1.shape=head1;
        fdef1.isSensor=true;

        b2bod1.createFixture(fdef1).setUserData("head1");
    }
//    public void onHeadHit(){
//        screen.spawnBullet(new BulletDef(new Vector2(b2bod1.getPosition().x,b2bod1.getPosition().y+20),smallBullet.class));
//    }
//    public void fire(){
//        BulletDef.add(new FireBall(screen, b2body.getPosition().x, b2body.getPosition().y, runningRight ? true : false));
//    }
}
