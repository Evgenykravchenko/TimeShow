package com.evgeny.kravchenko.timeshow;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DayCycle implements Drawable {

    private final double speed;
    private ArrayList<DayCyclePicture> dayCyclePictures;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
    private String time;
    private Map<String, Integer> indexByHour;
    private int index;

    private class DayCyclePicture {
        private Texture currentTexture;
        private Vector2 position;

        private DayCyclePicture(Vector2 position, Texture currentTexture) {
            this.position = position;
            this.currentTexture = currentTexture;
        }
    }

    public DayCycle(double speed) {
        this.speed = speed;
        initializeMap();
        initializePictures();
        time = simpleDateFormat.format(new Date());
    }

    public void render(Batch batch) {
        batch.draw(
                dayCyclePictures.get(index).currentTexture,
                dayCyclePictures.get(index).position.x,
                dayCyclePictures.get(index).position.y);
    }

    public void update() {
        time = simpleDateFormat.format(new Date());
        updateIndex();
    }

    private void updateIndex() {
        for (Map.Entry<String, Integer> pair: indexByHour.entrySet()) {
            index = time.equals(pair.getKey()) ? pair.getValue() : index;
        }
    }

    private void initializePictures() {
        dayCyclePictures = new ArrayList<>();
        String path = "image/dayCycle/";

        dayCyclePictures.add(new DayCyclePicture(
                new Vector2(0, 0),
                new Texture(path + "morning/morning.png"))
        );

        dayCyclePictures.add(new DayCyclePicture(
                new Vector2(0, 0),
                new Texture(path + "morning/lateMorning.png"))
        );

        dayCyclePictures.add(new DayCyclePicture(
                new Vector2(0, 0),
                new Texture(path + "afternoon/afternoon.png"))
        );

        dayCyclePictures.add(new DayCyclePicture(
                new Vector2(0, 0),
                new Texture(path + "afternoon/lateAfternoon.png"))
        );

        dayCyclePictures.add(new DayCyclePicture(
                new Vector2(0, 0),
                new Texture(path + "evening/evening.png"))
        );

        dayCyclePictures.add(new DayCyclePicture(
                new Vector2(0, 0),
                new Texture(path + "evening/lateEvening.png"))
        );

        dayCyclePictures.add(new DayCyclePicture(
                new Vector2(0, 0),
                new Texture(path + "night/night.png"))
        );

        dayCyclePictures.add(new DayCyclePicture(
                new Vector2(0, 0),
                new Texture(path + "night/lateNight.png"))
        );
    }

    private void initializeMap() {
        indexByHour = new HashMap<>();
        indexByHour.put("23", 6);
        indexByHour.put("00", 6);
        indexByHour.put("01", 6);

        indexByHour.put("02", 7);
        indexByHour.put("03", 7);
        indexByHour.put("04", 7);

        indexByHour.put("05", 0);
        indexByHour.put("06", 0);
        indexByHour.put("07", 0);

        indexByHour.put("08", 1);
        indexByHour.put("09", 1);
        indexByHour.put("10", 1);

        indexByHour.put("11", 2);
        indexByHour.put("12", 2);
        indexByHour.put("13", 2);

        indexByHour.put("14", 3);
        indexByHour.put("15", 3);
        indexByHour.put("16", 3);

        indexByHour.put("17", 4);
        indexByHour.put("18", 4);
        indexByHour.put("19", 4);

        indexByHour.put("20", 5);
        indexByHour.put("21", 5);
        indexByHour.put("22", 5);
    }
}
