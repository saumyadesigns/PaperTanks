//package com.mygdx.tanksv2.Sprites.Weapons;
package com.papertanks.desktop.Sprites.Weapons;

import com.badlogic.gdx.math.Vector2;

public class BulletDef {
    public Vector2 position;
    public Class<?> type;

    public BulletDef(Vector2 position, Class<?> type) {
        this.position = position;
        this.type = type;
    }


}
