

package com.soft.Repository;

import com.soft.Model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    EmployeeModel findByEmailAndPassword(String email, String password);
}