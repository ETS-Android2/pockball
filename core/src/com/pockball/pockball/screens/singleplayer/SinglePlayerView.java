package com.pockball.pockball.screens.singleplayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.pockball.pockball.assets.AssetsController;
import com.pockball.pockball.ecs.Engine;
import com.pockball.pockball.screens.ScreenController;
import com.pockball.pockball.screens.ScreenModel;
import com.pockball.pockball.screens.Util;

public class SinglePlayerView implements Screen {
    private final AssetsController assetsController;
    private Stage stage;
    private SinglePlayerController singlePlayerController;
    private Label numberOfShots;
    private ScreenController screenController;


    public SinglePlayerView(ScreenController screenController, SinglePlayerController singlePlayerController) {
        this.singlePlayerController = singlePlayerController;
        Engine.getInstance().initializeEngine(0);

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.assetsController = AssetsController.getInstance();

        numberOfShots = new Label("Shots: " + singlePlayerController.getNumberOfShots(), assetsController.getSkin());

        this.screenController = screenController;

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        table.add(numberOfShots);
        table.top();
      
        TextButton pauseButton = new TextButton("PAUSE", assetsController.getSkin());

        table.top().right();
        table.padTop(5);
        table.padRight(5);
        table.add(pauseButton);

        Util.addPathToButton(screenController, pauseButton, ScreenModel.Screen.SETTINGS, ScreenModel.Screen.SINGLEPLAYER);
    }

    @Override
    public void render(float delta) {
        Engine.getInstance().update(delta);

        numberOfShots.setText("Shots: " + singlePlayerController.getNumberOfShots());

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.getActors().clear();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
