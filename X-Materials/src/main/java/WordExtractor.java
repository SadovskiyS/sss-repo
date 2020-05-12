import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class WordExtractor{

    public static void main(String[] args) throws IOException {
        Notifier notifier = new Notifier();
        notifier.gui.textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("Space is pressed");
                    notifier.myresume();
                }
                if(e.getKeyCode() == KeyEvent.VK_ALT){
                    System.out.println("Alt is pressed");
                    notifier.mysuspend();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
