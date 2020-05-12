import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUISimple extends Thread{
    FileReaderClass fromMyFile = new FileReaderClass();
    JTextArea textArea;
    private JScrollPane scroll;

    public GUISimple(String text, int x, int y) throws IOException {
        JFrame frm = new JFrame("Текст из файла");
        frm.setBounds(x, y, 1000, 700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frm.setLayout(null);
        textArea = new JTextArea(40,100);
        //textArea.setBounds(0, 0, 1000, 700);
        textArea.setEditable(false);
        scroll = new JScrollPane(textArea);
        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frm.add(scroll);
        frm.pack();
        frm.setVisible(true);
        //frm.add(textArea);



    }
}
