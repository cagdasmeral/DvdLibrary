/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author cagdasmeral
 */
public interface DvdLibraryDao {

    Dvd addDvd(String title, Dvd dvd)
     throws DvdLibraryDaoException;

    List<Dvd> getAllDvds()
     throws DvdLibraryDaoException;

    Dvd getDvd(String title)
     throws DvdLibraryDaoException;

   
    Dvd removeDvd(String title)
     throws DvdLibraryDaoException;
}