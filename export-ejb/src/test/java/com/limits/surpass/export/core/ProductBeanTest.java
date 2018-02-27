package com.limits.surpass.export.core;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.limits.surpass.export.model.Branch;
import com.limits.surpass.export.model.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductBeanTest {
	
	@Mock
	private EntityManager em;

	@Mock
	private TypedQuery<Product> typedQueryMock;
	
	@Mock
	private List<Product> productListMock;
	
	@InjectMocks
	private ProductBean productBean;
	
	@Test
	public void shouldPass() {
		when(em.createNamedQuery("findProductsByBranch", Product.class)).thenReturn(typedQueryMock);
		when(typedQueryMock.setParameter(eq("branch"), any(Branch.class))).thenReturn(typedQueryMock);
		when(typedQueryMock.setParameter(eq("name"), anyString())).thenReturn(typedQueryMock);
		when(typedQueryMock.getResultList()).thenReturn(productListMock);
		assertNotNull(productBean.findProducts(mock(Branch.class), "test"));
	}

}
