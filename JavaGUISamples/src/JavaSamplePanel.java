/**
 * Created by alekseyananyev on 27.12.15.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class SamplePanelFrame extends Frame {
    SamplePanelFrame(int x, int y) {
        int winXPos, winYPos, winXSize = x, winYSize = y;
// параметры фрейма
        setTitle("Графические примеры");
// центрирование панели
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        winXPos = (dim.width - winXSize) / 2;
        winYPos = (dim.height - winYSize) / 2;

        setBounds(winXPos, winYPos, winXSize, winYSize);
        setBackground(Color.cyan);
//        setLayout(null);

        Font f = new Font("Arial", Font.BOLD, 11);  // Определение шрифта
        setFont(f);

        CheckPanel checkPanel = new CheckPanel(winXPos, winYPos, winXSize, winYSize);
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
}

class CheckPanel extends Panel {
    public CheckboxGroup choiseSample;
    public Checkbox[] sampleNameCB;
    public Button btnOK, btnCancel;

    CheckPanel(int widthCP, int heightCP, int x, int y) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setLayout(null);

        setBounds(widthCP - 8, heightCP - 8, 4, 4);
        setBackground(Color.green);
//        setLayout(null);

        choiseSample = new CheckboxGroup();
        sampleNameCB = new Checkbox[3];

        sampleNameCB[0] = new Checkbox("Простое окно", choiseSample, true);
        sampleNameCB[1] = new Checkbox("Простое окно 1", choiseSample, false);
        sampleNameCB[2] = new Checkbox("График", choiseSample, false);

        sampleNameCB[0].setBounds(30, 5, 5, 5);

        add(sampleNameCB[0]);
        add(sampleNameCB[1]);
        add(sampleNameCB[2]);

        btnOK = new Button("OK");
        btnCancel = new Button("Cancel");

//        btnOK.setBounds(getWidth()/2-110, heightCP - 20, 100, 30);
        btnCancel.setBounds(dim.width / 2, heightCP - 20, 100, 30);

        add(btnOK);
        add(btnCancel);
    }
}

class btnOKPressed implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

class btnCancelPressed implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
