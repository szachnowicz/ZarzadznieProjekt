package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Actors.Tablee;
import com.mygdx.game.Actors.Waiter;
import com.mygdx.game.MainGame;

import java.util.ArrayList;

/**
 * Created by Sebastian on 2017-05-22.
 */

public class MainScreen extends AbstractScreen {

    int currentTabel = 0;
    private Waiter waiter;
    private Tablee table;
    private ArrayList<Tablee> tableList;

    public MainScreen(MainGame mainGame) {
        super(mainGame);
    }

    @Override
    protected void init() {
        waiter = new Waiter();
        stage.addActor(waiter);
        table = new Tablee();
        tableList = new ArrayList<Tablee>();

        initSing();
        addTabel();

    }

    private void searhForTabel() {
        Timer.schedule(
                new Timer.Task() {
                    @Override
                    public void run() {

                        waiter.goToTable(findTabel());
                        System.out.println("go to table");
                    }
                }
                , 1.0f, 1.0f, 70);

    }

    private Tablee findTabel() {
        for (Tablee x : tableList
                ) {

            if (!x.isServed()) {
                System.out.println(x.toString());
                return  x;
            }
        }
        return null;
    }

    private void initSing() {

    }

    @Override
    public void render(float delta) {

        super.render(delta);
        stage.act(delta);
        update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();

    }

    private void update() {

        if (Gdx.input.justTouched()) {
            searhForTabel();
        }

    }

    public void addTabel() {
        Timer.schedule(
                new Timer.Task() {
                    @Override
                    public void run() {
                        tableList.add(new Tablee());
                        stage.addActor(tableList.get(tableList.size() - 1));
                    }
                }
                , 0.5f, 1f, 7);

    }

}

