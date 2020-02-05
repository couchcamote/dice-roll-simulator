package com.alexiesracca.sandbox.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alexiesracca.sandbox.entity.DiceRoll;

public class DiceRollHelper{
    
    private static Random random = new Random();

    public static List<DiceRoll> roll(int rollCount, int piece, int side) {
        List<DiceRoll> rolls = new ArrayList<DiceRoll>();
        DiceRoll roll = null;
        for (int r = 0; r < rollCount; r++) {
            roll = new DiceRoll(piece, side);
            int total = 0;
            String[] pieceRoll = new String[piece];
            for (int p = 0; p < piece; p++) {
                int up = rollDice(side);
                pieceRoll[p] = "" + up;
                total += up;
            }
            roll.setCombinationArray(pieceRoll);
            roll.setTotal(total);
            rolls.add(roll);
        }
        return rolls;
    }

    public static int rollDice(int side) {
        int r = random.nextInt(side) + 1;
        return r;
    }

}