package pl.ave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.ave.model.Employee;
import pl.ave.repository.EmployeeRepository;

import java.sql.SQLOutput;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataCustomQueriesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =SpringApplication.run(SpringDataCustomQueriesApplication.class, args);

        EmployeeRepository employeeRepo = ctx.getBean(EmployeeRepository.class);

        Stream.of(new Employee("Tomek", "Gruby", 2700.0),
                new Employee("Adrian", "Adi", 3500.0),
                new Employee("Michał", "Zet", 4750.0),
                new Employee("Patrycja", "Zet", 2500.0)).forEach(employeeRepo::save);

        System.out.println("Employees  find by last name and salary >= 2000");
        employeeRepo.findByLastNameAndSalary("Zet", 2000).forEach(System.out::println);

        System.out.println("Employee with salary greater than  >= 3500");
        employeeRepo.namesForSalaryAsc(3500).forEach(System.out::println);

    }

}
