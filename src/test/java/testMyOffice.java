import org.accp.office.dao.*;
import org.accp.office.pojo.*;
import org.accp.office.vo.ExpenditureVoDepartment;
import org.accp.office.vo.ExpenditureVoEmployee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author XingYu Yi
 * @create 2019-06-10 17:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class testMyOffice {
    //测试github
    @Autowired
    ApprovalStateMapper approvalStateMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    ExpenditureMapper expenditureMapper;
    @Autowired
    ExpenditureDetailMapper expenditureDetailMapper;
    @Autowired
    LeaveRecordMapper leaveRecordMapper;
    @Autowired
    PositionMapper positionMapper;
    @Autowired
    ReviewRecordMapper reviewRecordMapper;
    @Autowired
    ReviewStateMapper reviewStateMapper;
    @Test
    public void test(){
        /*for (ApprovalState temp : approvalStateMapper.selectByExample(null)) {
            System.out.println(temp);
        }*/

        for (Employee tem : employeeMapper.selectByExample(null)) {
            System.out.println(tem);
        }
    }

    @Test
    public void test01(){
        for (Department dep : departmentMapper.selectByExample(null)) {
            System.out.println(dep);
        }
    }
    
    @Test
    public void test02(){
        for (Expenditure exp : expenditureMapper.selectByExample(null)) {
            System.out.println(exp);
        }
    }

    @Test
    public void test03(){
        LeaveRecordExample leaveRecordExample = new LeaveRecordExample();
        LeaveRecord leaveRecord = leaveRecordMapper.selectByPrimaryKey(1);
        System.err.println(leaveRecord);

        /*for (LeaveRecord leaveRecord : leaveRecordMapper.selectByExample(null)) {
            System.out.println(leaveRecord);
        }*/
    }

    @Test
    public void test04(){
        for (ReviewRecord reviewRecord : reviewRecordMapper.selectByExample(null)) {
            System.out.println(reviewRecord);
        }
    }

    @Autowired
    ChartMapper chartMapper;
    @Test
    public void testVo(){
        for (ExpenditureVoEmployee expenditureVoDepartment : chartMapper.listExpenditureVoEmployee(null, null, null, null)) {
            System.out.println(expenditureVoDepartment);
        }
    }
}
