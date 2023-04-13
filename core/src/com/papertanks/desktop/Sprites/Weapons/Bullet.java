//package com.mygdx.tanksv2.Sprites.Weapons;
package com.papertanks.desktop.Sprites.Weapons;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
//import com.mygdx.tanksv2.Screens.playScreen;
import com.papertanks.desktop.Screens.playScreen;

public abstract class Bullet extends Sprite {
    protected playScreen screen;
    protected World world;
    protected Vector2 velocity;
    protected boolean toDestroy;
    protected boolean destroyed;
    protected Body b2body;

    public Bullet(playScreen screen, float x, float y) {
        this.screen = screen;
        this.world = screen.getWorld();
        setPosition(x, y);
        setBounds(getX(), getY(), 16, 16);
        defineMissile();
        toDestroy = false;
        destroyed = false;
    }

    public abstract void defineMissile();
    public abstract void use();
    public void update(float dt) {
        if (toDestroy && !destroyed) {
            world.destroyBody(b2body);
            destroyed = true;
        }
    }
    public void destroy() {
        toDestroy = true;
    }

}
