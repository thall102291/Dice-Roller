package com.sc.diceroller;

import java.awt.*;

/**
 * Created by thall on 4/29/2017.
 */
public class MyFont extends Font {

    public static final MyFont norm = new MyFont(Font.PLAIN, 20);

    public MyFont(int style, int size) {
        super("Courier", style, size);
    }
}
