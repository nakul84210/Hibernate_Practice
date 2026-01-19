package com.nakul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

       // Student student = new Student();
//        student.setsName("Nakul");
//        student.setsAge(40);
//        student.setRollNo(63);
        //System.out.println(student);

        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Nakul");
        a1.setTech("Java");
        a1.setLaptop(l1);


        SessionFactory st = new Configuration()
                .addAnnotatedClass(com.nakul.Alien.class)
                .configure()
                .buildSessionFactory();             //cfg.buildSessionFactory();

        Session session = st.openSession();

       // student = session.find(com.nakul.Student.class, 63);

        Transaction tx = session.beginTransaction();
        //session.merge(student);
        //session.remove(student);
        session.persist(a1);
        tx.commit();

        session.close();
        st.close();
        System.out.println(a1);
    }
}
