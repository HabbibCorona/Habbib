package Habbib;

import Habbib.controller.RequisitionController;
import Habbib.dao.BedDAO;
import Habbib.dao.InstitutionDAO;
import Habbib.dao.PatientDAO;
import Habbib.model.Bed;
import Habbib.model.Institution;
import Habbib.model.Patient;
import Habbib.model.Requisition;

import java.util.ArrayList;

import java.sql.Date;

public class Main {

    public static <DATE> void main(String[] args) throws Exception {

        RequisitionController require = new RequisitionController();
        InstitutionDAO institutionDAO = new InstitutionDAO();
        Institution institution = new Institution();
        Institution institution2 = new Institution();
        ArrayList<Requisition> requisitions;
        Patient patient = new Patient();
        PatientDAO patientDAO = new PatientDAO();
        Bed bed = new Bed();
        BedDAO bedDAO = new BedDAO();

        try {
            institution = institutionDAO.getInstitutionByName("teste");
            institution2 = institutionDAO.getInstitutionByName("Hospital1");
            requisitions = require.listRequisitions(institution);

            System.out.println("Retorno");

        }
        catch (Exception e){
            throw e;
        }

        int year = 1999-1900;
        Date date = new Date( year, 11, 12);


        patient.setCid("A-50");
        patient.setGender("Feminino");
        patient.setCpf("3333");
        patient.setDob(date);
        patient.setFirstName("Sona");
        patient.setLastName("Sustenido");
        ArrayList<Bed> beds = bedDAO.getBedByInstitution(institution2);
        bed.setInstitution(institution2);
        bed.setType("UTI");

        patientDAO.addPatient(patient);
        require.createRequisition(patient, beds.get(0), institution, "Super teste");
        Requisition requisition2 = new Requisition();
        requisition2.setId(requisitions.get(0).getId());
        requisition2.setStatus("Aprovado");
        require.updateRequisitionStatus(requisition2);

        System.out.println(patient.getDob());

    }
}
