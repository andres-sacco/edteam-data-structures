package org.edteam.util;

import java.util.Random;

public class BaseUtil {

    private static final int MIN = 0;
    private static final int MAX = 100;

    protected static final int TOTAL = 50;

    protected static int randomInteger() {
        return (new Random()).nextInt(MIN, MAX);
    }
}
