package L1;

public class Main {
    public static void main(String[] args) {
        //examples
        int ab = 2020;
        long kj = 666L;
        byte bt = 12;
        short sht = 278;

        float g = 382.5f;
        double db = 187.6d;

        char ch = 'Y';
        String word = "Hello!";

        boolean sign = true;


        //variants
        float a, b, c, d;
        a = 13f;
        b = 18.5f;
        c = 86f;
        d = 55f;

        int enter = 586;
        int year = 944;

        float resf;
        int resi;
        boolean resb;

        //вычисление
        resf = calc(a, b, c, d);
        System.out.println(resf);
        //сравнение суммы
        resb = compare(a, b);
        System.out.println(resb);
        //переворот
        resi = revers(enter);
        System.out.println(resi);
        //високостный год
        resb = calend(year);
        System.out.println(resb);


    }

    public static float calc(float a, float b, float c, float d) {

        return (a * (b + (c / d)));
    }

    public static boolean compare(float a, float b) {

        return (((a + b) >= 10) && ((a + b) <= 20));
    }

    public static int revers(int enter) {

        int num, exit = 0;

        if ((enter >= 100) && (enter <= 999)) {
            num = enter % 10;
            exit = num * 100;
            enter = enter / 10;
            num = enter % 10;
            exit = exit + num * 10;
            enter = enter / 10;
            exit = exit + enter;
        }
        return exit;
    }

    public static boolean calend(int year) {

        boolean result;

        if(year % 4 != 0){
            result = false;
        }
        else{
            if(year % 100 != 0){
                result = true;
            }
            else if(year % 400 != 0){
                result = false;
            }
            else result = true;
        }
        return result;
    }
}

