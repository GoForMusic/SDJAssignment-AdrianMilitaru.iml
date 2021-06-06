public class CoronaPassport {
    private String reason;
    private Date date;

    public CoronaPassport(String reason, Date date)
    {
        this.reason=reason;
        this.date=date.copy();
    }

    public String getReason()
    {
        return this.reason;
    }

    public Date getDate()
    {
        return this.date;
    }

    public String toString()
    {
        return this.date+" "+ this.reason;
    }
}
