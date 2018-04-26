package by.htp.car_catalog.dao.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.domain.User;

public class UserDaoHibernateImpl implements UserDao {

	@Override
	public void create(User entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();

	}

	@Override
	public User read(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();

		return (User) session.load(User.class, id);
	}

	@Override
	public List<User> readAll() {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<User> users = session.createCriteria(User.class).list();

		return users;
	}

	@Override
	public void update(User entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();

	}

	@Override
	public void delete(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(new User(id));
		session.getTransaction().commit();

	}

}
