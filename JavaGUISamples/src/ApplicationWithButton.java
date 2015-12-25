/**
 * Created by alekseyananyev on 24.12.15.
 */
// Подключение пакетов:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class RandomMinMax extends Random {
    int nextInt(int max, int min) {
        if( min > max) {
            int a = min;
            min = max;
            max = a;
        }

        int returnData = nextInt(max);

        while (returnData < min) {
            returnData = nextInt(max);
        }

        System.out.println("returnData:" + returnData);
        return returnData;
    }
}

// Класс фрейма:
class MyFrame extends JFrame{
    // Счетчик окон:
    public static int count=0;
    RandomMinMax rnd1 = new RandomMinMax();

    // Конструктор:
    MyFrame(int a,int b){
        count++;  // Количество открытых окон
// Название окна:
        setTitle("Печенье под номером "+count);
// Создание панели:
        MyPanel panel=new MyPanel();
        setSize(rnd1.nextInt(300,200),rnd1.nextInt(300,100)); // Размер окна
// Закрытие окна:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(a,b);  // Положение окна
        add(panel);        // Добавление панели
        setVisible(true);  // Отображение окна
    }
}
// Класс панели:
class MyPanel extends JPanel{
    // Конструктор:
    MyPanel(){
// Создание кнопки:
        JButton button = new JButton("Создать новое окно");
        JButton button_close = new JButton("Close");

        add(button);          // Добавление кнопки на панель
        add(button_close);

        button.addActionListener(listener);
        button_close.addActionListener(listener_close);
    } // Регистрация обработчика
    // Обработчик для кнопки - объект анонимного класса:
    ActionListener listener=new ActionListener(){
        public void actionPerformed(ActionEvent event){
            Random rnd=new Random();
// Создание окна со случайными координатами размещения на экране:
            MyFrame frame=new MyFrame(rnd.nextInt(800),rnd.nextInt(500));
        }
    };

    ActionListener listener_close=new ActionListener(){
        public void actionPerformed(ActionEvent event_close) {
            System.exit(0);
        }
    };
}
