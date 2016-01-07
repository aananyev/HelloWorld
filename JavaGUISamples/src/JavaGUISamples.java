/**
 * Created by alekseyananyev on 24.12.15.
 */

import java.awt.*;
import java.util.Random;

public class JavaGUISamples {
    public static void main(String args[]) {
        String[] nameOfSample = {"Простое окно", "Простое окно 1", "График функции", "Калькулятор"};
// Создание первого о
//        MyFrame frame = new MyFrame(100, 100);
//        MyFrameAWT frameAWT=new MyFrameAWT(100,100);

//        new PlotFrame(400, 500);
        new SamplePanelFrame(400, 250, nameOfSample);
    }
}