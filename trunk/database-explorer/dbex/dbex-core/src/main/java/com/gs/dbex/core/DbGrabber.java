/**
 * 
 */
package com.gs.dbex.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.gs.dbex.common.enums.ReadDepthEnum;
import com.gs.dbex.model.db.Column;
import com.gs.dbex.model.db.ForeignKey;
import com.gs.dbex.model.db.PrimaryKey;
import com.gs.dbex.model.db.Table;

/**
 * @author sabuj.das
 * 
 */
public abstract class DbGrabber {

	public abstract String grabSqlKeyWords(Connection connection)
			throws SQLException;


	

	
}
