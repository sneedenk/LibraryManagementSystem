/**
 * 
 */
package com.ss.lms.biz.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.lms.biz.entity.Branch;
import com.ss.lms.biz.entity.Copies;

/**
 * @author UCI
 *
 */
public class BranchDAO extends BaseDAO<Branch> {
	
	/**
	 * @param conn
	 */
	public BranchDAO(Connection conn) {
		super(conn);
	}
	
	public void addBranch(Branch branch) throws ClassNotFoundException, SQLException {
		save("insert into tbl_library_branch (branchId, branchName, branchAddress) values (?, ?, ?)", new Object[] { branch.getBranchID(), branch.getBranchName(), branch.getAddress()});
	}
	
	public Integer addBranchReturnPK(Branch branch) throws ClassNotFoundException, SQLException {
		return saveReturnPk("insert into tbl_library_branch (branchId, branchName, branchAddress) values (?, ?, ?)", new Object[] { branch.getBranchID(), branch.getBranchName(), branch.getAddress()});
	}

	public void updateBranch(Branch branch) throws SQLException, ClassNotFoundException {
		save("update tbl_library_branch set branchName=?, branchAddress=? where branchId = ?", new Object[]{branch.getBranchName().toString(), branch.getAddress().toString(), branch.getBranchID()} );
	}

	public void deleteBranch(Branch branch) throws ClassNotFoundException, SQLException {
		save("delete from tbl_library_branch where branchId = ?", new Object[] {branch.getBranchID()});
	}
	
	public List<Branch> readBranches() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_library_branch", null);
	}
	
	public List<Branch> readBranchesByID(Integer branchID) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_library_branch where branchId = ?", new Object[]{branchID});
	}
	
	public List<Branch> readBranchesByName(String branchName) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_library_branch where branchName = ?", new Object[]{branchName});
	}

	@Override
	List<Branch> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Branch> branches = new ArrayList<Branch>();
		List<Copies> copies = new ArrayList<Copies>();
		//populate copies
		while(rs.next()){
			Branch branch = new Branch(new Integer(rs.getInt("branchId")), new StringBuffer(rs.getString("branchName")), 
					new StringBuffer(rs.getString("branchAddress")));
			branches.add(branch);
		}
		return branches;

	}

	@Override
	List<Branch> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
