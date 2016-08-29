import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TagIDValidation {
	public void tagIDValidation() throws IOException{

		File f=new File("TagIdDump","TagIDsDumpFile.txt");
		f.createNewFile();
		File validTagidFile= new File("TagIdDump","ValidTagIDsFile.txt");
		validTagidFile.createNewFile();
		File invalidTagIDsFile=new File("TagIdDump","InvalidTadIDsFile.txt");
		invalidTagIDsFile.createNewFile();
		BufferedReader br =new BufferedReader(new FileReader(f));
		PrintWriter pw=new PrintWriter(new FileWriter(validTagidFile));
		PrintWriter inpw=new PrintWriter(new FileWriter(invalidTagIDsFile));
		String line =br.readLine();
		while(line!=null){
			if(line.length()==8 && line.charAt(0)!='0' && line.charAt(0)!='5'){
			pw.println(line);
			line=br.readLine();
			}else{
				inpw.println(line);
				line=br.readLine();
			}
		}
		pw.flush();
		pw.close();
		
		inpw.flush();
		inpw.close();
		
		br.close();
	
	}
	public static void main(String[] args) throws IOException {
		new TagIDValidation().tagIDValidation();
	}

}
