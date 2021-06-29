package pl.edu.pwr.s249248.simracinghelper;

import android.content.res.Resources;

import java.util.Locale;

public class SetupModel {
    private int id;
    private String setup_name;
    private String aero;
    private String transmission;
    private String geometry;
    private String suspension;
    private String brakes;
    private String tyres;
    private boolean areWetTyresOn;

    public SetupModel(int id, String setup_name, String aero, String transmission, String geometry, String suspension, String brakes, String tyres, boolean areWetTyresOn) {
        this.id = id;
        this.setup_name = setup_name;
        this.aero = aero;
        this.transmission = transmission;
        this.geometry = geometry;
        this.suspension = suspension;
        this.brakes = brakes;
        this.tyres = tyres;
        this.areWetTyresOn = areWetTyresOn;
    }

    public SetupModel(String setup_name) {
        this.setup_name = setup_name;
    }

    public SetupModel() {
    }

    @Override
    public String toString() {
        String language = Locale.getDefault().getLanguage();
        String lang_string = null;
        String wet_tyres = null;
        if(language == "pl")
        {
            if(areWetTyresOn==true){
                wet_tyres = "Tak";
            }
            else{
                wet_tyres = "Nie";
            }
            lang_string=setup_name + "\n" + "\n"
                    + "Aerodynamika = " + aero + "\n"
                    + "Przekładnia = " + transmission + "\n"
                    + "Geometria zawieszenia = " + geometry + "\n"
                    + "Zawieszenie = " + suspension + "\n"
                    + "Hamulce = " + brakes + "\n"
                    + "Opony = " + tyres + "\n"
                    + "Opony deszczowe = " + wet_tyres + "\n";
        }
        else
        {
            if(areWetTyresOn==true){
                wet_tyres = "Yes";
            }
            else{
                wet_tyres = "No";
            }
            lang_string=setup_name + "\n" + "\n"
                    + "Aerodynamics = " + aero + "\n"
                    + "Transmission = " + transmission + "\n"
                    + "Suspension geometry = " + geometry + "\n"
                    + "Suspension = " + suspension + "\n"
                    + "Brakes = " + brakes + "\n"
                    + "Tyres = " + tyres + "\n"
                    + "Wet tyres = " + wet_tyres + "\n";

        }
        return lang_string;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrack_name() {
        return setup_name;
    }

    public void setTrack_name(String track_name) {
        this.setup_name = setup_name;
    }

    public String getAero() {
        return aero;
    }

    public void setAero(String aero) {
        this.aero = aero;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getSuspension() {
        return suspension;
    }

    public void setSuspension(String suspension) {
        this.suspension = suspension;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public String getTyres() {
        return tyres;
    }

    public void setTyres(String tyres) {
        this.tyres = tyres;
    }

    public boolean isAreWetTyresOn() {
        return areWetTyresOn;
    }

    public void setAreWetTyresOn(boolean areWetTyresOn) {
        this.areWetTyresOn = areWetTyresOn;
    }
}
