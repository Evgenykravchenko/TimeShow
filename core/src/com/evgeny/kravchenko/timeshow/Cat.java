package com.evgeny.kravchenko.timeshow;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Cat implements Drawable {

    private CatPicture[] catPictures;
    private double speed;

    private class CatPicture {

        Texture catTexture;
        Vector2 position;

        private CatPicture(Vector2 position) {
            this.position = position;
            catTexture = new Texture("image/cat.png");
        }
    }

    public Cat() {
        speed = 0.5f;
        catPictures = new CatPicture[1];

        for (int i = 0; i < catPictures.length; i++) {
            catPictures[i] = new CatPicture(new Vector2(i * 100 + 8000 + 100 + (int) (Math.random() * 10000), 52));
        }
    }

    public void render(Batch batch) {
        for (int i = 0; i < catPictures.length; i++) {
            batch.draw
                    (
                            catPictures[i].catTexture,
                            catPictures[i].position.x,
                            catPictures[i].position.y
                    );
        }
    }

    public void update() {
        for (int i = 0; i < catPictures.length; i++) {
            catPictures[i].position.x -= speed;
            if (catPictures[i].position.x < -30) {
                catPictures[i].position.x = 8000 + 100 + (int) (Math.random() * 10000);
            }
        }
    }

}
