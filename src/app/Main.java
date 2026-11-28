
package app;

import ui.MainFrame;
import ui.ChatPanel;

public class Main {

    public static void main(String[] args) {

        MainFrame frame = new MainFrame();

        frame.add(new ChatPanel());

        frame.setVisible(true);
    }
}
