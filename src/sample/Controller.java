package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label RproZ;

    @FXML
    private TextField rho;

    @FXML
    private TextField faktor;

    @FXML
    private TextField anzmae;

    @FXML
    private TextField laengeTwin;

    @FXML
    private TextField sonstLae;

    @FXML
    private TextField trackWidth;

    @FXML
    private TextField copperThickness;

    @FXML
    private TextField akkuV;

    @FXML
    private TextField watth;

    @FXML
    private Label Rges;


    private double lenghtproMeander;
    private double anzMeand;
    private double sonstleange;
    private double fakt;

    private double trackWidthC;
    private double copperThicknessC;

    private double rhoC;


    public void CalcAll(){


        lenghtproMeander = Double.parseDouble(laengeTwin.getText());
        anzMeand = Double.parseDouble(anzmae.getText());
        sonstleange= Double.parseDouble(sonstLae.getText());
        fakt = Double.parseDouble(faktor.getText());
        rhoC = Double.parseDouble(rho.getText());

        trackWidthC = Double.parseDouble(trackWidth.getText());
        copperThicknessC = Double.parseDouble(copperThickness.getText());

        double Rresult = (rhoC*((10*fakt)/(trackWidthC*copperThicknessC)));



        RproZ.setText(String.valueOf(Rresult));


    }
}
