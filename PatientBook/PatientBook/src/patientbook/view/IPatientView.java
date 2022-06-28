/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Partha Gangavalli 2019
//Amended Address Book example from (C) Copyright 1992-2012 by Deitel & Associates, Inc.
package patientbook.view;

import patientbook.model.Patient;
import patientbook.presenter.PatientPresenter;

//IPatientView exposes the functionality of PatientView through these methods
public interface IPatientView {
   
    void bind(PatientPresenter p);
    void setBrowsing(Boolean f); 
    void displayMessage(String m); 
    void displayRecord(Patient p); 
    void displayMaxAndCurrent(int m,int c);
    //void showMessageDialog( String s1, String s2 );
}

