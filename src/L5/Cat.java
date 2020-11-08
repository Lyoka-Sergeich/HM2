package L5;

import java.util.Random;

public class Cat extends Animal{
    //конструктор точный
    public Cat(String name, float maxForRun, float maxForSwim, float maxForJump){
        super(name, maxForRun, maxForSwim, maxForJump);
    }
    //конструктор рандомный
    public Cat(String name){
        super(name);
        float tmp = new Random().nextFloat();
        float sign = new Random().nextFloat();

        if(sign > 0.5f) {
            this.maxForRun = 200f + 30f*tmp;
            this.maxForJump = 2f + 0.3f*tmp;
        }
        else {
            this.maxForRun = 200f - 30f*tmp;
            this.maxForJump = 2f - 0.3f*tmp;
        }
        this.maxForSwim = 0;
    }

    @Override
    protected void run(float distance) {
        if(distance > maxForRun) System.out.println(name + ": дистанция слишком большая.");
        else System.out.println(name + ": дистанция преодолена.");
    }

    @Override
    protected void swim(float distance) {
        System.out.println(name + ": коты не плавают.");
    }

    @Override
    protected void jump(float distance) {
        if(distance > maxForJump) System.out.println(name + ": препятствие слишком большое.");
        else System.out.println(name + ": препятствие преодолено.");
    }

}
