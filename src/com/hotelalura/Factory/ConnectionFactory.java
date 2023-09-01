package com.hotelalura.Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dtsrc;
	
	public ConnectionFactory(){
		var pDS=new ComboPooledDataSource();
		
		pDS.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
		pDS.setUser("root");
		pDS.setPassword(System.getenv("MY_PASS"));
		pDS.setMaxPoolSize(10);
		this.dtsrc=pDS;
	
	}

	
	public Connection recuperaConexion() {
		try {
		return this.dtsrc.getConnection();
		}catch(SQLException sqle) {
			throw new RuntimeException(sqle);
		}
	}
}