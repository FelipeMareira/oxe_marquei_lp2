package Model.DAO;

import java.util.List;

import Model.Entities.Forwarding;

public interface ForwardingDAO {
    void insert(Forwarding citizen);
    void deleteById(Integer id);
    Forwarding findyById(Integer id);
    List<Forwarding> findAll();
}
