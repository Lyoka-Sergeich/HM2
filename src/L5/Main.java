package L5;

import java.util.Random;
import L5.Animal;

public class Main {

    public static void main(String[] args) {


        Dog d1 = new Dog("Буся");
        Dog d2 = new Dog("Волк");
        Cat c1 = new Cat("Вася");
        Cat c2 = new Cat("Тень");
        Horse h1 = new Horse("Яблоко");
        Bird b1 = new Bird("Пух");
        Animal[] zoo = {d1, d2, c1, c2, h1, b1};

        //d1.run(5);

        for (int i = 0; i < zoo.length; i++) {
            zoo[i].run(100f);
            zoo[i].swim(50f);
            zoo[i].jump(2.5f);
        }
        //zoo[0].run(5);
        //Animal[] zoo1 = new Animal[6];
        System.out.println("*******************************************");
        zoo[0] = new Dog("Док");
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].run(100f);
            zoo[i].swim(50f);
            if(zoo[i] instanceof Cat) System.out.println("И не надо.");
            zoo[i].jump(2.5f);
        }
        //Animal z1;
        //Animal z1 = new Dog("Буся");
    }
}
