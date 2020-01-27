package ziibd.project.job;

public class JobThread extends Thread {

    Job job;

    JobThread(Job job, String name){
        super(name);
        this.job=job;
    }

    @Override
    public void run() {
        System.out.println("Thread "+getName()+" runs.");
        System.out.println("Printing "+job+" field values:");
        System.out.println("Job Id: "+job.getId());
        System.out.println("Job Title: "+job.getJobTitle());
        System.out.println("Job Minimal Salary: "+job.getMinSal());
        System.out.println("Job Maximum Salary: "+job.getMaxSal());
        System.out.println("----------------------------------");
    }

}
