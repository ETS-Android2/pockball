package com.pockball.pockball.game_states;

import com.badlogic.ashley.core.Entity;
import com.pockball.pockball.ecs.types.BallType;

public interface State {
    public void ballIntoHole(BallType ball);

    public Entity[] getPlayers();
}
