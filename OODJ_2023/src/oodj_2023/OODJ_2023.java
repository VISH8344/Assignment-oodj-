package oodj_2023;

import Model.Enum.UserRole;
import Model.Student;
import Model.User;
import UI.LoginPage;
import UI.RegisterPage;
import UI.WelcomePage;

public class OODJ_2023 {

    public static User current_user;
    public static boolean isLogIn;
    
    public static Student student;
    public static WelcomePage wp = new WelcomePage();
//    public static RegisterPage rp = new RegisterPage();
    public static LoginPage lp = new LoginPage(UserRole.STUDENT);

    private void initialize() {
        wp.setVisible(true);
    }

    public static void main(String[] args) {
        OODJ_2023 main = new OODJ_2023();
        main.initialize();
    }
}
