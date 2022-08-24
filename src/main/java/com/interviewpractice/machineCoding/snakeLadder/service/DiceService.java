package com.interviewpractice.machineCoding.snakeLadder.service;

import java.util.Random;

public class DiceService {

    public static int roll()
    {
        return new Random().nextInt(6)+1;
    }
}
