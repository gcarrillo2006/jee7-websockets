package com.limits.surpass.export.core;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.limits.surpass.export.model.Branch;

@RunWith(MockitoJUnitRunner.class)
public class BranchBeanTest {
	
	@Mock
	private EntityManager em;
	
	@Mock
	private TypedQuery<Branch> typedQueryMock;
	
	@Mock
	private Branch branchMock;
	
	@InjectMocks
	private BranchBean branchBean;
	
	@Test
	public void shouldPass() {
		when(em.createNamedQuery("findBranchesByUsername", Branch.class)).thenReturn(typedQueryMock);
		when(typedQueryMock.setParameter(eq("username"), anyString())).thenReturn(typedQueryMock);
		when(typedQueryMock.getSingleResult()).thenReturn(branchMock);
		assertNotNull(branchBean.findBranchByUsername("admin"));
	}

}
