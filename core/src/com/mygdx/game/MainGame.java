package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.Screen.MainScreen;

public class MainGame extends Game {

    public final static String TITLE = "MainGame";
    public final static int WIGHT = 1080;
    public final static int HEIGHT = 720;
    public final static float SCALE = (float) HEIGHT / WIGHT;


    private boolean paused;

    @Override
    public void create() {


        this.setScreen(new MainScreen(this));


    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

}

