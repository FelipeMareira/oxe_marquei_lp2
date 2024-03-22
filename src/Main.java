import Db.DatabaseConnection;
import Model.DAO.impl.CitizenDAOJDBC;
import Model.Entities.Citizen;

import java.sql.Connection;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        DatabaseConnection.getConnection();

        Citizen cidadao = new Citizen("Lucas", "07051202550", "20201020", "8888", "1111",
                LocalDate.parse("2000-05-17"),
                "Rua Francisco", "lucas@lucas.com", "040400");
        CitizenDAOJDBC citizenDAOJDBC = new CitizenDAOJDBC();
//        citizenDAOJDBC.insert(cidadao);

        System.out.println(citizenDAOJDBC.findById(1));
    }
}