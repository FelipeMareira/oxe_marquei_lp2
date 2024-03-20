package Model.DAO;

import java.util.List;

import Model.Entities.Forwarding;

public interface ForwardingDAO {
    void insert(Forwarding citizen);
    Forwarding findById(Integer id);
    List<Forwarding> findAll();
}
