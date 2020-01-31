package lhc;

import hr.Researcher;
import hr.SecurityOfficer;
import hr.Visitor;
import hr.dep.HRAssistant;
import infrastructure.lhc.Detector;
import infrastructure.lhc.Ring;
import infrastructure.security.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

import java.text.SimpleDateFormat;

public class Main {
    private static Object port;
    public static void main(String[] args) {
        createSearchAlgorithmPortInstance();
        // Anwendungsfälle Erstellung von ID Karten durch die Rezeption bzw. das Security Centre
        Reception reception = new Reception();
        SecurityCentre securityCentre = new SecurityCentre();
        SecurityOfficer securityOfficer = new SecurityOfficer();
        securityCentre.addOfficer(securityOfficer);
        IDCard idCard = securityOfficer.createIDCard(securityOfficer);
        securityOfficer.setIdCard(idCard);
        Visitor visitor = new Visitor();
        visitor.setName("Helmut Schmidt");
        IDCard newIDCard = reception.createIDCard(visitor);
        visitor.setIdCard(newIDCard);

        // Anwendungsfall Reader prüft Zugriff für einen Besucher
        IReader reader = new Reader();
        reader.insertIDCard(visitor.getIdCard());
        System.out.println(reader.allowEntry() ? "Darf betreten" : "Darf nicht betreten");
        reader.removeIDCard();

        // Anwendungsfall Reader prüft Zugriff für einen Mitarbeiter
        IWriter writer = new Writer();
        writer.insertIdCard(securityOfficer.getIdCard());
        writer.setPassword();
        writer.removeIdCard();
        reader.insertIDCard(securityOfficer.getIdCard());
        System.out.println(reader.allowEntry() ? "Darf betreten" : "Darf nicht betreten");
        reader.removeIDCard();

        // Anwendungsfall HRAssistant hat lesenden Zugriff auf die Daten der Mitarbeiter
        HRAssistant hrAssistant = new HRAssistant();
        hrAssistant.setEmployee(securityOfficer);
        reader.insertIDCard(hrAssistant.getEmployee().getIdCard());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(reader.getValidUntil().getTime()));
        // die nächste Zeile kann nicht kompiliert werden => ein HRAssistant kann keine Daten der Mitarbeiter verändern
        //writer.insertIdCard(hrAssistant.getEmployee().getIdCard());
        hrAssistant.removeEmployee();


        // Anwendungsfall Security Centre sperrt eine ID Karte
        securityOfficer.lock(visitor.getIdCard());
        reader.insertIDCard(visitor.getIdCard());
        System.out.println(reader.allowEntry() ? "Darf betreten" : "Darf nicht betreten");
        reader.removeIDCard();

        System.out.println("Starting experiment");
        Ring ring = new Ring(1);
        Detector detector = new Detector(2);
        ControlCenter controlCenter = new ControlCenter();
        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);
        controlCenter.startExperiment(5000, ExperimentScope.ESFull);

        //Researcher researcher = new Researcher();
        //researcher.updateExperiment(detector);
    }

    public static int search(String text, String pattern){
        try {
            return (int) port.getClass().getMethod("search", String.class, String.class).invoke(port, text, pattern);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return -1;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void createSearchAlgorithmPortInstance() {
        Object instance;

        try {
            System.out.println("pathToJar : " + Configuration.instance.PathToSearchAlgorithmJar);
            URL[] urls = {new File(Configuration.instance.PathToSearchAlgorithmJar).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Main.class.getClassLoader());
            Class clazz = Class.forName("SearchAlgorithm", true, urlClassLoader);
            System.out.println("clazz     : " + clazz.toString());

            instance = clazz.getMethod("getInstance").invoke(null);
            port = clazz.getDeclaredField("port").get(instance);
            System.out.println("port      : " + port.hashCode());
        } catch (Exception e) {
            System.err.println("--- exception");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
