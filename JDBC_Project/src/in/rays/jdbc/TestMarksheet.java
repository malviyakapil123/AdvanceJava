package in.rays.jdbc;


import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		//insert();
		marksheetMeritList();

	}

	private static void marksheetMeritList() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		
		MarksheetModel model = new MarksheetModel();

		List<MarksheetBean> list = model.getMeritList(bean);

		Iterator<MarksheetBean> it = list.iterator();

		System.out.println("ID\tROLLNO\tFNAME\tLNAME\t\tPHYSICS\t\tCHEMISTRY\tMATHS\tMARKS_TOTAL\tPERCENTAGE");

		while (it.hasNext()) {
			MarksheetBean mb = (MarksheetBean) it.next();
			int total = (mb.getChemistry()+mb.getPhysics()+mb.getMathematics());
			double percentage = total/3;
			System.out.print(mb.getId());
			System.out.print("\t" + mb.getRollno());
			System.out.print("\t" + mb.getFname());
			System.out.print("\t" + mb.getLname()+"\t");
			System.out.print("\t" + mb.getPhysics()+"\t");
			System.out.print("\t" + mb.getChemistry()+"\t");
			System.out.print("\t" + mb.getMathematics());
			System.out.print("\t" + total + "\t");
			System.out.println("\t"+percentage);
			
		}

	}

	private static void insert() throws Exception {

		MarksheetBean mb = new MarksheetBean();

		mb.setId(20);
		mb.setRollno(20);
		mb.setFname("Raghav");
		mb.setLname("Sharma");
		mb.setPhysics(62);
		mb.setChemistry(54);
		mb.setMathematics(82);

		MarksheetModel model = new MarksheetModel();
		model.add(mb);
		System.out.println("Record Insert");

	}

}
