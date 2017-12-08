package summative.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BrowseLibraryPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Box mainBox, hBox1, hBox2, hBox3, hBox4, hBox5;

	private JLabel jlBookTable;
	private JButton bOpenBook, bDeleteBook, bDeleteFile, bSave,
			bSaveAndQuit;
	private JTable tBooks;
	private MyTableModel model;
	private JScrollPane spBookTable;

	String[] bookColumns = { "Title", "Author", "Price", "ISBN" };
	String[][] bookData = { { " ", " ", " ", " " } };


	public BrowseLibraryPanel() {
		super(new FlowLayout());
		intWidgets();
		addWidgets();
		setBackground(new Color(194, 230, 248));
	}

	private void intWidgets() {
		mainBox = Box.createVerticalBox();

		hBox1 = Box.createHorizontalBox();
		hBox2 = Box.createHorizontalBox();
		hBox3 = Box.createHorizontalBox();
		hBox4 = Box.createHorizontalBox();
		hBox5 = Box.createHorizontalBox();

		jlBookTable = new JLabel("Showing All Book in Library");


		bOpenBook = new JButton("Open");
		bDeleteBook = new JButton("Delete");
		bDeleteFile = new JButton("Delete");
		bSave = new JButton("Save");
		bSaveAndQuit = new JButton("Save&Quit");
		
		model = new MyTableModel(bookData, bookColumns);
		tBooks = new JTable(model);
		tBooks.setPreferredScrollableViewportSize(new Dimension(328, 120));
		tBooks.setFillsViewportHeight(true);
		tBooks.setAutoCreateRowSorter(true);
		tBooks.getTableHeader().setReorderingAllowed(false);
		tBooks.getColumnModel().getColumn(0).setPreferredWidth(200);
		tBooks.getColumnModel().getColumn(1).setPreferredWidth(150);
		

		spBookTable = new JScrollPane(tBooks);
		
		spBookTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		spBookTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	}

	private void addWidgets() {
		hBox1.add(jlBookTable);
		hBox1.add(Box.createHorizontalStrut(50));
		hBox1.add(bDeleteBook);
		hBox1.add(bOpenBook);
		hBox2.add(spBookTable);
                
		hBox5.add(Box.createHorizontalStrut(185));
		hBox5.add(bSave);
		hBox5.add(Box.createHorizontalStrut(5));
		hBox5.add(bSaveAndQuit);

		mainBox.add(hBox1);
		mainBox.add(Box.createVerticalStrut(5));
		mainBox.add(hBox2);
		mainBox.add(Box.createVerticalStrut(5));
		mainBox.add(hBox3);
		mainBox.add(Box.createVerticalStrut(5));
		mainBox.add(hBox4);
		mainBox.add(Box.createVerticalStrut(5));
		mainBox.add(hBox5);

		add(mainBox);
		
	}
	
	public void addActionListener(ActionListener a){
		bOpenBook.addActionListener(a);
		bDeleteBook.addActionListener(a);

		bDeleteFile.addActionListener(a);
		bSave.addActionListener(a);
		bSaveAndQuit.addActionListener(a);
	}
	
	public JButton getButtonOpenBook(){
		return bOpenBook;
	}
	
	public JButton getButtonDeleteBook(){
		return bDeleteBook;
	}
	
	public JButton getButtonDeleteFile(){
		return bDeleteFile;
	}
	
	public JButton getButtonSave(){
		return bSave;
	}
	
	public JButton getButtonSaveAndQuit(){
		return bSaveAndQuit;
	}
	
	public JTable getBookTable(){
		return tBooks;
	}

}
