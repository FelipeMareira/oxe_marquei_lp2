package Model.DAO.impl;

import Db.DatabaseConnection;
import Model.DAO.PacientDAO;
import Model.Entities.Pacient;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacientDAOJDBC implements PacientDAO {
    private Connection conn;

    @Override
    public void insert(Pacient pacient) {
        String sql = "INSERT INTO PACIENT(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, createdAt, address, email, SIGTAP) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, pacient.getName());
            pstm.setString(2, pacient.getCPF());
            pstm.setString(3, pacient.getRG());
            pstm.setString(4, pacient.getPhoneNumber1());
            pstm.setString(5, pacient.getPhoneNumber2());
            pstm.setDate(6, Date.valueOf(pacient.getDateOfBirth()));
            pstm.setTimestamp(7, Timestamp.valueOf(pacient.getCreatedAt()));
            pstm.setString(8, pacient.getAddress());
            pstm.setString(9, pacient.getEmail());
            pstm.setString(10, pacient.getSIGTAP());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeConnection(conn);
        }
    }

    @Override
    public void update(Pacient pacient) {
        PreparedStatement pstm =  null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE PACIENT SET name = ?, phoneNumber1 = ?, phoneNumber2 = ?, address = ?, email = ? WHERE idPacient = ?"
            );

            pstm.setString(1, pacient.getName());
            pstm.setString(2, pacient.getPhoneNumber1());
            pstm.setString(3, pacient.getPhoneNumber2());
            pstm.setString(4, pacient.getAddress());
            pstm.setString(5, pacient.getEmail());
            pstm.setInt(6, pacient.getIdPacient());
            pstm.executeUpdate();
            System.out.println("FUNCIONOUUUU");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeConnection(conn);
        }
    }

    @Override
    public Pacient findById(Integer idCitizen) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PACIENT WHERE idPacient = ?");

            pstm.setInt(1, idCitizen);

            rs = pstm.executeQuery();

            if (rs.next()) {
                Pacient pacient = new Pacient();

                pacient.setIdPacient(rs.getInt("idPacient"));
                pacient.setName(rs.getString("name"));
                pacient.setCPF(rs.getString("CPF"));
                pacient.setRG(rs.getString("RG"));
                pacient.setPhoneNumber1(rs.getString("phoneNumber1"));
                pacient.setPhoneNumber2(rs.getString("phoneNumber2"));
                pacient.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                pacient.setAddress(rs.getString("address"));
                pacient.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                pacient.setEmail(rs.getString("email"));
                pacient.setSIGTAP(rs.getString("SIGTAP"));

                return pacient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Pacient> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PACIENT");
            rs = pstm.executeQuery();

            List<Pacient> listPacient = new ArrayList<>();

            while (rs.next()) {
                Pacient pacient = new Pacient();

                pacient.setIdPacient(rs.getInt("idPacient"));
                pacient.setName(rs.getString("name"));
                pacient.setCPF(rs.getString("CPF"));
                pacient.setRG(rs.getString("RG"));
                pacient.setPhoneNumber1(rs.getString("phoneNumber1"));
                pacient.setPhoneNumber2(rs.getString("phoneNumber2"));
                pacient.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                pacient.setAddress(rs.getString("address"));
                pacient.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                pacient.setEmail(rs.getString("email"));
                pacient.setSIGTAP(rs.getString("SIGTAP"));

                listPacient.add(pacient);
            }
            return listPacient;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeResultSet(rs);
        }
        return null;
    }
}