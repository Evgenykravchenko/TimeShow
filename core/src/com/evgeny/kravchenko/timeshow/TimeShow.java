package com.evgeny.kravchenko.timeshow;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class TimeShow extends ApplicationAdapter {
	private SpriteBatch batch;
	private Drawable backgroundTexture;
	private Drawable treeTexture;
	private Drawable cat;
	private Drawable time;
	private Drawable dayCycle;
	private Button btn;
	private ArrayList<Music> musicList;
	private int musicPlaylistLength;
	private int currentSoundIndexInPlayList;
	private int maxSoundIndexInPlayList;
	private boolean isDynamicTheme;

	@Override
	public void create () {
		isDynamicTheme = false;
		currentSoundIndexInPlayList = 0;
		musicList = new ArrayList<>();

		for (int i = 1; i < 5; i++) {
			musicList.add(Gdx.audio.newMusic(Gdx.files.internal("music/backgroundMusic" + i + ".mp3")));
			musicList.get(i - 1).setLooping(true);
			musicList.get(i - 1).setVolume(0.1f);
		}

		musicPlaylistLength = musicList.size();
		maxSoundIndexInPlayList = musicPlaylistLength - 1;

		batch = new SpriteBatch();
		btn = new Button();
		backgroundTexture = new Background();
		treeTexture = new Tree();
		cat = new Cat();
		dayCycle = new DayCycle(0);

		time = new Time(new Vector2(50, 150),3);

		musicList.get(0).play();

	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		checkAndChangeThemeRender();
		batch.end();
	}

	public void update() {
		checkAndChangeThemeUpdate();
		checkClicks();
	}

	private void checkClicks() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			if (musicList.get(currentSoundIndexInPlayList).getVolume() > 0) {
				musicList.get(currentSoundIndexInPlayList).setVolume(0);
				return;
			}
			musicList.get(currentSoundIndexInPlayList).setVolume(0.5f);
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
			musicList.get(currentSoundIndexInPlayList).stop();
			if (currentSoundIndexInPlayList < maxSoundIndexInPlayList) {
				musicList.get(++currentSoundIndexInPlayList).play();
				return;
			}

			currentSoundIndexInPlayList = 0;
			musicList.get(currentSoundIndexInPlayList).play();
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
			musicList.get(currentSoundIndexInPlayList).stop();
			if (currentSoundIndexInPlayList > 0) {
				musicList.get(--currentSoundIndexInPlayList).play();
				return;
			}
			currentSoundIndexInPlayList = maxSoundIndexInPlayList;
			musicList.get(currentSoundIndexInPlayList).play();
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
			isDynamicTheme = !isDynamicTheme;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	private void checkAndChangeThemeRender() {
		if (!isDynamicTheme) {
			backgroundTexture.render(batch);
			cat.render(batch);
			time.render(batch);
			treeTexture.render(batch);
			return;
		}

		dayCycle.render(batch);
		time.render(batch);
	}

	private void checkAndChangeThemeUpdate() {
		if (!isDynamicTheme) {
			backgroundTexture.update();
			cat.update();
			time.update();
			treeTexture.update();
			return;
		}

		time.update();
		dayCycle.update();
	}

}
