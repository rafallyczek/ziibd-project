package ziibd.project.department;

public class DepartmentThread extends Thread {

    Department department;

    DepartmentThread(Department department, String name){
        super(name);
        this.department=department;
    }

    @Override
    public void run() {
        System.out.println("Thread "+getName()+" runs.");
        System.out.println("Printing "+department+" field values:");
        System.out.println("Department Id: "+department.getId());
        System.out.println("Department Name: "+department.getName());
        System.out.println("Department Location: "+department.getLoc());
        System.out.println("Department Manager: "+department.getMgr());
        System.out.println("----------------------------------");
    }

}
