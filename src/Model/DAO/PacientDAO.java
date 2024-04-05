package Model.DAO;

import Model.Entities.Pacient;

import java.util.List;

public interface PacientDAO {
    void insert(Pacient pacient);
    void update(Pacient pacient);
    Pacient findById(Integer idCitizen);
    List<Pacient> findAll();
}
