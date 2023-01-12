package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();


        System.out.println("---TEST: INSERT---");
        Department department = new Department(null, "RH");
        departmentDao.insert(department);
        System.out.println("Id: " + department.getId());

        System.out.println("---TEST: UPDATE---");
        department.setName("People");
        departmentDao.update(department);
        System.out.println("Updated");

        System.out.println("---TEST: DELETE---");
        departmentDao.deleteById(5);
        System.out.println("Deleted");

        System.out.println("---TEST: FIND BY ID---");
        department = departmentDao.findById(6);
        System.out.println(department);

        System.out.println("---TEST: FIND ALL---");
        List<Department> departments = departmentDao.findAll();
        for (Department department1 : departments) {
            System.out.println(department1);
        }

    }
}