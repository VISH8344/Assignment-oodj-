package Model;

import Model.Enum.UserRole;
import java.io.Serializable;

public class Admin  extends User implements Serializable{
    private UserRole u_role = UserRole.ADMIN;
    public Admin(String username, String password){
        super(username, password);
    }

    // TO BE DELETED (Testing purpose)
    @Override
    public String toString() {
        return "Admin{" + super.getUsername() + " : " + super.getPassword() + '}';
    }

   public UserRole getUserRole(){
        return this.u_role;
    }

}
