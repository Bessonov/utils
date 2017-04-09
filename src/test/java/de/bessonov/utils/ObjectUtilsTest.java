package de.bessonov.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ObjectUtilsTest {

	@Test
	public void testFirstNotNull() {
		assertNull(ObjectUtils.firstNotNull());
		assertEquals("a", ObjectUtils.firstNotNull("a", "b"));
		assertEquals("b", ObjectUtils.firstNotNull(null, "b"));
		assertNull(ObjectUtils.firstNotNull(null, null));
	}
}
