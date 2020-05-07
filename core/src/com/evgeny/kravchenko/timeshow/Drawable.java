package com.evgeny.kravchenko.timeshow;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface Drawable {
    void render(Batch batch);
    void update();
}
