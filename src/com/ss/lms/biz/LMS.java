/**
 * 
 */
package com.ss.lms.biz;
import java.io.Serializable;
import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.StringBuffer;

/**
 * TODO:	each class loads the text file into JVM at start (into maps by ID)
 * 			any reads/updates/deletes are then based from there
 * 			upon exit or upon explicit user save, modify the save file (remember the user will never see it)
 * 			
 */


/**
 * @author Kyle Sneeden
 *
 */
public class LMS {

	/**
	 * @param args
	 */
	
	
	
	private static Scanner scan = new Scanner(System.in);
	private static HashMap<Integer, Author> authors = new HashMap<Integer, Author>();
	private static HashMap<Integer, Publisher> publishers = new HashMap<Integer, Publisher>();
	private static HashMap<Integer, Book> books = new HashMap<Integer, Book>();

	
	public static void main(String[] args) 
	{
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\Authors.txt")))
		{
			String line;
			while((line = br.readLine()) != null)
			{
				//is this use of StringBuffer[] object oriented?
				StringBuffer rawAuthorData = new StringBuffer(line);
				Integer authorID = new Integer(rawAuthorData.substring(0, rawAuthorData.indexOf("|")));
				StringBuffer authorName = new StringBuffer(rawAuthorData.substring(rawAuthorData.indexOf("|") + 1));
				Author currentAuthor = new Author(authorID, authorName);
				authors.put(authorID, currentAuthor);
			}
			
			/*
			 * System.out.println(authors.get(1)); 
			 * System.out.println(authors.get(2));
			 * System.out.println(authors.get(3));
			 */
			
		}
		catch(FileNotFoundException f)
		{
			System.err.println("Authors.txt does not exist");
		}
		catch(Exception e)
		{
			System.err.println("Error author book from file");
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\Publishers.txt")))
		{
			String line;
			while((line = br.readLine()) != null)
			{
				Integer lastDelimiter = 0;
				StringBuffer rawPublisherData = new StringBuffer(line);
				Integer publisherID = new Integer(rawPublisherData.substring(lastDelimiter, rawPublisherData.indexOf("|")));
				lastDelimiter = rawPublisherData.indexOf("|"); 
				StringBuffer businessName = new StringBuffer(rawPublisherData.substring(lastDelimiter + 1, rawPublisherData.indexOf("|", lastDelimiter + 1)));
				lastDelimiter = rawPublisherData.indexOf("|", lastDelimiter + 1); 
				StringBuffer address = new StringBuffer(rawPublisherData.substring(lastDelimiter + 1));
				Publisher currentPublisher = new Publisher(publisherID, businessName, address);
				publishers.put(publisherID, currentPublisher);
			}
			/*
			 * System.out.println(publishers.get(1)); System.out.println(publishers.get(2));
			 * System.out.println(publishers.get(3));
			 */
		}
		catch(FileNotFoundException f)
		{
			System.err.println("Publishers.txt does not exist");
		}
		catch(Exception e)
		{
			System.err.println("Error publisher book from file");
		}

		
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\Books.txt")))
		{
			String line;
			while((line = br.readLine()) != null)
			{
				//is this use of StringBuffer[] object oriented?
				Integer lastDelimiter = 0;
				StringBuffer rawBookData = new StringBuffer(line);
				Integer bookID = new Integer(rawBookData.substring(lastDelimiter, rawBookData.indexOf("|")));
				lastDelimiter = rawBookData.indexOf("|"); 
				StringBuffer title = new StringBuffer(rawBookData.substring(lastDelimiter + 1, rawBookData.indexOf("|", lastDelimiter + 1)));
				lastDelimiter = rawBookData.indexOf("|", lastDelimiter + 1); 
				Integer authorID = new Integer(rawBookData.substring(lastDelimiter + 1, rawBookData.indexOf("|", lastDelimiter + 1)));
				lastDelimiter = rawBookData.indexOf("|", lastDelimiter + 1);
				Integer publisherID = new Integer(rawBookData.substring(lastDelimiter + 1));
				Book currentBook = new Book(bookID, title, authorID, publisherID);
				books.put(bookID, currentBook);				 
			}
			
			/*
			 * System.out.println(books.get(1)[0]); System.out.println(books.get(1)[1]);
			 * System.out.println(books.get(1)[2]); System.out.println(books.get(2)[0]);
			 * System.out.println(books.get(2)[1]); System.out.println(books.get(2)[2]);
			 * System.out.println(books.get(3)[0]); System.out.println(books.get(3)[1]);
			 * System.out.println(books.get(3)[2]);
			 */
			 
		}
		catch(FileNotFoundException f)
		{
			System.err.println("Books.txt does not exist");
		}
		catch(Exception e)
		{
			System.err.println("Error reading book from file");
		}
		

		/*
		 * listBooks(); System.out.println(); listAuthors(); System.out.println();
		 * listPublishers();
		 */
		
		
		/*
		 * dbDriverMain(); Integer commandType = scan.nextInt();
		 * 
		 * if(commandType == 1) { dbDriver2("Create"); } else if(commandType == 1) {
		 * dbDriver2("Read"); } else if(commandType == 3) { dbDriver2("Update"); } else
		 * if(commandType == 4) { dbDriver2("Delete"); } else { dbDriverMain(); }
		 */		 		
		/*
		 * THIS IS FOR WEEK 2
		 * mainMenu(); 
		 * Integer userType = scan.nextInt();
		 * 
		 * switch(userType){ case 1: lib1(); break; case 2: admin1(); break; case 3:
		 * borr1(); break;
		 * 
		 * }
		 */
	}
	
	private static void addBook(StringBuffer title, Integer authorID, Integer publisherID)
	{
		Book newBook = new Book(title, authorID, publisherID);
		books.put(newBook.getBookID(), newBook);
	}
	
	private static void addAuthor(StringBuffer authorFullName)
	{
		Author newAuthor = new Author(authorFullName);
		authors.put(newAuthor.getAuthorID(), newAuthor);
	}
	
	private static void addPublisher(StringBuffer publisherName, StringBuffer address)
	{
		Publisher newPublisher = new Publisher(publisherName, address);
		publishers.put(newPublisher.getPublisherID(), newPublisher);
	}
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void listBooks()
	{
		for(HashMap.Entry<Integer, Book> currentBook : books.entrySet())
		{
			Integer authorID = currentBook.getValue().getAuthorID();
			Integer publisherID = currentBook.getValue().getPublisherID();
			System.out.println("ID: " + currentBook.getKey() + " | Title: " + currentBook.getValue().getTitle() + " | Written by: " + authors.get(authorID).getAuthorName() + " | Published by: " + publishers.get(publisherID).getPublisherName());
		}
	}
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void listAuthors()
	{
		for(HashMap.Entry<Integer, Author> currentAuthor : authors.entrySet())
		{
			System.out.println("ID: " + currentAuthor.getKey() + " | Name: " + currentAuthor.getValue().getAuthorName());
		}
	}
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void listPublishers()
	{
		for(HashMap.Entry<Integer, Publisher> currentPublisher : publishers.entrySet())
		{
			System.out.println("ID: " + currentPublisher.getKey() + " | Name: " + currentPublisher.getValue().getPublisherName() + " | Address: " + currentPublisher.getValue().getAddress());
		}
	}
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void listBooksByAuthor(Integer authorID)
	{
		for(HashMap.Entry<Integer, Book> currentBook : books.entrySet())
		{
			if(currentBook.getValue().getAuthorID().equals(authorID))
			{
				Integer publisherID = currentBook.getValue().getPublisherID();
				System.out.println("ID: " + currentBook.getKey() + " | Title: " + currentBook.getValue().getTitle() + " | Published by: " + publishers.get(publisherID).getPublisherName());
			}
		}

	}
	
	private static void deleteBook(Integer bookID)
	{
		books.remove(bookID);
	}
	
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void deleteAuthor(Integer authorID)
	{
		for(HashMap.Entry<Integer, Book> currentBook : books.entrySet())
		{
			//System.out.println("BookID: " + currentBook.getKey() + " Book Data: " + currentBook.getValue().toStringBuffer());
			if(currentBook.getValue().getAuthorID().equals(authorID))
			{
				deleteBook(currentBook.getValue().getBookID());
			}
		}
		authors.remove(authorID);
	}
	
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void deletePublisher(Integer publisherID)
	{
		for(HashMap.Entry<Integer, Book> currentBook : books.entrySet())
		{
			//System.out.println("BookID: " + currentBook.getKey() + " Book Data: " + currentBook.getValue().toStringBuffer());
			if(currentBook.getValue().getPublisherID().equals(publisherID))
			{
				deleteBook(currentBook.getValue().getBookID());
			}
		}
		publishers.remove(publisherID);
	}
	
	public static void dbDriverMain()
	{
		System.out.println("Welcome to the Smoothstack Library Management System. Would you like to (enter number only)");
		System.out.println("1) Create");
		System.out.println("2) Read");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5 or any key) Return to previous");
	}
	public static void dbDriver2(String item)
	{
		System.out.println("What do you want to " + item + "?");
	}
	
	
	
