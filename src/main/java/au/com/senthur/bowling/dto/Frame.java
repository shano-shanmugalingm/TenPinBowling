package au.com.senthur.bowling.dto;

/**
 * This class Represents a Turn in the Tenpin Bowling Game
 *
 * */
public class Frame {

    private int triesLeft = 2;
    private KnockDownType knockDownType;
    private int score;
    private boolean lastFrame;

    private int accumulationThreshold;

    private boolean bonus;
    private int bonusTriesLeft;

    public boolean isTriesLeft() {
        return triesLeft > 0;
    }

    public int getTriesLeft() {
        return triesLeft;
    }

    public void setTriesLeft(int triesLeft) {
        this.triesLeft = triesLeft;
    }

    public KnockDownType getKnockDownType() {
        return knockDownType;
    }

    public void setKnockDownType(KnockDownType knockDownType) {
        this.knockDownType = knockDownType;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isLastFrame() {
        return lastFrame;
    }

    public void setLastFrame(boolean lastFrame) {
        this.lastFrame = lastFrame;
    }

    public int getAccumulationThreshold() {
        return accumulationThreshold;
    }

    public void setAccumulationThreshold(int accumulationThreshold) {
        this.accumulationThreshold = accumulationThreshold;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public int getBonusTriesLeft() {
        return bonusTriesLeft;
    }

    public void setBonusTriesLeft(int bonusTriesLeft) {
        this.bonusTriesLeft = bonusTriesLeft;
    }
}
