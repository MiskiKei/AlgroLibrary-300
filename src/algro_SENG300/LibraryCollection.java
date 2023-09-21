package algro_SENG300;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;


public class LibraryCollection {

	
	public List<Book> matchingBooks = new ArrayList<>();
	private JFrame frame;
    private JTable bookTable;
    private JTextField SearchTextField;
    private JButton resetButton;
    private JScrollPane scrollPaneTable;

   
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryCollection window = new LibraryCollection();
					window.frame.setVisible(true);
					window.loadInitialBooks();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibraryCollection() {
		initComponents();
		createEvents();
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////
///// This method contains all of the code for creating and initializing components  
/////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
    private void initComponents() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1280, 950);
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu FileMenu = new JMenu("File");
        FileMenu.setFont(new Font("Songti SC", Font.PLAIN, 17));
        menuBar.add(FileMenu);
        
        JMenuItem ExitMenuItem = new JMenuItem("Exit");
        ExitMenuItem.setFont(new Font("Songti SC", Font.PLAIN, 17));
        FileMenu.add(ExitMenuItem);
        
        JMenu AboutMenu = new JMenu("About");
        AboutMenu.setFont(new Font("Songti SC", Font.PLAIN, 17));
        menuBar.add(AboutMenu);
        
        JPanel contentPane = new JPanel();
        frame.setContentPane(contentPane);
        contentPane.setLayout(null); // Null layout gets it so the program opens in the middle of the screen 
        
        
        SearchTextField = new JTextField();
        SearchTextField.setText("Search By Title, Author, ISBN, or Book ID");
        SearchTextField.setFont(new Font("Songti SC", Font.PLAIN, 17));
        
