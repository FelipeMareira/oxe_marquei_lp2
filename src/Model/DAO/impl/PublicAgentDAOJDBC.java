package Model.DAO.impl;

import Db.DatabaseConnection;
import Model.DAO.PublicAgentDAO;
import Model.Entities.PublicAgent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublicAgentDAOJDBC implements PublicAgentDAO {
    private Connection conn;

    @Override
    public void insert(PublicAgent publicAgent) {
        String sql = "INSERT INTO PUBLIC_AGENT(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, createdAt, address, email, userr, password, typeUser) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, publicAgent.getName());
            pstm.setString(2, publicAgent.getCPF());
            pstm.setString(3, publicAgent.getRG());
            pstm.setString(4, publicAgent.getPhoneNumber1());
            pstm.setString(5, publicAgent.getPhoneNumber2());
            pstm.setDate(6, Date.valueOf(publicAgent.getDateOfBirth()));
            pstm.setTimestamp(7, Timestamp.valueOf(publicAgent.getCreatedAt()));
            pstm.setString(8, publicAgent.getAddress());
            pstm.setString(9, publicAgent.getEmail());
            pstm.setString(10, publicAgent.getUser());
            pstm.setString(11, publicAgent.getPassword());
            pstm.setString(12, publicAgent.getTypeUser());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeConnection(conn);
        }
    }

    @Override
    public void update(PublicAgent publicAgent) {
        PreparedStatement pstm =  null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE PUBLIC_AGENT SET name = ?, phoneNumber1 = ?, phoneNumber2 = ?, address = ?, email = ?, password = ? WHERE idPublicAgent = ?"
            );

            pstm.setString(1, publicAgent.getName());
            pstm.setString(2, publicAgent.getPhoneNumber1());
            pstm.setString(3, publicAgent.getPhoneNumber2());
            pstm.setString(4, publicAgent.getAddress());
            pstm.setString(5, publicAgent.getEmail());
            pstm.setString(6, publicAgent.getPassword());
            pstm.setInt(6, publicAgent.getIdPublicAgent());
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
    public void deleteById(Integer idPublicAgent) {
        PreparedStatement pstm = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement("DELETE FROM PUBLIC_AGENT WHERE idPublicAgent = ?");

            pstm.setInt(1, idPublicAgent);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closeStatement(pstm);
        }
    }

    @Override
    public PublicAgent findById(Integer idPublicAgent) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM citizen WHERE idCitizen = ?");

            pstm.setInt(1, idPublicAgent);

            rs = pstm.executeQuery();

            if (rs.next()) {
                PublicAgent publicAgent = new PublicAgent();

                publicAgent.setIdPublicAgent(rs.getInt("idPublicAgent"));
                publicAgent.setName(rs.getString("name"));
                publicAgent.setCPF(rs.getString("CPF"));
                publicAgent.setRG(rs.getString("RG"));
                publicAgent.setPhoneNumber1(rs.getString("phoneNumber1"));
                publicAgent.setPhoneNumber2(rs.getString("phoneNumber2"));
                publicAgent.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                publicAgent.setAddress(rs.getString("address"));
                publicAgent.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                publicAgent.setEmail(rs.getString("email"));
                publicAgent.setTypeUser(rs.getString("typerUser"));

                return publicAgent;
            }
            return null;
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
    public List<PublicAgent> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PUBLIC_AGENT");
            rs = pstm.executeQuery();

            List<PublicAgent> listPublicAgent = new ArrayList<>();

            while (rs.next()) {
                PublicAgent publicAgent = new PublicAgent();

                publicAgent.setIdPublicAgent(rs.getInt("idPublicAgent"));
                publicAgent.setName(rs.getString("name"));
                publicAgent.setCPF(rs.getString("CPF"));
                publicAgent.setRG(rs.getString("RG"));
                publicAgent.setPhoneNumber1(rs.getString("phoneNumber1"));
                publicAgent.setPhoneNumber2(rs.getString("phoneNumber2"));
                publicAgent.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                publicAgent.setAddress(rs.getString("address"));
                publicAgent.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                publicAgent.setEmail(rs.getString("email"));
                publicAgent.setTypeUser(rs.getString("typerUser"));

                listPublicAgent.add(publicAgent);
            }
            return listPublicAgent;
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
