/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientbook;

import patientbook.model.IPatientModel;
import patientbook.model.PatientModel;
import patientbook.presenter.PatientPresenter;
import patientbook.view.IPatientView;
import patientbook.view.PatientView;

/**
 *
 * Partha Gangavalli 2019 
 * //Amended Address Book example from (C) Copyright 1992-2012 by Deitel & Associates, Inc.   
 */
public class PatientBook {

    
    public static void main(String[] args) {
        
        //create an instance of PatientModel instance
        IPatientModel ipm=new PatientModel();
        //create an instance of PatientView instance
        IPatientView  ipv=new PatientView();
        // create an instance of PatientPresenter with access to model and view
        PatientPresenter pp=new PatientPresenter(ipv,ipm);
        // assign view access to PatientPresenter
        ipv.bind(pp);
    }
    
}
