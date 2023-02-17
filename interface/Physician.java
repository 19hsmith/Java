import java.util.ArrayList;
import java.util.Date;


public class Physician extends User implements HIPAACompliantUser{
       
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
    public Physician(Integer id) {
        super(id);
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    @Override
    public boolean assignPin(int pin) {
        int length = (Integer.toString(pin)) .length();
        if(length == 4){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {

        return confirmedAuthID == this.id;
    }
	
    // TO DO: Setters & Getters

}
