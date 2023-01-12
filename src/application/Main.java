package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println("----- TESTE FindByID: -----");
        System.out.println(seller);

        System.out.println();

        System.out.println("----- TESTE FindByDepartment: -----");
        List<Seller> sellers = sellerDao.findByDepartment(2);
        for (Seller seller1 : sellers) {
            System.out.println(seller1);
        }

        System.out.println();

        System.out.println("----- TESTE FindAll: -----");
        sellers = sellerDao.findAll();
        for (Seller seller1 : sellers) {
            System.out.println(seller1);
        }
    }
}