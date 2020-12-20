import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class Hospital_1 {
	private static ArrayList<Doctor> Doctors = new ArrayList<Doctor>();
	private static Medical_Database Medical_Database;
	public Hospital_1() {
		Doctor dr1 = new Doctor("Rani",2235,"Orthopaedist");
		Doctor dr2 = new Doctor("Rahul",2236,"Physician");
		Doctor dr3 = new Doctor("Rakesh",2237,"Neurology");
		Doctor dr4 = new Doctor("Neeru",2238,"Nephrology");
		Doctor dr5 = new Doctor("Shyam",2239,"Cardiology");
		Doctor dr6 = new Doctor("Raj",2240,"ENT");
		Doctor dr7 = new Doctor("Neetu",2241,"Dermatology");
		Doctor dr8 = new Doctor("Nisha",2242,"Gynecology");
		Doctor dr9 = new Doctor("Arjun",2243,"Pediatrician");
		Doctor dr10 = new Doctor("Anubha",2244,"Dietician");
		Doctor dr11 = new Doctor("Suresh",2245,"General Surgeon");
		this.add_Doctor(dr1);
		this.add_Doctor(dr2);
		this.add_Doctor(dr3);
		this.add_Doctor(dr4);
		this.add_Doctor(dr5);
		this.add_Doctor(dr6);
		this.add_Doctor(dr7);
		this.add_Doctor(dr8);
		this.add_Doctor(dr9);
		this.add_Doctor(dr10);
		this.add_Doctor(dr11);
		this.Medical_Database = new Medical_Database();
		File file = new File("p_anonymous.csv"); 
	    if(file.length() == 0) {
	    	try { 
		        FileWriter outputfile = new FileWriter(file);  
		        CSVWriter writer = new CSVWriter(outputfile); 
		        String[] header = { "Name", "Age", "Sex","Disease","Medical_History" }; 
		        writer.writeNext(header); 
		        writer.close(); 
		    } 
		    catch (IOException e) { 				        
		        e.printStackTrace(); 
		    }
	    }else {
	    }
	}
	public void add_Doctor(Doctor d) {
		Doctors.add(d);
	}
	public ArrayList<Doctor> get_Doctors(){
		return Doctors;
	}private static String anonymise_string(String name) {
		int len = name.length();
		String ans = "";
		for(int i=0;i<len;i++) {
			ans+="*";
		}
		return ans;
	}
	public static void main(String[] args) {
		Hospital_1 h = new Hospital_1();
		System.out.println("       Welcome to StaySafe Hospital");
		System.out.println("         What do you want to do?\n");
		System.out.println("a) Schedule an appointment");
		System.out.println("b) Check Medical Record");
		System.out.println("c) Exit\n");
		Scanner in = new Scanner(System.in);
		System.out.print("Your answer:");
		String ans = in.nextLine();
		
		if(ans.equals("a")) {
				System.out.println("\nPlease provide us with patient details:-\n");
				System.out.print("Patient's name:");
				String p_name = in.nextLine();
				System.out.print("Patient's sex:");
				String p_sex = in.nextLine();
				System.out.print("Patient's age:");
				String p_age = in.nextLine();
				System.out.print("Patient's Phone No.:");
				String p_phone = in.nextLine();
				System.out.print("Patient's Address:");
				String p_address = in.nextLine();
				Patient p1 = new Patient(p_name,p_age,p_sex,p_phone,p_address);
				System.out.println("\nThank you for providing us with your details!");
				System.out.println("Do you want us to store your personal information on our database ?\n");
				System.out.println("a) Yes ");
				System.out.println("b) No\n");
				System.out.print("Your answer:");
				String ch = in.nextLine();
				if(ch.equals("a")) {
					System.out.println("\nThank you for letting us store your data.We will ensure that your data is secured at all times.");
					System.out.println("Do you want to let us use this data to conduct research ? (We ensure that the privacy of the data will be secured)\n");
					System.out.println("a) Yes");
					System.out.println("b) No\n");
					System.out.print("Your answer:");
					String a = in.nextLine();
					if(a.equals("a")) {
						System.out.println("\nThank you for allowing us to use the data for research purposes. For better transparency , down below is how the data would reach the research labs:-\n");
						System.out.println("Name        Age        Sex        Disease        Medical History");
						System.out.println(anonymise_string(p1.get_Name())+"         "+p1.get_age()+"         "+p1.get_sex()+"         "+"XXXX"+"         "+"XXXX\n");
						System.out.println("Which Doctor do you want to consult ?\n");
						System.out.println("a) Physician");
						System.out.println("b) ENT Specialist");
						System.out.println("c) Cardiologist");
						System.out.println("d) Nephrologist");
						System.out.println("e) Neurologist");
						System.out.println("f) Dermatologist");
						System.out.println("g) Gynecologist");
						System.out.println("h) Orthopedist");
						System.out.println("i) Pediatrician\n");
						
						System.out.print("Your answer:");
						String jk = in.nextLine();
						if(jk.equals("a")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2236) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("b")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2240) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("c")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2239) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("d")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2238) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("e")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2237) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("f")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2241) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("g")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2242) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);									
									System.out.print("\n");
								}
							}
						}else if(jk.equals("h")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2235) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("i")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2243) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else {
							System.out.println("/nEnter valid choice!!");
						}
						File file = new File("p_anonymous.csv"); 
					    try { 
					        FileWriter outputfile = new FileWriter(file,true);  
					        CSVWriter writer = new CSVWriter(outputfile); 
					        String[] data1 = {anonymise_string(p1.get_Name()),p1.get_age(),p1.get_sex(),p1.get_medical_concern(),p1.get_medical_history()}; 
					        writer.writeNext(data1); 					  					      
					        writer.close(); 
					    } 
					    catch (IOException e) { 				        
					        e.printStackTrace(); 
					    } 
						
					}if(a.equals("b")) {
						System.out.println("Okay , we won't use your data for research purposes");
						System.out.println("Which Doctor do you want to consult ?\n");
						System.out.println("a) Physician");
						System.out.println("b) ENT Specialist");
						System.out.println("c) Cardiologist");
						System.out.println("d) Nephrologist");
						System.out.println("e) Neurologist");
						System.out.println("f) Dermatologist");
						System.out.println("g) Gynecologist");
						System.out.println("h) Orthopedist");
						System.out.println("i) Pediatrician\n");
						
						System.out.print("Your answer:");
						String jk = in.nextLine();
						if(jk.equals("a")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2236) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("b")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2240) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("c")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2239) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("d")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2238) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("e")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2237) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("f")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2241) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("g")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2242) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);									
									System.out.print("\n");
								}
							}
						}else if(jk.equals("h")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2235) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else if(jk.equals("i")) {
							for(int i=0;i<Doctors.size();i++) {
								if(Doctors.get(i).get_ID() == 2243) {
									System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
									System.out.println("\n------------Appointment Begins-------------\n");
									Doctors.get(i).generate_report(p1,Medical_Database);
									System.out.print("\n");
								}
							}
						}else {
							System.out.println("/nEnter valid choice!!");
						}
					}
				}else if(ch.equals("b")) {
					System.out.println("Okay , we won't store any of the data regarding the patient in our database.");
					System.out.println("\nWhich Doctor do you want to consult ?\n");
					System.out.println("a) Physician");
					System.out.println("b) ENT Specialist");
					System.out.println("c) Cardiologist");
					System.out.println("d) Nephrologist");
					System.out.println("e) Neurologist");
					System.out.println("f) Dermatologist");
					System.out.println("g) Gynecologist");
					System.out.println("h) Orthopedist");
					System.out.println("i) Pediatrician\n");
					
					System.out.print("Your answer:");
					String jk = in.nextLine();
					if(jk.equals("a")) {
						for(int i=0;i<Doctors.size();i++) {
							if(Doctors.get(i).get_ID() == 2236) {
								System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
								System.out.println("\n------------Appointment Begins-------------\n");
								Doctors.get(i).generate_report(p1);
								System.out.print("\n");
							}
						}
					}else if(jk.equals("b")) {
						for(int i=0;i<Doctors.size();i++) {
							if(Doctors.get(i).get_ID() == 2240) {
								System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
								System.out.println("\n------------Appointment Begins-------------\n");
								Doctors.get(i).generate_report(p1);
								System.out.print("\n");
							}
						}
					}else if(jk.equals("c")) {
						for(int i=0;i<Doctors.size();i++) {
							if(Doctors.get(i).get_ID() == 2239) {
								System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
								System.out.println("\n------------Appointment Begins-------------\n");
								Doctors.get(i).generate_report(p1);
								System.out.print("\n");
							}
						}
					}else if(jk.equals("d")) {
						for(int i=0;i<Doctors.size();i++) {
							if(Doctors.get(i).get_ID() == 2238) {
								System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
								System.out.println("\n------------Appointment Begins-------------\n");
								Doctors.get(i).generate_report(p1);
								System.out.print("\n");
							}
						}
					}else if(jk.equals("e")) {
						for(int i=0;i<Doctors.size();i++) {
							if(Doctors.get(i).get_ID() == 2237) {
								System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
								System.out.println("\n------------Appointment Begins-------------\n");
								Doctors.get(i).generate_report(p1);
								System.out.print("\n");
							}
						}
					}else if(jk.equals("f")) {
						for(int i=0;i<Doctors.size();i++) {
							if(Doctors.get(i).get_ID() == 2241) {
								System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
								System.out.println("\n------------Appointment Begins-------------\n");
								Doctors.get(i).generate_report(p1);
								System.out.print("\n");
							}
						}
					}else if(jk.equals("g")) {
						for(int i=0;i<Doctors.size();i++) {
							if(Doctors.get(i).get_ID() == 2242) {
								System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
								System.out.println("\n------------Appointment Begins-------------\n");
								Doctors.get(i).generate_report(p1);									
								System.out.print("\n");
							}
						}
					}else if(jk.equals("h")) {
						for(int i=0;i<Doctors.size();i++) {
							if(Doctors.get(i).get_ID() == 2235) {
								System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
								System.out.println("\n------------Appointment Begins-------------\n");
								Doctors.get(i).generate_report(p1);
								System.out.print("\n");
							}
						}
					}else if(jk.equals("i")) {
						for(int i=0;i<Doctors.size();i++) {
							if(Doctors.get(i).get_ID() == 2243) {
								System.out.println("Dr "+Doctors.get(i).get_Name()+" will take your appointment");
								System.out.println("\n------------Appointment Begins-------------\n");
								Doctors.get(i).generate_report(p1);
								System.out.print("\n");
							}
						}
					}else {
						System.out.println("/nEnter valid choice!!");
					}
				}
			

		}else if(ans.equals("b")) {
			System.out.print("Please provide the keys generated at the time of record generation:-\n");
			System.out.print("\nPublic Key:");
			int puk = in.nextInt();
			System.out.print("Your Private Key:");
			int pk = in.nextInt(); 
			System.out.println("\nWait...\n");
			Medical_Database.read_record(pk, puk);
		}else if(ans.equals("c")) {
			System.out.println("Exiting..");
			System.exit(0);
		}else {
			System.out.println("Enter a valid option!!\n");
			main(args);
		}
		
		
	}
}
