package com.rafkind.rogue1;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import java.util.TimerTask;

public class Main {

    private AsciiPanel asciiPanel;
    private Controller controller;
    private Stack<Controller> controllerStack;
    private int tick;

    private GameState gameState;

    private Main() {
        controllerStack = new Stack<>();
        controllerStack.push(new TempController());
        controller = controllerStack.peek();
        gameState = new GameState();
    }

    private JFrame createGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        asciiPanel = new AsciiPanel(40, 25, AsciiFont.CP437_16x16);
        asciiPanel.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                controller.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                controller.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                controller.keyReleased(e);
            }
        });
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(asciiPanel, BorderLayout.CENTER);
        frame.pack();

        return frame;
    }

    private void startGameLoop() {
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(
            new TimerTask(){
                @Override
                public void run() {
                    GameStateTransition transition = controller.control(asciiPanel, tick++, null);
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
