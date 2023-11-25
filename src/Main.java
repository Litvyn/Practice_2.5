import exception.RegularPassNotEnoughMoneyException;
import exception.SchoolPassOverdueException;
import exception.SchoolPassTripFinishedException;
import exception.StudentPassOverdueException;
import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

public class Main {
    public Main(){

}
    public static void main(String[] args) throws SchoolPassTripFinishedException, RegularPassNotEnoughMoneyException,
            StudentPassOverdueException, SchoolPassOverdueException {

        TurnStile turnStile = new TurnStile();
        SchoolPass schoolPass = new SchoolPass(10, YearMonth.of(2023, 10));

        try {
            for (int i = 0; i < 12; i++) {
                turnStile.validateEntryPermission(schoolPass);
            }
        } catch (StudentPassOverdueException | SchoolPassTripFinishedException | RegularPassNotEnoughMoneyException |
                 SchoolPassOverdueException var9) {
            var9.printStackTrace();
        }

    }

}
