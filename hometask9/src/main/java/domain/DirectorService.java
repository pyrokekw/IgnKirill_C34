package domain;

public class DirectorService {

    public static boolean isEmployeeName (Director director, String firstName) {
        for (Employee subordinate : director.getSubordinates() ) {
            if (subordinate.getFirstName().equals(firstName)) {
                return true;
            }
            if (subordinate instanceof Director) {
                if (isEmployeeName((Director) subordinate, firstName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
