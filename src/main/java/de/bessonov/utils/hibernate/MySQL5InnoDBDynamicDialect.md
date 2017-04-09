# MySQL5InnoDBDynamicDialect for MySQL and MariaDB

Adds `ROW_FORMAT=DYNAMIC` to `CREATE TABLE` statement. This is useful to avoid a `Specified key was too long; max key length is 767 bytes` or `Index column size too large. The maximum column size is 767 bytes.` errors if utf8mb4 is used for emoji's.

## Usage

### Database configuretion

Following variables must be set for a db:
- innodb_file_format=barracuda
- innodb_large_prefix=1

### Spring Boot (application.yml)

```yaml
spring.jpa.properties.hibernate.dialect: de.bessonov.utils.hibernate.MySQL5InnoDBDynamicDialect
```

### Liquibase

#### Database migration

For database migration set (or equivalent xml configuration):

```yaml
modifySql:
  - regExpReplace:
    replace: CREATE TABLE.*
    with: $0 ENGINE=INNODB ROW_FORMAT=DYNAMIC
```

#### `liquibase-maven-plugin`

```
hibernate.dialect=de.bessonov.utils.hibernate.MySQL5InnoDBDynamicDialect
referenceUrl=hibernate:spring:db?dialect=de.bessonov.utils.hibernate.MySQL5InnoDBDynamicDialect
```

And plugin should have following dependency:

```xml
<plugin>
	<groupId>org.liquibase</groupId>
	<artifactId>liquibase-maven-plugin</artifactId>
	<version>${liquibase.maven.version}</version>
	<dependencies>
		<dependency>
			<groupId>de.bessonov</groupId>
			<artifactId>utils</artifactId>
			<version>${bessonov.utils.version}</version>
		</dependency>
	</dependencies>
</plugin>
```