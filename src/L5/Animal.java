package L5;

public abstract class Animal {

    protected String name;
    protected float maxForRun;
    protected float maxForSwim;
    protected float maxForJump;

    //конструктор точный
    public Animal(String name, float maxForRun, float maxForSwim, float maxForJump) {
        this.name = name;
        this.maxForRun = maxForRun;
        this.maxForSwim = maxForSwim;
        this.maxForJump = maxForJump;
    }
    //конструктор рандомный
    public Animal(String name) {
        this.name = name;
    }

    protected abstract void run(float distance);
    protected abstract void swim(float distance);
    protected abstract void jump(float distance);

    //protected abstract void move();
}
