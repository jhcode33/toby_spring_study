package vol1.kitec.ch1.study4_2.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	
	public abstract Connection makeConnection() throws ClassNotFoundException,
	SQLException;

}