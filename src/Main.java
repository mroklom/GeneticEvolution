import helper.GUIHelper;
import view.Panel;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Panel panel = new Panel();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(600,800));
        GUIHelper.showOnFrame(panel,"test");

    }
}
