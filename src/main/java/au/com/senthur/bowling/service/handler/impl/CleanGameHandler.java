package au.com.senthur.bowling.service.handler.impl;

import au.com.senthur.bowling.dto.Frame;
import au.com.senthur.bowling.dto.GameLine;
import au.com.senthur.bowling.dto.KnockDownType;
import au.com.senthur.bowling.service.handler.KnockDownHandler;

/**
 * A class to represent A Clean Roll which represents a Strike or Spare.
 *
 * */
public abstract class CleanGameHandler implements KnockDownHandler {

    /**
     * Method to process the roll
     *
     * @param gameLine {@link GameLine}
     * @param knockDownType {@link KnockDownType}
     * @param applicableTries int Each Turn can have two tries. This represents tries per turn that consists within a Clean Roll
     * @param cleanGameScore int The score that will be given for a clean roll
     * @param bonusRetries int The Number of Bonus retries for a clean roll
     * */
    protected void handle(GameLine gameLine, KnockDownType knockDownType, int applicableTries, int cleanGameScore, int bonusRetries) {
        Frame frame = gameLine.getCurrentFrame();
        frame.setKnockDownType(knockDownType);

        if (frame.getTriesLeft() == applicableTries) {
            frame.setAccumulationThreshold(knockDownType.getAccumulationThreshold());
        }

        frame.setTriesLeft(0);
        frame.setScore(frame.isBonus() ? frame.getScore() + cleanGameScore : cleanGameScore);
        handleLastFrame(frame, bonusRetries);

        accumulateScoreOfPreviousStrike(gameLine, cleanGameScore);
        accumulateScoreOfPreviousSpare(gameLine, cleanGameScore);
    }

    private void handleLastFrame(Frame frame, int applicableBonusRetries) {

        if (frame.isLastFrame()) {

            if (!frame.isBonus()) {
                frame.setBonus(true);
                frame.setBonusTriesLeft(applicableBonusRetries);
            } else {
                frame.setBonusTriesLeft(frame.getBonusTriesLeft() - 1);
            }
        }
    }

}
