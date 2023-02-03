package backend;

import constants.FileNames;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AdminRole implements FileNames{
    
	public LibrarianUserDataBase dataBase;

    public AdminRole() throws Throwable {
        this.dataBase=new LibrarianUserDataBase(FileNames.LIBRARIANS_FILENAME);
        this.dataBase.readFromFile();
    }
	
	
	public void addLibrarian (String librarianId,String name,String email,String address,String phoneNumber) throws IOException
	{

		LibrarianUser l=new LibrarianUser(librarianId,name,email,address,phoneNumber);
		this.dataBase.insertRecord(l);
	}
	
	public LibrarianUser[] getListOfLibrarians () throws FileNotFoundException
	{
		//this.dataBase.readFromFile();
		ArrayList <GeneralInterface> a=this.dataBase.returnAllRecords();
		LibrarianUser[] lArray=new LibrarianUser[1];
		return a.toArray(lArray);
	}

	public void removeLibrarian(String key) throws IOException
	{
		this.dataBase.deleteRecord(key);
	}
	
	public void logout() throws IOException
	{
		this.dataBase.saveToFile();
	}
}
