package com.ovationtix.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected <T> T get(Class<T> theClass, Long id) {
		return theClass.cast(getSession().get(theClass, id));
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Query createQuery(String hql) {
		return getSession().createQuery(hql);
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> list(Query query) {
		return query.list();
	}

}
