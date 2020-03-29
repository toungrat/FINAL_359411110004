import java.util.List;
import java.util.Scanner;

public class PatientManagement {

    public static void main(String[] args) {
        PatientDAOImpl dao = PatientDAOImpl.getInstance();
        displayALLPatient(dao);
        addNewPatient(dao);
        findPatient(dao);
        UpdatePatientByID(dao);
        deletePatientByID(dao);
    }
    private static void deletePatientByID(PatientDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Patient ID that you want to delete: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        dao.deletePAT(id);
    }
    private static void UpdatePatientByID(PatientDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Patient PAT = dao.findPAT(id);
        System.out.print(PAT.toString());

        System.out.println("Enter new blood result for Patient ID: "+PAT.getP_id());
        String p_blood_result = sc.nextLine();

        PAT.setP_blood_result(p_blood_result);
        dao.updatePAT(PAT);
    }
    private static void findPatient(PatientDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Patient PAT = dao.findPAT(id);
        System.out.print(PAT.toString());
    }
    private static void addNewPatient(PatientDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patient ID. ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Patient Name. ");
        String p_name = sc.nextLine();
        System.out.print("Enter Patient gender. ");
        String p_gender = sc.nextLine();
        System.out.print("Enter Patient Age. ");
        int p_age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Patient address. ");
        String p_address = sc.nextLine();
        System.out.print("Enter Patient blood result. ");
        String p_blood_result = sc.nextLine();
        dao.addPAT(new Patient(id,p_name,p_gender,p_age,p_address,p_blood_result));
    }
    private static void displayALLPatient(PatientDAOImpl dao) {
        List<Patient> PAT = dao.getAllPAT();
        for (Patient p:PAT) {
            System.out.println(p.toString());
        }
    }
}
