/**
 * Created by alekseyananyev on 27.12.15.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class SamplePanelFrame extends Frame {
    public String[] nameOfSample;
    CheckPanel checkPanel;

    SamplePanelFrame(int x, int y, String[] samples) {
        int winXPos, winYPos, winXSize = x, winYSize = y;
        checkPanel = new CheckPanel(0, 0, winXSize, winYSize, samples);

        nameOfSample = samples;
// параметры фрейма
        setTitle("Графические примеры");
// центрирование панели
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        winXPos = (dim.width - winXSize) / 2;
        winYPos = (dim.height - winYSize) / 2;

        setBounds(winXPos, winYPos, winXSize, winYSize);
        setBackground(Color.lightGray);
        setLayout(null);

        Font f = new Font("Arial", Font.BOLD, 12);  // Определение шрифта
        setFont(f);

        add(checkPanel);
// обработчик закрытия окна
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ve) {
                System.exit(0);
            }
        });

        checkPanel.btnOK.addActionListener(new btnOKPressed());
        checkPanel.btnCancel.addActionListener(new btnCancelPressed());

        setResizable(false);
        setVisible(true);
    }

    class btnOKPressed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String choiseAtSample = checkPanel.choiseSample.getSelectedCheckbox().getLabel();
            System.out.println("Choised:" + choiseAtSample);
// Вызов процедур
            if(choiseAtSample == nameOfSample[0])
                new MyFrame(100, 100);
            else if(choiseAtSample == nameOfSample[1])
                new MyFrameAWT(100, 100);
            else if(choiseAtSample == nameOfSample[2])
                new PlotFrame(400, 500);
            else if(choiseAtSample == nameOfSample[3])
                new CalculatorFrame();
        }
    }

    class btnCancelPressed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}

class CheckPanel extends Panel {
    public CheckboxGroup choiseSample;
    public Checkbox[] sampleNameCB;
    public Button btnOK, btnCancel;

    CheckPanel(int x, int y, int widthCP, int heightCP, String[] samples) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setLayout(null);

        setBounds(4, 4, widthCP - 8, heightCP - 8);
        setBackground(Color.gray);

        choiseSample = new CheckboxGroup();
        sampleNameCB = new Checkbox[4];
// сформировать чекбокс
        for(int i = 0; i < samples.length; i++) {
            sampleNameCB[i] = new Checkbox(samples[i], choiseSample, i == 0);
            sampleNameCB[i].setBounds(100, 50 + i * 30, 200, 30);
            add(sampleNameCB[i]);
        }
// кнопки
        btnOK = new Button("OK");
        btnCancel = new Button("Cancel");
// размеры кнопок
        btnOK.setBounds(widthCP / 2 - 110, heightCP - 50, 100, 30);
        btnCancel.setBounds(widthCP / 2 + 10, heightCP - 50, 100, 30);
// поместить на панель
        add(btnOK);
        add(btnCancel);
    }
}
