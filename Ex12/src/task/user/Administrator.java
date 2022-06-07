package task.user;

public final class Administrator extends Employee{

    public Administrator(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Employee createEmployee(String firstName, String lastName){
        return new Employee(firstName, lastName);
    }

    public void removeEmployee(Employee employee){
        if(employee != null)
            employee = null;
    }
}
