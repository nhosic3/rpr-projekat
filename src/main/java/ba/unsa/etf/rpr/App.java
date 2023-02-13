package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ClientManager;
import ba.unsa.etf.rpr.business.ServiceManager;
import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.domain.Service;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.*;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {

    private static final Option addService = new Option("addS", "add-service", false, "Adding new service to database");
    private static final Option addClient = new Option("addC", "add-client", false, "Adding new client to database");
    private static final Option getServices = new Option("getS", "get-services", false, "Printing all services from database");
    private static final Option getClients = new Option("getC", "get-clients", false, "Printing all clients from database");
    private static final Option deleteService = new Option("delS", "del-service", false, "Deleting service from database");
    private static final Option deleteClient = new Option("delC", "del-client", false, "Deleting client from database");

    public static void printFormattedOptions(Options options) {
        HelpFormatter h = new HelpFormatter();
        PrintWriter p = new PrintWriter(System.out);
        h.printUsage(p, 150, "java -jar rpr-projekat-0.1.jar [option] 'something else if needed' ");
        h.printOptions(p, 150, options, 2, 7);
        p.close();
    }

    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addService);
        options.addOption(addClient);
        options.addOption(getServices);
        options.addOption(getClients);
        options.addOption(deleteService);
        options.addOption(deleteClient);
        return options;
    }
    public static void main(String[] args) throws Exception {
        Options options = addOptions();
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl = commandLineParser.parse(options, args);

        ClientManager cm = new ClientManager();
        ServiceManager sm = new ServiceManager();

        if (cl.hasOption(getServices.getOpt()) || cl.hasOption(getServices.getLongOpt())) {
            List<Service> l = sm.getAll();
            if (l == null)
                System.out.println("No available service!");
            else
                for (Service s : l)
                    System.out.println(s);
        }
        else if (cl.hasOption(getClients.getOpt()) || cl.hasOption(getClients.getLongOpt())) {
            List<Client> l = cm.getAll();
            if (l == null)
                System.out.println("No available client!");
            else
                for (Client c : l)
                    System.out.println(c);
        }
        else if (cl.hasOption(deleteService.getOpt()) || cl.hasOption(deleteService.getLongOpt())) {
            try {
                int id = Integer.parseInt(cl.getArgList().get(0));
                sm.searchByClientId(id);
                sm.delete(id);
                System.out.println("Service deleted successfully!");
            } catch (Exception e) {
                if (e.getMessage().contains("not found"))
                    System.out.println("Service does not exist!");
                else
                    System.out.println(e.getMessage());
            }
        }
        else if (cl.hasOption(deleteClient.getOpt()) || cl.hasOption(deleteClient.getLongOpt())) {
            try {
                int id = Integer.parseInt(cl.getArgList().get(0));
                cm.searchById(id);
                cm.delete(id);
                System.out.println("Client deleted successfully!");
            } catch (Exception e) {
                if (e.getMessage().contains("not found"))
                    System.out.println("Client does not exist!");
                else
                    System.out.println(e.getMessage());
            }
        }
        else if (cl.hasOption(addService.getOpt()) || cl.hasOption(addService.getLongOpt())) {
            try {
                if (cl.getArgList().size() != 5) {
                    System.out.println("Invalid number of arguments!");
                } else {
                    Date date = new Date(new SimpleDateFormat("dd MM yyyy").parse(cl.getArgList().get(2)).getTime());
                    Date date2 = new Date(new SimpleDateFormat("dd MM yyyy").parse(cl.getArgList().get(3)).getTime());
                    int ss = Integer.parseInt(cl.getArgList().get(1));
                    int ss2 = Integer.parseInt(cl.getArgList().get(4));
                    Service s = sm.add(new Service(0, cl.getArgList().get(0), ss, date, date2, ss2));
                    System.out.println("Service added successfully!");
                    System.out.println(s);
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        else if (cl.hasOption(addClient.getOpt()) || cl.hasOption(addClient.getLongOpt())) {
            try {
                if (cl.getArgList().size() != 6) {
                    System.out.println("Invalid number of arguments!");
                } else {
                    Client c = cm.add(new Client(0, cl.getArgList().get(0), cl.getArgList().get(1), cl.getArgList().get(2), cl.getArgList().get(3), cl.getArgList().get(4)));
                    System.out.println("Client added successfully!");
                    System.out.println(c);
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        else {
            printFormattedOptions(options);
            System.exit(-1);
        }
    }
}
