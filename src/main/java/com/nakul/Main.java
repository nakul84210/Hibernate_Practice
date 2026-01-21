package com.nakul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Student student = new Student();
        // student.setsName("Nakul");
        // student.setsAge(40);
        // student.setRollNo(63);
        //System.out.println(student);

        Laptop l1 = new Laptop();
        l1.setLid(10);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(20);
        l2.setBrand("Macbook");
        l2.setModel("M4");
        l2.setRam(16);

        Laptop l3 = new Laptop();
        l3.setLid(30);
        l3.setBrand("HP");
        l3.setModel("Pavelion");
        l3.setRam(32);

        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setAname("Nakul");
        a1.setTech("Java");

        Alien a2 = new Alien();
        a2.setAid(2);
        a2.setAname("Ram");
        a2.setTech("Python");


        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l2));


        SessionFactory st = new Configuration()
                .addAnnotatedClass(com.nakul.Alien.class)
                .addAnnotatedClass(com.nakul.Laptop.class)
                .configure()
                .buildSessionFactory();             //cfg.buildSessionFactory();

        Session session = st.openSession();

       // student = session.find(com.nakul.Student.class, 63);

        Transaction tx = session.beginTransaction();
        //session.merge(student);
        //session.remove(student);
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        tx.commit();

        Alien a5 = session.find(Alien.class, 2);
        System.out.println(a5);

        session.close();
        st.close();
    }
}
