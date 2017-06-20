package com.rafkind.rogue1;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import com.google.common.collect.ImmutableList;
import com.rafkind.rogue1.gamedata.GameMap;
import com.rafkind.rogue1.gamedata.GameWorld;
import com.rafkind.rogue1.gamedata.PlayerCharacter;
import com.rafkind.rogue1.gamedata.PlayerCharacterGroup;
import com.rafkind.rogue1.gamedata.description.GameDescription;
import com.rafkind.rogue1.gamedata.generator.GameGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import java.util.TimerTask;

public class Main {

    public static int VIEWPORT_WIDTH = 40;
    public static int VIEWPORT_HEIGHT = 25;

    private AsciiPanel asciiPanel;
    private Controller controller;
    private Stack<Controller> controllerStack;
    private int tick;

    private GameState gameState;

    private GameWorld gameWorld;

    private Main() {
        gameWorld = new GameGenerator().generateFrom(new GameDescription());
        GameMap startMap = gameWorld.getMap("start");
        gameState = new GameState(
                new PlayerCharacterGroup(
                        ImmutableList.of(
                            new PlayerCharacter((char) 2, Colors.COLORS[15], Colors.COLORS[1])
                        ),
                        startMap.getStartLocation(),
                        startMap));
        MapController mapController = new MapController();

        controller = mapController;
        controllerStack = new Stack<>();
        controllerStack.push(controller);
    }

    private JFrame createGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        asciiPanel = new AsciiPanel(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, AsciiFont.CP437_16x16);
        asciiPanel.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                controller.keyTyped(e, gameState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                controller.keyPressed(e, gameState);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                controller.keyReleased(e, gameState);
            }
        });
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(asciiPanel, BorderLayout.CENTER);
        frame.pack();
        asciiPanel.requestFocusInWindow();

        return frame;
    }

    private void startGameLoop() {
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(
            new TimerTask(){
                @Override
                public void run() {
                    GameStateTransition transition = controller.control(asciiPanel, tick++, gameState);
                    if (transition != null) {
                        transition.passControl(controllerStack, gameState);
                        controller = controllerStack.peek();
                    }
                    asciiPanel.repaint();
                }
            },
            0,
            30);
    }

    public static void main(String[] args) {
        final Main main = new Main();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = main.createGui();
            main.startGameLoop();
            frame.setVisible(true);
        });
    }
}
