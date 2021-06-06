public class DiscordLesson extends OnlineLesson
{
    private String channelName;

    public DiscordLesson(String topic, Date date, Time start, Time end, Resource[] res, boolean camera,String channel)
    {
        super(topic,date,start,end,res,camera);
        this.channelName=channel;
    }

    public String getChannelName()
    {
        return this.channelName;
    }

    public String nameOfSoftware()
    {
        return "Discord";
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof DiscordLesson)) return false;

        DiscordLesson discordLesson = (DiscordLesson) obj;

        if(this.channelName.equals(discordLesson.channelName)&&super.equals(discordLesson)) return true;
        else return false;
    }


    public String toString()
    {
        String localString = this.channelName+" ";
        localString+=super.toString();
        return localString;
    }
}
