package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MainGame;

/**
 * Created by Sebastian on 2017-02-19.
 */
public abstract class AbstractScreen implements Screen {

    public final int OUT_OF_LIFE_SCREEN = 0;
    public final int NEXT_LEVEL_SCREEN = 1;
    protected MainGame game;
    protected Stage stage;
    protected SpriteBatch spriteBatch;
    private OrthographicCamera camera;

    public AbstractScreen(MainGame game) {
        this.game = game;
        createCamera();
        spriteBatch = new SpriteBatch();
        stage = new Stage(new StretchViewport(MainGame.WIGHT, MainGame.HEIGHT));
        Gdx.input.setInputProcessor(stage);
        init();

    }

    protected abstract void init();

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, MainGame.WIGHT, MainGame.HEIGHT);
        camera.update();

    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);

    }

    private void clearScreen() {
        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void pause() {
        game.setPaused(true);

    }

    @Override
    public void dispose() {
        game.dispose();
        stage.dispose();
        spriteBatch.dispose();
    }

    @Override
    public void hide() {

        for (Actor actor : stage.getActors()) {
            actor.remove();

        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

}

