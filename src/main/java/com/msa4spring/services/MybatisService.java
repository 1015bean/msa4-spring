package com.msa4spring.services;

import com.msa4spring.entities.Employee;
import com.msa4spring.mappers.EmployeeMapper;
import com.msa4spring.requests.EmployeesStoreRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 서비스 클래스임을 지정: @Service
// 생성자 자동생성: @RequiredArgsConstructor
@Service
@RequiredArgsConstructor
public class MybatisService {
    // 만들어 둔 맵퍼 불러오기
    private final EmployeeMapper employeeMapper;

    public List<Employee> getEmployees() {
        return employeeMapper.getEmployees();
    }

    // 트랜잭션(DB 롤백커밋) 자동실행: @Transactional
    @Transactional
    public Employee store(EmployeesStoreRequest employeesStoreRequest) {
        Employee employee = new Employee();
        employee.setBirth(employeesStoreRequest.birth());
        employee.setGender(employeesStoreRequest.gender());
        employee.setName(employeesStoreRequest.name());

        employeeMapper.store(employee);

        return employeeMapper.findByPk(employee.getEmpId());
    }
}
