package utility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import stepDeff.Hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WordDocument {
 static Hooks hooks = new Hooks();
 static String sceneriname = hooks.getcurrentscenrioname();
    public static void wordreport(List<String> ImgList, List<String> headingList) throws IOException, InvalidFormatException {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph p = doc.createParagraph();
        XWPFRun xwpfrun = p.createRun();
        xwpfrun.setBold(true);
        xwpfrun.setColor("0723f7");
        xwpfrun.setText(hooks.getcurrentscenrioname());
        xwpfrun.addBreak();
        for(int j=0;j < ImgList.size();j++) {
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            xwpfrun.setBold(true);
            xwpfrun.setColor("0723f7");
            xwpfrun.setText(headingList.get(j));
            xwpfrun.addBreak();
            xwpfrun.addPicture(new FileInputStream(ImgList.get(j)),format, headingList.get(j), Units.toEMU(400),Units.toEMU(200));
            xwpfrun.addCarriageReturn();
        }
        String wordDocPath = "";
        //wordDocPath = "C:/Users/ramak/OneDrive/Desktop/screenshots/" + sceneriname + ".docx";
        wordDocPath = System.getProperty("user.dir") + "/target/Extent Reports/" + sceneriname + ".docx";
        System.out.println(wordDocPath);
        FileOutputStream fos = new FileOutputStream(wordDocPath);
        doc.write(fos);
        fos.close();
    }
}
