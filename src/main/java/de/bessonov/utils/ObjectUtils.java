package de.bessonov.utils;

public interface ObjectUtils {

	/**
	 * returns first not null value
	 * 
	 * @author Anton Bessonov
	 */
	@SafeVarargs
	public static <T> T firstNotNull(T... objects) {
		for (T object : objects) {
			if (object != null) {
				return object;
			}
		}
		return null;
	}
}
