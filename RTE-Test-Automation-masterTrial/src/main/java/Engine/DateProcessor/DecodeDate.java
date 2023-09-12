package Engine.DateProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DecodeDate {
    Calendar current = Calendar.getInstance();
    int day;
    int month;
    int year;
    String monthString = "";

    public String decodeDate(String date) {
        if (!date.isEmpty()) {
            parseDate(date);
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date databaseTime = simpleDateFormat.parse(day + "-" + month + "-" + year);
                Date systemTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));

                if (databaseTime.getDate() == systemTime.getDate() && databaseTime.getMonth() == systemTime.getMonth() && databaseTime.getYear() == systemTime.getYear())
                    return "5";
                else if (databaseTime.after(systemTime)) {
                    if (databaseTime.getDay() == 6 || databaseTime.getDay() == 0) {
                        return "3";
                    } else return "4";
                } else if (databaseTime.before(systemTime)) {
                    if (databaseTime.getDay() == 6 || databaseTime.getDay() == 0) {
                        return "1";
                    } else return "2";
                } else {
                    System.out.println("Unhandled condition when coding date");
                    return null;
                }
            } catch (ParseException ex) {

            }
        }
        return "";
    }

    /**
     * Method to generate
     *
     * @param code Requires string code
     * @return Returns string value (coded)
     */
    public String generateDate(String code) {
        parseDate();
        switch (Integer.parseInt(code)) {
            case 1:     weekendPast(); break;
            case 2:     mondayPast(); break;
            case 3:     weekendFuture(); break;
            case 4:     mondayFuture(); break;
            //5 = today
            case 5:     todayPresent(); break;
            //6 = today + year
            case 6:     yearFuture(); break;
            case 7:     nextWorkingDay(); break;
            case 8:     nextMonth(); break;
            case 9:     thisDayNextYear(); break;
            case 10:    tomorrow(); break;
            case 11:    yesterday(); break;
            case 12:    randomDate(); break;
        }
        parseDate();
        setDate();
        /*if (env().getProject().equals("Product")) {
            if (day < 10) {
                return ("0" + String.valueOf(day) + "/" + monthString + "/" + String.valueOf(year));
            }
            return (String.valueOf(day) + "/" + monthString + "/" + String.valueOf(year));
        } else {
            if (day < 10) {
                return ("0" + String.valueOf(day) + "-" + monthString + "-" + String.valueOf(year));
            }
            return (String.valueOf(day) + "-" + monthString + "-" + String.valueOf(year));
        }*/
        if (day < 10) {
            return ("0" + day + "-" + monthString + "-" + year);
        }
        return (day + "-" + monthString + "-" + year);
    }

    /**
     * Method to generate
     *
     * @param code Requires string code
     * @return Returns string value (coded)
     */
    public String generateDateShortYear(String code) {
        parseDate();
        switch (Integer.parseInt(code)) {
            case 1:     weekendPast(); break;
            case 2:     mondayPast(); break;
            case 3:     weekendFuture(); break;
            case 4:     mondayFuture(); break;
            //5 = today
            case 5:     todayPresent(); break;
            //6 = today + year
            case 6:     yearFuture(); break;
            case 7:     nextWorkingDay(); break;
        }
        parseDate();
        setDate();
        /*if (env().getProject().equals("Product")) {
            if (day < 10) {
                return ("0" + String.valueOf(day) + "/" + monthString + "/" + String.valueOf(year));
            }
            return (String.valueOf(day) + "/" + monthString + "/" + String.valueOf(year));
        } else {
            if (day < 10) {
                return ("0" + String.valueOf(day) + "-" + monthString + "-" + String.valueOf(year));
            }
            return (String.valueOf(day) + "-" + monthString + "-" + String.valueOf(year));
        }*/

        //Short year
        String trimmedYear = String.valueOf(year);
        trimmedYear = trimmedYear.replace("2015", "15");

        if (day < 10) {
            return ("0" + day + "-" + monthString + "-" + trimmedYear);
        }
        return (day + "-" + monthString + "-" + trimmedYear);
    }

    /**
     * Method to parse the date
     *
     * @param date Requires String date
     */
    private void parseDate(String date) {
        this.day = Integer.parseInt(date.substring(6, 8));
        this.month = Integer.parseInt(date.substring(4, 6));
        this.year = Integer.parseInt(date.substring(0, 4));
        setDate();
    }

    /**
     * Method to parse the date
     */
    private void parseDate() {
        this.day = current.get(Calendar.DATE);
        this.month = current.get((Calendar.MONTH));
        this.year = current.get(Calendar.YEAR);
    }

    /**
     * Method to find the previous Monday
     */
    private void mondayPast() {
        switch (current.get(Calendar.DAY_OF_WEEK)) {
            case 1:     current.add(Calendar.DATE, -6); break;
            case 2:     current.add(Calendar.DATE, -7); break;
            case 3:     current.add(Calendar.DATE, -1); break;
            case 4:     current.add(Calendar.DATE, -2); break;
            case 5:     current.add(Calendar.DATE, -3); break;
            case 6:     current.add(Calendar.DATE, -4); break;
            case 7:     current.add(Calendar.DATE, -5); break;
        }
    }

    /**
     * Method to find the next Monday
     */
    private void mondayFuture() {
        switch (current.get(Calendar.DAY_OF_WEEK)) {
            case 1:     current.add(Calendar.DATE, 1); break;
            case 2:     current.add(Calendar.DATE, 7); break;
            case 3:     current.add(Calendar.DATE, 6); break;
            case 4:     current.add(Calendar.DATE, 5); break;
            case 5:     current.add(Calendar.DATE, 4); break;
            case 6:     current.add(Calendar.DATE, 3); break;
            case 7:     current.add(Calendar.DATE, 2); break;
        }
    }

    /**
     * Method to find the next year
     */
    private void yearFuture() {
        current.add(Calendar.DATE, 365);
    }

    /**
     * Method to find the next year
     */
    private void thisDayNextYear() {
        current.add(Calendar.DATE, 364);
    }

    /**
     * Method to find the next month
     */
    private void nextMonth() {
        current.add(Calendar.DATE, 30);
    }

    private void todayPresent() {
        current.add(Calendar.DATE, 0);
    }

    private void nextWorkingDay() {
        if (current.get(Calendar.DAY_OF_WEEK) == 5) current.add(Calendar.DATE,+3);
        else if (current.get(Calendar.DAY_OF_WEEK) == 6) current.add(Calendar.DATE,+2);
        else current.add(Calendar.DATE,+1);
    }

    private void tomorrow() {
        current.add(Calendar.DATE,+1);
    }

    private void yesterday() {
        current.add(Calendar.DATE,-1);
    }
    /**
     * Method which generates a random date within a 100 year range before and after today's date
     */
    private void randomDate() {
        int randNum = new Random().nextInt(36500);
        boolean randBool = new Random().nextBoolean();
        if (randBool == true) {
            current.add(Calendar.DATE,+randNum);
        } else {
            current.add(Calendar.DATE,-randNum);
        }
    }

    /**
     * Method to find the previous weekend
     */
    private void weekendPast() {
        switch (current.get(Calendar.DAY_OF_WEEK)) {
            case 1:     current.add(Calendar.DATE, -1); break;
            case 2:     current.add(Calendar.DATE, -2); break;
            case 3:     current.add(Calendar.DATE, -3); break;
            case 4:     current.add(Calendar.DATE, -4); break;
            case 5:     current.add(Calendar.DATE, -5); break;
            case 6:     current.add(Calendar.DATE, -6); break;
            case 7:     current.add(Calendar.DATE, -7); break;
        }
    }

    /**
     * Method to find the next weekend
     */
    private void weekendFuture() {
        switch (current.get(Calendar.DAY_OF_WEEK)) {
            case 1:     current.add(Calendar.DATE, 6); break;
            case 2:     current.add(Calendar.DATE, 5); break;
            case 3:     current.add(Calendar.DATE, 4); break;
            case 4:     current.add(Calendar.DATE, 3); break;
            case 5:     current.add(Calendar.DATE, 2); break;
            case 6:     current.add(Calendar.DATE, 1); break;
            case 7:     current.add(Calendar.DATE, 7); break;
        }
    }

    /**
     * Method to find the month and set the date
     */
    private void setDate() {
        switch (month) {
                case 0:    monthString = "January"; break;
                case 1:    monthString = "February"; break;
                case 2:    monthString = "March"; break;
                case 3:    monthString = "April"; break;
                case 4:    monthString = "May"; break;
                case 5:    monthString = "June"; break;
                case 6:    monthString = "July"; break;
                case 7:    monthString = "August"; break;
                case 8:    monthString = "September"; break;
                case 9:    monthString = "October"; break;
                case 10:   monthString = "November"; break;
                case 11:   monthString = "December"; break;
            }
        }  {
            switch (month) {
                case 0:    monthString = "Jan"; break;
                case 1:    monthString = "Feb"; break;
                case 2:    monthString = "Mar"; break;
                case 3:    monthString = "Apr"; break;
                case 4:    monthString = "May"; break;
                case 5:    monthString = "Jun"; break;
                case 6:    monthString = "Jul"; break;
                case 7:    monthString = "Aug"; break;
                case 8:    monthString = "Sep"; break;
                case 9:    monthString = "Oct"; break;
                case 10:   monthString = "Nov"; break;
                case 11:   monthString = "Dec"; break;
            }
        }


}