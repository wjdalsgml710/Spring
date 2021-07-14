package com.oracle.oBootMybatis03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis03.model.Emp;
import com.oracle.oBootMybatis03.model.EmpDept;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession session;

	@Override
	public int total() {
		int tot = 0;
		System.out.println("EmpDaoImpl Start total...");
		try {
			 // session -> Mapper ID total 호출
			tot = session.selectOne("tkEmptotal"); // 메소드 변수
			System.out.println("EmpDaoImpl Start total...");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl total Exception->"+e.getMessage());
		}
		
		return tot;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		List<Emp> empList = null;
		System.out.println("EmpDaoImpl listEmp Start...");
		try {
			// Naming Rule
			empList = session.selectList("tkEmpListAll", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->"+e.getMessage());
		}
		return empList;
	}

	@Override
	public Emp detail(int empno) {
		System.out.println("EmpDaoImpl detail start..");
		Emp emp = new Emp();
		try {
			//					    mapper ID , Parameter
			emp = session.selectOne("tkEmpSelOne", empno);
			System.out.println("EmpDaoImpl detail getEname->"+emp.getEname());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl detail Exception->"+e.getMessage());
		}
		return emp;
	}

	@Override
	public int update(Emp emp) {
		System.out.println("EmpDaoImpl update start...");
		int kkk = 0;
		try {
			kkk = session.update("TKempUpdate", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl update Exception->"+e.getMessage());
		}
		return kkk;
	}
	// emp 관리자만 Select
	@Override
	   public List<Emp> listManager() {
	      List<Emp> empList = null;
	      System.out.println("EmpDaoImpl listManager Start...");
	      try {
	         //Naming Rule
	         empList = session.selectList("tkSelectManager");
	      } catch (Exception e) {
	         System.out.println("EmpDaoImpl listManager Exception->"+e.getMessage());
	      }
	      return empList;
	   }

	@Override
	public int insert(Emp emp) {
		int result = 0;
		System.out.println("EmpDaoImpl insert Start...");
		try {
			result = session.insert("insertEmp", emp);
		} catch (Exception e) {
	         System.out.println("EmpDaoImpl insert Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int delete(int empno) {
		int result = 0;
		System.out.println("EmpDaoImpl delete Start...");
		try {
			result = session.delete("delete", empno);
			System.out.println("EmpDaoImpl delete result->"+result);
		} catch (Exception e) {
			System.out.println("EmpDaoImple delete Exception->"+e.getMessage());
		}
		return result;
	}

	@Override
	public List<EmpDept> listEmpDept() {
		System.out.println("EmpDaoImpl listEmpDept Start...");
		List<EmpDept> empDept = null;	      
	    try {
	       //Naming Rule
	    	empDept = session.selectList("TKlistEmpDept");
	    	System.out.println("EmpDaoImpl listEmpDept empDept.size()->"+empDept.size());
	    } catch (Exception e) {
	         System.out.println("EmpDaoImpl listEmpDept Exception->"+e.getMessage());
	    }
	    return empDept;
	   }
}
