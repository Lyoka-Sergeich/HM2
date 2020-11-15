package L7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Settings extends JFrame {

    private static final int SETTINGS_Width = 500;
    private static final int SETTINGS_Height = 200;

    private static final int MIN = 3;
    private static final int MAX = 10;
    private static final int DEF = 5;

    private MainForm m;
    private JSlider sld;

    Settings(MainForm m){

//основные свойства
        setResizable(false);  //нет необходимости в изменении размера
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //определяем выход при закрытии
//геометрия
        setSize(SETTINGS_Width, SETTINGS_Height);  //устанавливаем размеры
        setLocationRelativeTo(null);  //if ((c == null) || (componentWindow == null)) устанавливаем по центру экрана
//заголовок и обрамление
        setTitle("Размер");  //заголовок
        setLayout(new GridLayout(2,1));
        setSLD();

        setVisible(false);  //показываем
    }

    private void setSLD(){

        JLabel lb = new JLabel("Length " + DEF);

        sld = new JSlider(MIN, MAX, DEF);
        sld.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lb.setText("Length " + sld.getValue());
            }
        });

        add(lb);
        add(sld);
    }
}
