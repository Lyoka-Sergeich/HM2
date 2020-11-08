package L6;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args){

        int singleCharFile;
        FileInputStream fis1, fis2;
        FileOutputStream fos;
        StringBuilder sb1 = new StringBuilder();
        String fragment = "12345";

//прочесть 2 файла и записать в 3-й
        try {
            //читаем
            fis1 = new FileInputStream("text1.txt");
            while ((singleCharFile = fis1.read()) != -1) {
                sb1.append((char) singleCharFile);
            }
            sb1.append("\n");
            fis2 = new FileInputStream("text2.txt");
            while ((singleCharFile = fis2.read()) != -1) {
                sb1.append((char) singleCharFile);
            }
            //пишем
            fos = new FileOutputStream("text3.txt");
            byte[] b = (sb1.toString()).getBytes();
            fos.write(b);
            //закрываем
            fis1.close();
            fis2.close();
            fos.close();

            System.out.println(sb1.toString());   //содержимое результата
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

//поиск слова в файле
        try {
            //чистим буфер
            sb1.delete(0,sb1.length());
            //читаем
            fis1 = new FileInputStream("SearchZone.txt");
            while ((singleCharFile = fis1.read()) != -1) {
                sb1.append((char) singleCharFile);
            }
            //ищем
            if(findWordInBuffer(sb1, fragment)) System.out.println("fragment was found\n");
            else System.out.println("fragment was not found\n");

//            int lnf = fragment.length();
//            int ln = sb1.length() - fragment.length();
//            int i;
//            for (i = 0; i < ln; i++) {
//
//                if(fragment.equals(sb1.substring(i,i+lnf)) == true){
//                    System.out.println("fragment was found\n");
//                    break;
//                }
//
//            }
//            if(i == ln) System.out.println("fragment was not found\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

//поиск слова в папке
        //запрашиваем путь к папке программы
        String root = System.getProperty("user.dir");

        //определяем объект для каталога
        File folder = new File(root);
        File[] listOfFiles = folder.listFiles();

        //чистим буфер
        sb1.delete(0,sb1.length());
        for (File file : listOfFiles) {   //определяем объект для содержимого каталога, листаем содержимое
            if (file.isFile()) {          //если файл
                try {
                    //читаем
                    fis1 = new FileInputStream(file.getName());
                    while ((singleCharFile = fis1.read()) != -1) {
                        sb1.append((char) singleCharFile);
                    }
                    fis1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //ищем
        if(findWordInBuffer(sb1, fragment)) System.out.println("fragment was found\n");
        else System.out.println("fragment was not found\n");
    }

    public static boolean findWordInBuffer(StringBuilder s, String frag){

        int lnf = frag.length();
        int ln = s.length() - frag.length();
        int i;
        for (i = 0; i < ln; i++) {
            if(frag.equals(s.substring(i,i+lnf)) == true){
                return true;
            }
        }
        return false;
    }
}
