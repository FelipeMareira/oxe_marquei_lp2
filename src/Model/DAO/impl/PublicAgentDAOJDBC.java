package Model.DAO.impl;

import Db.DatabaseConnection;
import Model.DAO.PublicAgentDAO;
import Model.Entities.PublicAgent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PublicAgentDAOJDBC implements PublicAgentDAO{
    public void insert(PublicAgent publicAgent) {
        String sql = "INSERT INTO public_agent(name) VALUES (?)";
        Connection conn = null;
        PreparedStatement pstm =  null;

        try {
            conn = DatabaseConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            /*
            pstm.set(valor esperado pela query);
            * */

            //pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
