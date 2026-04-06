package lk.developerstack.lms.bo.custom;

import lk.developerstack.lms.dto.CreateLaptopDto;
import lk.developerstack.lms.dto.CustomRegistrationData;
import lk.developerstack.lms.dto.ProgramDto;
import lk.developerstack.lms.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface ProgramBo {
    public void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException;

    List<Long> findAllStudentIds();
    void register(long studentId, long programId);
    List<CustomRegistrationData> findAllRegistrations();
}