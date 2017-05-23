package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Sebastian on 2017-05-23.
 */

public class Tablee extends Image {

    public final int WEIGHT = 120;
    private boolean isServed = false;

    public Tablee() {
        super(new Texture("table.png"));
        this.setPosition(MathUtils.random(Gdx.graphics.getWidth() - WEIGHT), MathUtils.random(Gdx.graphics.getHeight() - WEIGHT));
        setSize(WEIGHT, WEIGHT);
    }

    public void setServed(boolean served) {
        isServed = served;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void tabelServed() {

        Action action = new Action() {
            @Override
            public boolean act(float delta) {
                setServed(false);

                Tablee.this.clearActions();
                return false;
            }
        };
        SequenceAction sequence = Actions.sequence(Actions.delay(10.0f),
                                                   Actions.sizeBy(50, 50, 0.3f)
                , action
        );

        if (!isServed) {
            this.addAction(Actions.sequence(
                    Actions.delay(.50f),
                    Actions.sizeBy(-50, -50, 0.3f)));
            isServed = true;
            addAction(sequence);
        }

    }

    public boolean isServed() {
        return isServed;
    }
}
