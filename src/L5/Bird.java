package L5;

import java.util.Random;

public class Bird extends Animal {
    //конструктор точный
    public Bird(String name, float maxForRun, float maxForSwim, float maxForJump){
        super(name, maxForRun, maxForSwim, maxForJump);
        this.maxForSwim = 0;
    }
    //конструктор рандомный
    public Bird(String name){
        super(name);
        float tmp = new Random().nextFloat();
        float sign = new Random().nextFloat();

        if(sign > 0.5f) {
            this.maxForRun = 5f + 1f*tmp;
            this.maxForJump = 0.2f + 0.1f*tmp;
        }
        else {
            this.maxForRun = 5f - 1f*tmp;
            this.maxForJump = 0.2f - 0.1f*tmp;
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
        System.out.println(name + ": птицы не плавают.");
    }

    @Override
    protected void jump(float distance) {
        if(distance > maxForJump) System.out.println(name + ": препятствие слишком большое.");
        else System.out.println(name + ": препятствие преодолено.");
    }
}
