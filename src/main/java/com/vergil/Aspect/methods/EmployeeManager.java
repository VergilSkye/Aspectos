package com.vergil.Aspect.methods;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

        public void getEmployeeById(Integer employeeId) {
        System.out.println("Method getEmployeeById() called");
    }

}
