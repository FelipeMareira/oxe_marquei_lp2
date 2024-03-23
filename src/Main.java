import Db.DatabaseConnection;
import Model.DAO.impl.CitizenDAOJDBC;
import Model.Entities.Citizen;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        DatabaseConnection.getConnection();

        Citizen cidadao = new Citizen("felipe", "1241414", "27211020", "8888", "1111",
                LocalDate.parse("2000-06-17"),
                "Rua Quisabor", "felipe@felipe.com", "14530");
        CitizenDAOJDBC citizenDAOJDBC = new CitizenDAOJDBC();

        citizenDAOJDBC.deleteById(6);
        System.out.println(citizenDAOJDBC.findAll());

    }
}