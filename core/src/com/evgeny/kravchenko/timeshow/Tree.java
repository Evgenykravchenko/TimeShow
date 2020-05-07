package com.evgeny.kravchenko.timeshow;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Tree implements Drawable {

    private double speed;
    private TreePicture[] treePictures;

    private class TreePicture {

        private Texture treeTexture;
        private Vector2 position;

        private TreePicture(Vector2 position) {
            this.position = position;
            treeTexture = new Texture("image/tree.png");
        }
    }

    public Tree() {
        speed = 0.5f;
        treePictures = new TreePicture[5];

        for (int i = 0; i < treePictures.length; i++) {
            treePictures[i] = new TreePicture(new Vector2(i * 100 + 100 + (int) (Math.random() * 200), 60));
        }
    }

    public void render(Batch batch) {
        for (TreePicture treePicture : treePictures) {
            batch.draw(treePicture.treeTexture, treePicture.position.x, treePicture.position.y);
        }
    }

    public void update() {
        for (int i = 0; i < treePictures.length; i++) {
            treePictures[i].position.x -= speed;
        }

        for (int j = 0; j < treePictures.length; j++) {
            if (treePictures[j].position.x < -70) {
                treePictures[j].position.x = 500 + 100 + (int) (Math.random() * 1000);
            }
        }
    }


}
