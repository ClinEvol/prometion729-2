package com.ujiuye.prometion.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.mapper.EmployeeMapper;
import com.ujiuye.prometion.pojo.AgeDistribution;
import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.pojo.EmployeeRole;
import com.ujiuye.prometion.pojo.SexNumber;
import com.ujiuye.prometion.utils.MD5Utils;
import com.ujiuye.prometion.utils.PinyinHelperUtil;
import demo.User;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.nio.ch.SelectorImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRoleService employeeRoleService;

    @Override
    public int remove(int eid) {
        //查一下中间表看一下中间表有没有数据
        List<EmployeeRole> employeeRoleList = employeeRoleService.listByEmpFk(eid);
        if(employeeRoleList!=null && employeeRoleList.size()>0){
            return -1;
        }
        return employeeMapper.remove(eid);
    }


    @Override
    public List<Employee> list(int type,String keyword) {
        List<Employee> list=null;
        if(type==0){//没有条件
            list=employeeMapper.list(null,null,null);
        }
        if(type==1){//按姓名
            list=employeeMapper.list(keyword,null,null);
        }
        if(type==2){//按电话
            list=employeeMapper.list(null,keyword,null);
        }
        if(type==3){//按入职时间
            list=employeeMapper.list(null,null,keyword);
        }
        return list;
    }

    @Override
    public int save(Employee employee,List<Integer> list) {
        //设置默认密码
        employee.setPassword(MD5Utils.stringToMD5("123456"));

        //设置用户名
        while(true){
            //获取姓名的拼音首字母    小江江
            String pinYinHeadChar = PinyinHelperUtil.getPinYinHeadChar(employee.getEname()).toLowerCase();
            //生成4位随机数据
            String number=String.valueOf(Math.random()).substring(3,7);
            String username=pinYinHeadChar+number;
            //查数据库
            Employee dbEmployee = employeeMapper.getByUserName(username);
            if(dbEmployee==null){
                employee.setUsername(username);
                break;
            }
        }
        //添加员工  自增长-获取id
        int save = employeeMapper.save(employee);

        //为这个员工添加角色    emp_role     角色id     员工的id(自增长-获取id)
        Integer eid = employee.getEid();
        //添加中间表   遍历   1,2,3
        for (Integer integer : list) {//integer为角色id
            EmployeeRole employeeRole=new EmployeeRole();
            employeeRole.setEmp_fk(eid);
            employeeRole.setRole_fk(integer);
            employeeRoleService.save(employeeRole);
        }

        return 1;
    }

    @Override
    public int update(Employee employee,List<Integer> list) {
        //先删除旧的角色
        employeeRoleService.removeByEmpFk(employee.getEid());
        //再添加
        Integer eid = employee.getEid();
        //添加中间表   遍历   1,2,3
        for (Integer integer : list) {//integer为角色id
            EmployeeRole employeeRole=new EmployeeRole();
            employeeRole.setEmp_fk(eid);
            employeeRole.setRole_fk(integer);
            employeeRoleService.save(employeeRole);
        }

        return employeeMapper.update(employee);
    }

    @Override
    public int updateLogo(Employee employee) {
        return employeeMapper.update(employee);
    }


    @Override
    public Employee getByEid(int eid) {
        return employeeMapper.getByEid(eid);
    }

    @Override
    public Employee login(String username, String password) {
        Employee employee = employeeMapper.getByUserName(username);
        if(employee==null){//没有查到该用户名的信息
            return null;
        }
        //查到该用户名的信息并判断密码是否正确
        if(MD5Utils.stringToMD5(password).equals(employee.getPassword())){//密码正确
            return employee;
        }
        return null;
    }

    @Override
    public Employee getByUserName(String username) {
        return employeeMapper.getByUserName(username);
    }

    @Override
    public File getExcel(int pageNum) {
        PageHelper.startPage(pageNum,5);
        List<Employee> list = employeeMapper.list(null, null, null);
        PageInfo<Employee> pageInfo=new PageInfo<>(list);
        File file = ListToExcel(pageInfo.getList(), pageNum);
        return file;
    }

    @Override
    public List<SexNumber> sexNumberList() {
        return employeeMapper.sexNumberList();
    }

    @Override
    public List<AgeDistribution> AgeDistributionList() {
        List<AgeDistribution> list=new ArrayList<>();
        list.add(new AgeDistribution(employeeMapper.countAge(18, 29),"青年组"));
        list.add(new AgeDistribution(employeeMapper.countAge(30, 39),"中青年组"));
        list.add(new AgeDistribution(employeeMapper.countAge(40, 49),"中年组"));
        list.add(new AgeDistribution(employeeMapper.countAge(50, 60),"中老年组"));
        return list;
    }

    @Value("${excel.url}")
    private String excelurl;

    //把一个集合写入到excel
    private File ListToExcel(List<Employee> list,int pageNum){
        String fileName="用户数据第"+pageNum+"页数据";
        //创建工作簿
        XSSFWorkbook workbook=new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet(fileName);
        //创建第一行，写表头
        XSSFRow sheetRow = sheet.createRow(0);
        sheetRow.createCell(0).setCellValue("eid");
        sheetRow.createCell(1).setCellValue("ename");
        sheetRow.createCell(2).setCellValue("esex");
        sheetRow.createCell(3).setCellValue("eage");
        sheetRow.createCell(4).setCellValue("telephone");
        sheetRow.createCell(5).setCellValue("hiredate");
        sheetRow.createCell(6).setCellValue("pnum");
        sheetRow.createCell(7).setCellValue("username");
        sheetRow.createCell(8).setCellValue("remark");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        //遍历集合，把集合数据写到excel
        for (int i=0;i<list.size();i++) {
            //获取集合的对象
            Employee employee = list.get(i);
            //一个对象对应一行   行的下标要从1开始
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(employee.getEid());
            row.createCell(1).setCellValue(employee.getEname());
            row.createCell(2).setCellValue(employee.getEsex());
            row.createCell(3).setCellValue(employee.getEage());
            row.createCell(4).setCellValue(employee.getTelephone());
            String timeStr = format.format(employee.getHiredate());
            row.createCell(5).setCellValue(timeStr);//2020-09-09
            row.createCell(6).setCellValue(employee.getPnum());
            row.createCell(7).setCellValue(employee.getUsername());
            row.createCell(8).setCellValue(employee.getRemark());
        }
        File file=new File(excelurl+fileName+".xlsx");
        try {
            workbook.write(new FileOutputStream(file));
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
