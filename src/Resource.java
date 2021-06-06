public class Resource {
    private String fileName;
    private String extension;

    public Resource(String fileName, String extension)
    {
        this.fileName=fileName;
        this.extension=extension;
    }

    public boolean isPDF()
    {
        if(this.extension.equals("pdf")||this.extension.equals("PDF")) return true;
        else return false;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Resource)) return false;

        Resource resource = (Resource) obj;

        if(this.extension.equals(resource.extension)&&this.fileName.equals(resource.fileName)) return true;
        else return false;
    }

    public String toString()
    {
        return "-Resource for this lesson#\n"+this.fileName+"."+this.extension;
    }

}
