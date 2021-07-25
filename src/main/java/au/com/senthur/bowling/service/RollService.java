package au.com.senthur.bowling.service;

import au.com.senthur.bowling.dto.Frame;
import au.com.senthur.bowling.dto.GameLine;
import au.com.senthur.bowling.dto.KnockDownType;
import au.com.senthur.bowling.exception.BowlingException;
import au.com.senthur.bowling.service.handler.KnockDownHandlerFactory;

import java.util.Objects;

/**
 * This class will handle rolls and calculating total score based on a game.
 *
 * */
public class RollService {

    private final KnockDownHandlerFactory knockDownHandlerFactory;

    public RollService(KnockDownHandlerFactory knockDownHandlerFactory) {
        this.knockDownHandlerFactory = knockDownHandlerFactory;
    }

    /**
     * This method will handle the roll of a game
     *
     * @param input {@link String} the current roll value
     * @param gameLine {@link GameLine} the current line being played.
     *
     * */
    public GameLine rollBall(String input, GameLine gameLine) {

        if (Objects.isNull(gameLine)) {
            throw new BowlingException("Game Line object cannot be null");
        }

        Frame frame = getOrCreateCurrentFrame(gameLine);
        knockDownHandlerFactory.getHandler(KnockDownType.findByIndicator(input)).handle(gameLine, input);

        if (frame.isLastFrame() && frame.getTriesLeft() == 0 && frame.getBonusTriesLeft() == 0) {
            gameLine.setGameOver(true);
        }

        return gameLine;
    }

    private static Frame getOrCreateCurrentFrame(GameLine gameLine) {
        Frame frame = gameLine.getCurrentFrame();
        if (Objects.isNull(frame) || (!frame.isTriesLeft() && !frame.isLastFrame())) {

            frame = new Frame();
            gameLine.addFrame(frame);
            if ((gameLine.isLastFrameReached())) {
                frame.setLastFrame(true);
            }
        }

        return frame;
    }

    /**
     * This method will provide the current total score of the game.
     *
     * @param gameLine {@link GameLine} the current line being played.
     *
     * */
    public int getTotalScore(GameLine gameLine) {

        if (Objects.isNull(gameLine)) {
            throw new BowlingException("Game Line object cannot be null");
        }

        return gameLine
                .getFrames()
                .stream()
                .mapToInt(frame -> frame.getScore())
                .sum();
    }
}
