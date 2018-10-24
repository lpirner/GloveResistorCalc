package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {

    @FXML
    private TextField rhoFX;

    @FXML
    private TextField faktorFX;

    @FXML
    private TextField UBatFX;

    @FXML
    private TextField batWhFX;

    @FXML
    private TextField batChargeFX;

    @FXML
    private TextField trackWidthFX;

    @FXML
    private TextField trackThicknessFX;

    @FXML
    private TextField countMFX;

    @FXML
    private TextField lenghtMFX;

    @FXML
    private TextField lenghtOtherFX;

    @FXML
    private Label r10FX;

    @FXML
    private Label igesFX;

    @FXML
    private Label rgesFX;

    @FXML
    private Label tbatFX;

    @FXML
    private Label PgesFX;


    /**
     * Best method in the world with many super great skills
     *
     */
    public void doEverything(){
        try	{
            //Spezifischer Widerstand in (Ohm * mm^2) / m
            double roh 					= Double.parseDouble(rhoFX.getText());
            double factor				= Double.parseDouble(faktorFX.getText());
            double countM 				= Double.parseDouble(countMFX.getText());

            //Längen in Millimetern (mm)
            double lenghtM 				= Double.parseDouble(lenghtMFX.getText());
            double lenghtOther 			= Double.parseDouble(lenghtOtherFX.getText());
            double trackWidth 			= Double.parseDouble(trackWidthFX.getText());
            double trackThickness 		= Double.parseDouble(trackThicknessFX.getText());

            //Akku Spannung in Volt (V)
            double UBat					= Double.parseDouble(UBatFX.getText());
            //Akku Ladung in Milliamperestunden (mAh)
            double batCharge 			= Double.parseDouble(batChargeFX.getText());
            //Akku Energie in Wattstunden (Wh)
            double batWh				= Double.parseDouble(batWhFX.getText()); //TODO

            //---------------------------------------------------------------------------------------------
            //----------------------- CALCULATE -----------------------------------------------------------
            //---------------------------------------------------------------------------------------------

            //Gesamtlänge in Millimeter (mm)
            double lenght 				= factor * ((countM*lenghtM) + lenghtOther);

            //Fläche in Millimter^2 (mm^2)
            double A 					= trackWidth * trackThickness;

            //Widerstand in Ohm -> Einheiten((Ohm * mm^2) / m) * (m/mm^2)
            double R10mm				= (roh*(0.001/A));
            double Rges					= (roh*((lenght/1000)/A));

            //Strom in Ampere (A)
            double I 					= (UBat / Rges);

            //Leistung in Watt (W)
            double P					= UBat * I;

            //Akku Laufzeit in Stunden
            double tBat					= batCharge/(I*1000);

            //---------------------------------------------------------------------------------------------
            //----------------------- MAGIC ---------------------------------------------------------------
            //---------------------------------------------------------------------------------------------

            r10FX.setText("R10mm (Ohm) = " + Double.toString(R10mm));
            rgesFX.setText("Rges (Ohm) = " + Double.toString(Rges));
            igesFX.setText("Iges (A) = " + Double.toString(I));
            PgesFX.setText("P (UBat * I) = " + Double.toString(P));
            tbatFX.setText("t_Bat (h) = " + Double.toString(tBat));


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

// U = R * I
// I = U / R

// P = U * I
// P = I^2 * R
// P = U^2 / R
}
