package DataBaseConnection;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import com.mysql.jdbc.Statement;

public class FileToFileTransformation {

    FileReader fr = null;
    BufferedReader br=null;
    String readLine;
    String filePath;
    StringBuffer sb = new StringBuffer();
    String line;
    //1st Code
    public StringBuffer readTextFile(String filePath) throws IOException {
        fr = new FileReader(filePath);
        br = new BufferedReader(fr);


        while((readLine = br.readLine()) != null)
        {
            line=readLine;
            sb.append(line+"\n");


        }
        System.out.println(sb);
        return sb;

    }
//2nd Code
    public static StringBuffer readTextFile2(String args, String filePath)throws Exception
    {
        // File file = new File(filePath);
        // BufferedReader br = new BufferedReader(new FileReader(file));
        // like \test as \t (ie. as a escape sequence)
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
        return null;
    }

    @Test
    public void verify() throws Exception {
        //StringBuffer sbb = readTextFile("C:\\Users\\singhrajs\\OneDrive - Broadridge Financial Solutions, Inc\\Desktop\\File To File Transformation\\LEGAL_ENTITY_UPLOAD_0.1\\LEGAL_ENTITY_UPLOAD\\output\\upsertJuristicLegalEntities.txt");
        //System.out.println(sbb);

        StringBuffer abc = readTextFile2("","C:\\Users\\singhrajs\\OneDrive - Broadridge Financial Solutions, Inc\\Desktop\\File To File Transformation\\LEGAL_ENTITY_UPLOAD_0.1\\LEGAL_ENTITY_UPLOAD\\output\\upsertJuristicLegalEntities.txt");
        System.out.println(abc);
    }



}



