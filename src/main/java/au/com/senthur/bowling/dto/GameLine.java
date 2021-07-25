package au.com.senthur.bowling.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* This class Represents a Tenpin Bowl Game.
*
* */
public class GameLine {

    public final static int FRAMES_PER_GAME = 10;
    private final List<Frame> frames = new ArrayList<>();
    private boolean gameOver;

    public void addFrame(Frame frame) {
        frames.add(frame);
    }

    public List<Frame> getFrames() {
        return Collections.unmodifiableList(frames);
    }

    public boolean isLastFrameReached() {
        return GameLine.FRAMES_PER_GAME - frames.size() == 0;
    }

    public Frame getCurrentFrame() {
        return frames.isEmpty() ? null : frames.get(frames.size() - 1);
    }

    public Frame getPreviousFrame() {
        return frames.isEmpty() || frames.size() < 2 ? null : frames.get(frames.size() - 2);
    }

    public Frame getSecondPreviousFrame() {
        return frames.isEmpty() || frames.size() < 3 ? null : frames.get(frames.size() - 3);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
