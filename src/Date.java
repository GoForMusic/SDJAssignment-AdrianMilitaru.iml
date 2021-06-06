import java.util.GregorianCalendar;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year)
    {
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public boolean isBefore(Date date2)
    {
        if(this.year < date2.year) return true;
        else if(this.year == date2.year && this.month < date2.month) return true;
        else if(this.year == date2.year && this.month == date2.month && this.day < date2.day) return true;
        else return false;
    }

    private boolean isLeapYear()
    {
        //is asking if the year is div 4 AND year is div by 100 but not equal with 0 OR div by 400
        if (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0)
        {
            return true;
        } else {
            return false;
        }
    }

    private int daysInMonth()
    {
        int numbersOfDays=1;

        if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12 )
        {
            numbersOfDays = 31;
        }
        else if ( this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11 )
        {
            numbersOfDays = 30;
        }
        else if ( this.month == 2 )
        {
            if(isLeapYear()){
                numbersOfDays = 29;
            }else{
                numbersOfDays = 28;
            }
        }

        return numbersOfDays;
    }

    private void nextDay()
    {
        this.day++;
        if(this.day>daysInMonth())
        {
            this.day = 1;
            this.month++;
            if(this.month>=12){
                this.day = 1;
                this.month=1;
                this.year++;
            }
        }
    }

    public int numberOfDaysUntil(Date date2) {
        int localDays = 0;
        while (date2.isBefore(this))
        {
            date2.nextDay();
            localDays++;
        }
        return localDays;
    }

    public static Date today(){
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentDay = currentDate.get(GregorianCalendar.DATE);
        int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
        int currentYear = currentDate.get(GregorianCalendar.YEAR);

        return new Date(currentDay,currentMonth,currentYear);
    }

    public Date copy()
    {
        return new Date(this.day,this.month,this.year);
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Date)) return false;

        Date date = (Date) obj;

        if(this.year==date.year&&this.month==date.month&&this.day==date.day) return true;
        else return false;
    }

    public String toString()
    {
        return this.day+"/"+this.month+"/"+this.year;
    }
}
