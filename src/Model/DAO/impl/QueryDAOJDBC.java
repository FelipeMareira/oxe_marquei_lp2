package Model.DAO.impl;

import Db.DatabaseConnection;
import Model.DAO.QueryDAO;
import Model.Entities.Solicitation;
import Model.Entities.PublicAgent;
import Model.Entities.Query;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOJDBC implements QueryDAO {

    private Connection conn;

    @Override
    public void insert(Query query) {
        String sql = "INSERT INTO QUERY(nameOfConsultationDoctor, CRMConsultationDoctor, officeAddress, dateAndTimeConsultation, idPublicAgent, idForwarding) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, query.getNameOfConsultationDoctor());
            pstm.setString(2, query.getCRMConsultationDoctor());
            pstm.setString(3, query.getOfficeAddress());
            pstm.setTimestamp(4, Timestamp.valueOf(query.getDateAndTimeConsultation()));
            pstm.setInt(5, query.getPublicAgent().getIdPublicAgent());
            pstm.setInt(6, query.getSolicitation().getIdSolicitation());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeConnection(conn);
        }
    }
    @Override
    public void update(LocalDateTime dateAndTimeOfConsultation, int idQuery){
        PreparedStatement pstm = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE QUERY SET dateAndTimeConsultation = ? WHERE idQuery = ?"
            );
            pstm.setTimestamp(1, Timestamp.valueOf(dateAndTimeOfConsultation));
            pstm.setInt(2, idQuery);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeConnection(conn);
        }
    }
    @Override
    public Query findById(Integer idQuery) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT q.* FROM QUERY q INNER JOIN PUBLIC_AGENT p ON q.idPublicAgent = p.idPublicAgent INNER JOIN SOLICITATION f ON q.idSolicitation = f.idSolicitation WHERE q.idQuery = ?"
            );

            pstm.setInt(1, idQuery);
            rs = pstm.executeQuery();

            if (rs.next()) {
                Query query = new Query();

                PublicAgent publicAgent = new PublicAgent();
                publicAgent.setIdPublicAgent(rs.getInt("idPublicAgent"));

                Solicitation solicitation = new Solicitation();
                solicitation.setIdSolicitation(rs.getInt("idSolicitation"));

                query.setIdQuery(rs.getInt("idQuery"));
                query.setNameOfConsultationDoctor(rs.getString("nameOfConsultationDoctor"));
                query.setCRMConsultationDoctor(rs.getString("CRMConsultationDoctor"));
                query.setOfficeAddress(rs.getString("officeAddress"));
                query.setDateAndTimeConsultation(rs.getTimestamp("dateAndTimeConsultation").toLocalDateTime());
                query.setPublicAgent(publicAgent);
                query.setSolicitation(solicitation);

                return query;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closeStatement(pstm);
            DatabaseConnection.closeResultSet(rs);
        }
        return null;
    }
    @Override
    public List<Query> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT q.* FROM QUERY q INNER JOIN PUBLIC_AGENT p ON q.idPublicAgent = p.idPublicAgent INNER JOIN SOLICITATION f ON q.idSolicitation = f.idSolicitation"
            );


            rs = pstm.executeQuery();
            List<Query> listQuery = new ArrayList<>();

            while (rs.next()) {
                Query query = new Query();

                PublicAgent publicAgent = new PublicAgent();
                publicAgent.setIdPublicAgent(rs.getInt("idPublicAgent"));

                Solicitation solicitation = new Solicitation();
                solicitation.setIdSolicitation(rs.getInt("idForwarding"));

                query.setIdQuery(rs.getInt("idQuery"));
                query.setNameOfConsultationDoctor(rs.getString("nameOfConsultationDoctor"));
                query.setOfficeAddress(rs.getString("officeAddress"));
                query.setDateAndTimeConsultation(rs.getTimestamp("dateAndTimeConsultation").toLocalDateTime());
                query.setPublicAgent(publicAgent);
                query.setSolicitation(solicitation);

                listQuery.add(query);
            }
            return listQuery;
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
