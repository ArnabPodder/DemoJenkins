package demoSelenium;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class HtmlReporter {
	public static void updateResult(int indexSI,  String screenShotLocation,String response) throws IOException {
//		public static void updateResult(int indexSI, String testCaseName, String testCaseStatus, String scriptName) throws IOException{
		String startDateTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new GregorianCalendar().getTime());
	    System.out.println("startDateTime "+startDateTime);
//		String userDirector = System.getProperty("user.dir");

		String resultFile = "D:\\SpringBoot\\demoSelenium\\htmlreport\\HTML_Report1.html";
		
		File file = new File(resultFile);
		System.out.println(file.exists());

		if (!file.exists()) {
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("<html>" + "\n");
			bw.write("<head><title>" + "HTML REPORT DEMO" + "</title>" + "\n");
			bw.write("</head>" + "\n");
			bw.write("<body style=\" background-color:rgb(177, 174, 174)\"");
			bw.write("<u><h1 align='center'><font face='Arial Black'> " + " HTML REPORT DEMO" + "</font></h1></u>" + "\n");
			bw.flush();
			bw.close();
		}
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(file, true));
//		if (indexSI == 1) {

			bw1.write("<table align='center' border='0' width='70%' height='10'>");
			bw1.write("<tr><td width='70%' </td></tr>");
			bw1.write("<table align='center' border='1' width='70%' height='47'>");
			bw1.write("<tr>");
			bw1.write("<td style=\"background-color:rgb(255, 252, 80)\" colspan='1' align='center'><b><font color='#000000' face='Tahoma' size='3'>ScriptName :&nbsp;&nbsp;&nbsp;</font><font color='#0000FF'' face='Tahoma' size='3'> Html Report Demo </font></b></td>");
			bw1.write("<td style=\"background-color:rgb(255, 252, 80)\" colspan='2' align='center'><b><font color='#000000' face='Tahoma' size='3'>Start Time :&nbsp;</font></b><font color='#0000FF'' face='Tahoma' size='3'><b>" + startDateTime + "</b> </font></td>");
			bw1.write("</tr>");
			bw1.write("<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>S.No</font></b></td>");
			bw1.write("<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Screenshot</font></b></td>");
			bw1.write("<td  bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Response </font></b></td>");
			bw1.write("</tr>");
//		}

		bw1.write("<tr>" + "\n");
		bw1.write("<td align='Center'><font color='#000000' face='Tahoma' size='3'>" + indexSI + "</font></td>" + "\n");
		bw1.write("<td valign='middle' align='center'><b><a href=\"D:\\SpringBoot\\demoSelenium\\screenshot\\demoHTML-04-12-2018_04-23-50.png\" target=\"_blank\"> Click to view Screenshot </a></b></td>" + "\n");
		if (response.equals("Pass"))
			bw1.write("<td  bgcolor='#000' valign='middle' align='Center'><b><font color='#1a9807' face='Tahoma' size='5'>" + response + "</font></b></td>" + "\n");
		else if(response.equals("Fail"))
			bw1.write("<td  bgcolor='#000' valign='middle' align='Center'><b><font color='#fd0000' face='Tahoma' size='5'>" + response + "</font></b></td>" + "\n");
		else if(response.equals("Skip"))
			bw1.write("<td  bgcolor='#000' valign='middle' align='Center'><b><font color='#1500ff' face='Tahoma' size='5'>" + response + "</font></b></td>" + "\n");
			
		bw1.write("</tr>" + "\n");
		bw1.write("</body>" + "\n");
		bw1.write("</html>");
		bw1.flush();
		bw1.close();
	}

}
