/**
 * 
 */
package com.ss.lms.biz;
//import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	
	
	
	//private static Scanner scan = new Scanner(System.in);
	private static HashMap<Integer, Author> authors = new HashMap<Integer, Author>();
	private static HashMap<Integer, Publisher> publishers = new HashMap<Integer, Publisher>();
	private static HashMap<Integer, Book> books = new HashMap<Integer, Book>();

	
	public static void main(String[] args) 
	{
		load();
		Integer menuConstraints[] = new Integer[2];
		//MAIN MENU
		menuConstraints = driverUIMain();
		Stack<Integer> input = new Stack<Integer>();
		ArrayList<StringBuffer> inputString = new ArrayList<StringBuffer>();

		try(Scanner scan = new Scanner(System.in))
		{
			input.push(getUserInput(scan, menuConstraints[0], menuConstraints[1]));
			/*
			 * while(input.get(input.size() - 1) == -1) { System.out.println("Last Input: "
			 * + input.get(input.size() - 1).toString()); input.pop(); Integer newInput =
			 * getUserInput(scan, menuConstraints[0], menuConstraints[1]);
			 * System.out.println("New Input: " + newInput); input.push(newInput); }
			 */			
			//BAD INPUT; MENU BACK TO MAIN MENU
			if(input.get(input.size() - 1) == -1)
			{
				System.out.println("Only integers between " + menuConstraints[0] + " and " + menuConstraints[1] + " are allowed. Try input again.");
				input.pop();
				menuConstraints = driverUIMain();
			}
			//BOOKS MENU
			else if(input.get(input.size() - 1) == 1)
			{
				menuConstraints = driverUIBooks();
				input.push(getUserInput(scan, menuConstraints[0], menuConstraints[1]));
				//System.out.println("Your input was: " + input.toString());
				//BAD INPUT; BACK TO BOOKS MENU
				if(input.get(input.size() - 1) == -1)
				{
					System.out.println("Only integers between " + menuConstraints[0] + " and " + menuConstraints[1] + " are allowed. Try input again.");
					input.pop();
					menuConstraints = driverUIBooks();
				}
				//CREATE A BOOK MENU
				else if(input.get(input.size() - 1) == 1)
				{
					System.out.println("Create a book. Enter title: ");
					inputString.add(new StringBuffer(getUserInput(scan)));
					System.out.println("Enter author: ");
					Author newAuthor = new Author(new StringBuffer(getUserInput(scan)));
					//inputString.add(new StringBuffer(getUserInput(scan)));
					System.out.println("Enter publisher name: ");
					inputString.add(new StringBuffer(getUserInput(scan)));
					System.out.println("Enter publisher address: ");
					inputString.add(new StringBuffer(getUserInput(scan)));
					Publisher newPublisher = new Publisher(inputString.get(0), inputString.get(1));
					Book newBook = new Book(inputString.get(0), newAuthor.getAuthorID(), newPublisher.getPublisherID());
					menuConstraints = driverUIBooks();
				}
				//READ ALL THEN BACK TO BOOKS MENU
				else if(input.get(input.size() - 1) == 2)
				{
					readBooks();
					menuConstraints = driverUIBooks();
				}
				//UPDATE BOOK
				else if(input.get(input.size() - 1) == 3)
				{
					System.out.println("Enter the ID of the book to update: ");
					input.push(new Integer(getUserIntegerInput(scan).toString()));
					Book newBook = books.get(input.get(input.size() - 1));
					System.out.println("Enter the new title of the book: ");
					StringBuffer title = getUserInput(scan);
					StringBuffer authorName = getUserInput(scan);
					StringBuffer publisherName = getUserInput(scan);
					StringBuffer address = getUserInput(scan);
					updateBook(newBook, title, authorName, publisherName, address);
				}
				//DELETE BOOK BY ID
				else if(input.get(input.size() - 1) == 4)
				{
					System.out.println("Enter ID of book to delete: ");
					input.push(new Integer(getUserIntegerInput(scan).toString()));
					deleteBook(input.get(input.size() - 1));
				}
				//SAVE BOOK
				else if(input.get(input.size() - 1) == 5)
				{
					save();
					menuConstraints = driverUIBooks();

				}
				//GO BACK
				else if(input.get(input.size() - 1) == 6)
				{
					menuConstraints = driverUIBooks();
				}
			}
			//AUTHORS MENU
			else if(input.get(input.size() - 1) == 2)
			{
				menuConstraints = driverUIAuthors();
				input.push(getUserInput(scan, menuConstraints[0], menuConstraints[1]));
				//BAD INPUT MENU; BACK TO AUTHORS MENU
				if(input.get(input.size() - 1) == -1)
				{
					menuConstraints = driverUIAuthors();
				}
				//CREATE AN AUTHOR MENU
				else if(input.get(input.size() - 1) == 1)
				{
					System.out.println("Enter author: ");
					Author newAuthor = new Author(new StringBuffer(getUserInput(scan)));
					authors.put(newAuthor.getAuthorID(), newAuthor);
				}
				//READ ALL AUTHORS MENU
				else if(input.get(input.size() - 1) == 2)
				{
					readAuthors();
					menuConstraints = driverUIAuthors();
				}
				//UPDATE AN AUTHOR MENU
				else if(input.get(input.size() - 1) == 3)
				{
					
				}
				//DELETE AN AUTHOR MENU
				else if(input.get(input.size() - 1) == 4)
				{
					System.out.println("Enter ID of the author to delete: ");
					input.push(new Integer(getUserIntegerInput(scan).toString()));
					deleteAuthor(input.get(input.size() - 1));
				}
				//SAVE; BACK TO AUTHORS MENU
				else if(input.get(input.size() - 1) == 5)
				{
					save();
					menuConstraints = driverUIAuthors();
				}
				//BACK TO  MENU
				else if(input.get(input.size() - 1) == 6)
				{
					menuConstraints = driverUIAuthors();
				}
				else
				{
					
				}
			}
			//PUBLISHERS MENU
			else if(input.get(input.size() - 1) == 3)
			{
				driverUIPublishers();
				menuConstraints = driverUIPublishers();
				input.push(getUserInput(scan, menuConstraints[0], menuConstraints[1]));
				//BAD INPUT MENU; BACK TO PUBLSHERS MENU
				if(input.get(input.size() - 1) == -1)
				{
					menuConstraints = driverUIAuthors();
				}
				//CREATE A PUBLSHER MENU
				else if(input.get(input.size() - 1) == 1)
				{
					
				}
				//READ ALL PUBLSHERS MENU
				else if(input.get(input.size() - 1) == 2)
				{
					readPublishers();
					menuConstraints = driverUIPublishers();
				}
				//UPDATE A PUBLSHER MENU
				else if(input.get(input.size() - 1) == 3)
				{
					
				}
				//DELETE A PUBLSHERS MENU
				else if(input.get(input.size() - 1) == 4)
				{
					System.out.println("Enter ID of publisher to delete: ");
					input.push(new Integer(getUserIntegerInput(scan).toString()));
					deletePublisher(input.get(input.size() - 1));
				}
				//SAVE; BACK TO PUBLSHERS MENU
				else if(input.get(input.size() - 1) == 5)
				{
					save();
					menuConstraints = driverUIPublishers();
				}
				//BACK TO  MENU
				else if(input.get(input.size() - 1) == 6)
				{
					menuConstraints = driverUIPublishers();
				}
				else
				{
					menuConstraints = driverUIPublishers();
				}

			}
			//SAVE THEN BACK TO MAIN MENU
			else if(input.get(input.size() - 1) == 4)
			{
				save();
				menuConstraints = driverUIMain();
			}
			//EXIT PROGRAM
			else if(input.get(input.size() - 1) == 5)
			{
				exit();
			}
			//UNKNOWN BAD INPUT; BACK TO MAIN MENU
			else
			{
				System.out.println("Only integers between " + menuConstraints[0] + " and " + menuConstraints[1] + " are allowed. Try input again.");
				input.pop();
				menuConstraints = driverUIMain();
			}
		}
		catch(InputMismatchException ime)
		{
			System.err.println("Please try again with legal input.");
		}
		catch(Exception e)
		{
			System.err.println("Something went wrong getting user input");
		}
		
		//System.out.println("Your input was: " + input.toString());

		//deleteAuthor(2);
		//deletePublisher(3);
		//addAuthor(new StringBuffer("John Smith"));
		//addPublisher(new StringBuffer("John's Publishing House"), new StringBuffer("1010 Springfield Ave, NP, NJ, USA"));
		//addBook(new StringBuffer("A New Book"), new StringBuffer("New Author"), new StringBuffer("New Publisher"), new StringBuffer("555 New St, New, NY, USA"));
		//updateAuthor(authors.get(1), new StringBuffer("An Updated Name"));
		//updatePublisher(publishers.get(2), new StringBuffer("Updated Publisher Name"), new StringBuffer("Updated Publisher Address, USA"));
		//updateBook(books.get(6), new StringBuffer("An Updated Title"), new StringBuffer("Updated Author Name"), new StringBuffer("Updated Pubisher Name"), new StringBuffer("This Updated Address, USA"));
		save();

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
	
	private static Book addBook(StringBuffer title, StringBuffer authorName, StringBuffer publisherName, StringBuffer address)
	{
		Author[] authorArray = authors.values().toArray(new Author[0]);
		Author bookAuthor = null;
		Integer i = 0;
		for(i = 0; i < authorArray.length; i++)
		{
			if(authorArray[i].getAuthorName().equals(authorName))
			{
				break;
			}
		}
		if(i < authorArray.length)
		{
			bookAuthor = authorArray[i];
		}
		else //if(i.equals(authorArray.length))
		{
			bookAuthor = addAuthor(authorName);
		}
		
		Publisher[] publisherArray = publishers.values().toArray(new Publisher[0]);
		Publisher bookPublisher;
		for(i = 0; i < publisherArray.length; i++)
		{
			if(publisherArray[i].getPublisherName().equals(publisherName) && publisherArray[i].getAddress().equals(address))
			{
				break;
			}
		}
		if(i < publisherArray.length)
		{
			bookPublisher = publisherArray[i];
		}
		else //if(i.equals(publisherArray.length))
		{
			bookPublisher = addPublisher(publisherName, address);
		}

		Book newBook = new Book(title, bookAuthor.getAuthorID(), bookPublisher.getPublisherID());
		Book[] bookArray = books.values().toArray(new Book[0]);
		Book book = null;
		for(i = 0; i < authorArray.length; i++)
		{
			if(bookArray[i].equals(newBook))
			{
				System.out.println("That book already exists");
				return bookArray[i];
			}
		}
		
		books.put(newBook.getBookID(), newBook);
		return newBook;
	}
	
	private static Author addAuthor(StringBuffer authorFullName)
	{
		for(HashMap.Entry<Integer, Author> currentAuthor : authors.entrySet())
		{
			if(currentAuthor.getValue().getAuthorName().equals(authorFullName))
			{
				System.out.println("That author already exists");
				return currentAuthor.getValue();
			}
		}
		Author newAuthor = new Author(authorFullName);
		authors.put(newAuthor.getAuthorID(), newAuthor);
		return newAuthor;
	}
	
	private static Publisher addPublisher(StringBuffer publisherName, StringBuffer address)
	{
		for(HashMap.Entry<Integer, Publisher> currentPublisher : publishers.entrySet())
		{
			if(currentPublisher.getValue().getPublisherName().equals(publisherName) && currentPublisher.getValue().getAddress().equals(address))
			{
				System.out.println("That publisher already exists");
				return currentPublisher.getValue();
			}
		}
		Publisher newPublisher = new Publisher(publisherName, address);
		publishers.put(newPublisher.getPublisherID(), newPublisher);
		return newPublisher;
	}
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void readBooks()
	{
		for(HashMap.Entry<Integer, Book> currentBook : books.entrySet())
		{
			Integer authorID = currentBook.getValue().getAuthorID();
			Integer publisherID = currentBook.getValue().getPublisherID();
			System.out.println("ID: " + currentBook.getKey() + " | Title: " + currentBook.getValue().getTitle() + " | Written by: " + authors.get(authorID).getAuthorName() + " | Published by: " + publishers.get(publisherID).getPublisherName());
		}
	}
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void readAuthors()
	{
		for(HashMap.Entry<Integer, Author> currentAuthor : authors.entrySet())
		{
			System.out.println("ID: " + currentAuthor.getKey() + " | Name: " + currentAuthor.getValue().getAuthorName());
		}
	}
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void readPublishers()
	{
		for(HashMap.Entry<Integer, Publisher> currentPublisher : publishers.entrySet())
		{
			System.out.println("ID: " + currentPublisher.getKey() + " | Name: " + currentPublisher.getValue().getPublisherName() + " | Address: " + currentPublisher.getValue().getAddress());
		}
	}
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void readBooksByAuthor(Integer authorID)
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
	
	private static void updateBook(Book book, StringBuffer title, StringBuffer authorName, StringBuffer publisherName, StringBuffer address)
	{		
		Author[] authorArray = authors.values().toArray(new Author[0]);
		Author bookAuthor = null;
		Integer i = 0;
		for(i = 0; i < authorArray.length; i++)
		{
			if(authorArray[i].getAuthorName().toString().equals(authorName.toString()))
			{
				break;
			}
		}
		if(i < authorArray.length)
		{
			System.out.println("That author already exists");
			bookAuthor = authorArray[i];
		}
		else //if(i.equals(authorArray.length))
		{
			System.out.println("New author added");
			bookAuthor = addAuthor(authorName);
		}
		book.setAuthorID(bookAuthor.getAuthorID());
		
		Publisher[] publisherArray = publishers.values().toArray(new Publisher[0]);
		Publisher bookPublisher;
		for(i = 0; i < publisherArray.length; i++)
		{
			if(publisherArray[i].getPublisherName().toString().equals(publisherName.toString()) && publisherArray[i].getAddress().toString().equals(address.toString()))
			{
				break;
			}
		}
		if(i < publisherArray.length)
		{
			System.out.println("That publisher already exists");
			bookPublisher = publisherArray[i];
		}
		else //if(i.equals(publisherArray.length))
		{
			System.out.println("New publisher added");
			bookPublisher = addPublisher(publisherName, address);
		}
		book.setPublisher(bookPublisher.getPublisherID());
		
		Book newBook = new Book(title, bookAuthor.getAuthorID(), bookPublisher.getPublisherID());
		Book[] bookArray = books.values().toArray(new Book[0]);
		for(i = 0; i < bookArray.length; i++)
		{
			if(bookArray[i].equals(newBook))
			{
				System.out.println("That book already exists");
				break;
			}
		}
		if(i == bookArray.length)
		{
			books.put(newBook.getBookID(), newBook);
		}
	}
	
	private static void updateAuthor(Author author, StringBuffer authorName)
	{
		for(HashMap.Entry<Integer, Author> currentAuthor : authors.entrySet())
		{
			if(currentAuthor.getValue().getAuthorName().toString().equals(authorName.toString()))
			{
				System.out.println("That author already exists");
				return;
			}
		}
		author.setAuthorName(authorName);
	}
	
	private static void updatePublisher(Publisher publisher, StringBuffer publisherName, StringBuffer address)
	{
		for(HashMap.Entry<Integer, Publisher> currentPublisher : publishers.entrySet())
		{
			if(currentPublisher.getValue().getPublisherName().toString().equals(publisherName.toString()) && currentPublisher.getValue().getAddress().toString().equals(address.toString()))
			{
				System.out.println("That publisher already exists");
				return;
			}
		}
		publisher.setPublisherName(publisherName);
		publisher.setAddress(address);
	}
	
	private static void deleteBook(Integer bookID)
	{
		books.remove(bookID);
	}
	
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void deleteAuthor(Integer authorID)
	{
		Collection<Book> bookValues = books.values();
		Iterator<Book> bookIterator = bookValues.iterator();
		while(bookIterator.hasNext())
		{
			Book nextBook = bookIterator.next();
			if(nextBook.getAuthorID().equals(authorID))
			{
				bookIterator.remove();
			}
		}
		authors.remove(authorID);
	}
	
	// THIS IS A GOOD CANDIDATE TO CONVERT TO LAMDAS/STREAMS
	private static void deletePublisher(Integer publisherID)
	{
		Collection<Book> bookValues = books.values();
		Iterator<Book> bookIterator = bookValues.iterator();
		while(bookIterator.hasNext())
		{
			Book nextBook = bookIterator.next();
			if(nextBook.getPublisherID().equals(publisherID))
			{
				bookIterator.remove();
			}
		}
		publishers.remove(publisherID);
	}
	
	private static void load()
	{
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\Authors.txt"));
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

			br = new BufferedReader(new FileReader("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\Publishers.txt"));
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

			br = new BufferedReader(new FileReader("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\Books.txt"));
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

			
		}
		catch(FileNotFoundException f)
		{
			System.err.println("File not found");
		}
		catch(Exception e)
		{
			System.err.println("Something went wrong");
		}
		finally
		{
			if(br != null)
			{
				try
				{
					br.close();
				}
				catch(IOException ioe)
				{
					System.err.println("Failed to close BufferedReader");
				}
				
			}
			
		}
	}
	/**
	 * save data to files
	 */
	private static void save()
	{
		BufferedWriter bw = null;
		try
		{
			//bw = new BufferedWriter(new FileWriter("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\test.txt"));
			//bw.write("This is only a test");
			//bw.flush();
			bw = new BufferedWriter(new FileWriter("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\Authors.txt"));
			for(HashMap.Entry<Integer, Author> currentAuthor : authors.entrySet())
			{
				//System.out.println(currentAuthor.getValue().toStringBuffer().toString());
				bw.write(currentAuthor.getValue().toStringBuffer().toString());
				bw.newLine();
			}
			bw.flush();

			bw = new BufferedWriter(new FileWriter("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\Books.txt"));
			for(HashMap.Entry<Integer, Book> currentBook : books.entrySet())
			{
				//System.out.println(currentBook.getValue().toStringBuffer().toString());
				bw.write(currentBook.getValue().toStringBuffer().toString());
				bw.newLine();
			}
			bw.flush();
			
			bw = new BufferedWriter(new FileWriter("C:\\Users\\UCI\\Documents\\GitHub\\Smoothstack\\src\\com\\ss\\lms\\biz\\Publishers.txt"));
			for(HashMap.Entry<Integer, Publisher> currentPublisher : publishers.entrySet())
			{
				//System.out.println(currentPublisher.getValue().toStringBuffer().toString());
				bw.write(currentPublisher.getValue().toStringBuffer().toString());
				bw.newLine();
			}
			bw.flush();
			System.out.println("Progress saved");
		} 
		catch(IOException e) 
		{
			System.err.println("Books.txt cannot be created or opened.");
		}
		catch(Exception e)
		{
			System.err.println("Error writing to Books.txt.");
		}
		finally
		{
			if(bw != null)
			{
				try
				{
					bw.close();
				}
				catch(IOException ioe)
				{
					System.err.println("Failed to close BufferedReader");
				}
			}

		}
	}
	/**
	 * save data to files then exit without error
	 */
	private static void exit()
	{
		//save();  //give the option to exit without saving
		System.exit(0);
	}
	
	private static StringBuffer getUserInput(Scanner scan) 
	{
		StringBuffer input = new StringBuffer(); 
		//if(scan.hasNextLine()) 
		//{ 
			input.append(scan.nextLine());
			if(input.length() >= 2)
			{
				return input;
			}
			System.out.println("Input must be at least 2 characters long");
		//} 
		return input;
	}
	private static Integer getUserIntegerInput(Scanner scan) 
	{
		Integer input = -1; 
		//while(scan.hasNextInt()) 
		//{ 
			input = scan.nextInt();
		//} 
		return input;
	}
	private static Integer getUserInput(Scanner scan, Integer low, Integer high) 
	{
		Integer input = -1; 
		while(scan.hasNextInt()) 
		{ 
			input = scan.nextInt();
			if(input >= low && input <= high)
			{
				return input;
			}
		} 
		return input;
	}
	 
	private static Integer[] driverUIMain()
	{
		System.out.println("Welcome to the Smoothstack Library Management System. Would you like to access books, authors, publishers, save your progress, or exit? (enter an integer 1-5 only)");
		System.out.println("1) Books");
		System.out.println("2) Authors");
		System.out.println("3) Publishers");
		System.out.println("4) Save Updates");
		System.out.println("5) Exit");
		Integer[] contraints = {1, 5};	
		return contraints;
	}
	private static Integer[] driverUIAuthors()
	{
		System.out.println("Welcome to authors. Would you like to create, read, update, delete, save your progress, or go back? (enter an integer 1-6 only)");
		System.out.println("1) Create Author");
		System.out.println("2) Read All Author");
		System.out.println("3) Update Author");
		System.out.println("4) Delete Author");
		System.out.println("5) Save Updates");
		System.out.println("6) Go back");
		Integer[] contraints = {1, 6};
		return contraints;
	}
	private static Integer[] driverUIBooks()
	{
		System.out.println("Welcome to books. Would you like to create, read, update, delete, save your progress, or go back? (enter an integer 1-6 only)");
		System.out.println("1) Create Book");
		System.out.println("2) Read All Books");
		System.out.println("3) Update Book");
		System.out.println("4) Delete Book");
		System.out.println("5) Save Updates");
		System.out.println("6) Go back");
		Integer[] contraints = {1, 6};
		return contraints;
	}
	private static Integer[] driverUIPublishers()
	{
		System.out.println("Welcome to publishers. Would you like to create, read, update, delete, save your progress, or go back? (enter an integer 1-6 only)");
		System.out.println("1) Create Publisher");
		System.out.println("2) Read All  Publishers");
		System.out.println("3) Update  Publisher");
		System.out.println("4) Delete  Publisher");
		System.out.println("5) Save Updates");
		System.out.println("6) Go back");
		Integer[] contraints = {1, 6};
		return contraints;
	}
	private static void driverUICreate()
	{
		System.out.println("What do you want to create?");
	}
	private static void driverUIRead()
	{
		System.out.println("What do you want to read?");
	}
	private static void driverUIUpdate()
	{
		System.out.println("What do you want to update?");
	}
	private static void driverUIDelete()
	{
		System.out.println("What do you want to delete?");
	}
	private static void mainMenu()
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
