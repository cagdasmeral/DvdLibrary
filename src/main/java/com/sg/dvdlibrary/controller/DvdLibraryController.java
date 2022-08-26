/**
 *
 * @author cagdasmeral 
 * @since  2022-08-19 
 *purpose: My first Hello World program in an IDE
 */

package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;


public class DvdLibraryController {

            private DvdLibraryView view;
            private DvdLibraryDao dao;
	    private UserIO io = new UserIOConsoleImpl();

	    public void run() {
    boolean keepGoing = true;
    int menuSelection = 0;
    try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listDvds();
                    break;
                case 2:
                    createDvd();
                    break;
                case 3:
                    viewDvd();
                    break;
                case 4:
                    removeDvd();
                    break;
                case 5:
                    io.print("EDIT DVD");
                    break;
                case 6:
                    io.print("SEARCH DVD");
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    } catch (DvdLibraryDaoException e) {
        view.displayErrorMessage(e.getMessage());
    }
}

    private int getMenuSelection() {
     return view.printMenuAndGetSelection();
}

private void createDvd() throws DvdLibraryDaoException {
    view.displayCreateDvdBanner();
    Dvd newDvd = view.getNewDvdInfo();
    dao.addDvd(newDvd.getTitle(), newDvd);
    view.displayCreateSuccessBanner();
}

private void listDvds() throws DvdLibraryDaoException {
    view.displayDisplayAllBanner();
    List<Dvd> dvdList = dao.getAllDvds();
    view.displayDvdList(dvdList);
}

private void viewDvd() throws DvdLibraryDaoException {
    view.displayDisplayDvdBanner();
    String title = view.getTitleChoice();
    Dvd dvd = dao.getDvd(title);
    view.displayDvd(dvd);
}

private void removeDvd() throws DvdLibraryDaoException {
    view.displayRemoveDvdBanner();
    String title = view.getTitleChoice();
    Dvd removedDvd = dao.removeDvd(title);
    view.displayRemoveResult(removedDvd);
}

private void unknownCommand() {
    view.displayUnknownCommandBanner();
}

private void exitMessage() {
    view.displayExitBanner();
}
public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
    this.dao = dao;
    this.view = view;
}

}
