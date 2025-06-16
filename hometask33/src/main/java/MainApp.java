import relationships.manyToMany.Course;
import relationships.manyToMany.Student;
import relationships.oneToMany.Department;
import relationships.oneToMany.Employee;
import relationships.oneToOne.User;
import relationships.oneToOne.UserDetails;
import services.*;


public class MainApp {

    private static final SaveService saveService = new SaveService();
    private static final FindByIDService findService = new FindByIDService();

    public static void main(String[] args) {

        //OneToOne
        User user = new User();
        user.setName("Mike");
        UserDetails userDetails = new UserDetails();
        userDetails.setMobileNumber("1111");
        user.setUserDetails(userDetails);
        userDetails.setUser(user);

        saveService.save(user);

        User user1 = findService.findByID(user.getId(), User.class);

        System.out.println("Поиск по айди Пользователя с деталями.");
        System.out.println(user1);

        //OneToMany/ManyToOne
        Department dept = new Department();
        dept.setName("IT");

        Employee emp1 = new Employee();
        emp1.setName("Alice");
        emp1.setPosition("Developer");

        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setPosition("Manager");

        dept.addEmployee(emp1);
        dept.addEmployee(emp2);
        saveService.save(dept);

        Department dep = findService.findByID(dept.getId(), Department.class);
        Employee emp = findService.findByID(emp2.getId(), Employee.class);

        System.out.println("Поиск по айди Департамента и Сотрудника.");
        System.out.println(dep);
        System.out.println(emp);

        //ManyToMany
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Lamp");

        Course math = new Course();
        math.setTitle("Mathematics");

        Course physics = new Course();
        physics.setTitle("Physics");

        student.addCourse(math);
        student.addCourse(physics);
        saveService.save(student);

        Student stud = findService.findByID(student.getId(), Student.class);
        Course course = findService.findByID(math.getId(), Course.class);

        System.out.println("Поиск по айди Студента и Предмета.");
        System.out.println(stud);
        System.out.println(course);


    }
}
