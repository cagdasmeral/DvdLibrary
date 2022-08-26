/**
 *
 * @author cagdasmeral 
 * @since  2022-08-19 
 *purpose: My first Hello World program in an IDE
 */

package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;


public class DvdLibraryView {
    
    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Dvd collections");
        io.print("2. Add a Dvd to the collection");
        io.print("3. View Dvd");
        io.print("4. Remove a Dvd");
        io.print("5. Edit Dvd information");
	    io.print("6. Search for a Dvd");
	    io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public Dvd getNewDvdInfo() {
    String title = io.readString("Please enter Title");
    String releaseDate = io.readString("Please enter Release Date");
    String directorsName = io.readString("Please enter Director`s Name");
    String mpaaRating = io.readString("Please enter Mpaa Rating");
    String studio = io.readString("Please enter Studio");
    String userOpinion = io.readString("Please enter User Opinion");
    Dvd currentDvd = new Dvd(title);
    currentDvd.setReleaseDate(releaseDate);
    currentDvd.setDirectorsName(directorsName);
    currentDvd.setMpaaRating(mpaaRating);
    currentDvd.setStudio(studio);
    currentDvd.setUserOpinion(userOpinion);
    return currentDvd;
}
    public void displayCreateDvdBanner() {
    io.print("=== Create Dvd ===");
}
    public void displayCreateSuccessBanner() {
    io.readString(
            "Dvd successfully created.  Please hit enter to continue");
}
    public void displayDvdList(List<Dvd> dvdList) {
    for (Dvd currentDvd : dvdList) {
        String dvdInfo = String.format("#%s : %s %s %s %s %s",
              currentDvd.getTitle(),
              currentDvd.getReleaseDate(),
			  currentDvd.getDirectorsName(),
			  currentDvd.getMpaaRating(),
			  currentDvd.getStudio(),
              currentDvd.getUserOpinion());
        io.print(dvdInfo);
    }
    io.readString("Please hit enter to continue.");
}
    public void displayDisplayAllBanner() {
    io.print("=== Display All Students ===");
}
    public void displayDisplayDvdBanner () {
    io.print("=== Display Dvd ===");
}

public String getTitleChoice() {
    return io.readString("Please enter the Title.");
}

public void displayDvd(Dvd dvd) {
    if (dvd != null) {
        io.print(dvd.getTitle());
        io.print(dvd.getReleaseDate());
		io.print(dvd.getDirectorsName());
		io.print(dvd.getMpaaRating());
		io.print(dvd.getStudio());
        io.print(dvd.getUserOpinion());
        io.print("");
    } else {
        io.print("No such dvd.");
    }
    io.readString("Please hit enter to continue.");
}
public void displayRemoveDvdBanner () {
    io.print("=== Remove Dvd ===");
}

public void displayRemoveResult(Dvd dvdRecord) {
    if(dvdRecord != null){
      io.print("Dvd successfully removed.");
    }else{
      io.print("No such dvd.");
    }
    io.readString("Please hit enter to continue.");
}
public void displayExitBanner() {
    io.print("Good Bye!!!");
}

public void displayUnknownCommandBanner() {
    io.print("Unknown Command!!!");
}
public DvdLibraryView(UserIO io) {
    this.io = io;
}
public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}

}
