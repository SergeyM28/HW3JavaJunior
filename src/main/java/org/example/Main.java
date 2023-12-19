package org.example;

//Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
//Обеспечьте поддержку сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными.
//Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла. Выведите все поля объекта,
//включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.

import java.io.*;

//2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Harry Potter", 13, 4.5);

        try(FileOutputStream fileOutputStream = new FileOutputStream("students.txt")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            System.out.println(student.getName() + " успешно сериализован");
        }

        try(FileInputStream fileInputStream = new FileInputStream("students.txt")){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student student2 = (Student) objectInputStream.readObject();
            System.out.println(student2.getName() + " успешно десериализован");
            System.out.println(student2); // поле GPA помечено transient, поэтому оно не было сохранено и не было восстановлено
        }



    }
}