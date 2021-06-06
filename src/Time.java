public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int h,int m, int s)
    {
        this.hour=h;
        this.minute=m;
        this.second=s;
    }

    public Time(int totalTimeInSeconds)
    {
        this.hour=totalTimeInSeconds/3600;
        totalTimeInSeconds-=this.hour*3600;
        this.minute=totalTimeInSeconds/60;
        totalTimeInSeconds-=this.minute*60;
        this.second=totalTimeInSeconds;
    }

    public int convertToSeconds()
    {
        return this.hour * 3600 + this.minute * 60 + this.second;
    }

    public boolean isBefore(Time time2)
    {
        return convertToSeconds() < time2.convertToSeconds();
    }

    public Time timeUntil(Time time2)
    {
        int localInt = convertToSeconds()-time2.convertToSeconds();
        return new Time(localInt<0?localInt*=-1:localInt);
    }

    public Time copy()
    {
        return new Time(this.hour,this.minute,this.second);
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Time)) return false;

        Time time = (Time) obj;

        if(this.hour==time.hour&&this.minute== time.minute&&this.second==time.second) return true;
        else return false;
    }

    public String toString()
    {
        return this.hour+":"+this.minute+":"+this.second;
    }

}
