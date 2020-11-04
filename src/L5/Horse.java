package L5;

import java.util.Random;

public class Horse extends Animal {
    //конструктор точный
    public Horse(String name, float maxForRun, float maxForSwim, float maxForJump){
        super(name, maxForRun, maxForSwim, maxForJump);
    }
    //конструктор рандомный
    public Horse(String name){
        super(name);
        float tmp = new Random().nextFloat();
        float sign = new Random().nextFloat();

        if(sign > 0.5f) {
            this.maxForRun = 1500f + 300f*tmp;
            this.maxForSwim = 100f + 15f*tmp;
            this.maxForJump = 3f + 0.5f*tmp;
        }
        else {
            this.maxForRun = 1500f + 300f*tmp;
            this.maxForSwim = 100f + 15f*tmp;
            this.maxForJump = 3f + 0.5f*tmp;
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
}
