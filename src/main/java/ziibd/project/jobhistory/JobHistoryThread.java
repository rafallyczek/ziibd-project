package ziibd.project.jobhistory;

public class JobHistoryThread extends Thread {

    JobHistory jobHistory;

    JobHistoryThread(JobHistory jobHistory, String name){
        super(name);
        this.jobHistory=jobHistory;
    }

    @Override
    public void run() {
        System.out.println("Thread "+getName()+" runs.");
        System.out.println("Printing "+jobHistory+" field values:");
        System.out.println("Job History Id: "+jobHistory.getId());
        System.out.println("Job History Start Date: "+jobHistory.getStartDate());
        System.out.println("Job History Department: "+jobHistory.getDept());
        System.out.println("Job History Job: "+jobHistory.getJob());
        System.out.println("Job History End Date: "+jobHistory.getEndDate());
        System.out.println("----------------------------------");
    }

}
