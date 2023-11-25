package exception;

import passes.SchoolPass;
import passes.StudentPass;
import java.time.YearMonth;

public class StudentPassOverdueException extends Exception {
    private StudentPass pass;
    public StudentPassOverdueException(StudentPass pass) {

        this.pass = pass;
    }

    public int calculateTermOfOverdue() {
        int countMonth = YearMonth.now().getMonthValue() - this.pass.getMonth().getMonthValue();
        int yearMonth = YearMonth.now().getYear() - this.pass.getMonth().getYear();
        return countMonth + yearMonth * 12;
    }

    public String toString() {
        return "StudentPassOverdueException: the pass has been overdue " + this.calculateTermOfOverdue() + " month ago";
    }
}
