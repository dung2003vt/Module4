package com.example.productthymeleaf.DAO;

import com.example.productthymeleaf.DAO.connection.MyConnection;
import com.example.productthymeleaf.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final Connection connection;
    private final String SELECT_ALL = "select * from product;";
    private final String SELECT_BY_ID = "select * from product where id = ?;";
    private final String INSERT_INTO = "insert into product(id,name,price,quantity,image) value (?,?,?,?,?);";
    private final String UPDATE_BY_ID = "update product set name = ?,price=?,quantity=?,image=? where id = ?;";
    private final String DELETE_BY_ID = "delete from product where id = ?";
    private final String SEARCH_BY_NAME = "select * from product where name like ?;";
    public ProductDAO() {
        connection = MyConnection.getConnection();
    }
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            convertResultSetToList(products, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    private void convertResultSetToList(List<Product> products , PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            Integer quantity = resultSet.getInt("quantity");
            String image= resultSet.getString("image");
            Product product = new Product(id,name, price, quantity, image);
            products.add(product);
        }
    }
    public Product findById(Long id) {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Integer quantity = resultSet.getInt("quantity");
                String image= resultSet.getString("image");
                product = new Product(id, name,price,quantity, image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    public void addProduct(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
