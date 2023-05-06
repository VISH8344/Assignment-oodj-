package Controller;

import Model.Application;
import Model.Enum.ApplicationStatus;
import Model.HostelRoom;
import Model.Payment;
import Model.Student;
import Util.FileName;
import Util.FileUtil;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ApplicationController implements Controller {

    private ArrayList<Application> applications;
    private static ApplicationController applicationController;

    public static ApplicationController ActivateApplicationController() {
        if (ApplicationController.applicationController == null) {
            ApplicationController.applicationController = new ApplicationController();
        }
        return ApplicationController.applicationController;
    }

    ApplicationController() {
        this.applications = new ArrayList<>();
        ArrayList<String[]> textRecords = FileUtil.ReadFile(FileName.APPLICATION);
        textRecords.forEach(record -> {
            Application loadedObject = fromTextToObject(record);
            applications.add(loadedObject);
        });
    }

    private Application fromTextToObject(String[] splittedLine) {
        int id = Integer.parseInt(splittedLine[0]);
        LocalDateTime dateTime = LocalDateTime.parse(splittedLine[1]);
        ApplicationStatus status = ApplicationStatus.valueOf(splittedLine[2]);
        String rejectedReason = splittedLine[3];
        int stuID = Integer.parseInt(splittedLine[4]);
        int roomID = Integer.parseInt(splittedLine[5]);
        int paymentID = Integer.parseInt(splittedLine[6]);
        Student studentObject = StudentController.ActivateStudentController().getStudentById(stuID);
        HostelRoom roomObject = HostelRoomController.ActivateHostelRoomController().getHostelRoomById(roomID);
        Payment paymentObject = PaymentController.ActivatePaymentController().getPaymentById(paymentID);
        return new Application(id, studentObject, roomObject, dateTime, paymentObject, status, rejectedReason);
    }

    private ArrayList<String> fromObjectToText() {
        ArrayList<String> fileContents = new ArrayList<>();
        applications.forEach(application -> {
            fileContents.add(
                    application.getApplicationID() + ";"
                    + application.getDateTime() + ";"
                    + application.getApplicationStatus() + ";"
                    + application.getRejectedReason() + ";"
                    + application.getStudent().getStudentID() + ";"
                    + application.getRoom().getRoomID() + ";"
                    + application.getPayment().getPaymentID());
        });
        return fileContents;
    }

    private int generateUniqueNumber(int num) {
        return num + 1;
    }

    private boolean checkIDIsExist(int id) {
        boolean isFound = false;
        for (Application ap : applications) {
            if (ap.getApplicationID() == id) {
                isFound = true;
            }
        }
        return isFound;
    }

    @Override
    public int getNewID() {
        int tempNewId = applications.size() + 1;
        boolean isIDExist = checkIDIsExist(tempNewId);
        while (isIDExist) {
            tempNewId = generateUniqueNumber(tempNewId);
            if (!checkIDIsExist(tempNewId)) {
                break;
            }
        }
        return tempNewId;
    }

    public ArrayList<Application> getApplications() {
        return this.applications;
    }

    public Application getApplicationById(int id) {
        Application response = null;
        for (int i = 0; i < applications.size(); i++) {
            if (applications.get(i).getApplicationID() == id) {
                response = applications.get(i);
                break;
            }
        }
        if (response == null) {
            System.out.println("Application with this id : " + id + " is not found");
        }
        return response;
    }

    public Application getApplicationByStudentID(int stuID) {
        Application response = null;
        for (int i = 0; i < applications.size(); i++) {
            if (applications.get(i).getStudent().getStudentID() == stuID) {
                response = applications.get(i);
                break;
            }
        }
        if (response == null) {
            System.out.println("Application with this student id : " + stuID + " is not found");
        }
        return response;
    }
    
    public ArrayList<Application> getPendingApplications(){
        ArrayList<Application> response = new ArrayList<>();
        for (int i = 0; i < applications.size(); i++) {
            if(applications.get(i).getApplicationStatus() == ApplicationStatus.PENDING){
                response.add(applications.get(i));
            }
        }
        if (response == null) {
            System.out.println("There is no pending applications in the record.");
        }
        return response;
    }
    
    public ArrayList<Application> getApprovedApplications(){
        ArrayList<Application> response = new ArrayList<>();
        for (int i = 0; i < applications.size(); i++) {
            if(applications.get(i).getApplicationStatus() == ApplicationStatus.APPROVED){
                response.add(applications.get(i));
            }
        }
        if (response == null) {
            System.out.println("There is no approved applications in the record.");
        }
        return response;
    }
    
    public ArrayList<Application> getRejectedApplications(){
        ArrayList<Application> response = new ArrayList<>();
        for (int i = 0; i < applications.size(); i++) {
            if(applications.get(i).getApplicationStatus() == ApplicationStatus.REJECTED){
                response.add(applications.get(i));
            }
        }
        if (response == null) {
            System.out.println("There is no rejected applications in the record.");
        }
        return response;
    }

    public void add(Application Application) {
        this.applications.add(Application);
        saveRecords();
    }

    public void updateApplication(Application stu) {
        for (int i = 0; i < applications.size(); i++) {
            if (applications.get(i).getApplicationID() == stu.getApplicationID()) {
                applications.set(i, stu);
                break;
            }
        }
        saveRecords();
    }

    @Override
    public void saveRecords() {
        System.out.println("applications: " + applications.toString());
        FileUtil.WriteToFile(FileName.APPLICATION, fromObjectToText());
    }

    // Testing
//    public static void main(String[] args) {
//        ApplicationController ac = applicationController.ActivateApplicationController();
//        ac.getApplications().forEach(application -> {
//            System.out.println(application.getApplicationID());
//        });
////        System.out.println(stuController.getNewID());
//    }
}
