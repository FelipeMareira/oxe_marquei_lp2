package Model.DAO;

import Model.Entities.Pacient;

import java.util.List;

public interface PacientDAO {
    void insert(Pacient pacient);
    void update(String phoneNumber1, String phoneNumber2, String address, String email, int idPacient);
    Pacient findById(Integer idCitizen);
    List<Pacient> findAll();
}
