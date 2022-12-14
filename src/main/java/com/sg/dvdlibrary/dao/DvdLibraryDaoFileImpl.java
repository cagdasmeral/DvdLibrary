/**
 *
 * @author cagdasmeral 
 * @since  2022-08-19 
 *purpose: My first Hello World program in an IDE
 */

package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class DvdLibraryDaoFileImpl implements DvdLibraryDao{

    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::"; 
    
    private Map<String, Dvd> dvds = new HashMap<>();
    
    @Override
    public Dvd addDvd(String title, Dvd dvd) 
       throws DvdLibraryDaoException {
         loadDvd();
         Dvd newDvd = dvds.put(title, dvd);
         writeDvd();
         return newDvd;
}

    @Override
   public List<Dvd> getAllDvds() 
     throws DvdLibraryDaoException {
       loadDvd();
       return new ArrayList(dvds.values());
}

    @Override
    public Dvd getDvd(String title) 
      throws DvdLibraryDaoException {
        loadDvd();
        return dvds.get(title);
}

    @Override
    public Dvd removeDvd(String title) 
      throws DvdLibraryDaoException {
        loadDvd();
        Dvd removedDvd = dvds.remove(title);
        writeDvd();
        return removedDvd;
}

   
    
   private Dvd unmarshallDvd(String dvdAsText){
    
    String[] dvdTokens = dvdAsText.split(DELIMITER);

    String title = dvdTokens[0];

    Dvd dvdFromFile = new Dvd(title);

    dvdFromFile.setReleaseDate(dvdTokens[1]);

    dvdFromFile.setDirectorsName(dvdTokens[2]);

    dvdFromFile.setMpaaRating(dvdTokens[3]);
	
    dvdFromFile.setStudio(dvdTokens[4]);
	
    dvdFromFile.setUserOpinion(dvdTokens[5]);
    
    return dvdFromFile;
}
   private void loadDvd() throws DvdLibraryDaoException {
    Scanner scanner;

    try {
        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(DVD_FILE)));
    } catch (FileNotFoundException e) {
        throw new DvdLibraryDaoException(
                "-_- Could not load dvd data into memory.", e);
    }
    String currentLine;
    Dvd currentDvd;
    while (scanner.hasNextLine()) {
        currentLine = scanner.nextLine();
        currentDvd = unmarshallDvd(currentLine);
        dvds.put(currentDvd.getTitle(), currentDvd);
    }
    scanner.close();
}
   private String marshallDvd(Dvd aDvd){

    String dvdAsText = aDvd.getTitle() + DELIMITER;

    dvdAsText += aDvd.getReleaseDate() + DELIMITER;

    dvdAsText += aDvd.getDirectorsName() + DELIMITER;

    dvdAsText += aDvd.getMpaaRating() + DELIMITER;
	
	dvdAsText += aDvd.getStudio() + DELIMITER;
	
	dvdAsText += aDvd.getUserOpinion() + DELIMITER;

    return dvdAsText;
}
   private void writeDvd() throws DvdLibraryDaoException {
    
    PrintWriter out;

    try {
        out = new PrintWriter(new FileWriter(DVD_FILE));
    } catch (IOException e) {
        throw new DvdLibraryDaoException(
                "Could not save dvd data.", e);
    }

    String dvdAsText;
    List<Dvd> dvdList = this.getAllDvds();
    for (Dvd currentDvd : dvdList) {

        dvdAsText = marshallDvd(currentDvd);

        out.println(dvdAsText);

        out.flush();
    }
    out.close();
}
}
