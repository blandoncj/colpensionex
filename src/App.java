import models.Contributor;
import util.ContributorCSVHandler;
import util.SuperCache;
import util.ContributorQueue;
import util.Blacklist;
import enums.PublicInstitution;
import enums.PensionFund;
import enums.Characterization;
import enums.Gender;
import services.GeneralValidation;

import java.util.List;

/**
 * The App class is the main entry point for the application.
 * It performs the following steps:
 * 
 * 1. Reads the CSV files and loads the data into cache.
 * 2. Implements business logic to validate contributors.
 * 3. Generates a queue of approved contributors.
 * 4. Creates a blacklist of contributors who can be embargoed.
 * 5. Adds a new contributor to the CSV file and verifies the addition.
 * 
 * The application reads contributor data from a CSV file, validates the data,
 * and processes it according to specific business rules. It then outputs the
 * results to the console.
 * 
 * The main method performs the following tasks:
 * - Reads the CSV file and loads the data into memory.
 * - Validates each contributor and adds valid contributors to an approved queue.
 * - Adds contributors who can be embargoed to a blacklist.
 * - Outputs the list of approved contributors and the blacklist to the console.
 * - Adds a new contributor to the CSV file and verifies the addition by reading
 *   the file again and outputting the updated list of contributors.
 * 
 * Note: Ensure that the file path to the CSV file is correct.
 */

public class App {
    public static void main(String[] args) {
        String filePath = "cotizantes.csv"; 
        ContributorCSVHandler handler = new ContributorCSVHandler(filePath);
        List<Contributor> contributors = handler.readRows();

        SuperCache superCache = new SuperCache();
        superCache.addCache(filePath, handler.getCache());

        System.out.println("Cotizantes leídos del archivo CSV:");
        for (Contributor contributor : contributors) {
            System.out.println(contributor);
        }

        ContributorQueue approvedQueue = new ContributorQueue();
        Blacklist embargoBlacklist = new Blacklist();
        Blacklist inhabilitadosBlacklist = new Blacklist();

        for (Contributor contributor : contributors) {
            GeneralValidation validation = new GeneralValidation(contributor);
            if (validation.isValid()) {
                approvedQueue.addContributor(contributor);
                if (contributor.getCharacterization() == Characterization.EMBARGAR) {
                    embargoBlacklist.add(contributor);
                } else if (contributor.getCharacterization() == Characterization.INHABILITAR) {
                    inhabilitadosBlacklist.add(contributor);
                }
            }
        }

        System.out.println("\nCola de cotizantes aprobados con prioridades:");
        ContributorQueue sortedQueue = new ContributorQueue();
        while (!approvedQueue.isQueueEmpty()) {
            sortedQueue.addContributor(approvedQueue.removeContributor());
        }
        while (!sortedQueue.isQueueEmpty()) {
            Contributor contributor = sortedQueue.removeContributor();
            System.out.println(contributor);
            approvedQueue.addContributor(contributor); 
        }

        System.out.println("\nCotizantes aprobados para traslado:");
        while (!approvedQueue.isQueueEmpty()) {
            Contributor approvedContributor = approvedQueue.removeContributor();
            System.out.println(approvedContributor);
        }

        System.out.println("\nCotizantes embargables:");
        for (Contributor blacklistedContributor : embargoBlacklist) {
            System.out.println(blacklistedContributor);
        }

        System.out.println("\nCotizantes inhabilitados:");
        for (Contributor inhabilitadoContributor : inhabilitadosBlacklist) {
            System.out.println(inhabilitadoContributor);
        }

        Contributor newContributor = new Contributor(
                "CC", "123456789", "Nuevo Cotizante", "Bogotá", 30, 100, 500.0,
                false, false, false, false, false, null,
                PublicInstitution.POLICIA, PensionFund.PUBLICO, Characterization.ACTIVO, Gender.MASCULINO
        );
        handler.writeRow(newContributor);

        contributors = handler.readRows();
        System.out.println("\nCotizantes después de añadir uno nuevo:");
        for (Contributor contributor : contributors) {
            System.out.println(contributor);
        }
    }
}