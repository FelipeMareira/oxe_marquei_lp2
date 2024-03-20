package Model.Services;

import Model.DAO.DAOFactory;
import Model.DAO.QueryDAO;
import Model.Entities.Query;

import java.util.List;

public class QueryService {
    private QueryDAO queryDAO = DAOFactory.creatQueryDAO();

    public void insert(Query query) {
        queryDAO.insert(query);
    }

    public void update(Query query) {
        queryDAO.update(query);
    }

    public Query findById(Query query) {
        return queryDAO.findyById(0);
    }

    public List<Query> findAll() {
        return queryDAO.findAll();
    }
}
