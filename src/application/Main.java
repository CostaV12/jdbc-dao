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

        System.out.println("----- TESTE findByID: -----");
        System.out.println(seller);

        System.out.println();

        System.out.println("----- TESTE findByDepartment: -----");
        List<Seller> sellers = sellerDao.findByDepartment(2);
        for (Seller seller1 : sellers) {
            System.out.println(seller1);
        }

        System.out.println();

        System.out.println("----- TESTE findAll: -----");
        sellers = sellerDao.findAll();
        for (Seller seller1 : sellers) {
            System.out.println(seller1);
        }

        System.out.println();

        System.out.println("----- TESTE insert: -----");

        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.0, new Department(2, null));
        sellerDao.insert(newSeller);
        System.out.println("New Seller, id = " + newSeller.getId());

        System.out.println();

        System.out.println("----- TESTE update: -----");

        Seller updateSeller = sellerDao.findById(9);
        updateSeller.setName("Vinicius Costa dos Santos");
        sellerDao.update(updateSeller);
        System.out.println("Updated seller");
    }
}