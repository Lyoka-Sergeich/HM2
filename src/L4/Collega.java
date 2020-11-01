package L4;

public class Collega {
    private String FIO;
    private String position;
    private int tel;
    private float salary;
    private int age;
    private int num;

    private static int t;



    Collega(){

    }
    public Collega(String FIO, String position, int tel, float salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
        this.num = t;
        t++;
    }
    public void describeCollega(String FIO, String position, int tel, float salary, int age){
        this.FIO = FIO;
        this.position = position;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    //методы чтения полей
    public String getFIO() {
        return FIO;
    }
    public String getposition() {
        return position;
    }
    public int gettel() { return tel; }
    public float getsalary() {
        return salary;
    }
    public int getage() {
        return age;
    }
    //повышение зарплаты
    public void upSalary() {
        if(this.age > 45) this.salary += 5000;
        return;
    }
}
