/**
 * 
 */
package com.gs.oracle.comps;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.gs.oracle.OracleGuiConstants;
import com.gs.oracle.connection.ConnectionProperties;
import com.gs.oracle.util.MenuBarUtil;

/**
 * @author sabuj.das
 * 
 */
public class TableDetailsPanel extends JPanel implements ActionListener,
		OracleGuiConstants {

	private JTabbedPane tableDetailsTabbedPane;
	private String tableName;
	private ConnectionProperties connectionProperties;
	
	public TableDetailsPanel(String tableName) {
		this(tableName, null);
	}
	

	public TableDetailsPanel(String tableName,
			ConnectionProperties connectionProperties) {
		this.tableName = tableName;
		this.connectionProperties = connectionProperties;
		initComponents();
	}



	private void initComponents() {
		tableDetailsTabbedPane = new JTabbedPane();
		tableDetailsTabbedPane.setFocusable(false);
		tableDetailsTabbedPane.addTab("Data", new ImageIcon(
				TableDetailsPanel.class
						.getResource(OracleGuiConstants.IMAGE_PATH
								+ "table_data.gif")), new JPanel());
		tableDetailsTabbedPane.addTab("Columns",new ImageIcon(
				TableDetailsPanel.class
				.getResource(OracleGuiConstants.IMAGE_PATH
						+ "columngroup.gif")), 
						new ColumnDetailsPanel(getTableName(), getConnectionProperties()));
		tableDetailsTabbedPane.addTab("Constraints",new ImageIcon(
				TableDetailsPanel.class
				.getResource(OracleGuiConstants.IMAGE_PATH
						+ "constraint.gif")), new JPanel());
		tableDetailsTabbedPane.addTab("Dependencies",new ImageIcon(
				TableDetailsPanel.class
				.getResource(OracleGuiConstants.IMAGE_PATH
						+ "dependency.gif")), new JPanel());
		tableDetailsTabbedPane.addTab("Indexes",new ImageIcon(
				TableDetailsPanel.class
				.getResource(OracleGuiConstants.IMAGE_PATH
						+ "index.gif")), new JPanel());
		tableDetailsTabbedPane.addTab("DDL", new ImageIcon(
				TableDetailsPanel.class
				.getResource(OracleGuiConstants.IMAGE_PATH
						+ "generate_ddl.gif")),new JPanel());

		setLayout(new BorderLayout());

		add(tableDetailsTabbedPane, BorderLayout.CENTER);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public JTabbedPane getTableDetailsTabbedPane() {
		return tableDetailsTabbedPane;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public ConnectionProperties getConnectionProperties() {
		return connectionProperties;
	}


	public void setConnectionProperties(ConnectionProperties connectionProperties) {
		this.connectionProperties = connectionProperties;
	}

}
