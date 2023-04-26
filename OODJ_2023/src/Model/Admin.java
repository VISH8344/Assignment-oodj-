/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 */
public class Admin  extends User implements Serializable{
    public Admin(String username, String password){
        super(username, password);
    }

    // TO BE DELETED (Testing purpose)
    @Override
    public String toString() {
        return "Admin{" + super.getUsername() + " : " + super.getPassword() + '}';
    }
}
