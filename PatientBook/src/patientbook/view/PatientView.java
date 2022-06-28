/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientbook.view;

// Fig. 28.32: PatientView.java
// A simple Patient book
//Partha Gangavalli 2019
//Amended Address Book example from (C) Copyright 1992-2012 by Deitel & Associates, Inc.

import patientbook.view.IPatientView;
import patientbook.presenter.PatientPresenter;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import patientbook.model.Patient;

public class PatientView extends JFrame implements IPatientView
{
   // the presenter for this view
   private PatientPresenter presenter;

   // GUI components
   private JButton browseButton;
   private JLabel ageLabel;
   private JTextField ageTextField;
   private JLabel firstNameLabel;
   private JTextField firstNameTextField;
   private JLabel idLabel;
   private JTextField idTextField;
   private JTextField indexTextField;
   private JLabel lastNameLabel;
   private JTextField lastNameTextField;
   
   private JLabel addLabel;
   private JTextField addTextField;
   private JTextField maxTextField;
   private JButton nextButton;
   private JLabel ofLabel;
   private JLabel nextOfKinLabel;
   private JTextField nextOfKinTextField;
   private JButton previousButton;
   private JButton queryByNameButton;
   private JButton queryByIDButton;
   private JLabel queryByNameLabel;
   private JLabel queryByIDLabel;
   private JPanel queryPanel;
   private JPanel navigatePanel;
   private JPanel displayPanel;
   private JTextField queryByNameTextField;
   private JTextField queryByIDTextField;
   private JButton insertButton;
   
   // no-argument constructor
   public PatientView()
   {
      super( "Patient Book" ); 
      
      // create GUI
      navigatePanel = new JPanel();
      previousButton = new JButton();
      indexTextField = new JTextField( 2 );
      ofLabel = new JLabel();
      maxTextField = new JTextField( 2 );
      nextButton = new JButton();
      displayPanel = new JPanel();
      idLabel = new JLabel();
      idTextField = new JTextField( 10 );
      firstNameLabel = new JLabel();
      firstNameTextField = new JTextField( 10 );
      lastNameLabel = new JLabel();
      lastNameTextField = new JTextField( 10 );
      ageLabel = new JLabel();
      ageTextField = new JTextField( 10 );
      nextOfKinLabel = new JLabel();
      nextOfKinTextField = new JTextField( 10 );
      nextOfKinLabel = new JLabel();
      nextOfKinTextField = new JTextField( 10 );
      queryPanel = new JPanel();
      queryByNameLabel = new JLabel();
      queryByNameTextField = new JTextField( 10 );
      queryByIDLabel = new JLabel();
      queryByIDTextField = new JTextField( 10 );
      queryByNameButton = new JButton();
      queryByIDButton = new JButton();
      browseButton = new JButton();
      insertButton = new JButton();
     

      setLayout( new FlowLayout( FlowLayout.CENTER, 10, 10 ) );
      setSize( 600, 355 );
      setResizable( false );

      navigatePanel.setLayout(
         new BoxLayout( navigatePanel, BoxLayout.X_AXIS ) );

      previousButton.setText( "Previous" );
      
      previousButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               previousButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      navigatePanel.add( previousButton );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      indexTextField.setHorizontalAlignment(
         JTextField.CENTER );
      
      navigatePanel.add( indexTextField );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      ofLabel.setText( "of" );
      navigatePanel.add( ofLabel );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      maxTextField.setHorizontalAlignment(
         JTextField.CENTER );
      maxTextField.setEditable( false );
      navigatePanel.add( maxTextField );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      
      nextButton.setText( "Next" );
      nextButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               nextButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      navigatePanel.add( nextButton );
      add( navigatePanel );
      
      //set browsing to off
      setBrowsing(false);
      displayPanel.setLayout( new GridLayout( 5, 2, 4, 4 ) );
      
      //Ass 1 set text
      idLabel.setText( "Test ID:" );
      
      
      //idLabel.setText( "Patient ID:" );
      displayPanel.add( idLabel );
      idTextField.setEditable( false );
      displayPanel.add( idTextField );

      //Ass 1 set text
      firstNameLabel.setText( "First Name:" );
      
      //nameLabel.setText( "Patient Name:" );
      displayPanel.add( firstNameLabel );
      displayPanel.add( firstNameTextField );

      lastNameLabel.setText( "Last Name:" );
      displayPanel.add( lastNameLabel );
      displayPanel.add( lastNameTextField );

      ageLabel.setText( "Contact Phone:" );
      displayPanel.add( ageLabel );
      displayPanel.add( ageTextField );

      nextOfKinLabel.setText( "Date of Birth:" );
      displayPanel.add( nextOfKinLabel );
      displayPanel.add( nextOfKinTextField );
      add( displayPanel );
      
      nextOfKinLabel.setText( "Gender:" );
      displayPanel.add( nextOfKinLabel );
      displayPanel.add( nextOfKinTextField );
      add( displayPanel );
      
      nextOfKinLabel.setText( "Test Date:" );
      displayPanel.add( nextOfKinLabel );
      displayPanel.add( nextOfKinTextField );
      add( displayPanel );
      
      nextOfKinLabel.setText( "Test Method:" );
      displayPanel.add( nextOfKinLabel );
      displayPanel.add( nextOfKinTextField );
      add( displayPanel );

      nextOfKinLabel.setText( "Test Result:" );
      displayPanel.add( nextOfKinLabel );
      displayPanel.add( nextOfKinTextField );
      add( displayPanel );
      
      queryPanel.setLayout( 
         new BoxLayout( queryPanel, BoxLayout.X_AXIS) );

      queryPanel.setBorder( BorderFactory.createTitledBorder(
         "Find an entry by name or id" ) );
      queryByNameLabel.setText( "Patient Name:" );
      queryPanel.add( Box.createHorizontalStrut( 5 ) );
      queryPanel.add( queryByNameLabel );
      queryPanel.add( Box.createHorizontalStrut( 10 ) );
      queryPanel.add( queryByNameTextField );
      queryPanel.add( Box.createHorizontalStrut( 10 ) );
      queryByNameButton.setText( "Find Name" );
      queryPanel.add( queryByNameButton );
      
      queryByIDLabel.setText( "Patient Id" );
      queryPanel.add( Box.createHorizontalStrut( 5 ) );
      queryPanel.add( queryByIDLabel );
      queryPanel.add( Box.createHorizontalStrut( 10 ) );
      queryPanel.add( queryByIDTextField );
      queryPanel.add( Box.createHorizontalStrut( 10 ) );
      queryByIDButton.setText( "Find ID" );
      queryPanel.add( queryByIDButton );
      queryByNameButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               queryButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener
      
      queryByIDButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               queryButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener
      
      
      queryPanel.add( Box.createHorizontalStrut( 5 ) );
      add( queryPanel );
      
      
      browseButton.setText( "Browse All Entries" );
      browseButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               browseButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      add( browseButton );

      insertButton.setText( "Insert New Entry" );
      insertButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               insertButtonActionPerformed( evt );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

	   add( insertButton );

      addWindowListener( 
         new WindowAdapter() 
         {  
            public void windowClosing( WindowEvent evt )
            {
               presenter.close();
               System.exit( 0 );
            } // end method windowClosing
         } // end anonymous inner class
      ); // end call to addWindowListener
	
      
      setVisible( true );
   } // end no-argument constructor

