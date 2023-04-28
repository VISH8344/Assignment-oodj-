package oodj_2023;

import Model.Enum.UserRole;
import Model.Student;
import Model.User;
import UI.LoginPage;
import UI.RegisterPage;
import UI.WelcomePage;
import Util.Config_Setup_Data;

public class OODJ_2023 {

    public static User current_user;
    public static boolean isLogIn;
    
    public static Student student;
    public static LoginPage lp;
    public static WelcomePage wp = new WelcomePage();
//    public static RegisterPage rp = new RegisterPage();

    private void initialize() {
        Config_Setup_Data.InitializeData();
        wp.setVisible(true);
    }

    public static void main(String[] args) {
        OODJ_2023 main = new OODJ_2023();
        main.initialize();
    }
    
}
