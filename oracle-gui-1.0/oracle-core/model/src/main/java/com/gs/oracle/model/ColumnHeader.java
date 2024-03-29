/**
 * 
 */
package com.gs.oracle.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author sabuj.das
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnHeader {

	String title();
	int index();
}