   // set the presenter for this view
   public void bind( PatientPresenter pp) {
       presenter = pp;
   }

    // Event handlers
    
   // handles call when previousButton is clicked
   private void previousButtonActionPerformed( ActionEvent evt ) {
       presenter.showPrevious();
   }

   // handles call when nextButton is clicked
   private void nextButtonActionPerformed( ActionEvent evt ) 
   {
       presenter.showNext();
   } 

   // handles call when queryButton is clicked
   private void queryButtonActionPerformed( ActionEvent evt )
   {
       if(evt.getSource()==queryByIDButton)
       presenter.performQueryById(Integer.parseInt(queryByIDTextField.getText()));
       else
       presenter.performQueryByName(queryByNameTextField.getText());
   } 

   // handles call when browseButton is clicked
   private void browseButtonActionPerformed( ActionEvent evt )
   {
       presenter.browse();
   }

   // handles call when insertButton is clicked
   private void insertButtonActionPerformed( ActionEvent evt ) 
   {
       String firstName=firstNameTextField.getText();
       String lastName=lastNameTextField.getText();
       int contactPhone=Integer.parseInt(contactPhoneTextField.getText());
       String nok=nextOfKinTextField.getText();
       presenter.insertNewEntry(name,address,age,nok);
   } 
    // IPatientView interface implementation
   
    public void displayRecord(Patient p)
    {
        
        idTextField.setText(""+p.getPatientID());
        firstNameTextField.setText( p.getfirstName() );
        addressTextField.setText( p.getAddress() );
        ageTextField.setText(""+p.getAge() );
        nextOfKinTextField.setText(p.getNextOfKin() );
        
    }
    public void displayMaxAndCurrent(int m,int c)
    {
        maxTextField.setText(""+m);
        indexTextField.setText(""+(c+1));
    }
    public void displayMessage(String m)
    {
         JOptionPane.showMessageDialog( this,m );
    }
    public void setBrowsing(Boolean f)
    {
        nextButton.setEnabled(f);
        previousButton.setEnabled( f );
    }
    
   

} // end class PatientView


