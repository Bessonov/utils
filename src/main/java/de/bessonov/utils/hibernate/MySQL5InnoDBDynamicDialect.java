package de.bessonov.utils.hibernate;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Adds `ROW_FORMAT=DYNAMIC` to `CREATE TABLE` statement.
 * This is useful to avoid a `Specified key was too long; max key length is 767 bytes`
 * or `Index column size too large. The maximum column size is 767 bytes.` errors if utf8mb4 is used for emoji's.<br>
 * <br>
 * Additionally, following variables must be set:
 * <ul>
 * 	<li>innodb_file_format=barracuda</li>
 * 	<li>innodb_large_prefix=1</li>
 * </ul><br>
 * 
 * org.hibernate::hibernate-core is expected to be in classpath.
 * 
 * @author Anton Bessonov
 */
public class MySQL5InnoDBDynamicDialect extends MySQL5InnoDBDialect {

	@Override
	public String getTableTypeString() {
		return super.getTableTypeString() + " ROW_FORMAT=DYNAMIC";
	}
}
