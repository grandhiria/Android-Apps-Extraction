package sg.edu.ntu.medicine.lkc.service.AndroidApps;

/*

@author Venugopal Giridharan
@purpose Extract the Android apps from 42matters.com based on the keywords typed
         The keywords are sent to a shell script and the shell script contains other API query parameters
         The shell script's location is obtained from a properties file 
         The location of the properties file obtained from the console
         The output of the shellscript is in JSON format
         The JSON output is converted into an excel sheet
         An excel workbook is created, and for each of the keyword a respective excel sheet is created within the workbook.
 */
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;
import com.google.gson.Gson;
import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class AndroidAppTest_2 {

    private Properties prop = new Properties();
    //Specify the keywords
    //'dummy-test-12x' is not a keyword
    String keywords[] = {"डायबिटीज", "मधुमेह रोगी", "शर्करा", "ग्लिसीमिक", "रक्त शर्करा", "इन्सुलिन", "dummy-test-12x"};
    boolean excelFileCreated;
    private HSSFWorkbook wb;
    private HSSFSheet sheet[] = new HSSFSheet[keywords.length];
    private int rowNumber = 1;
    private int searchStartFrom = 0;
    public int sheetNum = 0;
    int length;

    public int keywordsCount() {
        return keywords.length;
    }

    public void createExcelIO() {
        InputStream input = null;
        try {
            Scanner getInput = new Scanner(System.in);
            System.out.println("Example: /opt/config2.properties");
            System.out.print("Enter the properties file name with its location on your computer: ");
            String inputString = getInput.nextLine();
            System.out.print("You entered: " + inputString + "\n");
            input = new FileInputStream(inputString); //get the file from here
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AndroidAppTest_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            Logger.getLogger(AndroidAppTest_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("The script name is :" + prop.getProperty("FileName") + "\n");
        System.out.println("The output file is :" + prop.getProperty("outputFile"));
    }
    //Create an excel sheet
    void createWorkSheet() {
        wb = new HSSFWorkbook();
        for (int SheetNumber = 0; SheetNumber < keywords.length - 1; SheetNumber++) {
            sheet[SheetNumber] = wb.createSheet(keywords[SheetNumber]);
            // Create row at index zero ( Top Row)
            HSSFRow row = sheet[SheetNumber].createRow((short) 0);
            String[] headers = {"Title", "Category", "Developer", "Description", "Release Date", "currentVersionReleaseDate", "Version", "Website", "Rating Counts", "Average User Rating", "Average User Rating For Current Version", "Market URL", "Size"};
            for (int i = 0; i <= 12; i++) {

                HSSFCell cell = row.createCell((short) i);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(headers[i]);
                excelFileCreated = false;
            }
        }
    }

    public void executeScript(int shnum) throws IOException, InterruptedException, NullPointerException {
        Gson gson = new Gson();
        Process p;
        p = Runtime.getRuntime().exec(prop.getProperty("FileName"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder jsonStringResult = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) != null) {
            jsonStringResult.append(line);
        }

        p.waitFor();
        Results results = gson.fromJson(jsonStringResult.toString(), Results.class);
        List<Data> tempData = results.getResults();
        updateExcelFile(tempData, shnum);
        int newSearchFrom = 0;
        System.out.println("Pages " + results.getPage());
        if (results.getPage() != null) {
            if (results.getPage() < results.getNumPages() + 1) {
                System.out.println("Page Number is : " + results.getPage());
                newSearchFrom = searchStartFrom + 100;
                readAndUpdateScriptFile(searchStartFrom + ",", newSearchFrom + ",");
                searchStartFrom = newSearchFrom;
                executeScript(shnum);

                FileOutputStream fileOutput = new FileOutputStream(prop.getProperty("outputFile"));
                wb.write(fileOutput);
                fileOutput.flush();
                fileOutput.close();
            }
        }

        System.out.println("File Created ..");
        updateKeyword(searchStartFrom + ",", 0 + ",", keywords[shnum], keywords[shnum + 1]);
        searchStartFrom = 0;
    }
    int RowNumReSetter = 0;

    private void updateExcelFile(List<Data> tempData, int sheetNo) {
        if (RowNumReSetter != sheetNo) {
            rowNumber = 1;
            RowNumReSetter = sheetNo;
        }
        if (sheet[sheetNo] != null) {
            for (Data data : tempData) {

                HSSFRow row1 = sheet[sheetNo].createRow((short) rowNumber++);
                int k = 0;

                //ANDROID BELOW *********************
                //cell 1
                HSSFCell cell1 = row1.createCell((short) (k));
                cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell1.setCellValue(data.getTitle());

                //cell 2
                HSSFCell cell2 = row1.createCell((short) (k + 1));
                cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell2.setCellValue(data.getCategory());

                //cell 3
                HSSFCell cell3 = row1.createCell((short) (k + 2));
                cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell3.setCellValue(data.getDeveloper());

                //cell 4
                HSSFCell cell4 = row1.createCell((short) (k + 3));
                cell4.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell4.setCellValue(data.getDescription());

                //cell 5
                HSSFCell cell5 = row1.createCell((short) (k + 4));
                cell5.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell5.setCellValue(data.getCreated());

                //cell 6
                HSSFCell cell6 = row1.createCell((short) (k + 5));
                cell6.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell6.setCellValue(data.getMarketUpdate());

                //cell 7
                HSSFCell cell7 = row1.createCell((short) (k + 6));
                cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell7.setCellValue(data.getVersion());

                //cell 8
                HSSFCell cell8 = row1.createCell((short) (k + 7));
                cell8.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell8.setCellValue(data.getWebsite());

                //cell 9
                if (data.getRating() != null) {
                    HSSFCell cell9 = row1.createCell((short) (k + 8));
                    cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell9.setCellValue(data.getRating());
                } else {
                    HSSFCell cell9 = row1.createCell((short) (k + 8));
                    cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell9.setCellValue("NULL");
                };

                //cell 10
                if (data.getDownloadsMax() != null) {
                    HSSFCell cell10 = row1.createCell((short) (k + 9));
                    cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell10.setCellValue(data.getDownloadsMax());
                } else {
                    HSSFCell cell10 = row1.createCell((short) (k + 9));
                    cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell10.setCellValue("NULL");
                };

                //cell 11
                if (data.getDownloadsMin() != null) {
                    HSSFCell cell11 = row1.createCell((short) (k + 10));
                    cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell11.setCellValue(data.getDownloadsMin());
                } else {
                    HSSFCell cell11 = row1.createCell((short) (k + 10));
                    cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell11.setCellValue("NULL");
                }
                //cell 12
                HSSFCell cell12 = row1.createCell((short) (k + 11));
                cell12.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell12.setCellValue(data.getMarketUrl());

                //cell 13
                if (data.getSize() != null) {
                    HSSFCell cell13 = row1.createCell((short) (k + 12));
                    cell13.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell13.setCellValue(data.getSize());
                } else {
                    HSSFCell cell13 = row1.createCell((short) (k + 12));
                    cell13.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell13.setCellValue("NULL");
                }

                System.out.println("**************************************************************\n");
            }
            
        } 
    }

    public void readAndUpdateScriptFile(String oldSearchFrom, String newSearchFrom) {
        String fileName = prop.getProperty("FileName");
        String line = null;
        StringBuilder builder = new StringBuilder();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("\"from\":")) {
                    String newLine = line.replaceFirst(oldSearchFrom, newSearchFrom);
                    line = newLine;
                }
                builder.append(line + "\n");
                System.out.println(line);
            }
            // Always close files.
            bufferedReader.close();
            createNewScriptFile(builder.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public void updateKeyword(String oldSearchFrom, String newSearchFrom, String oldKeyword, String newKeyword) {
        String fileName = prop.getProperty("FileName");
        String line = null;
        StringBuilder builder = new StringBuilder();
        String newLine;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("\"full_text_term\":")) {

                    newLine = line.replace(oldKeyword, newKeyword);
                    line = newLine;

                    //line = newLine;
                } else if (line.contains("\"from\":")) {
                    newLine = line.replaceFirst(oldSearchFrom, newSearchFrom);
                    line = newLine;
                }
                builder.append(line + "\n");
                System.out.println(line);
            }
            // Always close files.
            bufferedReader.close();
            createNewScriptFile(builder.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    void createNewScriptFile(String scriptContent) {
        // The name of the file to write.
        String fileName = prop.getProperty("FileName");
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Note that write() does not automatically append a newline character.
            bufferedWriter.write(scriptContent);
            // Always close files.
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        AndroidAppTest_2 obj = new AndroidAppTest_2();
        int keywordsCount = obj.keywordsCount();
        obj.createExcelIO();
        obj.createWorkSheet();
        for (int i = 0; i < keywordsCount - 1; i++) {
            obj.executeScript(i);
        }
    }
}
