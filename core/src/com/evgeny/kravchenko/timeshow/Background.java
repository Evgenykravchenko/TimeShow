package com.evgeny.kravchenko.timeshow;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Background implements Drawable {

    private final double speed;
    private final BackgroundPicture[] backgroundPictures;

    private class BackgroundPicture {
        private final Texture backgroundTexture;
        private final Vector2 position;

        private BackgroundPicture(Vector2 position) {
            this.position = position;
            backgroundTexture = new Texture("image/back1.jpg");
        }
    }

    public Background() {
        speed = 0.5f;
        backgroundPictures = new BackgroundPicture[2];

        for (int i = 0; i < backgroundPictures.length; i++) {
            backgroundPictures[i] = new BackgroundPicture(new Vector2(i * 500, 0));
        }
    }

    public void render(Batch batch) {
        for (BackgroundPicture backgroundPicture : backgroundPictures) {
            batch.draw(
                    backgroundPicture.backgroundTexture,
                    backgroundPicture.position.x,
                    backgroundPicture.position.y
            );
        }
    }

    public void update() {
        for (BackgroundPicture backgroundPicture : backgroundPictures) {
            backgroundPicture.position.x -= speed;
        }

        if (backgroundPictures[0].position.x < -500) {
            for (int i = 0; i < backgroundPictures.length; i++) {
                backgroundPictures[i].position.x = i * 500;
            }
        }
    }
}
