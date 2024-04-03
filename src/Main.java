import Db.DatabaseConnection;
import Model.DAO.PublicAgentDAO;
import Model.DAO.impl.CitizenDAOJDBC;
import Model.DAO.impl.ForwardingDAOJDBC;
import Model.DAO.impl.PublicAgentDAOJDBC;
import Model.DAO.impl.QueryDAOJDBC;
import Model.Entities.Citizen;
import Model.Entities.Forwarding;
import Model.Entities.PublicAgent;
import Model.Entities.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        DatabaseConnection.getConnection();

//        Citizen cidadao = new Citizen("Suzana", "1243214", "27061020", "8888", "1111",
//            =     LocalDate.parse("1995-06-17"),
//                "Rua Quisabor", "suzana@suzana.com", "14750");
//        CitizenDAOJDBC citizenDAOJDBC = new CitizenDAOJDBC();

//        PublicAgent publicAgent = new PublicAgent(
//                "Ricardo", "102045", "2573230", "320165023",
//                "49203220", LocalDate.parse("1995-06-17"), "Rua BC", "ricardo@ricardo.com",
//                "ricardin", "802831", "admim"
//        );
//        PublicAgentDAOJDBC publicAgentDAOJDBC = new PublicAgentDAOJDBC();
//
//        publicAgentDAOJDBC.insert(publicAgent);
//
//        System.out.println(publicAgentDAOJDBC.findAll());
//        CitizenDAOJDBC citizenDAOJDBC = new CitizenDAOJDBC();
//        PublicAgentDAOJDBC publicAgentDAOJDBC = new PublicAgentDAOJDBC();

//        Forwarding forwarding = new Forwarding(
//                "20202010", "olá mundo!", "bixo@bixo.com",
//                citizenDAOJDBC.findById(11)
//        );
//        ForwardingDAOJDBC forwardingDAOJDBC = new ForwardingDAOJDBC();
//
//        Query query = new Query(
//                "rodriguinho", LocalDateTime.parse("2024-12-30T19:34:50.63"),
//                "Cirurgia 1", publicAgentDAOJDBC.findById(1), forwardingDAOJDBC.findById(1)
//        );
//        QueryDAOJDBC queryDAOJDBC = new QueryDAOJDBC();
//        queryDAOJDBC.insert(query);

        System.out.println("\n" + "-------------------------------- FINDY ALL--------------------------" + "\n");
        CitizenDAOJDBC citizenDAOJDBC = new CitizenDAOJDBC();
        System.out.println(citizenDAOJDBC.findAll());

        PublicAgentDAOJDBC publicAgentDAOJDBC = new PublicAgentDAOJDBC();
        System.out.println(publicAgentDAOJDBC.findAll());

        ForwardingDAOJDBC forwardingDAOJDBC = new ForwardingDAOJDBC();
        System.out.println(forwardingDAOJDBC.findAll());

        QueryDAOJDBC queryDAOJDBC  = new QueryDAOJDBC();
        System.out.println(queryDAOJDBC.findAll());

        System.out.println("\n" + "-------------------------------- FINDY BY ID --------------------------" + "\n");
        System.out.println(citizenDAOJDBC.findById(11));
        System.out.println(publicAgentDAOJDBC.findById(1));
        System.out.println(forwardingDAOJDBC.findById(1));
        System.out.println(queryDAOJDBC.findById(1));

        System.out.println("\n" + "-------------------------------- DELETE BY ID --------------------------" + "\n");
        publicAgentDAOJDBC.deleteById(1);
        System.out.println(publicAgentDAOJDBC.findAll());

        System.out.println("\n" + "-------------------------------- UPDATE --------------------------" + "\n");

    }
}