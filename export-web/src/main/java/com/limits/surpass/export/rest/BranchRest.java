package com.limits.surpass.export.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.limits.surpass.export.core.BranchBean;
import com.limits.surpass.export.model.Branch;
import com.limits.surpass.export.model.Token;

@Path("/branch")
public class BranchRest {
	
	@Inject
	private BranchBean branchBean;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list/{id}")
	public List<Branch> obtainBranchList(@PathParam("id") Integer enterpriseId, Token token) {
		List<Branch> branchList = branchBean.findBranches(enterpriseId);
		return branchList;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	@RolesAllowed({"admin","seller"})
	public List<Branch> obtainBranchList() {
		//List<Branch> branchList = branchBean.findBranches(enterpriseId);
		List<Branch> branchList = new ArrayList<Branch>();
		Branch branch = new Branch();
		branch.setName("Principal");
		branchList.add(branch);
		branch = new Branch();
		branch.setName("Secundaria");
		branchList.add(branch);
		return branchList;
	}
	
	public void saveBranch(Branch branch) {
		
	}

}
