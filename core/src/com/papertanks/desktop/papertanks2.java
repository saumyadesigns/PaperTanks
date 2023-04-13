//package com.mygdx.tanksv2;
package com.papertanks.desktop;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
//import com.mygdx.tanksv2.Screens.playScreen;
import com.papertanks.desktop.Screens.playScreen;

public class papertanks2 extends Game {
	public static final int V_WIDTH=1280;
	public static final int V_HEIGHT=720;
	public static final float PPM = 100;

	public static final short TANK1_BIT=2;
	public static final short TANK2_BIT=2;
	public static final short GROUND_BIT=4;
	public static final short BULLET_BIT=8;
	public static final short DESTROYED_BIT=16;
	public SpriteBatch batch;
//	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		setScreen(new playScreen(this));

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}