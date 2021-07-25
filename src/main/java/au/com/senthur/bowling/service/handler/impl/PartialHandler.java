package au.com.senthur.bowling.service.handler.impl;

import au.com.senthur.bowling.dto.Frame;
import au.com.senthur.bowling.dto.GameLine;
import au.com.senthur.bowling.dto.KnockDownType;
import au.com.senthur.bowling.service.handler.KnockDownHandler;
import au.com.senthur.bowling.util.Utils;

/**
 * Class to handle Partial Roll (Which represent Pins knocked down per Roll)
 *
 * */
public class PartialHandler implements KnockDownHandler {

    @Override
    public void handle(GameLine gameLine, String input) {

        int score = Utils.getNum(input);

        Frame frame = gameLine.getCurrentFrame();
        frame.setKnockDownType(KnockDownType.PARTIAL);
        frame.setScore(frame.getScore() + score);

        if (frame.isTriesLeft()) {
            frame.setTriesLeft(frame.getTriesLeft() - 1);
        }

        if (frame.isLastFrame() && frame.isBonus()) {
            frame.setBonusTriesLeft(frame.getBonusTriesLeft() - 1);
        }

        accumulateScoreOfPreviousStrike(gameLine, score);
        accumulateScoreOfPreviousSpare(gameLine, score);
    }
}
