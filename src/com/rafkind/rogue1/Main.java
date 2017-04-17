package com.rafkind.rogue1;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private AsciiPanel asciiPanel;
    private Controller controller;
    private Stack<Controller> controllerStack;
    private int tick;

    private GameState gameState;

    public Main() {
        controllerStack = new Stack<Controller>();
        controllerStack.push(new TempController());
        controller = controllerStack.peek();
        gameState = new GameState();
    }

    public JFrame createGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        asciiPanel = new AsciiPanel(40, 25, AsciiFont.CP437_16x16);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(asciiPanel, BorderLayout.CENTER);

        return frame;
    }

    public void startGameLoop() {
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
