package L4;

public class Main {

    public static void main(String[] args){

        //вывод с помощью методов
        Collega ob1 = new Collega("Mg","tyur",5,7,10);
        System.out.println(ob1.getFIO());
        System.out.println(ob1.getposition());
        //работа с массивом
        Collega[] list = new Collega[5];
        list[0] = new Collega("Худяков А.Н.","стажёр",5348,7000,25);
        list[1] = new Collega("Бродецкая А.П.","стажёр",5348,7000,21);
        list[2] = new Collega("Гордеева А.Ю.","младший научный сотрудник",5360,50000,32);
        list[3] = new Collega("Гилюк С.С.","завотделом",5377,70000,46);
        list[4] = new Collega("Антонов В.Н.","старший научный сотрудник",5381,65000,37);

        for (int i = 0; i < list.length; i++) {
            if(list[i].getage() > 40)
            System.out.println(list[i].getFIO() + " " + list[i].getposition() + " " + list[i].gettel()
                    + " " + list[i].getsalary() + " " + list[i].getage());
        }
        //повышение зарплаты
        for (int i = 0; i < list.length; i++) {
            list[i].upSalary();
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].getFIO() + " " + list[i].getposition() + " " + list[i].gettel()
                    + " " + list[i].getsalary() + " " + list[i].getage());
        }
    }
}