        SearchTextField = new JTextField();
        SearchTextField.setBounds(21, 16, 1243, 30);
        contentPane.add(SearchTextField);
        SearchTextField.setColumns(10);
       
	    
	    SearchTextField.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(Color.GRAY),
	            BorderFactory.createEmptyBorder(5, 10, 5, 10)));
	    SearchTextField.setCaretColor(Color.BLACK);
	    SearchTextField.setForeground(Color.LIGHT_GRAY);
	    
	    resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Songti SC", Font.PLAIN, 17));
        resetButton.setBounds(1157, 677, 117, 30);
        contentPane.add(resetButton);
	    
        
        scrollPaneTable = new JScrollPane();
        scrollPaneTable.setBounds(21, 58, 1243, 611);
        contentPane.add(scrollPaneTable);

        String[] columnNames = { "Cover", "Book ID", "Title", "Author", "ISBN", "Publication Year", "Rating" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        bookTable = new JTable(tableModel);
       
        scrollPaneTable.setViewportView(bookTable);
        
        
       
       //Font for the table 
        Font textFont = new Font("Songti SC", Font.PLAIN, 17);
        bookTable.setFont(textFont);
        
        Font headerFont = new Font("Songti SC", Font.PLAIN, 18);
        JTableHeader tableHeader = bookTable.getTableHeader();
        tableHeader.setFont(headerFont);
        
        
        bookTable.setEnabled(false);
        
    }
        
	//PULLS FROM FILEREADER AND GETS 10 BOOKS
        public void loadInitialBooks() {
            DefaultTableModel tableModel = (DefaultTableModel) bookTable.getModel();

            //PULLS FROM FILEREADER AND GETS 10 BOOKS
            List<Book> books = null;
            try {
                books = Book_FileReader.readCSV();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (books != null) {
                int limit = Math.min(10, books.size());
                for (int i = 0; i < limit; i++) {
                    Book book = books.get(i);
                    Object[] rowData = {
                        getImageIcon(book.getImageUrl()), // Display image
                        book.getBookId(),
                        book.getTitle(),
                        book.getAuthors(),
                        book.getIsbn(),
                        book.getOriginalPublicationYear(),
                        book.getAverageRating()
                    };
                    tableModel.addRow(rowData);
                }
            }
        

	  
  ///////THIS CODE FIXES THE COLUMNS OF THE TABLE
	        
	        int coverColumnIndex = 0; // "Book ID" is the second column (index 1)
	        int coverpreferredWidth = 120; 

	        TableColumn coverColumn = bookTable.getColumnModel().getColumn(coverColumnIndex);
	        coverColumn.setPreferredWidth(coverpreferredWidth);
	        
	        
	        int bookIdColumnIndex = 1; // "Book ID" is the second column (index 1)
	        int preferredWidth = 80; 

	        TableColumn bookIdColumn = bookTable.getColumnModel().getColumn(bookIdColumnIndex);
	        bookIdColumn.setPreferredWidth(preferredWidth);
	    

	        int titleColumnIndex = 2; 
	        int titlePreferredWidth = 440; 

	        TableColumn titleColumn = bookTable.getColumnModel().getColumn(titleColumnIndex);
	        titleColumn.setPreferredWidth(titlePreferredWidth);
	        
	        int authorColumnIndex = 3; 
	        int authorPreferredWidth = 240; 

	        TableColumn authorColumn = bookTable.getColumnModel().getColumn(authorColumnIndex);
	        authorColumn.setPreferredWidth(authorPreferredWidth);
	        
	        int ISBNColumnIndex = 4; 
	        int ISBNPreferredWidth = 130; 

	        TableColumn ISBNColumn = bookTable.getColumnModel().getColumn(ISBNColumnIndex);
	        ISBNColumn.setPreferredWidth(ISBNPreferredWidth);
	        
	        int yearColumnIndex = 5; 
	        int yearPreferredWidth = 180; 

	        TableColumn yearColumn = bookTable.getColumnModel().getColumn(yearColumnIndex);
	        yearColumn.setPreferredWidth(yearPreferredWidth);
	        
	        int ratingColumnIndex = 6; 
	        int ratingPreferredWidth = 90; 

	        TableColumn ratingColumn = bookTable.getColumnModel().getColumn(ratingColumnIndex);
	        ratingColumn.setPreferredWidth(ratingPreferredWidth);
	        
	        
	        
	//////////THIS CODE HELPS TO RENDERER THE IMAGE ON THE TABLE 
	        
	    //This thing makes it so the images are actually whole
	        bookTable.setRowHeight(155);
	       

	    // Set custom renderer for the "Cover" column
	    coverColumn = bookTable.getColumnModel().getColumn(0); //this is the index of the cover
	    coverColumn.setCellRenderer(new ImageRenderer());
    }

	    // method to create an ImageIcon from a URL
	    private ImageIcon getImageIcon(String imageUrl) {
	        try {
	            URL url = new URL(imageUrl);
	            return new ImageIcon(ImageIO.read(url));
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    // renderer for displaying images
	    private class ImageRenderer implements TableCellRenderer {
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
	                int row, int column) {
	            return (value != null) ? new JLabel((ImageIcon) value) : null;
	        }
	    }
	    
	    
	//////METHOD FOR SEARCHING BOOK MATCHES AUTHOR, ISBN, BOOK ID, TITLE 
	    
	    public List<Book> populateMatchingBooksBySearch(String key) throws IOException {
	    	
	        BookSearch mySearch = new BookSearch();
	        List<Book> books = Book_FileReader.readCSV();
	        
	        List<Book> matchingBooks = new ArrayList<>();

	        // Try searching by Book ID
	        try {
	            int bookIdToSearch = Integer.parseInt(key);
	            Book foundBook = mySearch.binarySearchBookID(books, bookIdToSearch);

	            if (foundBook != null) {
	                matchingBooks.add(foundBook);
	            }
	        } catch (NumberFormatException e) {
	            // If the key is not an INT it will continue to move onto the next criteria (ISBN, Title, Author) which are all strings 
	        }

	        // Try searching by ISBN
	        if (matchingBooks.isEmpty()) {
	            Book foundBook = mySearch.linearSearchISBN(books, key);
	            if (foundBook != null) {
	                matchingBooks.add(foundBook);
	            }
	        }
	        
	       // Try searching by OG Title
	        if (matchingBooks.isEmpty()) {
	            Book foundBook = mySearch.linearSearchOGTitle(books, key);
	            if (foundBook != null) {
	                matchingBooks.add(foundBook);
	            }
	        }
	        
	       // Try searching by Author
	        if (matchingBooks.isEmpty()) {
	            Book foundBook = mySearch.linearSearchAuthor(books, key);
	            if (foundBook != null) {
	                matchingBooks.add(foundBook);
	            }
	        }

	        
	        // Window that pops up if there are no matches found between the four methods 
	        if (matchingBooks.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Error: No matches found.");
	        }

	        return matchingBooks;
	    }

  
	/////////METHOD FOR UPDATING TABLES AFTER SEARCH AND SORT 
	    public void updateTableWithSearchResults(List<Book> matchingBooks) {
	        DefaultTableModel tableModel = (DefaultTableModel) bookTable.getModel();
	        tableModel.setRowCount(0); // Clear existing rows

	        for (Book book : matchingBooks) {
	            Object[] rowData = {
	                getImageIcon(book.getImageUrl()), // Display image
	                book.getBookId(),
	                book.getTitle(),
	                book.getAuthors(),
	                book.getIsbn(),
	                book.getOriginalPublicationYear(),
	                book.getAverageRating()
	            };
	            tableModel.addRow(rowData);
	        }
	    }



///////////////////////////////////////////////////////////////////////////////////////////////
///// This method contains all of the code for creating events
/////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Action and Event Handlers.
	 */

	private void createEvents() {
		
		SearchTextField.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String key = SearchTextField.getText();
		            
		            List<Book> matchingBooks = populateMatchingBooksBySearch(key);
		            updateTableWithSearchResults(matchingBooks);
		            
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		
	    resetButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		DefaultTableModel tableModel = (DefaultTableModel) bookTable.getModel();
	 	        tableModel.setRowCount(0); // Clear existing rows on tables
	 	        
	    		loadInitialBooks();
	    	}
	    });
			 
		
	 //Gray to Black text for search bar
		SearchTextField.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (SearchTextField.getText().equals("Search By Title, Author, ISBN, or Book ID")) {
		            SearchTextField.setText("");
		        }
		        SearchTextField.setForeground(Color.BLACK); // Set text color to black when focused
		        SearchTextField.setFont(new Font("Songti SC", Font.PLAIN, 17));
		        
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        if (SearchTextField.getText().isEmpty()) {
		            SearchTextField.setText("Search By Title, Author, ISBN, or Book ID");
		        }
		        SearchTextField.setForeground(Color.GRAY); // Set text color to gray when focus is lost
		        SearchTextField.setFont(new Font("Songti SC", Font.PLAIN, 17));
		    }
		});
		
		SearchTextField.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            SearchTextField.requestFocusInWindow();
	        }
	    });

	    SearchTextField.addFocusListener(new FocusAdapter() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (SearchTextField.getText().equals("Search By Title, Author, ISBN, or Book ID")) {
	                SearchTextField.setText("");
	                SearchTextField.setForeground(new Color(153, 153, 153)); 
	            }
	        }

	        @Override
	        public void focusLost(FocusEvent e) {
	            if (SearchTextField.getText().equals("")) {
	                SearchTextField.setText("Search By Title, Author, ISBN, or Book ID");
	                SearchTextField.setForeground(new Color(153, 153, 153));
	            }
	        }
	    });

	    SearchTextField.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            SearchTextField.setForeground(Color.BLACK);
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            if (SearchTextField.getText().isEmpty()) {
	                SearchTextField.setForeground(new Color(153, 153, 153));
	            }
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            // not needed for plain text fields
	        }
	    });
	}
	}
