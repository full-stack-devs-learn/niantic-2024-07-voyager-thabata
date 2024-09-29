package com.niantic.services;

import com.niantic.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class MySqlProductDao implements ProductDao {
    private final JdbcTemplate jdbcTemplate;

    public MySqlProductDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource() {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        String sql = "SELECT product_id, product_name, category_id, unit_price FROM products WHERE category_id = ?";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            return new Product(
                    resultSet.getInt("product_id"),
                    resultSet.getString("product_name"),
                    resultSet.getInt("category_id"),
                    resultSet.getDouble("unit_price")
            );
        }, categoryId);
    }

    @Override
    public Product getProductById(int productId) {
        String sql = "SELECT product_id, product_name, category_id, unit_price FROM products WHERE product_id = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
            return new Product(
                    resultSet.getInt("product_id"),
                    resultSet.getString("product_name"),
                    resultSet.getInt("category_id"),
                    resultSet.getDouble("unit_price")
            );
        }, productId);
    }

    @Override
    public Product addProduct(Product product) {
        String sql = "INSERT INTO products (product_name, category_id, unit_price) VALUES (?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getCategoryId());
            ps.setDouble(3, product.getPrice());
            return ps;
        }, keyHolder);
        int newId = keyHolder.getKey().intValue();
        return getProductById(newId);
    }

    @Override
    public void updateProduct(int productId, Product product) {
        String sql = "UPDATE products SET product_name = ?, category_id = ?, unit_price = ? WHERE product_id = ?";
        jdbcTemplate.update(sql, product.getProductName(), product.getCategoryId(), product.getPrice(), productId);
    }

    @Override
    public void deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE product_id = ?";
        jdbcTemplate.update(sql, productId);
    }
}