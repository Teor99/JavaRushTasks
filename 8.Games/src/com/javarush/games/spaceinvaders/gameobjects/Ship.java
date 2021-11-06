package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject {
    public boolean isAlive = true;
    private List<int[][]> frames;
    private int frameIndex;
    private boolean loopAnimation = false;

    public Ship(double x, double y) {
        super(x, y);
    }

    public boolean isVisible() {
        return isAlive || frameIndex < frames.size();
    }

    public void setStaticView(int[][] viewFrame) {
        setMatrix(viewFrame);
        this.frames = new ArrayList<>();
        this.frames.add(viewFrame);
        this.frameIndex = 0;
    }

    public Bullet fire() {
        return null;
    }

    public void kill() {
        isAlive = false;
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;
        setMatrix(viewFrames[0]);
        this.frames = Arrays.asList(viewFrames);
        this.frameIndex = 0;
    }

    public void nextFrame() {
        frameIndex++;

        if (loopAnimation && frameIndex >= frames.size()) {
            frameIndex = 0;
        }

        if (frameIndex < frames.size()) {
            matrix = frames.get(frameIndex);
        }
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }
}
