package vol1.kitec.ch7.study5_3.springframe.sqlservice;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;

import vol1.kitec.ch7.study5_3.springframe.dao.UserDao;
import vol1.kitec.ch7.study5_3.springframe.sqlservice.jaxb.SqlType;
import vol1.kitec.ch7.study5_3.springframe.sqlservice.jaxb.Sqlmap;

public class OxmSqlService implements SqlService {

private final BaseSqlService baseSqlService = new BaseSqlService();
	
	private final OxmSqlReader oxmSqlReader = new OxmSqlReader();
	private SqlRegistry sqlRegistry = new HashMapSqlRegistry();
	
	public void setSqlRegistry(SqlRegistry sqlRegistry) {
		this.sqlRegistry = sqlRegistry;
	}
	
	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.oxmSqlReader.setUnmarshaller(unmarshaller);
	}
	
	public void setSqlmap(Resource sqlmap) {
		this.oxmSqlReader.setSqlmap(sqlmap);
	}

	@PostConstruct
	public void loadSql() {
		this.baseSqlService.setSqlReader(this.oxmSqlReader);
		this.baseSqlService.setSqlRegistry(this.sqlRegistry);
		
		this.baseSqlService.loadSql();
	}

	public String getSql(String key) throws SqlRetrievalFailureException {
		return this.baseSqlService.getSql(key);
	}
	
	private class OxmSqlReader implements SqlReader {
		private Unmarshaller unmarshaller;
		private Resource sqlmap = new ClassPathResource("sqlmap.xml", UserDao.class);

		public void setUnmarshaller(Unmarshaller unmarshaller) {
			this.unmarshaller = unmarshaller;
		}

		public void setSqlmap(Resource sqlmap) {
			this.sqlmap = sqlmap;
		}

		public void read(SqlRegistry sqlRegistry) {
			try {
				Source source = new StreamSource(sqlmap.getInputStream());
				Sqlmap sqlmap = (Sqlmap)this.unmarshaller.unmarshal(source);
				for(SqlType sql : sqlmap.getSql()) {
					sqlRegistry.registerSql(sql.getKey(), sql.getValue());
				}
			} catch (IOException e) {
				throw new IllegalArgumentException(this.sqlmap.getFilename() + "À» °¡Á®¿Ã ¼ö ¾ø½À´Ï´Ù", e);
			}
		}
	}

}
