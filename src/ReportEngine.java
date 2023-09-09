import java.util.ArrayList;
import java.util.HashMap;

public class ReportEngine {
    HashMap<Integer, MonthlyReport>monthlyReports=new HashMap<>();
    HashMap<Integer, YearReport>yearReports=new HashMap<>();

    //YearlyReport yearlyReport=new YearlyReport();
    FileReader fileReader=new FileReader();
    void readMonthlyReports(){
        ///0000
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
                         //,
                         //Integer.parseInt(split[0]));
                 if (split[1].equals("TRUE")){
                     monthlyReport.expenses.add(record);
                 }else {
                     monthlyReport.earnings.add(record);

                 }
             }
             monthlyReports.put(i,monthlyReport);
           // System.out.println(strings);
            //System.out.println(monthlyReport.year);

        }


    }

    void readYearReport(){
        ///0000
        for (int i=1;i<=1;i++){
            String fileName="y.2021.csv";
            ArrayList<String> strings = fileReader.readFileContents(fileName);
            strings.remove(0);
            YearReport yearReport=new YearReport();
            yearReport.year=2021;
            yearReport.month=new ArrayList<>();
            yearReport.expenses=new ArrayList<>();
            yearReport.earnings=new ArrayList<>();

            for (String string:strings){

                String [] split=string.split(",");
                yearReport.month.add(Integer.parseInt(split[0]));

                if (split[2].equals("true")){
                    yearReport.expenses.add(Integer.parseInt(split[1]));
                }else {
                    yearReport.earnings.add(Integer.parseInt(split[1]));

                }
            }
            yearReports.put(1,yearReport);


        }


    }



}


