package exception;

import passes.SchoolPass;
import java.time.YearMonth;

public class SchoolPassOverdueException extends PassWithTermException{
    private SchoolPass pass;

    public SchoolPassOverdueException(SchoolPass schoolPass) {

        this.pass = schoolPass;
    }

    public int calculateTermOfOverdue() {
        int countMonth = YearMonth.now().getMonthValue() - this.pass.getMonth().getMonthValue();
        int yearMonth = YearMonth.now().getYear() - this.pass.getMonth().getYear();
        return countMonth + yearMonth * 12;
    }

    public String toString() {
        return "SchoolPassOverdueException: the pass has been overdue " + this.calculateTermOfOverdue() + " month ago";
    }
}