	public static void mainMenu()
	{
		System.out.println("Welcome to the Smoothstack Library Management System. Which category of user are you (enter number only)");
		System.out.println();
		System.out.println("1) Librarian");
		System.out.println("2) Administrator");
		System.out.println("3) Borrower");
	}
	
	public static void lib1()
	{
		System.out.println("1) Enter the branch you manage");
		System.out.println("2) Quit to previous");
	}
	
	public static void lib2()
	{
		System.out.println("1) University Library, Boston"); 
		System.out.println("2) State Library, New York"); 
		System.out.println("3) Federal Library, Washington DC"); 
		System.out.println("4) County Library, McLean VA"); 
		System.out.println("5) Quit to previous");  
	}
	
	public static void lib3()
	{
		System.out.println("1) Update the details of the Library");
		System.out.println("2) Quit to previous");
	}
	
	public static void lib4()
	{
		System.out.print("You have chosen to update the Branch with Branch Id: X and Branch Name: ABCD. Enter ‘quit’ at any prompt to cancel operation.");
		System.out.print("Please enter new branch name or enter N/A for no change:");
		System.out.print("Please enter new branch address or enter N/A for no change:");
	}
	
	public static void admin1()
	{
		System.out.println("1) Add/Update/Delete/Read Book and Author");
		System.out.println("2) Add/Update/Delete/Read Genres");
		System.out.println("3) Add/Update/Delete/Read Publishers");
		System.out.println("4) Add/Update/Delete/Read Library Branches");
		System.out.println("5) Add/Update/Delete/Read Borrowers");
	}
	
	public static void borr0()
	{
		System.out.println("Enter the your Card Number:");
	}
	
	public static void borr1()
	{
		System.out.println("1) Check out a book");
		System.out.println("2) Return a Book");
		System.out.println("3) Quit to Previous");
	}
	
	public static void borr2()
	{
		System.out.println("Pick the Branch you want to check out from:");
		System.out.println("1) University Library, Boston"); 
		System.out.println("2) State Library, New York");
		System.out.println("3) Federal Library, Washington DC");
		System.out.println("4) County Library, McLean VA"); 
		System.out.println("5) Quit to previous");
	}
	
	public static void borr3()
	{
		System.out.println("1) Lost Tribe by Sidney Sheldon");
		System.out.println("2) The Haunting by Stepehen King");
		System.out.println("3) Microtrends by Mark Penn");
		System.out.println("4) Quit to cancel operation");
	}
}
