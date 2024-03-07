package Model.DAO;

import Model.Entities.Citizen;

import java.util.List;

public interface CitizenDAO {
    void insert(Citizen citizen);
    void update(Citizen citizen);
    void deleteById(Integer id);
    Citizen findyById(Integer id);
    List<Citizen> findAll();
}
