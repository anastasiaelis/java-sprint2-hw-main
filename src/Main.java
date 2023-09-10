import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportEngine reportEngine = new ReportEngine();
        Check check = new Check();
        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                reportEngine.readMonthlyReports();
            }else if (command == 2 ) {
                reportEngine.readYearReport();
            }else if (command == 3 ) {
                 for (int i=1;i<=3;i++) {
                     check.sverka(reportEngine.monthlyReports.get(i), reportEngine.yearReport);
                 }
            }else if (command == 4 ) {
                String [] months={"январь","февраль","март"};
                for (int i=1;i<=3;i++){
                    System.out.println("Месяц " + months[i-1]+":");
                    check.returnInfo(reportEngine.monthlyReports.get(i));
                }
            } else if (command == 5) {
                    check.returnInfoY(reportEngine.yearReport);
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
        scanner.close();
        System.out.println("Программа завершена");
    }
    public static void printMenu(){
        System.out.println("Что вы хотите сделать?");
        System.out.println("Считать все месячные отчёты - 1");
        System.out.println("Считать годовой отчёт - 2");
        System.out.println("Сверить отчёты - 3");
        System.out.println("Вывести информацию о всех месячных отчётах - 4");
        System.out.println("Вывести информацию о годовом отчёте - 5");
        System.out.println("Выход - 0");
    }
}


