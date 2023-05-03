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
    
    private int generateUniqueNumber(int num){
        return num + 1;
    }
    
    private boolean checkIDIsExist(int id){
        boolean isFound = false;
        for(Application ap : applications){
            if(ap.getApplicationID() == id){
                isFound = true;
            }
        }
        return isFound;
    }

    @Override
    public int getNewID() {
        int tempNewId = applications.size() + 1;
        boolean isIDExist = checkIDIsExist(tempNewId);
        while(isIDExist){
            tempNewId = generateUniqueNumber(tempNewId);
            if(!checkIDIsExist(tempNewId)){
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
            if (applications.get(i).getStudent().getStudentID()== stuID) {
                response = applications.get(i);
                break;
            }
        }
        if (response == null) {
            System.out.println("Application with this student id : " + stuID + " is not found");
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
