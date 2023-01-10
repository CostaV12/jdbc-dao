package application;

import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Department department = new Department(1, "Computers");
        Seller seller = new Seller(1, "Bob Brown", "bob@gmail.com", LocalDate.now(), 2000.00, department);

        System.out.println(department);
        System.out.println(seller);
    }
}