package Model.DAO;

import java.util.List;

import Model.Entities.Solicitation;

public interface SolicitationDAO {
    void insert(Solicitation solicitation);
    Solicitation findById(Integer id);
    List<Solicitation> findAll();
}
