import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;


import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Iterator;

public class KyivSmartCard {

        public static final int COUNT_OF_SCHOOL_PER_MONTH = 50;
        public static final int FARE = 12;
        private static final ArrayList<MetroPass> internalCardStorage = new ArrayList();
        private static int countOfPermetions = 0;
        private static int countOfProhibitions = 0;

        public KyivSmartCard() {
        }

        public static MetroPass createPass(PassType passType) {
            MetroPass metroPass = new MetroPass();
            switch (passType) {
                case SCHOOL_PASS:
                    metroPass = new SchoolPass(50);
                    break;
                case STUDENT_PASS:
                    metroPass = new StudentPass();
                    break;
                case REGULAR_PASS:
                    metroPass = new RegularPass();

            }

            internalCardStorage.add(metroPass);
            ((MetroPass)metroPass).setUid(((MetroPass)metroPass).getUid() + 1);
            return (MetroPass)metroPass;
        }

        public static void addPermition() {

            ++countOfPermetions;
        }

        public static void addProhibition() {

            ++countOfProhibitions;
        }

        public static int getCountOfPermetions() {

            return countOfPermetions;
        }

        public static int getCountOfProhibitions() {
            return countOfProhibitions;
        }

        public static void addFounds(RegularPass regularPass, int amount) {
            regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() + amount);
        }

        public static int getTotalOfOverdueAndEmptyPass() {
            int count = 0 ;
            for (MetroPass metroPass : internalCardStorage){
                if(metroPass instanceof SchoolPass pass ){
                    if (pass.getCountOfTrip() == 0 || pass.getMonth().isBefore(YearMonth.now()))
                        count++;
                }else if (metroPass instanceof  StudentPass pass){
                    if(pass.getMonth().isBefore(YearMonth.now())){
                        count++;
                    }

                }
            }
                return count ;
        }

        public static void subtractFair(RegularPass regularPass) {
            if (regularPass.getAmountOfMoney() >= 12) {
                regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() - 12);
            } else {
                System.out.println("Not enough money !");
            }

        }
}


