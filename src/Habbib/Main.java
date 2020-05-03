package Habbib;

import Habbib.controller.SessionController;
import Habbib.model.Institution;
import Habbib.controller.InstitutionRegister;

public class Main {

    public static void main(String[] args) {

        try
        {
            InstitutionRegister newInstitution = new InstitutionRegister();
            int pkHospital = newInstitution.addAddress(150, 789, "Casa", "Pinheiros", "São Paulo", "SP", "Rua Consolação");
            newInstitution.Register("12332", "Santa casa", "verde", "1190988998", "Privado", pkHospital);
            SessionController sessionController = new SessionController();
            Institution institution = sessionController.login("Santa casa", "verde");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
