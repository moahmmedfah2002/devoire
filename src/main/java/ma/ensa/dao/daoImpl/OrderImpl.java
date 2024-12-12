package ma.ensa.dao.daoImpl;

import ma.ensa.connexion.Connexion;
import ma.ensa.dao.OrderDao;
import ma.ensa.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderImpl implements OrderDao {

    private Connection con;
    public OrderImpl() throws SQLException, ClassNotFoundException {
        Connexion connexion=new Connexion();
        this.con = connexion.getCon();
    }

    @Override
    public boolean addOrder(Order order) throws SQLException {
        PreparedStatement ps = this.con.prepareCall("Insert into orders(date,amount,costumer,statue) values(?,?,?,?)");
        ps.setDate(1,order.getDate());
        ps.setDouble(2,order.getAmount());
        ps.setDouble(3,order.getCostumer());
        ps.setBoolean(4,order.isStatue());
        return ps.executeUpdate()>0;

    }
}
