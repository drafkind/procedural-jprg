package com.rafkind.rogue1;

import java.util.Stack;

public class GameStateTransition {
    private final State oldState;
    private final State newState;
    private final Operation operation;

    public GameStateTransition(
            final State oldState,
            final State newState,
            final Operation operation) {
        this.oldState = oldState;
        this.newState = newState;
        this.operation = operation;
    }

    public void passControl(Stack<Controller> controllerStack, GameState gameState) {

    }

    public static enum Operation {
        STACK,
        REPLACE;
    }
}
