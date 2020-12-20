import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor {
	private String name;
	private int Doctor_ID;
	private String Specialisation;
	private ArrayList<Integer> public_keys = new ArrayList<Integer>();
	
	public Doctor(String n , int i , String s) {
		this.name = n;
		this.Doctor_ID = i;
		this.Specialisation = s;
	}
	public int get_ID() {
		return this.Doctor_ID;
	}
	public String get_Name() {
		return this.name;
	}
	public void generate_report(Patient p1 , Medical_Database d1) {
		String name = p1.get_Name();
		String doc = this.name;
		String age = p1.get_age();
		String sex = p1.get_sex();
		String pn = p1.get_Phone_no();
		String Address = p1.get_Address();
		LocalDate Date = java.time.LocalDate.now();
		p1.Attend_Appointment();
		String mc = p1.get_medical_concern();
		String mh = p1.get_medical_history();
		int Patient_ID = d1.give_new_record_ID();
		
		Patient_Record p = new Patient_Record(name,doc,age,sex,Patient_ID,pn,Address,Date,mc,mh);
		p1.recieve_privatekey(d1.add_Record(p));
		p1.recieve_publickey(p.get_public_key());
		this.add_Public_key(p.get_public_key());
		System.out.println("Public Key of the record is - "+p.get_public_key());
		System.out.println("Private Key of the record is - "+p1.permit());
		display_record(p);
	}
	public void generate_report(Patient p1) {
		p1.Attend_Appointment();
		System.out.println("*****************************");
		System.out.println("       Medical Report");
		System.out.println("      Date:"+java.time.LocalDate.now());
		System.out.println("Name:"+p1.get_Name());
		System.out.println("Age:"+p1.get_age());
		System.out.println("sex:"+p1.get_sex());
		System.out.println("Phone No.:"+p1.get_Phone_no());
		System.out.println("Address:"+p1.get_Address());
		System.out.println("Doctor's Name:"+this.name);
		System.out.println("Chief Complaint:"+p1.get_medical_concern());
		System.out.println("Medical History:"+p1.get_medical_history());
		System.out.println("*****************************");
		
	}
	private void display_record(Patient_Record p1) {
		System.out.println("*****************************");
		System.out.println("       Medical Report");
		System.out.println("      Date:"+p1.get_Date_of_Presentation());
		System.out.println("Patient_ID:"+p1.get_Patient_ID());
		System.out.println("Name:"+p1.get_Name());
		System.out.println("Age:"+p1.get_age());
		System.out.println("sex:"+p1.get_sex());
		System.out.println("Phone No.:"+p1.get_Phone_no());
		System.out.println("Address:"+p1.get_Address());
		System.out.println("Doctor's Name:"+p1.get_Doctors_name());
		System.out.println("Chief Complaint:"+p1.get_chief_complaint());
		System.out.println("Medical History:"+p1.get_medical_history());
		System.out.println("*****************************");
	}
	private void add_Public_key(int k) {
		this.public_keys.add(k);
	}public ArrayList<Integer> get_public_keys(){
		return this.public_keys;
	}
	
}
