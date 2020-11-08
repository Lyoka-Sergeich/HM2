package L3;

import java.util.Random;
import java.util.Scanner;

public class HWk3 {

    private static final char HUMAN_DOT = 'X';
    private static final char PC_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static int maxX;
    public static int maxY;
    public static int winSerie;

    public static char[][] field;

    public static void writeField() {
        maxX = maxY = 5;   //пока примем поле квадратным
        field = new char[maxY][maxX];

        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты через пробел: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x)); //&& - and / || - or
        field[y][x] = HUMAN_DOT;
    }

    public static void pcTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(maxX); // 0...5
            y = RANDOM.nextInt(maxY);
        } while (!isEmptyCell(y, x));
        field[y][x] = PC_DOT;
    }

    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

    public static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    public static boolean checkWin(char c) {

        int cnt;   //счётчик серии

        //проверка по строкам
        for(int y = 0; y < maxY; y++) {
            cnt = 0;
            for (int x = 0; x < maxX; x++) {
                if(field[y][x] == c) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie) return true;
        }
        //проверка по столбцам
        for(int x = 0; x < maxX; x++) {
            cnt = 0;
            for (int y = 0; y < maxY; y++) {
                if(field[y][x] == c) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie) return true;
        }
        //проверка по диагоналям
        //главная и параллельные снизу
        for (int i = 0; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(int x = 0; x < maxX-i; x++) {
                if(field[x+i][x] == c) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie) return true;
        }
        //параллельные сверху
        for (int i = 1; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(int x = 0; x < maxX-i; x++) {
                if(field[x][x+i] == c) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie) return true;
        }
        //побочная и параллельные снизу
        for (int i = 0; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(int x = 0; x < maxX-i; x++) {
                if(field[x+i][maxX-x-1] == c) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie) return true;
        }
        //параллельные сверху
        for (int i = 1; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(int x = 0; x < maxX-i; x++) {
                if(field[x][maxX-x-1-i] == c) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie) return true;
        }

        return false;
    }

    public static boolean isFullMap() {
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if(field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static void findMyAndEnemySerie(){

        int x, y;
        int cnt;   //счётчик серии
        //найти свою серию из 3 знаков и выбрать место для 4-го
        //проверка по строкам
        for(y = 0; y < maxY; y++) {
            cnt = 0;
            for (x = 0; x < maxX; x++) {
                if(field[y][x] == PC_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-1) {                                    //нашли
                for (x = 0; x < maxX; x++) {
                    if(field[y][x] == EMPTY_DOT){
                        field[y][x] = PC_DOT;  //поставили
                        return;                //уходим
                    }
                }

            }
        }
        //проверка по столбцам
        for(x = 0; x < maxX; x++) {
            cnt = 0;
            for (y = 0; y < maxY; y++) {
                if(field[y][x] == PC_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-1) {                                    //нашли
                for (y = 0; y < maxY; y++) {
                    if(field[y][x] == EMPTY_DOT){
                        field[y][x] = PC_DOT;  //поставили
                        return;                //уходим
                    }
                }
            }
        }
        //проверка по диагоналям
        //главная и параллельные снизу
        for (int i = 0; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(x = 0; x < maxX-i; x++) {
                if(field[x+i][x] == PC_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-1) {                                        //нашли
                for(x = 0; x < maxX-i; x++) {
                    if(field[x+i][x] == EMPTY_DOT){
                        field[x+i][x] = PC_DOT;  //поставили
                        return;                //уходим
                    }
                }
            }
        }
        //параллельные сверху
        for (int i = 1; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(x = 0; x < maxX-i; x++) {
                if(field[x][x+i] == PC_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-1) {                                        //нашли
                for(x = 0; x < maxX-i; x++) {
                    if(field[x][x+i] == EMPTY_DOT){
                        field[x][x+i] = PC_DOT;  //поставили
                        return;                //уходим
                    }
                }
            }
        }
        //побочная и параллельные снизу
        for (int i = 0; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(x = 0; x < maxX-i; x++) {
                if(field[x+i][maxX-x-1] == PC_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-1) {                                        //нашли
                for(x = 0; x < maxX-i; x++) {
                    if(field[x+i][maxX-x-1] == EMPTY_DOT){
                        field[x+i][maxX-x-1] = PC_DOT;  //поставили
                        return;                //уходим
                    }
                }
            }
        }
        //параллельные сверху
        for (int i = 1; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(x = 0; x < maxX-i; x++) {
                if(field[x][maxX-x-1-i] == PC_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-1) {                                        //нашли
                for(x = 0; x < maxX-i; x++) {
                    if(field[x][maxX-x-1-i] == EMPTY_DOT){
                        field[x][maxX-x-1-i] = PC_DOT;  //поставили
                        return;                //уходим
                    }
                }
            }
        }


//найти чужую серию из 2 знаков и выбрать место для своего
        //проверка по строкам
        for(y = 0; y < maxY; y++) {
            cnt = 0;
            for (x = 0; x < maxX; x++) {
                if(field[y][x] == HUMAN_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-2) {                 //нашли
                //ищем свободное место по соседству
                for (x = 0; x < maxX; x++) {
                    if((field[y][x] == EMPTY_DOT)&&
                            ((field[y][x-1] == HUMAN_DOT)||(field[y][x+1] == HUMAN_DOT))){
                        field[y][x] = PC_DOT;      //поставили
                        return;                    //уходим
                    }
                }
            }
        }
        //проверка по столбцам
        for(x = 0; x < maxX; x++) {
            cnt = 0;
            for (y = 0; y < maxY; y++) {
                if(field[y][x] == HUMAN_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-2) {                                    //нашли
                for (y = 0; y < maxY; y++) {
                    if((field[y][x] == EMPTY_DOT)&&
                            ((field[y-1][x] == HUMAN_DOT)||(field[y+1][x] == HUMAN_DOT))){
                        field[y][x] = PC_DOT;      //поставили
                        return;                    //уходим
                    }
                }
            }
        }
        //проверка по диагоналям
        //главная и параллельные снизу
        for (int i = 0; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(x = 0; x < maxX-i; x++) {
                if(field[x+i][x] == HUMAN_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-2) {                                        //нашли
                for(x = 0; x < maxX-i; x++) {
                    if((field[x+i][x] == EMPTY_DOT)&&
                            ((field[x+i-1][x-1] == HUMAN_DOT)||(field[x+i+1][x+1] == HUMAN_DOT))){
                        field[x+i][x] = PC_DOT;      //поставили
                        return;                    //уходим
                    }
                }
            }
        }
        //параллельные сверху
        for (int i = 1; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(x = 0; x < maxX-i; x++) {
                if(field[x][x+i] == HUMAN_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-2) {                                        //нашли
                for(x = 0; x < maxX-i; x++) {
                    if((field[x][x+i] == EMPTY_DOT)&&
                            ((field[x-1][x+i-1] == HUMAN_DOT)||(field[x+1][x+i+1] == HUMAN_DOT))){
                        field[x][x+i] = PC_DOT;      //поставили
                        return;                    //уходим
                    }
                }
            }
        }
        //побочная и параллельные снизу
        for (int i = 0; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(x = 0; x < maxX-i; x++) {
                if(field[x+i][maxX-x-1] == HUMAN_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-2) {                                        //нашли
                for(x = 0; x < maxX-i; x++) {
                    if((field[x+i][maxX-x-1] == EMPTY_DOT)&&
                            ((field[x+i+1][maxX-x-1-1] == HUMAN_DOT)||(field[x+i-1][maxX-x-1+1] == HUMAN_DOT))){
                        field[x+i][maxX-x-1] = PC_DOT;      //поставили
                        return;                    //уходим
                    }
                }
            }
        }
        //параллельные сверху
        for (int i = 1; i < maxX - winSerie + 1; i++) {
            cnt = 0;
            for(x = 0; x < maxX-i; x++) {
                if(field[x][maxX-x-1-i] == HUMAN_DOT) cnt++;
                else cnt = 0;
            }
            if(cnt >= winSerie-2) {                                        //нашли
                for(x = 0; x < maxX-i; x++) {
                    if((field[x][maxX-x-1-i] == EMPTY_DOT)&&
                            ((field[x+1][maxX-x-1-i-1] == HUMAN_DOT)||(field[x-1][maxX-x-1-i+1] == HUMAN_DOT))){
                        field[x][maxX-x-1-i] = PC_DOT;      //поставили
                        return;                    //уходим
                    }
                }
            }
        }
        //если таких серий ещё нет
        pcTurn();
    }


    public static void main(String[] args) {
        writeField();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Человек выиграл!!!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья");
                break;
            }
            System.out.println();
            findMyAndEnemySerie();
            printMap();
            if (checkWin(PC_DOT)) {
                System.out.println("Компьютер выиграл!!! $(((");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья");
                break;
            }
            System.out.println();
        }
    }


}
