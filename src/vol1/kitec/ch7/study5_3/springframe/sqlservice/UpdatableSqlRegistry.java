package vol1.kitec.ch7.study5_3.springframe.sqlservice;

import java.util.Map;

public interface UpdatableSqlRegistry extends SqlRegistry {
	public void updateSql(String key, String sql) throws SqlUpdateFailureException;
	
	public void updateSql(Map<String, String> sqlmap) throws SqlUpdateFailureException;

}
