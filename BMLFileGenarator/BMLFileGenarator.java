import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class BMLFileGenarator {
	static String  BMLfile;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		new TagIDValidation().tagIDValidation();
		
		Thread.sleep(1000);
		
		File f =new File("TagIdDump","ValidTagIDsFile.txt");
	//	f.createNewFile();
		BufferedReader br =new BufferedReader(new FileReader(f));
		String line=br.readLine();
		l1:for(int outerloop=1;outerloop<=1000;outerloop++){
				File f1 =new File("BMLFiles",fileNameGenarator()+twoDigitValidation(""+outerloop)+".txt");
		//	Thread.sleep(100);
				f1.createNewFile();
				PrintWriter pw =new PrintWriter(new FileWriter(f1));
				pw.println("header line");
				for(int i=1;i<=51;i++){
					if(line==null ){
						pw.print("EOD of the line, no of the ID are "+(i-1));
						
						pw.flush();
						pw.close();
					//	Thread.sleep(100);
						break l1;
					}else{
						if( i<=50){
							pw.println("xxxx"+line+"yyyy");
							// pw.flush();
							//Thread.sleep(100);
							System.out.println("xxxx"+line+"yyyy");
							line=br.readLine();
							//System.out.println("xxxx"+line+"yyyy");
						}else{
							pw.print("EOf of the line, no of the ID are "+(i-1));
						//	br.readLine();
							pw.flush();
							pw.close();
						//	Thread.sleep(2000);
							continue l1;
							}
					}
					}
		}
	}
public static String fileNameGenarator(){
		Calendar c=Calendar.getInstance();
		String year=""+c.get(Calendar.YEAR);
		String month=""+(c.get(Calendar.MONTH)+1);
		String date=""+c.get(Calendar.DATE);
		String hr=""+c.get(Calendar.HOUR);
		String sec=""+c.get(Calendar.SECOND);
		//System.out.println(sec);
		BMLfile =year+twoDigitValidation(month)+twoDigitValidation(date)+twoDigitValidation(hr)+twoDigitValidation(sec);
		return BMLfile;
			}

public  static String twoDigitValidation(String val){
	if(val.length()==1){
		val="0"+val;
	}
	return val;
}

}
