package au.com.senthur.bowling.service.handler;

import au.com.senthur.bowling.dto.Frame;
import au.com.senthur.bowling.dto.GameLine;
import au.com.senthur.bowling.dto.KnockDownType;

import java.util.Objects;

/**
 * An Handler interface to handle each Roll and Hit Type.
 *
 * */
public interface KnockDownHandler {

    /**
     * This method will process the roll.
     *
     * @param gameLine {@link GameLine}
     * @param score {@link String}
     *
     * */
    void handle(GameLine gameLine, String score);

    /**
     * This method will accumulate score of Last two Strikes using the  current roll score.
     *
     * @param gameLine {@link GameLine}
     * @param score int
     *
     * */
    default void accumulateScoreOfPreviousStrike(GameLine gameLine, int score) {
        accumulateScoreOfPreviousFrame(gameLine.getPreviousFrame(), score, KnockDownType.STRIKE);
        accumulateScoreOfPreviousFrame(gameLine.getSecondPreviousFrame(), score, KnockDownType.STRIKE);
    }

    /**
     * This method will accumulate score of Last Spare using the  current roll score.
     *
     * @param gameLine {@link GameLine}
     * @param score int
     *
     * */
    default void accumulateScoreOfPreviousSpare(GameLine gameLine, int score) {
        accumulateScoreOfPreviousFrame(gameLine.getPreviousFrame(), score, KnockDownType.SPARE);
    }

    private static void accumulateScoreOfPreviousFrame(Frame frame, int score, KnockDownType knockDownType) {
        if (Objects.nonNull(frame) && knockDownType.equals(frame.getKnockDownType()) && frame.getAccumulationThreshold() > 0) {
            frame.setScore(frame.getScore() + score);
            frame.setAccumulationThreshold(frame.getAccumulationThreshold() - 1);
        }
    }

}
