import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Patient_Record implements Serializable{
	private String Name;
	private String Doctor_name;
	private String age;
	private String sex;
	private int Patient_ID;
	private String Phone_no;
	private String Address;
	private LocalDate Date_of_presentation;
	private String Chief_complaint;
	private String Medical_History;
	private int public_key;
	private static int n = 4567;
	
public Patient_Record(String name,String Doc,String age,String sex,int Patient_ID,String Phone_no,String Address,LocalDate DOP,String Chief_complaint,String MH) {
		this.Name = name;
		this.Doctor_name = Doc;
		this.age = age;
		this.sex = sex;
		this.Patient_ID = Patient_ID;
		this.Phone_no = Phone_no;
		this.Address = Address;
		this.Date_of_presentation = DOP;
		this.Chief_complaint = Chief_complaint;
		this.Medical_History = MH;
		File file = new File("misc.txt");
		if(file.length() != 0) {
			try
	        {
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            this.n = (int) ois.readObject();
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
		}
		this.public_key = n;
		n -= 15;
		try
        {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.n);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
	}
public String get_Name() {
	return this.Name;
}
public int get_public_key() {
	return this.public_key;
}
public String get_Doctors_name() {
	return this.Doctor_name;
}
public String get_age() {
	return this.age;
}
public String get_sex() {
	return this.sex;
}
public int get_Patient_ID() {
	return this.Patient_ID;
}
public String get_Phone_no() {
	return this.Phone_no;
}
public String get_Address() {
	return this.Address;
}
public LocalDate get_Date_of_Presentation() {
	return this.Date_of_presentation;
}
public String get_chief_complaint() {
	return this.Chief_complaint;
}
public String get_medical_history() {
	return this.Medical_History;
}

}
