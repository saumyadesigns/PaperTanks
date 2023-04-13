//package com.mygdx.tanksv2.Sprites.Weapons;
package com.papertanks.desktop.Sprites.Weapons;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
//import com.mygdx.tanksv2.Screens.playScreen;
//import com.mygdx.tanksv2.papertanks;
import com.papertanks.desktop.Screens.playScreen;

public class Small extends Sprite {
    playScreen screen;
    World world;
    float stateTime;
    boolean destroyed;
    boolean setToDestroy;
    boolean fireRight;
    private TextureRegion smallMissile;

    Body b2body;
    public Small(playScreen screen, float x, float y, boolean fireRight){
        super(screen.getAtlas().findRegion("Frame 1"));
        this.fireRight=fireRight;
        this.screen=screen;
        this.world=screen.getWorld();
        smallMissile= new TextureRegion(getTexture(),563,46,578,62);
        setBounds(563,46,578,62);
        setRegion(smallMissile);
        defineSmallMissile();



    }
    public void defineSmallMissile(){
        BodyDef bdef=new BodyDef();
        bdef.position.set(fireRight ? getX() + 12 : getX() - 12, getY());
        bdef.type= BodyDef.BodyType.DynamicBody;

        if(!world.isLocked())
            b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(3);
        fdef.shape = shape;
        fdef.restitution = 1;
        fdef.friction = 0;
        b2body.createFixture(fdef).setUserData(this);
        b2body.setLinearVelocity(new Vector2(fireRight ? 2 : -2, 2.5f));
    }

}
