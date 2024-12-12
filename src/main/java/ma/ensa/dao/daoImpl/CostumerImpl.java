package ma.ensa.dao.daoImpl;

import ma.ensa.connexion.Connexion;
import ma.ensa.dao.CostumerDao;
import ma.ensa.entity.Custumer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CostumerImpl implements CostumerDao {
    private Connection con;
    public CostumerImpl() throws SQLException, ClassNotFoundException {
        Connexion connexion=new Connexion();
        this.con = connexion.getCon();
    }

    @Override
    public Custumer getCostumer(int id) throws SQLException {
        PreparedStatement ps = this.con.prepareCall("SELECT * FROM costumer WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Custumer custumer=new Custumer();
            custumer.setId(rs.getInt("id"));
            custumer.setName(rs.getString("nom"));
            custumer.setEmail(rs.getString("email"));
            custumer.setPhone(rs.getString("phone"));
            return custumer;



        }
        return null;
    }
}
