package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTestSuite {
    @Autowired
    SearchFacade searchFacade;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testFindCompanies() {
        //given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        //when
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        List<Company> companies = searchFacade.findCompanies("ter");

        //then
        Assert.assertEquals(2, companies.size());

        //cleanup
        try {
            companyDao.delete(softwareMachine);
            companyDao.delete(dataMaesters);
            companyDao.delete(greyMatter);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testFindEmployees() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaClarckson = new Employee("Linda", "Clarckson");

        //when
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaClarckson);
        List<Employee> employees = searchFacade.findEmployees("clarck");

        //then
        Assert.assertEquals(2, employees.size());

        //cleanup
        try {
            employeeDao.delete(johnSmith);
            employeeDao.delete(stephanieClarckson);
            employeeDao.delete(lindaClarckson);
        } catch (Exception e) {
            //do nothing
        }
    }
}