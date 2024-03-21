package Model.DAO.impl;

import Db.DatabaseConnection;
import Model.DAO.CitizenDAO;
import Model.Entities.Citizen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CitizenDAOJDBC implements CitizenDAO {
    public void insert(Citizen citizen) {
        String sql = "INSERT INTO citizen(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, createdAt, address, email, SIGTAP) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm =  null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, citizen.getName());
            pstm.setString(2, citizen.getCPF());
            pstm.setString(3, citizen.getRG());
            pstm.setString(4, citizen.getPhoneNumber1());
            pstm.setString(5, citizen.getPhoneNumber2());
            pstm.setObject(6, citizen.getDateOfBirth());
            pstm.setObject(7, citizen.getCreatedAt());
            pstm.setString(8, citizen.getAddress());
            pstm.setString(9, citizen.getEmail());
            pstm.setString(10, citizen.getSIGTAP());
            //pstm.execute();

            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                pstm.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    DatabaseConnection.closeConnection(conn);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Citizen citizen) {

    }

    public void deleteById(Integer id) {

    }

    public Citizen findById(Integer id) {
        return Citizen citizen;
    }

    public List<Citizen> findAll() {
        return List<Citizen> citizen;
    }
}
