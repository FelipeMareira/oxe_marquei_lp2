package Model.DAO;

import Model.DAO.impl.*;
public class DAOFactory {
    public static CitizenDAO createCitizenDAO() {
        return new CitizenDAOJDBC('DB.getConnection()');
    }

    public static PublicAgentDAO createPublicAgentDAO() {
        return new PublicAgentDAOJDBC("DB.getConnection()");
    }

    public static ForwardingDAO createForwardingDAO() {
        return new ForwardingDAOJDBC("DB.getConnection()");
    }

    public static QueryDAO creatQueryDAO() {
        return new QueryDAOJDBC("DB.getConnection()");
    }
}
