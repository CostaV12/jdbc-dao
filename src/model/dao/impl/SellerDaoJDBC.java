package model.dao.impl;

import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT s.*,d.Name as DepName "
                    + "FROM seller AS s INNER JOIN department AS d "
                    + "ON s.DepartmentId = d.Id "
                    + "WHERE s.Id = ?");

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Department department = instantiateDepartment(resultSet);

                return instantiateSeller(resultSet, department);
            } else {
                return null;
            }


        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    private Seller instantiateSeller(ResultSet resultSet, Department department) throws SQLException {
        return new Seller(
                resultSet.getInt("Id"),
                resultSet.getString("Name"),
                resultSet.getString("Email"),
                resultSet.getDate("BirthDate").toLocalDate(),
                resultSet.getDouble("BaseSalary"),
                department);
    }

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
        return new Department(resultSet.getInt("DepartmentId"), resultSet.getString("DepName"));
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
