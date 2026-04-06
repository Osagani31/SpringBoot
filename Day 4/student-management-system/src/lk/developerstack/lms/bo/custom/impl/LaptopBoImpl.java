package lk.developerstack.lms.bo.custom.impl;

import lk.developerstack.lms.bo.custom.LaptopBo;
import lk.developerstack.lms.dao.DaoFactory;
import lk.developerstack.lms.dao.custom.LaptopDao;
import lk.developerstack.lms.dto.CreateLaptopDto;
import lk.developerstack.lms.entity.Laptop;

import java.sql.SQLException;

public class LaptopBoImpl implements LaptopBo {
    LaptopDao laptopDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.LAPTOP);
    @Override
    public void saveLaptop(CreateLaptopDto dto) throws SQLException, ClassNotFoundException {
        Laptop laptop = new Laptop();
        laptop.setBrand(dto.getBrand());
        laptopDao.saveLaptopWithStudentId(dto.getStudentId(), laptop);
    }
}