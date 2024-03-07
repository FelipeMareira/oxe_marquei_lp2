package Model.DAO;

import Model.Entities.Query;

import java.util.List;

public interface QueryDAO {
    void insert(Query query);
    void update(Query query);
    Query findyById(Integer id);
    List<Query> findAll();
}
