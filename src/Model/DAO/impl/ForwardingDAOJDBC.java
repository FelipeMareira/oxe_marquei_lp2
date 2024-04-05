package Model.DAO.impl;

import Db.DatabaseConnection;
import Model.DAO.ForwardingDAO;
import Model.Entities.Pacient;
import Model.Entities.Forwarding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForwardingDAOJDBC implements ForwardingDAO {
    private Connection conn;

    @Override
    public void insert(Forwarding forwarding) {
        PreparedStatement pstm = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(
                    "INSERT INTO FORWARDING(CRM, request, nameOfRequestDoctor, idPacient) VALUES (?, ?, ?, ?)"
            );

            pstm.setString(1, forwarding.getCRM());
            pstm.setString(2, forwarding.getRequest());
            pstm.setString(3, forwarding.getNameOfRequestDoctor());
            pstm.setInt(4, forwarding.getPacient().getIdPacient());

            pstm.execute();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closeStatement(pstm);
        }
    }

    @Override
    public Forwarding findById(Integer idForwarding) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT f.* FROM FORWARDING f INNER JOIN PACIENT p ON f.idPacient = p.idPacient WHERE f.idForwarding = ?"
            );
            pstm.setInt(1, idForwarding);
            rs = pstm.executeQuery();

            if (rs.next()) {
                Forwarding forwarding = new Forwarding();
                Pacient pacient = new Pacient();
                pacient.setIdPacient(rs.getInt("idPacient"));

                forwarding.setIdForwarding(rs.getInt("idForwarding"));
                forwarding.setCRM(rs.getString("CRM"));
                forwarding.setRequest(rs.getString("request"));
                forwarding.setNameOfRequestDoctor(rs.getString("nameOfRequestDoctor"));
                forwarding.setPacient(pacient);

                return forwarding;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Forwarding> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT f.* FROM FORWARDING f INNER JOIN PACIENT p ON f.idPacient = p.idPacient"
            );
            rs = pstm.executeQuery();

            List<Forwarding> listForwarding = new ArrayList<>();

            while (rs.next()) {
                Forwarding forwarding = new Forwarding();
                Pacient pacient = new Pacient();
                pacient.setIdPacient(rs.getInt("idPacient"));

                forwarding.setIdForwarding(rs.getInt("idForwarding"));
                forwarding.setCRM(rs.getString("CRM"));
                forwarding.setRequest(rs.getString("request"));
                forwarding.setNameOfRequestDoctor(rs.getString("nameOfRequestDoctor"));
                forwarding.setPacient(pacient);

                listForwarding.add(forwarding);
            }
            return listForwarding;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeResultSet(rs);
        }
        return null;
    }
}
