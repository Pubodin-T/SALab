package edu.parinya.softarchdesign.structural;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;


public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{

    public TimeLoggingHealthcareWorker(HealthcareWorker member){
        super(member);
        System.out.println("Decorate " + member.getName() + " with TimeLogging.");
    }

    @Override
    public void service(){
        Date date = new Date();
        var df = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.US);
        System.out.print(df.format(date) + ": ");
        super.service();
    }
}
