package org.tms.hibernate.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
@Data
public abstract class SessionService {

    private final SessionFactory factory;
    private Session session;

    public Session openSession() {
        session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public void closeSession() {
        Transaction transaction = session.getTransaction();
        transaction.commit();
        session.close();
    }
}