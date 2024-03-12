import javax.swing.*;

public class MyEditor extends JFrame {

    private static final int WIDTH = 800;
    private static final int LENGTH = 800;

    public MyEditor() {
        setTitle("My Test Editor");
        setSize(WIDTH, LENGTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MyEditor editor = new MyEditor();
        editor.setVisible(true);
    }
}
