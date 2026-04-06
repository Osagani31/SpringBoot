package lk.developerstack.lms.dao.custom;

import lk.developerstack.lms.dao.CrudDao;
import lk.developerstack.lms.entity.Program;
import lk.developerstack.lms.entity.Registration;
import lk.developerstack.lms.entity.Student;

import java.util.Date;
import java.util.List;

public interface ProgramDao extends CrudDao<Program, Long> {
    public List<Long> findAllProgramIds();
    void register(long studentId, long programId);
    List<Registration> findAllRegistrations();
}