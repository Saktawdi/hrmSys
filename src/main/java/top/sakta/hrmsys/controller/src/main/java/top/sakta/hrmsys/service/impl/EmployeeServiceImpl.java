package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.Employee;
import top.sakta.hrmsys.mapper.EmployeeMapper;
import top.sakta.hrmsys.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getEmployeeByID(String eID) {
        return employeeMapper.getEmployeeByID(eID);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }

    @Override
    public int insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(String rID) {
        return employeeMapper.deleteEmployee(rID);
    }
}
