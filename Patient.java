import java.util.Scanner;

public class Patient {
	private String Name;
	private String age;
	private String sex;
	private String Phone_no;
	private String Address;
	private int private_key;
	private int public_key;
	private String Medical_concern;
	private String Medical_History;
	
	public Patient(String n,String ag,String s,String p,String a) {
		this.Name = n;
		this.age = ag;
		this.sex = s;
		this.Phone_no = p;
		this.Address = a;
	}
	public void recieve_privatekey(int k) {
		this.private_key = k;
	}
	public void recieve_publickey(int k) {
		this.public_key = k;
	}
	public int permit() {
		return (this.get_private_key());
	}
	public int give_public_key() {
		return this.public_key;
	}
	private void set_medical_concern(String mc) {
		this.Medical_concern = mc;
	}
	private void set_medical_history(String mh) {
		this.Medical_History = mh;
	}
	public String get_medical_concern() {
		return this.Medical_concern;
	}
	public String get_medical_history() {
		return this.Medical_History;
	}
	public void Attend_Appointment() {
		Scanner a = new Scanner(System.in);
		System.out.print("Enter Chief Complaint:");
		String mc = a.nextLine();
		System.out.print("Enter Medical History:");
		String mh = a.nextLine();
		this.set_medical_concern(mc);
		this.set_medical_history(mh);
		a.close();
	}
	public String get_Name() {
		return this.Name;
	}
	public String get_age() {
		return this.age;
	}
	public String get_sex() {
		return this.sex;
	}
	public String get_Phone_no() {
		return this.Phone_no;
	}
	public String get_Address() {
		return this.Address;
	}
	private int get_private_key() {
		return this.private_key;
	}
	
}	
