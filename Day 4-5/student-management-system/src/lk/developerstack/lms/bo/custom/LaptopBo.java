package lk.developerstack.lms.bo.custom;

import lk.developerstack.lms.dto.CreateLaptopDto;
import lk.developerstack.lms.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface LaptopBo {
    public void saveLaptop(CreateLaptopDto dto) throws SQLException, ClassNotFoundException;
}