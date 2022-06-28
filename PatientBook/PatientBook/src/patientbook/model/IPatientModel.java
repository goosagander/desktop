/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientbook.model;

import java.util.List;
import java.time.LocalDate;
//Partha Gangavalli 2019
//Amended Address Book example from (C) Copyright 1992-2012 by Deitel & Associates, Inc.

//IPatientModel exposes the functionality of PatientModel through these methods
public interface IPatientModel 
{
    public List<Patient> getAllPatients();
    public List<Patient> getPatientsByName(String name);
    public List<Patient> getPatientsByID(int id );
    public int addPatient(String firstName,String lastName, int contactPhone,LocalDate dateOfBirth, String gender);
    public void close();
}
