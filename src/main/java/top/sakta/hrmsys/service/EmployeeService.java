package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.Employee;

import java.util.Date;
import java.util.List;

/**
 * Mapper 档案Service
 * @author Quescc
 * @version 1.0
 * @data 2023年12月23日
 */

public interface EmployeeService {
    Employee getEmployeeByID(String eID);

    List<Employee> getAllEmployees();

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(String rID);

    List<Employee> getEmployeeLikeID(String ID);

    List<Employee> getEmployeesByStatus(int eStatus);

    List<Employee> getEmployeesByConditions(String eL1InstID, String eL2InstID, String eL3InstID, String ePositionCategory, String ePositionName, Date StartRecodDate, Date EndRecodDate);

    int updateEmployeeStatus(String eID,int eStatus);

}
