package L5;

import java.util.Random;


public class Dog extends Animal{


    public static final Random RANDOM = new Random();
    //конструктор точный
    public Dog(String name, float maxForRun, float maxForSwim, float maxForJump){
        super(name, maxForRun, maxForSwim, maxForJump);
    }
    //конструктор рандомный
    public Dog(String name){
        super(name);
        float tmp = new Random().nextFloat();
        float sign = new Random().nextFloat();

        if(sign > 0.5f) {
            this.maxForRun = 500f + 100f*tmp;
            this.maxForSwim = 10f + 2f*tmp;
            this.maxForJump = 0.5f + 0.2f*tmp;
        }
        else {
            this.maxForRun = 500f - 100f*tmp;
            this.maxForSwim = 10f - 2f*tmp;
            this.maxForJump = 0.5f - 0.2f*tmp;
        }
    }

    @Override
    protected void run(float distance) {
        if(distance > maxForRun) System.out.println(name + ": дистанция слишком большая.");
        else System.out.println(name + ": дистанция преодолена.");
    }

    @Override
    protected void swim(float distance) {
        if(distance > maxForSwim) System.out.println(name + ": дистанция слишком большая.");
        else System.out.println(name + ": дистанция преодолена.");
    }

    @Override
    protected void jump(float distance) {
        if(distance > maxForJump) System.out.println(name + ": препятствие слишком большое.");
        else System.out.println(name + ": препятствие преодолено.");
    }

//    protected void move() {
//        System.out.println(name + " has moved "+ maxForJump);
//    }

}
