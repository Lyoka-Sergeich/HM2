package L7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

    private static final int MAINFORM_Width = 600;
    private static final int MAINFORM_Height = 600;
//    private static final int COORD_X = 600;
//    private static final int COORD_Y = 600;

    private Settings setsWindow;

    MainForm(){

//основные свойства
        setResizable(false);  //нет необходимости в изменении размера
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //определяем выход при закрытии

//геометрия
        setSize(MAINFORM_Width, MAINFORM_Height);  //устанавливаем размеры
//        setLocation(COORD_X,COORD_Y);
        setLocationRelativeTo(null);  //if ((c == null) || (componentWindow == null)) устанавливаем по центру экрана
//заголовок и обрамление
        setTitle("Добро пожаловать в ИГРУ!!!");  //заголовок
        setsWindow = new Settings(this);  //создаём производную форму


        JPanel panelBUTTON = new JPanel();                     //создаём панель для кнопок
        panelBUTTON.setLayout(new GridLayout(1,2));  //делим панель
        JButton btnBegin = new JButton("НАЧНЁМ");         //создаём кнопки
        JButton btnSettings = new JButton("НАСТРОИМ");
        btnSettings.addActionListener(new ActionListener() {  //определяем действие кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                setsWindow.setVisible(true);
            }
        });
        panelBUTTON.add(btnBegin);                             //добавляем кнопки
        panelBUTTON.add(btnSettings);

        JEditorPane panelTXT = new JEditorPane();              //создаём панель текста
        panelTXT.setText("Настройте поле");                    //задаём текст



        add(panelTXT);                          //рисуем
        add(panelBUTTON, BorderLayout.SOUTH);

        setVisible(true);  //показываем
    }
}
