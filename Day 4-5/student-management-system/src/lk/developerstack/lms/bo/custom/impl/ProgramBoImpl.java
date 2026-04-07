package lk.developerstack.lms.bo.custom.impl;

import lk.developerstack.lms.bo.custom.ProgramBo;
import lk.developerstack.lms.dao.DaoFactory;
import lk.developerstack.lms.dao.custom.ProgramDao;
import lk.developerstack.lms.dto.CustomRegistrationData;
import lk.developerstack.lms.dto.ProgramDto;
import lk.developerstack.lms.entity.Program;
import lk.developerstack.lms.entity.Registration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramBoImpl implements ProgramBo {
    private final ProgramDao programDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.PROGRAM);
    @Override
    public void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException {
        // MapStruct, model mapper
        Program program = new Program();
        program.setTitle(dto.getTitle());
        program.setCredit(dto.getCredit());
        programDao.save(program);
    }

    @Override
    public List<Long> findAllStudentIds() {
        return programDao.findAllProgramIds();
    }

    @Override
    public void register(long studentId, long programId) {
        programDao.register(studentId,programId);
    }

    @Override
    public List<CustomRegistrationData> findAllRegistrations() {

        List<CustomRegistrationData> data = new ArrayList<>();
        for (Registration temp:programDao.findAllRegistrations()
        ) {
            data.add(
                    new CustomRegistrationData(
                            temp.getRegDate(),
                            temp.getStudent().getName(),
                            temp.getProgram().getTitle()

                    )
            );
        }

        return data;
    }
}