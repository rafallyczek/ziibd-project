package ziibd.project.jobgrade;

public class JobGradeThread extends Thread {

    JobGrade jobGrade;

    JobGradeThread(JobGrade jobGrade, String name){
        super(name);
        this.jobGrade=jobGrade;
    }

    @Override
    public void run() {
        System.out.println("Thread "+getName()+" runs.");
        System.out.println("Printing "+jobGrade+" field values:");
        System.out.println("Job Grade Id: "+jobGrade.getId());
        System.out.println("Job Grade Lowest Salary: "+jobGrade.getLowestSal());
        System.out.println("Job Grade Highest Salary: "+jobGrade.getHighestSal());
        System.out.println("----------------------------------");
    }

}
