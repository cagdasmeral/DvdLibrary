/**
 *
 * @author cagdasmeral 
 * @since  2022-08-19 
 *purpose: My first Hello World program in an IDE
 */

package com.sg.dvdlibrary.dao;

public class DvdLibraryDaoException extends Exception{
    
    public DvdLibraryDaoException(String message) {
        super(message);
    }
    
    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}