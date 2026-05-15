package com.msa4spring.mappers;

import com.msa4spring.entities.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// DB-JAVA 매핑 해주는 객체
// @Mapper: DB에 데이터 요청(.XML파일의 쿼리문)해서 받아온 데이터를 담는 List 인스턴스(List<Employee>)를 자동생성
@Mapper
public interface EmployeeMapper {
    List<Employee> getEmployees();

    int store(Employee employee);
    Employee findByPk(long empId);
}
