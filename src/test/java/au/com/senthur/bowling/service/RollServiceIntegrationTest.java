package au.com.senthur.bowling.service;

import au.com.senthur.bowling.dto.GameLine;
import au.com.senthur.bowling.exception.BowlingException;
import au.com.senthur.bowling.service.handler.KnockDownHandlerFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RollServiceIntegrationTest {

    private KnockDownHandlerFactory knockDownHandlerFactory;
    private RollService rollService;

    @BeforeEach
    void init() {
        knockDownHandlerFactory = new KnockDownHandlerFactory();
        rollService = new RollService(knockDownHandlerFactory);
    }

    @Test
    void rollBall_shouldThrowException_whenGameLineIsNull() {
        Assertions.assertThrows(BowlingException.class, () -> rollService.rollBall("X", null));
    }

    @Test
    void getTotalScore_shouldThrowException_whenGameLineIsNull() {
        Assertions.assertThrows(BowlingException.class, () -> rollService.getTotalScore(null));
    }


    @Test
    void rollBall_shouldReturn300Points_whenGameConsistsTwelveRollTwelveStrikes() {
        GameLine gameLine = new GameLine();
        for (int count = 1 ; count <=12 ; count ++) {
            rollService.rollBall("X", gameLine);
        }

        assertTrue(gameLine.isGameOver());
        assertEquals(300, rollService.getTotalScore(gameLine));
    }

    @Test
    void rollBall_shouldReturn90Points_whenGameConsistsTwentyRollsTenPairsOfNineAndMiss() {
        GameLine gameLine = new GameLine();
        for (int count = 1 ; count <=10 ; count ++) {
            rollService.rollBall("9", gameLine);
            rollService.rollBall("-", gameLine);
        }

        assertTrue(gameLine.isGameOver());
        assertEquals(90, rollService.getTotalScore(gameLine));
    }

    @Test
    void rollBall_shouldReturn150Points_whenGameConsistsTwentyOneRollsTenPairsOfFiveAndSpareWithFinalFive() {
        GameLine gameLine = new GameLine();
        for (int count = 1 ; count <=10 ; count ++) {
            rollService.rollBall("5", gameLine);
            rollService.rollBall("/", gameLine);
        }
        rollService.rollBall("5", gameLine);

        assertTrue(gameLine.isGameOver());
        assertEquals(150, rollService.getTotalScore(gameLine));
    }

    @Test
    void rollBall_shouldReturn135Points_whenGameConsistsSixteenRollsFourStrikesOnePairOfNinePairOfFiveMisses() {
        GameLine gameLine = new GameLine();
        for (int count = 1 ; count <=4 ; count ++) {
            rollService.rollBall("X", gameLine);
        }

        rollService.rollBall("9", gameLine);
        rollService.rollBall("9", gameLine);

        for (int count = 1 ; count <= 10 ; count ++) {
            rollService.rollBall("-", gameLine);
        }

        assertTrue(gameLine.isGameOver());
        assertEquals(135, rollService.getTotalScore(gameLine));
    }

    @Test
    void rollBall_shouldReturn48Points_whenGameConsistsLineConsistNineteenRollsTwoStrikesFourteenMissesOneStrikeTwoBonusesOfFourEach() {
        GameLine gameLine = new GameLine();
        for (int count = 1 ; count <=2 ; count ++) {
            rollService.rollBall("X", gameLine);
        }

        for (int count = 1 ; count <= 14 ; count ++) {
            rollService.rollBall("-", gameLine);
        }

        rollService.rollBall("X", gameLine);
        rollService.rollBall("4", gameLine);
        rollService.rollBall("4", gameLine);

        assertTrue(gameLine.isGameOver());
        assertEquals(48, rollService.getTotalScore(gameLine));
    }

    @Test
    void rollBall_shouldReturns14Points_whenGameConsistsTwentyOneRollsNineteenMissesOneSpareOneBonusOfFour() {
        GameLine gameLine = new GameLine();

        for (int count = 1 ; count <= 19 ; count ++) {
            rollService.rollBall("-", gameLine);
        }

        rollService.rollBall("/", gameLine);
        rollService.rollBall("4", gameLine);

        assertTrue(gameLine.isGameOver());
        assertEquals(14, rollService.getTotalScore(gameLine));
    }

}
