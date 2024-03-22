package Model.DAO.impl;

import Db.DatabaseConnection;
import Model.DAO.CitizenDAO;
import Model.Entities.Citizen;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAOJDBC {
    private Connection conn;
    public void insert(Citizen citizen) {
        String sql = "INSERT INTO CITIZEN(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, createdAt, address, email, SIGTAP) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
//
    public void update(Citizen citizen) {
        PreparedStatement pstm =  null;

        try {
            pstm = conn.prepareStatement(
                    "UPDATE CITIZEN SET name = ?, phoneNumber1 = ?, phoneNumber2 = ?, address = ?, email = ? WHERE idCitizen = ?"
            );

            pstm.setString(1, citizen.getName());
            pstm.setString(2, citizen.getPhoneNumber1());
            pstm.setString(3, citizen.getPhoneNumber2());
            pstm.setString(4, citizen.getAddress());
            pstm.setString(5, citizen.getEmail());
            pstm.setInt(6, citizen.getIdCitizen());
            pstm.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(pstm);
        }
    }

    public void deleteById(Integer idCitizen) {
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement("DELETE FROM CITIZEN WHERE idCitizen = ?");

            pstm.setInt(1, idCitizen);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(pstm);
        }
    }

    public Citizen findById(Integer idCitizen) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM citizen WHERE idCitizen = ?");

            pstm.setInt(1, idCitizen);

            rs = pstm.executeQuery();

            if (rs.next()) {
//                Citizen citizen = new Citizen(
//                        rs.getInt("idCitizen"), rs.getString("name"),
//                        rs.getString("CPF"), rs.getString("RG"),
//                        rs.getString("phoneNumber1"), rs.getString("phoneNumber2"),
//                        LocalDate.ofInstant(rs.getDate("dateOfBirth").toInstant(), ZoneId.systemDefault()),
//                        rs.getString("address"),
//                        LocalDateTime.ofInstant(rs.getDate("createdAt").toInstant(), ZoneId.systemDefault()),
//                        rs.getString("email"),
//                        rs.getString("SIGTAP")
//                );
                Citizen citizen = new Citizen();

                citizen.setIdCitizen(rs.getInt("idCitizen"));
                citizen.setName(rs.getString("name"));
                citizen.setCPF(rs.getString("CPF"));
                citizen.setRG(rs.getString("RG"));
                citizen.setPhoneNumber1(rs.getString("phoneNumber1"));
                citizen.setPhoneNumber2(rs.getString("phoneNumber2"));
                citizen.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                citizen.setAddress(rs.getString("address"));
                citizen.setCreatedAt(rs.getDate("createdAt").toLocalDate());
                citizen.setEmail(rs.getString("email"));
                citizen.setSIGTAP(rs.getString("SIGTAP"));



//                citizen.setDateOfBirth(LocalDate.ofInstant(rs.getDate("dateOfBirth").toInstant(), ZoneId.systemDefault()));

                return citizen;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeResultSet(rs);
        }
        return null;
    }

    public List<Citizen> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement("SELECT * FROM citizen");
            rs = pstm.executeQuery();

            List<Citizen> listCitizen = new ArrayList<>();

            while (rs.next()) {
                Citizen citizen = new Citizen();

                citizen.setIdCitizen(rs.getInt("idCitizen"));
                citizen.setName(rs.getString("name"));
                citizen.setCPF(rs.getString("CPF"));
                citizen.setRG(rs.getString("RG"));
                citizen.setPhoneNumber1(rs.getString("phoneNumber1"));
                citizen.setPhoneNumber2(rs.getString("phoneNumber2"));
                citizen.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                citizen.setAddress(rs.getString("address"));
                citizen.setCreatedAt(rs.getDate("createdAt").toLocalDate());
                citizen.setEmail(rs.getString("email"));
                citizen.setSIGTAP(rs.getString("SIGTAP"));

                listCitizen.add(citizen);
            }
            return  listCitizen;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeResultSet(rs);
        }
        return null;
    }
}
