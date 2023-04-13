//package com.mygdx.tanksv2.Sprites;

package com.papertanks.desktop.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
//import com.mygdx.tanksv2.Screens.playScreen;
import com.papertanks.desktop.Screens.playScreen;

//import java.awt.*;

public abstract class interactiveTileObject {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;
    protected Fixture fixture;
    protected playScreen screen;

    public interactiveTileObject(World world, TiledMap map, Rectangle bounds){
        this.world=world;
        this.screen=screen;
        this.map=map;
        this.bounds=bounds;

        BodyDef bdef=new BodyDef();
        FixtureDef fdef=new FixtureDef();
        PolygonShape shape=new PolygonShape();

        bdef.type= BodyDef.BodyType.StaticBody;
        bdef.position.set((float)(bounds.getX()+bounds.getWidth()/2),(float)(bounds.getY()+bounds.getHeight()/2));

        body=world.createBody(bdef);

        shape.setAsBox((float) bounds.getWidth()/2,(float) bounds.getHeight()/2);

        fdef.shape=shape;
        fixture=body.createFixture(fdef);

    }
    public abstract void OnHeadHit();
    public void setCategoryFilter(short filterBit){
        Filter filter=new Filter();
        filter.categoryBits=filterBit;
        fixture.setFilterData(filter);
    }
    public TiledMapTileLayer.Cell getCell(){
        TiledMapTileLayer layer=(TiledMapTileLayer) map.getLayers().get(1);
        return layer.getCell((int)(body.getPosition().x/4),(int)(body.getPosition().y)/4);
    }
    }
