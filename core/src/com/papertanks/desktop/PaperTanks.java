package com.papertanks.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.papertanks.desktop.states.GameStateManager;
import com.papertanks.desktop.states.Loading;

public class PaperTanks extends ApplicationAdapter {
	public static final int WIDTH=1280;
	public static final int HEIGHT=720;

	public static final String TITLE="PaperTanks";
	private GameStateManager gsm;
	private SpriteBatch batch;
	private Pixmap pm;
	private Music bgm;
//	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm=new GameStateManager();
		ScreenUtils.clear(1, 1, 1, 1);

//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.push(new Loading(gsm));
		bgm= Gdx.audio.newMusic(Gdx.files.internal("paperTanks_assets/ui_bgMusic.mp3"));
		pm=new Pixmap(Gdx.files.internal("paperTanks_assets/ui_cursor_B.png"));
		bgm.setVolume(0.009f);
		bgm.setLooping(true);
		bgm.play();
		Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm,25,25));
//		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch , Gdx.graphics.getDeltaTime());
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
		bgm.dispose();
		pm.dispose();
	}
}