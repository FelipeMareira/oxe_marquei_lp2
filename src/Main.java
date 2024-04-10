import Db.DatabaseConnection;
import Model.DAO.impl.SolicitationDAOJDBC;
import Model.DAO.impl.PatientDAOJDBC;
import Model.DAO.impl.PublicAgentDAOJDBC;
import Model.DAO.impl.QueryDAOJDBC;
import Model.Entities.Solicitation;
import Model.Entities.Patient;
import Model.Entities.PublicAgent;
import Model.Entities.Query;
import Utils.SendEmail;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        DatabaseConnection.getConnection();

//        PatientDAOJDBC patientDAOJDBC = new PatientDAOJDBC();
//        PublicAgentDAOJDBC publicAgentDAOJDBC = new PublicAgentDAOJDBC();
//        SolicitationDAOJDBC solicitationDAOJDBC = new SolicitationDAOJDBC();
//        QueryDAOJDBC queryDAOJDBC = new QueryDAOJDBC();
//
//
//        Patient patient1 = new Patient(
//                "Lucas de Oliveira", "1111", "1212", "77988039898",
//                LocalDate.parse("2000-05-17"), "Rua Ribeiro", "lucassdeoliveira@outlook.com.br",
//                "7777"
//        );
//        Patient patient2 = new Patient("Suzana", "1243214", "27061020", "8888",
//                "1111", LocalDate.parse("1995-06-17"),
//                "Rua Quisabor", "suzana@suzana.com", "14750"
//        );
//
//        patientDAOJDBC.insert(patient1);
//        System.out.println(patientDAOJDBC.findAll());
//        patientDAOJDBC.insert(patient2);
//        System.out.println(patientDAOJDBC.findAll());
//
//        PublicAgent publicAgent1 = new PublicAgent(
//                "Ricardo", "102045", "2573230", "320165023",
//                "49203220", LocalDate.parse("1995-06-17"), "Rua BC",
//                "ricardo@ricardo.com", "ricardin", "802831", "admin"
//        );
//
//        PublicAgent publicAgent2 = new PublicAgent(
//                "Almeida", "102046", "2573231", "320165024",
//                "49203221", LocalDate.parse("1995-06-18"), "Rua BC",
//                "almeida@almeida.com", "almeidinha", "802832", "normal"
//        );
//        publicAgentDAOJDBC.insert(publicAgent1);
//        publicAgentDAOJDBC.insert(publicAgent2);
//        System.out.println(publicAgentDAOJDBC.findAll());
//
//        Solicitation solicitation = new Solicitation(
//                "20202010", "Ontem o paciente estava bastante cansado e aflito pelos problemas da vida!",
//                "Professora Ana Cristina",
//                patientDAOJDBC.findById(1)
//        );
//        solicitationDAOJDBC.insert(solicitation);
//        System.out.println(solicitationDAOJDBC.findAll());
//
//
//        Query query = new Query(
//                "Flavia", "2525252", "Rua Barao Consulta 1",LocalDateTime.parse("2024-12-30T19:34:50.63"),
//                publicAgentDAOJDBC.findById(2), solicitationDAOJDBC.findById(1)
//        );
//        queryDAOJDBC.insert(query);
//        System.out.println(queryDAOJDBC.findAll());
//
//        System.out.println("\n" + "-------------------------------- FIND ALL--------------------------" + "\n");
//        System.out.println(patientDAOJDBC.findAll());
//
//        System.out.println(publicAgentDAOJDBC.findAll());
//
//        System.out.println(solicitationDAOJDBC.findAll());
//
//        System.out.println(queryDAOJDBC.findAll());
//
//        System.out.println("\n" + "-------------------------------- FINDY BY ID --------------------------" + "\n");
//        System.out.println(patientDAOJDBC.findById(1));
//        System.out.println(publicAgentDAOJDBC.findById(1));
//        System.out.println(solicitationDAOJDBC.findById(1));
//        System.out.println(queryDAOJDBC.findById(1));
//
//        System.out.println("\n" + "-------------------------------- DELETE BY ID --------------------------" + "\n");
//        publicAgentDAOJDBC.deleteById(2);
//        System.out.println(publicAgentDAOJDBC.findAll());
//
//        System.out.println("\n" + "-------------------------------- UPDATE --------------------------" + "\n");
//        patientDAOJDBC.update(
//                "1-252525",
//                "2-252525",
//                "Rua Baixo",
//                "luska.soliver7@gmail.com",
//                1
//        );
//        publicAgentDAOJDBC.update(
//            "333",
//                "Rua CB",
//                "ricarda@ricardin.com",
//                2
//        );
//        queryDAOJDBC.update(
//                LocalDateTime.parse("2025-12-30T19:34:50.63"),
//                1
//        );
//        System.out.println("\n" + "-------------------------------- SENDER EMAIL --------------------------" + "\n");
//
//        Query query1 = queryDAOJDBC.findById(1);
//        Solicitation solicitation1 = solicitationDAOJDBC.findById(query1.getSolicitation().getIdSolicitation());
//        Patient paciente = patientDAOJDBC.findById(solicitation1.getPatient().getIdPatient());
//
//        SendEmail.sender(
//                "lucassdeoliveira@outlook.com.br",
//                "Agendamento",
//                "Consulta Marcada no dia " + query.getDateAndTimeConsultation()
//        );
    }
}