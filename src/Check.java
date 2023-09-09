public class Check {
    void returnInfo(MonthlyReport f){
        ///0000
       int sizeEarn=f.earnings.size();
       int sizeExp=f.expenses.size();
       int maxEarn=0;
       int maxExp=0;
       int sumEarn=0;
       int sumExp=0;
       String nameOfMaxEar="";
       String nameOfMaxExp="";

       for (int i=0;i<sizeEarn;i++){
           Record a= f.earnings.get(i);
           if ((a.quantity*a.price)>maxEarn){
              maxEarn=a.quantity*a.price;
              nameOfMaxEar=a.name;
           }
           sumEarn+=a.quantity*a.price;
       }

        for (int i=0;i<sizeExp;i++){
            Record a= f.expenses.get(i);
            if ((a.quantity*a.price)>maxExp){
                maxExp=a.quantity*a.price;
                nameOfMaxExp=a.name;
            }
        sumExp+=a.quantity*a.price;

        }
        System.out.println("Самый прибыльный товар "+nameOfMaxEar+", заработали "+maxEarn+" рублей.");
        System.out.println("Самая большая трата была "+maxExp+" рублей за "+nameOfMaxExp);
    }
    void sverka(MonthlyReport f, YearReport y){
        String [] months={"январь","февраль","март"};

        int sizeEarn=f.earnings.size();
        int sizeExp=f.expenses.size();
       int sumEarn=0;
        int sumExp=0;
        String nameOfMaxEar="";
        String nameOfMaxExp="";

        for (int i=0;i<sizeEarn;i++){
            Record a= f.earnings.get(i);
            sumEarn+=a.quantity*a.price;
        }

        for (int i=0;i<sizeExp;i++){
            Record a= f.expenses.get(i);
            sumExp+=a.quantity*a.price;

        }
       int ii= f.month;
            Integer b = y.expenses.get(ii-1);
            Integer a = y.earnings.get(ii-1);
             if ((sumExp==b)&&(sumEarn==a)) {
            System.out.println("отчеты за "+months[ii-1]+" сошлись");
        }else {
                 if (sumExp!=b){
                     System.out.println("Не сходятся траты за " +months[ii-1]+": в отчете за месяц "+b+",в годовом - "+sumExp);
                 }
                 if (sumEarn!=a){
                     System.out.println("Не сходятся доходы за " +months[ii-1]+": в отчете за месяц "+a+",в годовом - "+sumEarn);
                 }
             }


    }



    void returnInfoY(YearReport y){
        Integer siz= y.month.size();
        String [] months={"январь","февраль","март"};
        System.out.println("Годовой отчет:");
        int sumEarn=0;
        int sumExp=0;
        for (int i=0;i<3;i++) {
            Integer b = y.expenses.get(i);
            Integer a = y.earnings.get(i);
            String name = months[i];
            System.out.println("Месяц "+name+":");

            System.out.println("Прибыль " + (a-b) + " рублей.");
            sumEarn+=a;
            sumExp+=b;
        }
        System.out.println("Среднемесячный доход " + sumEarn/3 + " рублей."+ ", Средние траты " + sumExp/3 + " рублей.");

    }
    }

