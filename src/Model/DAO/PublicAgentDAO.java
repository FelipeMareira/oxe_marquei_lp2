package Model.DAO;

import Model.Entities.PublicAgent;

import java.util.List;

public interface PublicAgentDAO {
    void insert(PublicAgent publicAgent);
    void update(PublicAgent publicAgent);
    void deleteById(Integer id);
    PublicAgent findById(Integer id);
    List<PublicAgent> findAll();
}
