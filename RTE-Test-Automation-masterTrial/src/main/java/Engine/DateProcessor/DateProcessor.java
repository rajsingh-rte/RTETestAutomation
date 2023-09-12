package Engine.DateProcessor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Processor for dates
 */
public class DateProcessor {
    /**
     * Decodes date, returns string
     */
    public String dateDecode(String date) {
        return new DecodeDate().decodeDate(date);
    }

    /**
     * Generate date, return string (01-April-2015)
     */
    public String generateDate(String code) {
        if (!code.isEmpty() && code != null) {
            if (code.length() < 3) {
                return new DecodeDate().generateDate(code);
            } else {
                return code;
            }
        } else {
            return "";
        }
    }

    /**
     * Generate date, return string (01-April-15)
     */
    public String generateDateShortYear(String code) {
        if (!code.isEmpty()) {
            if (code.length() < 3) {
                return new DecodeDate().generateDateShortYear(code);
            } else {
                return code;
            }
        } else {
            return "";
        }
    }

    /**
     * Get current time HH:MM:SS
     */
    public String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * Class to get today's date, not to be used by Test Scripts due to single format (DD/MM/YYYY)
     */
    public String getTodaysDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public List<String> getLastTwoMonthsOfDates() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar current = Calendar.getInstance();

        List<String> dates = new ArrayList<String>();
        dates.add(dateFormat.format(current.getTime()));
        for (int days = 0; days < 59; days++) {
            //for each day
            current.add(Calendar.DATE, -1);
            dates.add(dateFormat.format(current.getTime()));
        }
        dates = reverseList(dates);

