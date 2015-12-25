import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * Created by alekseyananyev on 25.12.15.
 */

// Класс фрейма:
class MyFrameAWT extends Frame {
    public static int count=0; // Количество открытых окон
// Конструктор:
    MyFrameAWT(int a,int b){
        count++;                   // Количество открытых окон
        setTitle("Печенье под номером "+count);
        setLayout(null);        // Отключение менеджера размещения элементов
        Font f=new Font("Arial",Font.BOLD,11);  // Определение шрифта
        setFont(f);                             // Применение шрифта

        Button btn=new Button("Испечь печеньку");
        Button btnClose = new Button("Съесть всё печенье");

        btn.setBounds(50,50,200,30);  // Размеры и положение кнопки
        add(btn);                      // Добавление кнопки
        setBounds(a,b,300,200);        // Положение и размер окна

        btnClose.setBounds(50,100, 200, 30);
        add(btnClose);
// Регистрация обработчика в окне:
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ve) {
                System.exit(0);
            }               // Закрытие окна
        });
// Регистрация обработчика в кнопке:
        btn.addActionListener(new ButtonPressed());
        btnClose.addActionListener(new ButtonClosePressed());

        setVisible(true);              // Отображение окна
    }
}
// Класс обработчика для кнопки:
class ButtonPressed implements ActionListener {
    private Random rnd;
    // Конструктор:
    ButtonPressed(){
        rnd = new Random();
    }
    public void actionPerformed(ActionEvent ae){
// Создание окна со случайным положением на экране:
        new MyFrameAWT(rnd.nextInt(800),rnd.nextInt(500));
    }
}

class ButtonClosePressed implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
}

class FrameAndButtonAWT{
    public static void main(String args[]){
// Создание первого окна:
        MyFrameAWT frame=new MyFrameAWT(100,100);
    }
}
