package au.com.senthur.bowling.service.handler.impl;

import au.com.senthur.bowling.dto.Frame;
import au.com.senthur.bowling.dto.GameLine;
import au.com.senthur.bowling.dto.KnockDownType;
import au.com.senthur.bowling.service.handler.KnockDownHandler;

/**
 * Class to handle Roll Misses.
 *
 * */
public class MissHandler implements KnockDownHandler {

    @Override
    public void handle(GameLine gameLine, String score) {

        Frame frame = gameLine.getCurrentFrame();
        frame.setKnockDownType(KnockDownType.MISS);

        if (frame.isTriesLeft()) {
            frame.setTriesLeft(frame.getTriesLeft() - 1);
        }

        if (frame.isLastFrame() && frame.isBonus()) {
            frame.setBonusTriesLeft(frame.getBonusTriesLeft() - 1);
        }

        accumulateScoreOfPreviousStrike(gameLine, 0);
        accumulateScoreOfPreviousSpare(gameLine, 0);
    }
}
