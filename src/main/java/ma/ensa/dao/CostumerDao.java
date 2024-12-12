package ma.ensa.dao;

import ma.ensa.entity.Custumer;

import java.sql.SQLException;

public interface CostumerDao {
    public Custumer getCostumer(int id) throws SQLException;
}
