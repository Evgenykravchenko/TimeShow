package com.evgeny.kravchenko.timeshow;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time implements Drawable {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private String time;
    private BitmapFont timeFont;
    private Vector2 position;
    private int scaleX;
    private int scaleY;
    private int scale;

    public Time(Vector2 position, int scale) {
        this.position = position;
        this.scale = scale;

        time = simpleDateFormat.format(new Date());

        timeFont = new BitmapFont();
        timeFont.setColor(Color.TAN);
        timeFont.getData().setScale(scale);
    }

    public Time(Vector2 position, int scaleX, int scaleY) {
        this.position = position;
        this.scaleX = scaleX;
        this.scaleY = scaleY;

        time = simpleDateFormat.format(new Date());

        timeFont = new BitmapFont();
        timeFont.setColor(Color.BLACK);
        timeFont.getData().setScale(scaleX, scaleY);
    }

    public void render(Batch batch) {
        timeFont.draw(batch, time, position.x, position.y);
    }

    public void update() {
        time = simpleDateFormat.format(new Date());
    }

}
