package Controller;

import Model.Application;
import Util.FileName;
import Util.SerializationUtil;
import java.util.ArrayList;

public class ApplicationController implements Controller {

    ArrayList<Application> applications;
    private static ApplicationController applicationController;

    public static ApplicationController ActivateApplicationController() {
        if (ApplicationController.applicationController == null) {
            ApplicationController.applicationController = new ApplicationController();
        }
        return ApplicationController.applicationController;
    }

    ApplicationController() {
        this.applications = new ArrayList<>();
        applications = (ArrayList<Application>) SerializationUtil.readObjectFromFile(FileName.APPLICATION);
    }

    @Override
    public int getNewID() {
        return applications.size() + 1;
    }

    public ArrayList<Application> getApplications() {
        return this.applications;
    }

    public Application getApplicationById(int id) {
        return applications.stream()
                .filter(application -> application.getApplicationID() == id)
                .findFirst()
                .orElse(null);
    }

    public Application getApplicationByStudentID(int stuID) {
        return applications.stream()
                .filter(application -> (application.getStudent().getStudentID() == stuID))
                .findFirst()
                .orElse(null);
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
        SerializationUtil.writeObjectToFile(this.applications, FileName.APPLICATION);
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
