package com.nakul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setsName("Ram");
        student.setsAge(12);
        student.setRollNo(21);
        //System.out.println(student);


        SessionFactory st = new Configuration()
                .addAnnotatedClass(com.nakul.Student.class)
                .buildSessionFactory();             //cfg.buildSessionFactory();
        Session session = st.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(student);
        tx.commit();
        session.close();
        st.close();
        System.out.println(student);
    }
}
