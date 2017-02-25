package de.bessonov.utils.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MySQL5InnoDBDynamicDialectTest {

	@Test
	public void testTableTypeString() {
		MySQL5InnoDBDynamicDialect mySQL5InnoDBDynamicDialect = new MySQL5InnoDBDynamicDialect();
		assertEquals(" ENGINE=InnoDB ROW_FORMAT=DYNAMIC", mySQL5InnoDBDynamicDialect.getTableTypeString());
	}
}
