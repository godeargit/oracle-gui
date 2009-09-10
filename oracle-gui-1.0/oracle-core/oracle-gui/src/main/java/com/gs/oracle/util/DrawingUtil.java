/**
 * 
 */
package com.gs.oracle.util;

import java.awt.Graphics;

import com.gs.oracle.OracleGuiConstants;
import com.gs.oracle.model.Column;
import com.gs.oracle.model.Table;

/**
 * @author sabuj.das
 *
 */
public class DrawingUtil{

	
	public static int calculateTableWidth(Graphics graphics, Table table){
		int charWidth = graphics.getFontMetrics().charWidth('H');
		int maxLength = table.getModelName().length();
		for (Column column : table.getColumnlist()) {
			String colName = column.getModelName();
			int length = colName.length();
			if(length > maxLength){
				maxLength = length;
			}
		}
		return 30 + (charWidth * maxLength);
	}
	
	public static int calculateTableHeight(Graphics graphics, Table table){
		int charHeight = calculateCellHeight(graphics) + 2;
		int lineCount = 1 + table.getColumnlist().size();
		return charHeight * lineCount;
	}
	
	public static int calculateCellHeight(Graphics graphics){
		return graphics.getFontMetrics().getHeight() + 5;
	}
}
