import java.util.ArrayList;
import java.util.HashMap;

public class ReportEngine {
    HashMap<Integer, MonthlyReport>monthlyReports=new HashMap<>();
    YearReport yearReport=new YearReport();
    FileReader fileReader=new FileReader();
    void readMonthlyReports(){
        for (int i=1;i<=3;i++){
             String fileName="m.20210"+i+".csv";
             ArrayList<String> strings = fileReader.readFileContents(fileName);
             strings.remove(0);
             MonthlyReport monthlyReport=new MonthlyReport();
             monthlyReport.year=2021;
             monthlyReport.month=i;
             monthlyReport.expenses=new ArrayList<>();
             monthlyReport.earnings=new ArrayList<>();

             for (String string:strings){
                 String [] split=string.split(",");
                 Record record=new Record(split[0],Integer.parseInt(split[2]),Integer.parseInt(split[3]));
                 if (split[1].equals("TRUE")){
                     monthlyReport.expenses.add(record);
                 }else {
                     monthlyReport.earnings.add(record);

                 }
             }
             monthlyReports.put(i,monthlyReport);
        }
    }

    void readYearReport(){
        for (int i=1;i<=1;i++){
            String fileName="y.2021.csv";
            ArrayList<String> strings = fileReader.readFileContents(fileName);
            strings.remove(0);
            yearReport.year=2021;
            yearReport.yearExpenses=new HashMap<>();
            yearReport.yearEarnings=new HashMap<>();
            for (String string:strings){
                String [] split=string.split(",");
                if (split[2].equals("true")){
                    yearReport.yearExpenses.put(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
                }else {
                    yearReport.yearEarnings.put(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
                }
            }
        }
    }
}


