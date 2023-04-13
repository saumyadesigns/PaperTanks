//package com.mygdx.tanksv2.Sprites;
package com.papertanks.desktop.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
//import com.mygdx.tanksv2.papertanks;
import com.papertanks.desktop.papertanks2;

import java.awt.*;

public class Floor extends interactiveTileObject{
    public Floor(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(papertanks2.BULLET_BIT);


    }


    @Override
    public void OnHeadHit() {
        Gdx.app.log("Floor","Collision");
        setCategoryFilter(papertanks2.DESTROYED_BIT);
        getCell().setTile(null);
    }
}
