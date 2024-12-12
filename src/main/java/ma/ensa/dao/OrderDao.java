package ma.ensa.dao;

import ma.ensa.entity.Order;

import java.sql.SQLException;

public interface OrderDao {
    public boolean addOrder(Order order) throws SQLException;
}
