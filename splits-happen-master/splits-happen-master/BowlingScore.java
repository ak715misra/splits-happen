package com.akmisra;

public class BowlingScore {
    int[] rolls;        // main array implemented to take care of rolls
    int currentRoll;    // track the current roll

    // create a global array of 21 rolls in the constructor itself.
    public BowlingScore() {
        this.rolls = new int[21];
    }

    // update the main rolls array with pins down in the current roll
    public void attempt(int p) {
        rolls[currentRoll++] = p;
    }

    // main method to compute the score for an entire game of 10 rolls
    public int score() {
        int score = 0;
        int frame = 0;

        for (int i = 0; i < 10; i++) {
            if (wasRollAStrike(frame)) {
                // score incremented by 10 and pins down in next two rolls
                score += 10 + bonusForStrike(frame);
                frame++;
            } else if (wasRollASpare(frame)) {
                // score incremented by 10 and pins down in next roll
                score += 10 + bonusForSpare(frame);
                frame += 2;
            } else {
                score += sumOfRolls(frame);
                frame += 2;
            }
        }

        return score;
    }

    private boolean wasRollAStrike(int frame) {
        return rolls[frame] == 10;
    }

    private boolean wasRollASpare(int frame) {
        return sumOfRolls(frame) == 10;
    }

    private int bonusForStrike(int frame) {
        return sumOfRolls(frame+1);
    }

    private int bonusForSpare(int frame) {
        return rolls[frame+2];
    }

    private int sumOfRolls(int frame) {
        return rolls[frame] + rolls[frame+1];
    }
}