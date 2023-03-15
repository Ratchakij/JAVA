import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Emp_Data_Avg_Age {
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> cList = new ArrayList<ArrayList<String>>();
		ArrayList<StaffInfo> staffInfoList = new ArrayList<StaffInfo>();
		try (Scanner sc = new Scanner(System.in)) {
			// Company Amount
			int n = sc.nextInt();
			sc.nextLine();
			// Company
			for (int i = 0; i < n; i++) {
				String s = sc.nextLine();
				String[] ss = s.split(" ");
				cList.add(new ArrayList<>());
				cList.get(i).add(ss[0]);
				cList.get(i).add(ss[1]);
			}
			//Staff
			int i = 0;
			int j = 0;
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				String[] ss = s.split(" ");
				if (i < Integer.valueOf(cList.get(j).get(1))) {
					StaffInfo staffInfo = new StaffInfo();
					staffInfo.comName = cList.get(j).get(0);
					staffInfo.comName = cList.get(j).get(0);
					staffInfo.id = ss[0];
					staffInfo.name = ss[1];
					staffInfo.surname = ss[2];
					staffInfo.age = Integer.valueOf(ss[3]);
					staffInfoList.add(staffInfo);
					i++;
				}
				if (i == Integer.valueOf(cList.get(j).get(1))) {
					i = 0;
					j += 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// sort
		for (int i = 0; i < cList.size(); i++) {
			for (int j = 0; j < cList.size(); j++) {
				if (cList.get(i).get(0).compareTo(cList.get(j).get(0)) < 0) {
					Collections.swap(cList, i, j);
				}
			}
		}
		for (int i = 0; i < staffInfoList.size(); i++) {
			for (int j = 0; j < staffInfoList.size(); j++) {
				if (staffInfoList.get(i).comName.compareTo(staffInfoList.get(j).comName) < 0) {
					Collections.swap(staffInfoList, i, j);
				}
			}
		}
		// Find avg age
		for (int i = 0; i < cList.size(); i++) {
			double totalAge = 0;
			//			System.out.println(cList.get(i).get(0));
			for (int j = 0; j < staffInfoList.size(); j++) {
				StaffInfo s = new StaffInfo();
				if (cList.get(i).get(0).equals(staffInfoList.get(j).comName)) {
					totalAge += staffInfoList.get(j).age;
				}
			}
			totalAge /= Integer.valueOf(cList.get(i).get(1));
			//			System.out.println(totalAge);
		}
		// Find the oldest
		for (int i = 0; i < cList.size(); i++) {
			StaffInfo s = new StaffInfo();
			for (int j = 0; j < staffInfoList.size(); j++) {
				if (cList.get(i).get(0).equals(staffInfoList.get(j).comName)) {
					//					max = max > staffInfoList.get(j).age ? max : staffInfoList.get(j).age;
					s = s.age > staffInfoList.get(j).age ? s : staffInfoList.get(j);
				}
			}
			System.out.println(s.comName + " " + s.id + " " + s.age + " " + s.name + " " + s.surname);
		}
	}
}

class StaffInfo {

	public String comName;
	public String id;
	public String name;
	public String surname;
	public int age;

	public StaffInfo() {
	}

	public StaffInfo(String xcomName) {
		this.comName = xcomName;
	}

	public StaffInfo(String xid, String xname, String xsurname, int xage) {
		this.id = xid;
		this.name = xname;
		this.surname = xsurname;
		this.age = xage;
	}

	@Override
	public String toString() {
		return "StaffInfo [comName=" + comName + ", id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
}
