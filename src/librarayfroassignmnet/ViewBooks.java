package librarayfroassignmnet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ViewBooks extends JFrame {
	static ViewBooks frame;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBooks frame = new ViewBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewBooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		JLabel lblAdminSection = new JLabel("View Books");
		lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAdminSection.setForeground(Color.GRAY);
		
		JButton btnUpdateBooks = new JButton("View Books");
		btnUpdateBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			UpdateBooks.main(new String[]{});
			}
		});
		btnUpdateBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		JButton btnUpdateBooks = new JButton("Add Books");
		btnUpdateBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddBooksForm.main(new String[]{});
			frame.dispose();
			}
		});
		
		JButton btnDeleteBooks = new JButton("Add Books");
		btnDeleteBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteBooks.main(new String[]{});
			frame.dispose();
			}
		});
		
		JButton btnSearchBooks = new JButton("Add Books");
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddBooksForm.main(new String[]{});
			frame.dispose();
			}
		});
		
		JButton btnAvailableBooks = new JButton("Add Books");
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddBooksForm.main(new String[]{});
			frame.dispose();
			}
		});
		
		JButton btnSoldBooks = new JButton("Add Books");
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddBooksForm.main(new String[]{});
			frame.dispose();
			}
		});
		
		
		
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DbConnect.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
	}

}