package Week3;

import java.util.*;

public class LogEntry 
{
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int byteReturned;

    public LogEntry(String ip,Date time,String req,int status,int bytes)
    {
        ipAddress=ip;
        accessTime=time;
        request=req;
        statusCode=status;
        byteReturned=bytes;
    }


}