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
            } else if (command == 3 ) { //3. Сверить отчёты
                if ((reportEngine.monthlyReports.get(1)!=null)&&(reportEngine.yearReports.get(1)!=null)){
                    for (int i=1;i<=3;i++) {
                        check.sverka(reportEngine.monthlyReports.get(i), reportEngine.yearReports.get(1));
                    }
                } else {
                    System.out.println("Нет данных для сверки, вернитесь  к п.1 и п.2 меню");
                }
            }else if (command == 4 ) { //4. Вывести информацию о всех месячных отчётах
                if(reportEngine.monthlyReports.get(1)!=null) {
                     String [] months={"январь","февраль","март"};
                for (int i=1;i<=3;i++){
                    System.out.println("Месяц " + months[i-1]+":");
                    check.returnInfo(reportEngine.monthlyReports.get(i));
                }
                } else {
                    System.out.println("Вы не передали данные месячных отчетов! Вернитесь к п.1 меню");
                }
            } else if (command == 5) { //5. Вывести информацию о годовом отчёте
                if(reportEngine.yearReports.get(1)!=null) {
                    check.returnInfoY(reportEngine.yearReports.get(1));
                } else {
                    System.out.println("Вы не передали данные годового отчета!  Вернитесь к п.2 меню");
                }
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
        System.out.println("Вывести информацию о всех месячных отчётах-4");
        System.out.println("Вывести информацию о годовом отчёте - 5");
        System.out.println("Выход - 0");
    }
}


