package Model.DAO.impl;

import Db.DatabaseConnection;
import Model.DAO.QueryDAO;
import Model.Entities.Citizen;
import Model.Entities.Query;
import org.postgresql.core.v3.QueryExecutorImpl;

import javax.xml.crypto.Data;
import java.sql.*;

public class QueryDAOJDBC implements QueryDAO {

    private Connection conn;
    public void insert(Query query) {
        String sql = "INSERT INTO QUERY(nameOfConsultationDoctor, officeAddress, dateAndTimeConsultation, idPublicAgent, idForwarding) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, query.getNameOfConsultationDoctor());
            pstm.setString(2, query.getOfficeAddress());
            pstm.setTimestamp(3, Timestamp.valueOf(query.getDateAndTimeConsultation()));
            pstm.setInt(4, query.getPublicAgent().getIdPublicAgent());
            pstm.setInt(5, query.getForwarding().getIdForwarding());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeConnection(conn);
        }
    }

    public void update(Query query){
        PreparedStatement pstm = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE QUERY SET dateAndTimeOfConsultation = ? WHERE idQuery = ?"
            );
            pstm.setTimestamp(1, Timestamp.valueOf(query.getDateAndTimeConsultation()));
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeConnection(conn);
        }
    }

    public Query findById(Integer idQuery) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM citizen WHERE idCitizen = ?");

            pstm.setInt(1, idQuery);
            rs = pstm.executeQuery();

            if (rs.next()) {
                Query query = new Query();

                query.setIdQuery(rs.getInt("idQuery"));
                query.setNameOfConsultationDoctor(rs.getString("nameOfConsultationDoctor"));
                query.setOfficeAddress(rs.getString("officeAddress"));
                query.setDateAndTimeConsultation(rs.getTimestamp("dateAndTimeConsultation").toLocalDateTime());
                query.setPublicAgent();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
    }

}
