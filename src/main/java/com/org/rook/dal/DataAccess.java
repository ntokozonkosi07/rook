/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.rook.dal;

import com.org.rook.model.Accident;
import com.org.rook.model.Location;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author ntokozo-nkosi
 */
public class DataAccess {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
    }

    public Integer createAccident(Accident a) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + a.toString());
        return a.getId();
    }
    
    public List<Accident> getAccidents() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Accident> accidents = session.createQuery("FROM Accident").list();
		session.close();
		System.out.println("Found " + accidents.size() + " Accidents");
		return accidents;

	}

    public Integer createLocation(Location loc) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(loc);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + loc.toString());
        return loc.getId();
    }

}
