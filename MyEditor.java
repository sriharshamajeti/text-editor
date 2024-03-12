import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyEditor extends JFrame {

    private static final int WIDTH = 800;
    private static final int LENGTH = 800;
    private static final int MARGIN = 20;

    private int cursorX = 0;
    private int cursorY = 0;

    StringBuilder text = new StringBuilder();

    public MyEditor() {
        setTitle("My Test Editor");
        setSize(WIDTH, LENGTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cursorX = e.getX();
                cursorY = e.getY();
                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char keyChar = e.getKeyChar();
                if(Character.isDefined(keyChar)) {
                    text.insert(text.length(), keyChar);
                    repaint();
                }
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D)  g;
        g2D.setFont(new Font("Serif", Font.PLAIN, 24));
        int x = MARGIN;
        int y = MARGIN + g2D.getFontMetrics().getHeight();
        for (String line : text.toString().split("\n")) {
            g2D.drawString(line, x, y);
            y += g2D.getFontMetrics().getHeight();
        }

        g2D.drawLine(cursorX, cursorY, cursorX, cursorY + g2D.getFontMetrics().getHeight());
    }

    public static void main(String[] args) {
        MyEditor editor = new MyEditor();
        editor.setVisible(true);
    }
}
