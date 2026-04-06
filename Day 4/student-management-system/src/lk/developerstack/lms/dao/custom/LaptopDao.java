package lk.developerstack.lms.dao.custom;

import lk.developerstack.lms.dao.CrudDao;
import lk.developerstack.lms.entity.Laptop;
import lk.developerstack.lms.entity.Student;

public interface LaptopDao extends CrudDao<Laptop, Long> {
    public void saveLaptopWithStudentId(long studentId, Laptop laptop);
}