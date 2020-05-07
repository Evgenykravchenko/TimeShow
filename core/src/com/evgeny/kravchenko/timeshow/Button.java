package com.evgeny.kravchenko.timeshow;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button {

    private Sprite skin;
    private int width = 30;
    private int height = 30;

    public Button() {
        skin = new Sprite(new Texture("image/btn.png"));
        skin.setPosition(50, 50);
        skin.setSize(width, height);
    }

    public void render(SpriteBatch batch) {
        batch.draw(skin, 50, 50);
    }

    public void update() {

    }
}
