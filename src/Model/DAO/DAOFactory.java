package Model.DAO;

import Model.DAO.impl.CitizenDAOJDBC;
import Model.DAO.impl.ForwardingDAOJDBC;
import Model.DAO.impl.PublicAgentDAOJDBC;
import Model.DAO.impl.QueryDAOJDBC;

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
