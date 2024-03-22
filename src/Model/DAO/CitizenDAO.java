package Model.DAO;

import Model.Entities.Citizen;

import java.util.List;

public interface CitizenDAO {
    void insert(Citizen citizen);
    void update(Citizen citizen);
    void deleteById(Integer idCitizen);
    Citizen findById(Integer idCitizen);
    List<Citizen> findAll();
}
