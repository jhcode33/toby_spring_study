package vol1.kitec.ch7.study5_2.springframe.sqlservice;

public interface SqlRegistry {
	void registerSql(String key, String sql);

	String findSql(String key) throws SqlNotFoundException;
}
