package passes;

import java.time.YearMonth;

public class SchoolPass extends MetroPass{
    private int countOfTrip;
    private YearMonth month ;

    public SchoolPass(int countOfTrip, YearMonth month) {
        this.countOfTrip = countOfTrip;
        this.month = month;
    }
    public SchoolPass(int countOfTrip){

        this.countOfTrip= countOfTrip;
    }

    public int getCountOfTrip()
    {
        return this.countOfTrip;
    }
    public YearMonth getMonth(){

        return this.month;
    }

    public void setMonth(YearMonth month){

        this.month=month;
    }
    public void setCountOfTrip(int countOfTrip){

        this.countOfTrip=countOfTrip;
    }
}
