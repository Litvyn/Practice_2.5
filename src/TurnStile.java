import exception.RegularPassNotEnoughMoneyException;
import passes.MetroPass;
import exception.RegularPassNotEnoughMoneyException;
import exception.SchoolPassOverdueException;
import exception.SchoolPassTripFinishedException;
import exception.StudentPassOverdueException;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

public class TurnStile {
    public TurnStile() {

    }

    public void validateEntryPermission(MetroPass metroPass) throws SchoolPassOverdueException, StudentPassOverdueException, SchoolPassTripFinishedException, RegularPassNotEnoughMoneyException {
        if (metroPass instanceof SchoolPass schoolPass) {
            if (schoolPass.getMonth().isBefore(YearMonth.now())) {
                KyivSmartCard.addProhibition();
                throw new SchoolPassOverdueException(schoolPass);
            } else if (schoolPass.getCountOfTrip() <= 0) {
                KyivSmartCard.addProhibition();
                throw new SchoolPassTripFinishedException(schoolPass);
            }
        }
        else if (metroPass instanceof StudentPass studentPass) {
            if (studentPass.getMonth().isBefore(YearMonth.now())) {
                KyivSmartCard.addProhibition();
                throw new StudentPassOverdueException(studentPass);
            } else KyivSmartCard.addPermition();
        }
        else if (metroPass instanceof RegularPass regularPass) {
            if (regularPass.getAmountOfMoney() < 12) {
                KyivSmartCard.addProhibition();
                throw new RegularPassNotEnoughMoneyException(regularPass);

            }
            else{
                KyivSmartCard.subtractFair(regularPass);
                KyivSmartCard.addPermition();
            }
        }

    }
}