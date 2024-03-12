import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyEditor extends JFrame {

    private static final int WIDTH = 800;
    private static final int LENGTH = 800;

    private int cursorX = 0;
    private int cursorY = 0;

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
                System.out.println(cursorX);
                System.out.println(cursorY);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char keyChar = e.getKeyChar();
                System.out.println(keyChar);
            }
        });
    }

    public static void main(String[] args) {
        MyEditor editor = new MyEditor();
        editor.setVisible(true);
    }
}
