package com.example.employee_ms.audit;

import com.example.employee_ms.entity.Employee;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AuditAspect {
    private final AuditLogRepository auditLogRepository;

    public AuditAspect(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

//    @Before("execution(* com.example.employee_ms.service.*.*(..))")
    @Before("execution(* com.example.employee_ms.service.EmployeeService.createEmployee(..))")
    public void logCreateEmployee() {
        AuditLog log = new AuditLog();
        log.setUsername("admin");
        log.setAction("Create new employee");
        log.setTimestamp(new Date());

        auditLogRepository.save(log);
    }

    @Before("execution(* com.example.employee_ms.service.EmployeeService.updateEmployee(..)) && args(employee,..)")
    public void logUpdateEmployee(Employee employee) {
        AuditLog log = new AuditLog();
        log.setUsername("admin");
        log.setAction("Update employee " + employee.getEmployeeId());
        log.setTimestamp(new Date());

        auditLogRepository.save(log);
    }

    @Before("execution(* com.example.employee_ms.service.EmployeeService.deleteEmployee(..)) && args(employeeId,..)")
    public void logDeleteEmployee(String employeeId) {
        AuditLog log = new AuditLog();
        log.setUsername("admin");
        log.setAction("Delete employee " + employeeId);
        log.setTimestamp(new Date());

        auditLogRepository.save(log);
    }

    @Before("execution(* com.example.employee_ms.service.EmployeeService.deleteAllEmployee(..))")
    public void logDeleteAllEmployee() {
        AuditLog log = new AuditLog();
        log.setUsername("admin");
        log.setAction("Delete all employee ");
        log.setTimestamp(new Date());

        auditLogRepository.save(log);
    }

    @Before("execution(* com.example.employee_ms.service.EmployeeService.getAllEmployee(..))")
    public void logGetAllEmployee() {
        AuditLog log = new AuditLog();
        log.setUsername("admin");
        log.setAction("Get all employee");
        log.setTimestamp(new Date());

        auditLogRepository.save(log);
    }

    @Before("execution(* com.example.employee_ms.service.EmployeeService.getEmployee(..)) && args(employeeId,..)")
    public void logGetEmployee(String employeeId) {
        AuditLog log = new AuditLog();
        log.setUsername("admin");
        log.setAction("Get employee " + employeeId);
        log.setTimestamp(new Date());

        auditLogRepository.save(log);
    }
}
