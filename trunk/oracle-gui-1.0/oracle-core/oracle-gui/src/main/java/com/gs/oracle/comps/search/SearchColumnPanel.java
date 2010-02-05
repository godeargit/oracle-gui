/**
 * 
 */
package com.gs.oracle.comps.search;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.gs.oracle.OracleGuiConstants;

/**
 * @author sabuj.das
 *
 */
public class SearchColumnPanel extends JPanel implements ActionListener {
	
	private static final Icon DB_SEARCH_ICON = new ImageIcon(
			SearchTablePanel.class.getResource(OracleGuiConstants.IMAGE_PATH + "database_search.png"));
	private static final Icon LOADING_SEARCH_RESULT_ICON = new ImageIcon(
			SearchTablePanel.class.getResource(OracleGuiConstants.IMAGE_PATH + "loading_001.gif"));
	
    public SearchColumnPanel() {
        initComponents();
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        columnNameTextField = new JTextField();
        jLabel3 = new JLabel();
        availableSchemasComboBox = new JComboBox();
        allSchemaCheckBox = new JCheckBox();
        jSeparator1 = new JSeparator();
        jLabel5 = new JLabel();
        jScrollPane1 = new JScrollPane();
        searchResultTable = new JTable();
        clearButton = new JButton();
        imageLabel = new JLabel();
        searchButton = new JButton();
        resultLabel = new JLabel();

        setLayout(new GridBagLayout());

        jLabel1.setText("<HTML> <BODY> <B><U>S</U>earch Column</B> ( * = any string, ? = any char) </BODY> </HTML>");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(8, 2, 8, 2);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Column Name");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(2, 2, 2, 2);
        add(jLabel2, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(2, 2, 2, 2);
        add(columnNameTextField, gridBagConstraints);

        jLabel3.setText("In Schema");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(2, 2, 2, 2);
        add(jLabel3, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(2, 2, 2, 2);
        add(availableSchemasComboBox, gridBagConstraints);

        allSchemaCheckBox.setText("All available Schemas");
        allSchemaCheckBox.addActionListener(this);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(2, 0, 2, 2);
        add(allSchemaCheckBox, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(6, 2, 6, 2);
        add(jSeparator1, gridBagConstraints);

        jLabel5.setText("Search Result  ");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(2, 2, 2, 2);
        add(jLabel5, gridBagConstraints);

        searchResultTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matching column", "Table", "Owner", "Open Table"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchResultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        searchResultTable.setColumnSelectionAllowed(true);
        searchResultTable.setGridColor(new Color(153, 204, 255));
        jScrollPane1.setViewportView(searchResultTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(2, 2, 2, 2);
        add(jScrollPane1, gridBagConstraints);

        clearButton.setText("Clear");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(2, 2, 2, 2);
        add(clearButton, gridBagConstraints);

        imageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        imageLabel.setIcon(LOADING_SEARCH_RESULT_ICON);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new Insets(2, 2, 2, 2);
        add(imageLabel, gridBagConstraints);

        searchButton.setText("Search");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(2, 2, 2, 2);
        add(searchButton, gridBagConstraints);

        resultLabel.setText("hjhgjh");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(resultLabel, gridBagConstraints);
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == allSchemaCheckBox) {
            SearchColumnPanel.this.allSchemaCheckBoxActionPerformed(evt);
        }
    }// </editor-fold>

    private void allSchemaCheckBoxActionPerformed(ActionEvent evt) {
        if(allSchemaCheckBox.isSelected()){
            availableSchemasComboBox.setEnabled(false);
        } else if(!allSchemaCheckBox.isSelected()){
            availableSchemasComboBox.setEnabled(true);
        }
    }


    // Variables declaration - do not modify
    private JCheckBox allSchemaCheckBox;
    private JComboBox availableSchemasComboBox;
    private JButton clearButton;
    private JTextField columnNameTextField;
    private JLabel imageLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JLabel resultLabel;
    private JButton searchButton;
    private JTable searchResultTable;
    // End of variables declaration

}