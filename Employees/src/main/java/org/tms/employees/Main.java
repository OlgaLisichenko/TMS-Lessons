package org.tms.employees;

public class Main {

    public static void main(String[] args) {

        //1. Необходимо создать 2 работника и 1 директора. Для каждого сотрудника распечатать полное имя сотрудника и его з/п
        System.out.println("__________ 1 __________");
        Worker worker1 = new Worker("Фёдор", "Фёдоров", 1);
        Worker worker2 = new Worker("Пётр", "Петров", 2);
        Director director1 = new Director("Дмитрий", "Дмитриев", 10);
        System.out.println(worker1);
        System.out.println(worker2);
        System.out.println(director1);

        //2. Назначить двух созданных сотрудников под управление директора. Распечатать сведения о директоре
        System.out.println("__________ 2 __________");
        director1.assignEmployee(worker1);
        director1.assignEmployee(worker2);
        System.out.println(director1);

        //3. Создать нового директора с одним сотрудником (под управлением) и добавить его под управления существующего директора
        System.out.println("__________ 3 __________");
        Worker worker3 = new Worker("Семён", "Семёнов", 4);
        Director director2 = new Director("Максим", "Максимов", 10);
        director2.assignEmployee(worker3);
        director1.assignEmployee(director2);
        System.out.println(director2);

        //4. Убедиться, что сведения о первом директоре теперь включают сведения о втором, который так же добавлен к нему
        System.out.println("__________ 4 __________");
        System.out.println(director1);

        //5. Создать сервис, который определяет есть ли у данного директора в подчинении сотрудник с указанным именем
        System.out.println("__________ 5 __________");
        SearchService service = new SearchService();
        System.out.println(service.searchByName(director1, director2)); //true
        System.out.println(service.searchByName(director2, worker1));   //false
        System.out.println(service.searchByName(director1, worker3));   //true
    }
}