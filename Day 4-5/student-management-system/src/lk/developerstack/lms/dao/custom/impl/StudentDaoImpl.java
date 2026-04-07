package lk.developerstack.lms.dao.custom.impl;

import lk.developerstack.lms.dao.custom.StudentDao;
import lk.developerstack.lms.entity.Student;
import lk.developerstack.lms.exceptions.NotFoundException;
import lk.developerstack.lms.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void save(Student student) throws SQLException, ClassNotFoundException {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Student student) throws SQLException, ClassNotFoundException {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            session.beginTransaction();
            String hql = "FROM Student WHERE id=:provideId";
            Query<Student> query =
                    session.createQuery(hql, Student.class);
            query.setParameter("provideId", student.getId());
            Student selectedStudent = query.uniqueResult();

            if (selectedStudent != null) {
                selectedStudent.setName(student.getName());
                selectedStudent.setContact(student.getContact());
                session.update(selectedStudent);
                session.getTransaction().commit();
                return;
            }
            throw new NotFoundException("Can't find Data");
        }
    }

    @Override
    public Student find(Long id) throws SQLException, ClassNotFoundException {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            String hql = "FROM Student WHERE id=:provideId";
            Query<Student> query =
                    session.createQuery(hql, Student.class);
            query.setParameter("provideId", id);
            return query.uniqueResult();
        }
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Student WHERE id=:selectedId");
            query.setParameter("selectedId", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Student> findAll() throws SQLException, ClassNotFoundException {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }
}
