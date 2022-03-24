package com.pockball.pockball.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Util {

    public static void addPathToButton(ScreenController screenController, TextButton button, ScreenModel.Screen screen, ScreenModel.Screen previousScreen) {
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                screenController.changeScreen(screen, previousScreen);
                // TODO: This is a temporary bugfix, that prevents quitting a SP-game,
                //  then reentering to not show pool board.
                screenController.changeScreen(previousScreen, screen);
                screenController.changeScreen(screen, previousScreen);
            }
        });
    }
}
