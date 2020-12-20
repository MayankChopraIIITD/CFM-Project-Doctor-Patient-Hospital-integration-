import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Medical_Database  {
	private ArrayList<Patient_Record> Patient_Records = new ArrayList<Patient_Record>() ;
	private ArrayList<Integer> Patient_Public_keys;
	private ArrayList<Integer> Patient_Private_keys;
	private int num = 67950;
	public Medical_Database() {
		File file = new File("PatientRecord.txt");
		if(file.length() > 0) {
			System.out.println("Decrypting Data...");
			System.out.println("Done!!");
			try
	        {
	            FileInputStream fis = new FileInputStream("PatientRecord.txt");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	 
	            this.Patient_Records = (ArrayList) ois.readObject();
	            this.Patient_Public_keys = (ArrayList) ois.readObject();
	            this.Patient_Private_keys = (ArrayList) ois.readObject();
	            this.num = (int) ois.readObject();
	            ois.close();
	            fis.close();
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	            return;
	        } 
	        catch (ClassNotFoundException c) 
	        {
	            System.out.println("Class not found");
	            c.printStackTrace();
	            return;
	        }
		}else {
			this.Patient_Private_keys = new ArrayList<Integer>();
			this.Patient_Public_keys = new ArrayList<Integer>();
		}
	}
	public int add_Record(Patient_Record pr1) {
		Patient_Records.add(pr1);
		Patient_Private_keys.add(num);
		Patient_Public_keys.add(pr1.get_public_key());
		int n = this.num;
		this.num -= 65;
		try
        {
            FileOutputStream fos = new FileOutputStream("PatientRecord.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.Patient_Records);
            oos.writeObject(this.Patient_Public_keys);
            oos.writeObject(this.Patient_Private_keys);
            oos.writeObject(this.num);
            oos.close();
            fos.close();
            System.out.println("Encrypting Data...");
            System.out.println("Done!!");
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
		return n;
	}
	public int give_new_record_ID() {
		return Patient_Records.size();
	}
	private int give_record_ID(Patient_Record p1) {
		return Patient_Records.indexOf(p1);
	}
	public void read_record(int private_key,int public_key) {
		int j = -1;
		for(int i=0;i<Patient_Private_keys.size();i++) {
			if(Patient_Private_keys.get(i).intValue() == private_key && Patient_Public_keys.get(i).intValue() == public_key) {
				j = i;
				break;
			}
		}
		if(j != -1) {
			System.out.println("Keys matched, showing result now:-");
			display_record(this.Patient_Records.get(j));
		}else {
			System.out.println("You need to enter valid keys to gain access to health record!!");
		}
	}
	public void read_record(int public_key) {
		System.out.println("You cannot access document without private key");
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
	public ArrayList<Integer> get_Patient_Public_Keys(){
		return this.Patient_Public_keys;
	}
}
