//package com.mygdx.tanksv2.Sprites.Weapons;
package com.papertanks.desktop.Sprites.Weapons;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
//import com.mygdx.tanksv2.Screens.playScreen;
import com.papertanks.desktop.Screens.playScreen;

public class smallBullet extends Bullet {

    public smallBullet(playScreen screen, float x, float y) {
        super(screen, x, y);
        setRegion(screen.getAtlas().findRegion("Frame 1"), 563, 46, 578, 62);
        velocity= new Vector2(0, 0);
    }

    @Override
    public void defineMissile() {
        BodyDef bdef=new BodyDef();
        bdef.position.set(getX(), getY());
        bdef.type= BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape= new CircleShape();
        shape.setRadius(6);

        fdef.shape= shape;
        b2body.createFixture(fdef).setUserData(this);
    }

    @Override
    public void use() {
        destroy();
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        b2body.setLinearVelocity(velocity);
    }
}