        return dates;
    }

    public List<String> getLastSixMonthsOfDates() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar current = Calendar.getInstance();

        List<String> dates = new ArrayList<String>();
        dates.add(dateFormat.format(current.getTime()));
        for (int days = 0; days < 180; days++) {
            //for each day
            current.add(Calendar.DATE, -1);
            dates.add(dateFormat.format(current.getTime()));
        }
        dates = reverseList(dates);

        return dates;
    }

    /**
     * Date Converstion
     * Convert from DD-MMM-YYYY to YYYY-MM-DD
     * @param date Where MMM is the full month word
     * @return number only string
     */
    public String convertToWSDate(String date) {
        if (date != null && !date.equals("")) {
            System.out.println("Converting " + date);
            char[] dateInBytes = date.toCharArray();
            String convertedDate = "";
            String convertYears = "";
            String convertMonths = "";
            boolean inMonth = false;
            String convertDays = "";
            for (int loop = 0; loop < dateInBytes.length; loop++) {
                //If the first two chars, it's days
                if (loop < 2) {
                    convertDays = convertDays + dateInBytes[loop];
                } else if (loop == 2) {
                    inMonth = true;
                } else if (inMonth) {
                    if ((dateInBytes[loop] + "").equals("-")) inMonth = false;
                    else convertMonths = convertMonths + dateInBytes[loop];
                } else {
                    convertYears = convertYears + dateInBytes[loop];
                }
            }
            /*11-11-11*/
            convertMonths = convertAlphabeticDatetoNumeric(convertMonths);
            return convertYears + "-" + convertMonths + "-" + convertDays;

            /*11/November/11*/
            /*convertMonths = convertAlphabeticDatetoFullName(convertMonths);
            return convertYears + "/" + convertMonths + "/" + convertDays;*/

            /*11/Nov/11*/
            //return convertYears + "/" + convertMonths + "/" + convertDays;
        } else {
            System.out.println("date is null");
            return "";
        }
    }

    /**
     * Date Converstion
     * Convert from DD-MMM-YYYY to DD-MM_YY
     * @param date Where MMM is the full month word
     * @return number only string
     */
    public String convertToValuationTableDate(String date) {
        if (date != null && !date.equals("")) {
            System.out.println("Converting " + date);
            char[] dateInBytes = date.toCharArray();
            String convertedDate = "";
            String convertYears = "";
            String convertMonths = "";
            boolean inMonth = false;
            String convertDays = "";
            for (int loop = 0; loop < dateInBytes.length; loop++) {
                //If the first two chars, it's days
                if (loop < 2) {
                    convertDays = convertDays + dateInBytes[loop];
                } else if (loop == 2) {
                    inMonth = true;
                } else if (inMonth) {
                    if ((dateInBytes[loop] + "").equals("-")) inMonth = false;
                    else convertMonths = convertMonths + dateInBytes[loop];
                } else {
                    convertYears = convertYears + dateInBytes[loop];
                }
            }
            /*11-11-11*/
            convertMonths = convertAlphabeticDatetoNumeric(convertMonths);
            return convertDays + "-" + convertMonths + "-" + convertYears.substring(2);

            /*11/November/11*/
            /*convertMonths = convertAlphabeticDatetoFullName(convertMonths);
            return convertYears + "/" + convertMonths + "/" + convertDays;*/

            /*11/Nov/11*/
            //return convertYears + "/" + convertMonths + "/" + convertDays;
        } else {
            System.out.println("date is null");
            return "";
        }
    }

    /**
     * Date Converstion
     * Convert from YYYY-MM-DD to DD-MM-YY
     * @param date Where MMM is the full month word
     * @return number only string
     */
    public String convertWSDateToTaskDashboard(String date) {
        if (date != null && !date.equals("")) {
            //YYYY-MM-DD to YY-MM-DD
            String trim = date.substring(2);
            //YY-MM-DD to DD-MM-YY
            CharSequence cs = trim.subSequence(0, trim.length());
            int divA = 0;
            int divB = 0;
            for (int a = 0; a < cs.length(); a++) {
                char c = cs.charAt(a);
                if (String.valueOf(c).equals("-") && divA == 0) {
                    divA = a;
                } else if (String.valueOf(c).equals("-") && divB ==0) {
                    divB = a;
                }
            }
            if (divA != 0 && divB != 0) {
                CharSequence csa = trim.subSequence(0, divA);
                CharSequence csb = trim.subSequence(divA, divB);
                CharSequence csc = trim.subSequence(divB + 1, trim.length());
                return csc.toString().replace("-", "") + "-" + csb.toString().replace("-", "") + "-" + csa.toString().replace("-", "");
            }
            return "";
        } else {
            System.out.println("date is null");
            return "";
        }
    }


    private String convertAlphabeticDatetoNumeric(String alphabeticMonth) {
        if (alphabeticMonth.contains("Jan")) return "01";
        else if (alphabeticMonth.contains("Feb")) return "02";
        else if (alphabeticMonth.contains("Mar")) return "03";
        else if (alphabeticMonth.contains("Apr")) return "04";
        else if (alphabeticMonth.contains("May")) return "05";
        else if (alphabeticMonth.contains("Jun")) return "06";
        else if (alphabeticMonth.contains("Jul")) return "07";
        else if (alphabeticMonth.contains("Aug")) return "08";
        else if (alphabeticMonth.contains("Sep")) return "09";
        else if (alphabeticMonth.contains("Oct")) return "10";
        else if (alphabeticMonth.contains("Nov")) return "11";
        return "12";
    }

    public String shortToLongMonth(String inputDate){
        String date = inputDate;
        if((date.contains("Jan") && (!date.contains("January")))) date = date.replace("Jan", "January");
        else if((date.contains("Feb") && (!date.contains("February")))) date = date.replace("Feb", "February");
        else if((date.contains("Mar") && (!date.contains("March")))) date = date.replace("Mar", "March");
        else if((date.contains("Apr") && (!date.contains("April")))) date = date.replace("Apr", "April");
        else if((date.contains("Jun") && (!date.contains("June")))) date = date.replace("Jun", "June");
        else if((date.contains("Jul") && (!date.contains("July")))) date = date.replace("Jul", "July");
        else if((date.contains("Aug") && (!date.contains("August")))) date = date.replace("Aug", "August");
        else if((date.contains("Sep") && (!date.contains("September")))) date = date.replace("Sep", "September");
        else if((date.contains("Oct") && (!date.contains("October")))) date = date.replace("Oct", "October");
        else if((date.contains("Nov") && (!date.contains("November")))) date = date.replace("Nov", "November");
        else if((date.contains("Dec") && (!date.contains("December")))) date = date.replace("Dec", "December");
        else System.out.println("Date "+ date +" not processed.");
        return date;
    }

    public String ddMMMMyyyyToDDmmYY(String inputDate){
        String date = inputDate;

        if (inputDate.contains("January")){ date = date.replace("January", "01");}
        else if (inputDate.contains("February")){ date = date.replace("February", "02");}
        else if (inputDate.contains("March")){ date = date.replace("March", "03");}
        else if (inputDate.contains("April")){ date = date.replace("April", "04");}
        else if (inputDate.contains("May")){ date = date.replace("May", "05");}
        else if (inputDate.contains("June")){ date = date.replace("June", "06");}
        else if (inputDate.contains("July")){ date = date.replace("July", "07");}
        else if (inputDate.contains("August")){ date = date.replace("August", "08");}
        else if (inputDate.contains("September")){ date = date.replace("September", "09");}
        else if (inputDate.contains("October")){ date = date.replace("October", "10");}
        else if (inputDate.contains("November")){ date = date.replace("November", "11");}
        else if (inputDate.contains("December")){ date = date.replace("December", "12");}

        date = date.substring(0, 6) + date.substring(8, 10);
        return date;
    }

    private List<String> reverseList(List<String> orig) {
        List<String> reversed = new ArrayList<String>();
        for (int loop = 0; loop < orig.size(); loop++) {
            reversed.add(orig.get((orig.size() - loop) - 1));
        }
        return reversed;
    }

    public String ddMMMyyyyToShortYear (String date) {
        //expected format: 16-Jan-2015
        if (date.length() != 10) {
            System.out.println("Input date not in expected format.");
            return "" ;
        } else {
            return(date.substring(0, 6) + date.substring(8, 10));
        }
    }

    public String swapShortAlphaForNumericDate(String date) {
        if (date.contains("Jan")) return date.replace("Jan","01");
        else if (date.contains("Feb")) return date.replace("Feb","02");
        else if (date.contains("Mar")) return date.replace("Mar","03");
        else if (date.contains("Apr")) return date.replace("Apr","04");
        else if (date.contains("May")) return date.replace("May","05");
        else if (date.contains("Jun")) return date.replace("Jun","06");
        else if (date.contains("Jul")) return date.replace("Jul","07");
        else if (date.contains("Aug")) return date.replace("Aug","08");
        else if (date.contains("Sep")) return date.replace("Sep","09");
        else if (date.contains("Oct")) return date.replace("Oct","10");
        else if (date.contains("Nov")) return date.replace("Nov","11");
        return date.replace("Dec","12");
    }
}
