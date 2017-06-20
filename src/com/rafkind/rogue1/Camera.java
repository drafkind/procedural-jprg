package com.rafkind.rogue1;

import asciiPanel.AsciiPanel;
import com.rafkind.rogue1.gamedata.GameMap;

import java.awt.*;

/**
 * Created by dave on 6/19/17.
 */
public class Camera {

    private int width;
    private int height;
    private Point upperLeft;

    public Camera(int width, int height, Point upperLeft) {
        this.width = width;
        this.height = height;
        this.upperLeft = upperLeft;
    }

    public static Camera lookAt(GameMap gameMap, AsciiPanel screen, Point target) {
        int w = screen.getWidthInCharacters();
        int h = screen.getHeightInCharacters();
        int mw = gameMap.getMapWidth();
        int mh = gameMap.getMapHeight();

        int ulx = target.x - (w/2);
        if (ulx < 0) {
            ulx = 0;
        } else if (ulx > mw - w) {
            ulx = mw - w;
        }

        int uly = target.y - (h/2);
        if (uly < 0) {
            uly = 0;
        } else if (uly > mh - h) {
            uly = mh - h;
        }

        return new Camera(w, h, new Point(ulx, uly));
    }

    public Point getUpperLeft() {
        return upperLeft;
    }
}
