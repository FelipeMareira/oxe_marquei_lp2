package Model.DAO.impl;

import Db.DatabaseConnection;
import Model.DAO.ForwardingDAO;
import Model.Entities.Forwarding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ForwardingDAOJDBC  {
//    public void insert(Forwarding forwarding) {
//        String sql = "INSERT INTO forwarding(name) VALUES (?)";
//        Connection conn = null;
//        PreparedStatement pstm =  null;
//
//        try {
//            conn = DatabaseConnection.getConnection();
//            pstm = conn.prepareStatement(sql);
//
//            /*
//            pstm.set(valor esperado pela query);
//            * */
//
//            //pstm.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (pstm != null) {
//                    pstm.close();
//                }
//
//                if (conn != null) {
//                    conn.close();
//                }
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
