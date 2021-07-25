package au.com.senthur.bowling.service.handler.impl;

import au.com.senthur.bowling.dto.GameLine;
import au.com.senthur.bowling.dto.KnockDownType;

/**
 * Class to handle Spare Roll
 *
 * */
public class SpareHandler extends CleanGameHandler {

    private static final int TRIES_PER_FRAME = 1;
    private static final int BONUS_RETRIES = 1;
    private static final int SPARE_SCORE = 10;

    @Override
    public void handle(GameLine gameLine, String score) {
        handle(gameLine, KnockDownType.SPARE, TRIES_PER_FRAME, SPARE_SCORE, BONUS_RETRIES);
    }
}
