package top.sakta.hrmsys.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Payroll {
    private String eL1InstName;
    private String eL2InstName;
    private String eL3InstName;
    private int count;
    private int salarySum;
}
