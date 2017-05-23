package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Sebastian on 2017-05-23.
 */

public class Waiter extends Image {

    public final int WEIGHT = 100;
    private boolean isFree = false;

    public Waiter() {
        super(new Texture("waiter.png"));
        this.setPosition(0, 0);
        setSize(WEIGHT, WEIGHT);
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public void goToKitchen() {

        Action goToKitchen = Actions.sequence(
                Actions.delay(.50f),
                Actions.moveTo(0, 0, 1.0f, Interpolation.smoother)
        );
        this.addAction(goToKitchen);

        //   this.addAction(Actions.rotateBy(-180, 0.1f));
    }

    public void goToTable(int x, int y) {
        Action goToKitchen = Actions.sequence(
                Actions.delay(.50f),
                Actions.moveTo(x, y, 1.0f, Interpolation.smoother),
                Actions.delay(.50f),
                Actions.moveTo(0, 0, 1.0f, Interpolation.smoother)
        );
        this.addAction(goToKitchen);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void goToTable(final Tablee tablee) {

        if (tablee == null || isFree) {
            System.out.println("Kelner jest zajety");
            return;
        }
        isFree = true;
        System.out.println("Kelner jest zajety");
        Action goToKitchen = Actions.sequence(
                Actions.delay(.50f),
                Actions.moveTo(tablee.getX(), tablee.getY(), 1.0f, Interpolation.smoother),
                Actions.delay(.150f),
                Actions.moveTo(0, 0, 1.0f, Interpolation.smoother),
                new Action() {
                    @Override
                    public boolean act(float delta) {
                        isFree = false;
                        System.out.println("Kelner nie jest zajety");
                        Waiter.this.clearActions();
                        return false;
                    }
                }
        );

        tablee.tabelServed();
        this.addAction(goToKitchen);
    }
}
