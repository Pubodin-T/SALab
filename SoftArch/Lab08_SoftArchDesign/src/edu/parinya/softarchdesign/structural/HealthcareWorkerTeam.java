package edu.parinya.softarchdesign.structural;
import java.util.Set;
import java.util.LinkedHashSet;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    private Set<HealthcareServiceable> members;

    public HealthcareWorkerTeam(){
        members = new LinkedHashSet<>();
    }

    public void addMember(HealthcareServiceable worker){
        members.add(worker);
    }

    public void removeMember(HealthcareServiceable worker){
        members.remove(worker);
    }

    public void service(){
        for (HealthcareServiceable member : members){
            member.service();
        }
    }

    public double getPrice(){
        double totalPrice = 0;
        for (var member: members){
            totalPrice += member.getPrice();
        }
        return totalPrice;
    }
}
