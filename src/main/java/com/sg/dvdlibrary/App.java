/**
 *
 * @author cagdasmeral 
 * @since  2022-08-19 
 *purpose: My first Hello World program in an IDE
 */

package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DvdLibraryController;
import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;


public class App {
    
  public static void main(String[] args) {
    UserIO myIo = new UserIOConsoleImpl();
    DvdLibraryView myView = new DvdLibraryView(myIo);
    DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
    DvdLibraryController controller =
            new DvdLibraryController(myDao, myView);
    controller.run();
}

 
}
