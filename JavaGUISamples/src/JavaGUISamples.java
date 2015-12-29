/**
 * Created by alekseyananyev on 24.12.15.
 */

import java.awt.*;
import java.util.Random;

public class JavaGUISamples {
    public static void main(String args[]) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Размер экрана:" + dim + dim.height + dim.width);
// Создание первого о
//        MyFrame frame = new MyFrame(100, 100);
//        MyFrameAWT frameAWT=new MyFrameAWT(100,100);

//        new PlotFrame(400, 500);
        new SamplePanelFrame(400, 300);
    }
}