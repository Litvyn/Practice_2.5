package exception;

import passes.SchoolPass;

public class SchoolPassTripFinishedException extends Exception{
    private SchoolPass pass;

    public SchoolPassTripFinishedException(SchoolPass schoolPass) {
        this.pass = schoolPass;
    }

    public String toString() {
        return "SchoolPassTripFinishedException: school pass " + pass.getUid() + " has no more trip";
    }

}
