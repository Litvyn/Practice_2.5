package exception;

import passes.RegularPass;

public class RegularPassNotEnoughMoneyException extends Exception{
    private RegularPass pass;

    public RegularPassNotEnoughMoneyException(RegularPass regularPass) {

        this.pass = regularPass;
    }
    public String toString() {
        int var10000 = this.pass.getUid();
        return "RegularPassNotEnoughMoneyException: on the pass with id " + pass.getUid()+ " lefts only " + pass.getAmountOfMoney() + " UAH";
    }
}
