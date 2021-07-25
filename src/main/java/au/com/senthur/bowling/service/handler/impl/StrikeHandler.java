package au.com.senthur.bowling.service.handler.impl;

import au.com.senthur.bowling.dto.GameLine;
import au.com.senthur.bowling.dto.KnockDownType;

/**
 * Class to handle Strike Roll
 *
 * */
public class StrikeHandler extends CleanGameHandler {

    private static final int TRIES_PER_FRAME = 2;
    private static final int BONUS_RETRIES = 2;
    private static final int STRIKE_SCORE = 10;

    @Override
    public void handle(GameLine gameLine, String score) {
        handle(gameLine, KnockDownType.STRIKE, TRIES_PER_FRAME, STRIKE_SCORE, BONUS_RETRIES);
    }
}
