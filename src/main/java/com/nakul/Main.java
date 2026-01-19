package com.nakul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
//        student.setsName("Nakul");
//        student.setsAge(40);
//        student.setRollNo(63);
        //System.out.println(student);



        SessionFactory st = new Configuration()
                .addAnnotatedClass(com.nakul.Student.class)
                .configure()
                .buildSessionFactory();             //cfg.buildSessionFactory();

        Session session = st.openSession();

        student = session.find(com.nakul.Student.class, 63);

        Transaction tx = session.beginTransaction();
        //session.merge(student);
        session.remove(student);
        tx.commit();

        session.close();
        st.close();
        System.out.println(student);
    }
}
