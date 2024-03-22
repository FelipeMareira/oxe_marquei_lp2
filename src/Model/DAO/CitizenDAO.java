package Model.DAO;

import Model.Entities.Citizen;

import java.util.List;

public interface CitizenDAO {
    void insert(Citizen citizen);
    void update(Citizen citizen);
    Citizen findById(Integer idCitizen);
    List<Citizen> findAll();
}
