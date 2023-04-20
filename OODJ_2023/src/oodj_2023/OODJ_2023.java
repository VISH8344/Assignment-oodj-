package oodj_2023;

import Model.Student;
import UI.LoginPage;
import UI.RegisterPage;
import UI.WelcomePage;

public class OODJ_2023 {

    public static WelcomePage wp = new WelcomePage();
    public static RegisterPage rp = new RegisterPage();
    public static LoginPage lp = new LoginPage();

    public static Student studentlogin;

    public static void main(String[] args) {
        wp.setVisible(true);
    }

}
