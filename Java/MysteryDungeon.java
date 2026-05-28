package Java;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MysteryDungeon extends JPanel implements KeyListener {

    int tileSize = 40;

    // P = player starting point
    // # = wall
    // . = floor
    char[][] map = {
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
        {'#', '.', '#', '#', '.', '.', '.', '#', '.', '#'},
        {'#', '.', '.', '.', '.', '#', '.', '#', '.', '#'},
        {'#', '.', '.', '#', '.', '.', '.', '.', '.', '#'},
        {'#', '.', '.', '#', '.', '#', '#', '.', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
        {'#', '.', '#', '.', '#', '#', '.', '#', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    int playerRow = 1;
    int playerCol = 1;

    public MysteryDungeon() {
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawMap(g);
        drawPlayer(g);
    }

    public void drawMap(Graphics g) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {

                int x = col * tileSize;
                int y = row * tileSize;

                if (map[row][col] == '#') {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(x, y, tileSize, tileSize);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(x, y, tileSize, tileSize);
                }

                g.setColor(Color.BLACK);
                g.drawRect(x, y, tileSize, tileSize);
            }
        }
    }

    public void drawPlayer(Graphics g) {
        int x = playerCol * tileSize;
        int y = playerRow * tileSize;

        g.setColor(Color.BLUE);
        g.fillOval(x + 5, y + 5, tileSize - 10, tileSize - 10);
    }

    public void movePlayer(int rowChange, int colChange) {
        int newRow = playerRow + rowChange;
        int newCol = playerCol + colChange;

        if (map[newRow][newCol] != '#') {
            playerRow = newRow;
            playerCol = newCol;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            movePlayer(-1, 0);
        } else if (key == KeyEvent.VK_S) {
            movePlayer(1, 0);
        } else if (key == KeyEvent.VK_A) {
            movePlayer(0, -1);
        } else if (key == KeyEvent.VK_D) {
            movePlayer(0, 1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // not used yet
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // not used yet
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(420, 440);
        window.setContentPane(new MysteryDungeon());
        window.setVisible(true);
    }
}