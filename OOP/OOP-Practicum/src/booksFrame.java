import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class booksFrame extends JFrame{
	Connection conn=null;
	PreparedStatement state=null;
	ResultSet result=null;
	//������� ���������� �� ������������ �� id-���� �� ��������� ������������
	int id=-1;
	int idauthor=-1;
	int idpub=-1;
	int idsearch=-1;
	int idgenre=-1;
	
	//��� ��� �����
	JTabbedPane tab=new JTabbedPane();

	
	//��� ��������
	//������� ����� �� ��������
	JPanel bookPanel=new JPanel();
	Border panelPadding = BorderFactory.createEmptyBorder(10, 10, 10, 10);

	
	
	//��������� �� ��������
	JPanel bookPanel1=new JPanel();
	JPanel bookPanel2=new JPanel();
	JPanel bookPanel3=new JPanel();
	
	//�������
	JLabel bookNameL=new JLabel("������������:");
	JLabel bookAuthorL=new JLabel("�����:");
	JLabel bookGenreL=new JLabel("����:");
	JLabel bookPublisherL=new JLabel("�����������:");
	JLabel bookOpisL=new JLabel("��������:");
	JLabel bookQuantityL=new JLabel("����:");
	JLabel bookPriceL=new JLabel("����:");
	JLabel bookYearL=new JLabel("������:");
	
	private static final long serialVersionUID = 4L;
	
	//�������� ������ �� ���������
	JTextField bookNameTF=new JTextField();
	JTextField bookAuthorTF=new JTextField();
	JTextField bookPublisherTF=new JTextField();
	JTextField bookDescrTF=new JTextField();
	JTextField bookQuantityTF=new JTextField();
	JTextField bookPriceTF=new JTextField();
	JTextField bookYearTF=new JTextField();
	
	//��������� �� ��������������
	JComboBox<String> comboAuthor=new JComboBox<String>();
	JComboBox<String> comboPublisher=new JComboBox<String>();
	JComboBox<String> comboGenre=new JComboBox<String>();
	
	//������ �� ������ ��������
	JButton BAdd=new JButton("������");
	JButton BDel=new JButton("������");
	JButton BEdit=new JButton("�������");
			
	//�������+������ �� ������������
	JTable bookTable=new JTable();
	JScrollPane bookScroll=new JScrollPane(bookTable);
	
	
	//��� �����
	//������
	JLabel authorNameL=new JLabel("��� �� �����:");
	JLabel authMessageL = new JLabel("�������� �����",SwingConstants.CENTER);
	//�������� ����
	JTextField authorNameTF=new JTextField();
	//������� ����� �� �����
	JPanel authorPanel=new JPanel();
	//���������
	JPanel authorPanel1=new JPanel();
	JPanel authorPanel2=new JPanel();
	JPanel authorPanel3=new JPanel();
	
	//������ �� ������ ��������
	JButton AuthAdd=new JButton("������");
	JButton AuthDel=new JButton("������");
	JButton AuthEdit=new JButton("�������");
	
	//�������+������ �� �����
	JTable authorTable=new JTable();
	JScrollPane authorScroll=new JScrollPane(authorTable);
	
	
	//��� �����������
	//������
	JLabel pubNameL=new JLabel("�����������:");
	JLabel pubMessageL = new JLabel("�������� �����������",SwingConstants.CENTER);
	//�������� ���� �� ���������
	JTextField pubNameTF=new JTextField();

	//������� �����
	JPanel pubPanel=new JPanel();
	
	//���������
	JPanel pubPanel1=new JPanel();
	JPanel pubPanel2=new JPanel();
	JPanel pubPanel3=new JPanel();

	//������ �� �����������
	JButton PubAdd=new JButton("������");
	JButton PubDel=new JButton("������");
	JButton PubEdit=new JButton("�������");
	
	
	
	//�������+������ �� �����������
	JTable pubTable=new JTable();
	JScrollPane pubScroll=new JScrollPane(pubTable);
	
	
	//��� �������: ��-����� ���� � ��������
	//������
	JLabel srchBookPriceL=new JLabel("�������� ���������� ����:");
	JLabel srchBookComboAuthorL=new JLabel("�������� �����:");
	//�������� ���� �� ���������
	JTextField srchBookPriceTF=new JTextField();
	JComboBox<String> comboSrchAuthor=new JComboBox<String>();
	//������� �����
	JPanel srchPanel=new JPanel();
	//���������
	JPanel srchPanel1=new JPanel();
	JPanel srchPanel2=new JPanel();
	JPanel srchPanel3=new JPanel();

	//������ �� ������������
	JButton srchSearch=new JButton("�����");
	JLabel srchMessageL=new JLabel("������ ���� �������� �� ���������� �� ������� �� ����, � �� ����� ���� � ������� '-'",SwingConstants.CENTER);
   
	//�������+������ �� ���������
	JTable srchTable=new JTable();
	JScrollPane srchScroll=new JScrollPane(srchTable);
	
	public booksFrame() {
		
		conn=MyDBConnection.getConnection();
		this.setSize(650, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("�����");
		this.bookPanel.setBorder(panelPadding);
		this.authorPanel.setBorder(panelPadding);
		this.pubPanel.setBorder(panelPadding);
		this.srchPanel.setBorder(panelPadding);
		
		
		// tab ��������
				tab.add(bookPanel,"��������");
				bookPanel.setLayout(new GridLayout(3,1));
				//����� ��������
				bookPanel.add(bookPanel1);

				bookPanel1.setLayout(new GridLayout(8,2));
				bookPanel1.add(bookNameL);bookPanel1.add(bookNameTF);
				bookPanel1.add(bookAuthorL);bookPanel1.add(comboAuthor);
				bookPanel1.add(bookGenreL);bookPanel1.add(comboGenre);
				bookPanel1.add(bookPublisherL);bookPanel1.add(comboPublisher);
				bookPanel1.add(bookOpisL);bookPanel1.add(bookDescrTF);
				bookPanel1.add(bookQuantityL);bookPanel1.add(bookQuantityTF);
				bookPanel1.add(bookPriceL);bookPanel1.add(bookPriceTF);
				bookPanel1.add(bookYearL);bookPanel1.add(bookYearTF);

				//����� �������� �� ��������
				bookPanel.add(bookPanel2);
				bookPanel2.add(BAdd);bookPanel2.add(BDel);bookPanel2.add(BEdit);
				
				// ������ 
				BAdd.addActionListener(new AddBookDB());
				BDel.addActionListener(new DelBookDB());
				BEdit.addActionListener(new EditBookDB());
				
				bookPanel.add(bookPanel3);
				bookScroll.setPreferredSize(new Dimension(550, 200));
				bookPanel3.add(bookScroll);
				
				
			//��� �����  
				tab.add(authorPanel,"�����");
				authorPanel.setLayout(new GridLayout(3,1));
				authorPanel.add(authorPanel1);
				authMessageL.setForeground(Color.black);
				authorPanel1.add(authorNameL);authorPanel1.add(authorNameTF);
				authorNameTF.setPreferredSize(new Dimension(450,30));

				authorPanel.add(authorPanel2);
				authorPanel2.add(AuthAdd);authorPanel2.add(AuthDel);authorPanel2.add(AuthEdit);
				
				// ������ 
				AuthAdd.addActionListener(new AddAuthorDB());
				AuthDel.addActionListener(new DelAuthorDB());
				AuthEdit.addActionListener(new EditAuthorDB());
				
				authorPanel.add(authorPanel3);
				authorScroll.setPreferredSize(new Dimension(550, 200));
				authorPanel3.setLayout(new GridLayout(2,1));
				authorPanel3.add(authMessageL);
				authorPanel3.add(authorScroll);
			//��� ����������� 
				tab.add(pubPanel,"�����������");
				pubPanel.setLayout(new GridLayout(3,1));
				pubPanel.add(pubPanel1);
				pubMessageL.setForeground(Color.black);
				pubPanel1.add(pubNameL);pubPanel1.add(pubNameTF);
				pubNameTF.setPreferredSize(new Dimension(450,30));

				pubPanel.add(pubPanel2);
				
				
				pubPanel2.add(PubAdd);pubPanel2.add(PubDel);pubPanel2.add(PubEdit);
				
				
				// ������ 
				PubAdd.addActionListener(new AddPublisherDB());
				PubDel.addActionListener(new DelPublisherDB());
				PubEdit.addActionListener(new EditPublisherDB());
				
				pubPanel.add(pubPanel3);
				pubScroll.setPreferredSize(new Dimension(550, 200));
				pubPanel3.setLayout(new GridLayout(2,1));
				pubPanel3.add(pubMessageL);
				pubPanel3.add(pubScroll);
				
				
			//��� �������  
				tab.add(srchPanel,"�������");
				srchPanel.setLayout(new GridLayout(3,1));
				srchPanel.add(srchPanel1);
				
				srchPanel1.setLayout(new GridLayout(2,2));
				srchPanel1.add(srchBookPriceL);srchPanel1.add(srchBookPriceTF);
				srchBookPriceTF.setPreferredSize(new Dimension(450,30));
				srchPanel1.add(srchBookComboAuthorL);srchPanel1.add(comboSrchAuthor);
				srchPanel.add(srchPanel2);
				
				srchPanel2.setLayout(new GridLayout(2,1));
				srchPanel2.add(srchSearch);
				srchPanel2.add(srchMessageL);
				srchMessageL.setForeground(Color.black);
				// ������ 
				srchSearch.addActionListener(new SearchDB());
				
				srchPanel.add(srchPanel3);
				srchScroll.setPreferredSize(new Dimension(550, 200));
				srchPanel3.add(srchScroll);
		
				this.add(tab);
				this.setVisible(true);
				this.refreshBookTable(); // ������� ��� ���������
				this.refreshComboAuthor();
				this.refreshComboGenre();
				this.refreshComboPublisher();
				//this.refreshComboGenre();
				this.refreshAuthTable("AUTHTABLE", authorTable); // ������� � ���������
				this.refreshPubTable("PUBTABLE", pubTable); // ������� � ���������

				//��������� �� ������� � ��������� �� ������������
				bookTable.addMouseListener(new MouseActionBookTable());
				authorTable.addMouseListener(new MouseActionAuthorTable());
				pubTable.addMouseListener(new MouseActionPubTable());
				
				comboAuthor.addActionListener(new ActionListener() {
					
					//��������� �������� ���������� �� ����� ���� ��� � ������� ������ ���
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						if(tab.getSelectedIndex()==0 && idauthor>0) {
							
							String str="select * from authtable where author='" + comboAuthor.getSelectedItem().toString()+"'";
							try {
								state=conn.prepareStatement(str);
								result=state.executeQuery();
								result.next();
								idauthor=Integer.parseInt(result.getObject(1).toString());
							} catch (SQLException e1) {e1.printStackTrace();}

							System.out.println(comboAuthor.getSelectedItem().toString());
							System.out.println(str);
							System.out.println(idauthor);
						}
					}
				});

				comboPublisher.addActionListener(new ActionListener() {
					
					//��������� �������� ���������� �� ����������� ���� ��� � ������� ������ ���
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						if(tab.getSelectedIndex()==0 && idpub>0) {
							
							String str="select * from pubtable where publisher='"+comboPublisher.getSelectedItem().toString()+"'";
							try {
								state=conn.prepareStatement(str);
								result=state.executeQuery();
								result.next();
								idpub=Integer.parseInt(result.getObject(1).toString());
							} catch (SQLException e1) {e1.printStackTrace();}

							System.out.println(comboPublisher.getSelectedItem().toString());
							System.out.println(str);
							System.out.println(idpub);
						}

					}
				});
				
				                                   
	}
	
		// ����������� ������� � ��������� �� ������� ������ � ���������� ���
		public void refreshBookTable() {
			//conn=MyDBConnection.getConnection();
			String str="";
			str="select booktable.id, name, authtable.author,booktable.idauthor, pubtable.publisher,booktable.idpublisher, descr, quant,price,datein,yearr,genretable.genre,booktable.idgenre from booktable,pubtable,authtable,genretable where booktable.idpublisher=pubtable.id and booktable.idauthor=authtable.id and booktable.idgenre=genretable.id";
			try {
				state=conn.prepareStatement(str);
				result=state.executeQuery();
				bookTable.setModel(new MyTModel(result));
				
				
				bookTable.getColumnModel().getColumn(3).setMinWidth(0);
				bookTable.getColumnModel().getColumn(3).setMaxWidth(0);
				bookTable.getColumnModel().getColumn(3).setWidth(0);

				bookTable.getColumnModel().getColumn(5).setMinWidth(0);
				bookTable.getColumnModel().getColumn(5).setMaxWidth(0);
				bookTable.getColumnModel().getColumn(5).setWidth(0);
				
				bookTable.getColumnModel().getColumn(12).setMinWidth(0);
				bookTable.getColumnModel().getColumn(12).setMaxWidth(0);
				bookTable.getColumnModel().getColumn(12).setWidth(0);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ����������� ������� � ��������� �� ����� � ���������� ���
		public void refreshAuthTable(String name, JTable table) {
			//conn=MyDBConnection.getConnection();
			String str="select * from "+name;
			try {
				state=conn.prepareStatement(str);
				result=state.executeQuery();
				table.setModel(new MyTModel(result));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ����������� ������� � ��������� �� ����������� � ���������� ���
		public void refreshPubTable(String name, JTable table) {
			//conn=MyDBConnection.getConnection();
			String str="select * from "+name;
			try {
				state=conn.prepareStatement(str);
				result=state.executeQuery();
				table.setModel(new MyTModel(result));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ���������� ����� ������� �� ��������� �� �����
		public void refreshComboAuthor() {
			
			idauthor=-1;
			comboAuthor.removeAllItems();
			comboSrchAuthor.removeAllItems();
			comboSrchAuthor.addItem("-");
			String sql="select id, author from authtable";
			String item="";
			
			try {
				state=conn.prepareStatement(sql);
				result=state.executeQuery();
				if(result.next()) {
					idauthor=Integer.parseInt(result.getObject(1).toString());
					
					do{
						item=result.getObject(2).toString();
						comboAuthor.addItem(item);
						comboSrchAuthor.addItem(item);
					}while(result.next());
					
				}
			} catch (SQLException e) {e.printStackTrace();}
			
		}
        
		// ���������� ����� ������� �� ��������� �� �����������
		public void refreshComboPublisher() {
			
			idpub=-1;

			comboPublisher.removeAllItems();
			
			String sql="select id, publisher from pubtable";
			//conn=DBConnection.getConnection();
			String item="";
			
			try {
				state=conn.prepareStatement(sql);
				result=state.executeQuery();
				if(result.next()) {
					idpub = Integer.parseInt(result.getObject(1).toString());
					do {
						item=result.getObject(2).toString();
						comboPublisher.addItem(item);
					}while(result.next());
				}
			} catch (SQLException e) {e.printStackTrace();}
		}
		
		public void refreshComboGenre() {
			
			idgenre=-1;

			comboGenre.removeAllItems();
			
			String sql="select id, genre from genretable";
			//conn=DBConnection.getConnection();
			String item="";
			
			try {
				state=conn.prepareStatement(sql);
				result=state.executeQuery();
				if(result.next()) {
					idgenre=Integer.parseInt(result.getObject(1).toString());
					do {
						item=result.getObject(2).toString();
						comboGenre.addItem(item);
					}while(result.next());
				}
			} catch (SQLException e) {e.printStackTrace();}
		}
		
		// �������� ������ "��������" �� ������� �����
 		class AddBookDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {
				if(!bookNameTF.getText().isEmpty()) {
					String sql="insert into booktable(name, idauthor, idpublisher, descr, quant, price, datein, yearr, idgenre) values(?,?,?,?,?,?,CURDATE(),?,?)";
					try {
						
						state=conn.prepareStatement(sql);
						state.setString(1, bookNameTF.getText());
						state.setInt(2, idauthor);
						state.setInt(3, idpub);
						state.setString(4, bookDescrTF.getText());
						
						state.setInt(5, Integer.parseInt(bookQuantityTF.getText()));
						state.setDouble(6, Double.parseDouble(bookPriceTF.getText()));
						state.setInt(7, Integer.parseInt(bookYearTF.getText()));
						
						state.setInt(8, idgenre);
						state.execute();
						refreshBookTable();
						
					} catch (SQLException e1) {e1.printStackTrace();}
				
					bookNameTF.setText("");
					bookDescrTF.setText("");
					bookYearTF.setText("");
					bookDescrTF.setText("");
					bookPriceTF.setText("");
					id=-1;
				}
			}
		}
		// �������� ������ "���������" �� ������� �����
		class DelBookDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {
//				conn=DBConnection.getConnection();
				if (id>0) {
					String sql="delete from booktable where id=?";
					try {
						state=conn.prepareStatement(sql);
						state.setInt(1, id);
						state.execute();
						refreshBookTable();
					
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					bookNameTF.setText("");
					bookDescrTF.setText("");
					bookYearTF.setText("");
					id=-1;
				}
			}
		}
		// �������� ������ "�������" �� ������� �����
		class EditBookDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {
//				conn=DBConnection.getConnection();
				if(id>0) {
					String sql="update booktable set name=?, idauthor=?, idpublisher=?, descr=?, quant=?, price=?, yearr=?, idgenre=? where id=?";
				
					try {
						state=conn.prepareStatement(sql);
						
						state.setString(1, bookNameTF.getText());
						state.setInt(2, idauthor);
						state.setInt(3, idpub);
						state.setString(4, bookDescrTF.getText());
						state.setInt(5, Integer.parseInt(bookQuantityTF.getText()));
						state.setDouble(6, Double.parseDouble(bookPriceTF.getText()));
						state.setInt(7, Integer.parseInt(bookYearTF.getText()));
						state.setInt(8, id);
						state.setInt(9, idgenre);
						state.execute();
						
						refreshBookTable();
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					bookNameTF.setText("");
					bookDescrTF.setText("");
					bookYearTF.setText("");
				}
				
			}
		}
		// �������� ������ "��������" �� �����
		class AddAuthorDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {
				if(!authorNameTF.getText().isEmpty()) {
					String sql="insert into authtable(author) values(?)";
					try {
						state=conn.prepareStatement(sql);
						state.setString(1, authorNameTF.getText());
						state.execute();
						
						refreshAuthTable("AUTHTABLE", authorTable);
						refreshComboAuthor();
						authMessageL.setText("������� � �������!");
						authMessageL.setForeground(Color.blue);
					} catch (SQLException e1) {e1.printStackTrace();}
				
					authorNameTF.setText("");
				}
				else {
					authMessageL.setText("���� �������� �����!");
					authMessageL.setForeground(Color.red);
				}
			}
		}
		// �������� ������ "���������" �� �����
		class DelAuthorDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {
				if (idauthor>0) {
					String sql="delete from authtable where id=?";
					String checkIfBookExists = "select count(idauthor) from booktable where idauthor = "+idauthor;
					
					try {
						state=conn.prepareStatement(checkIfBookExists);
						result=state.executeQuery();
						result.next();
						int count = Integer.parseInt(result.getObject(1).toString());
						if(count>0) 
						{
							authMessageL.setText("���� ����� �� ���� �� ���� ������!");
							authMessageL.setForeground(Color.red);
							return;
						}
						
						state=conn.prepareStatement(sql);
						state.setInt(1, idauthor);
						state.execute();
						refreshAuthTable("AUTHTABLE", authorTable);
						refreshComboAuthor();
						authMessageL.setText("������� � ������!");
						authMessageL.setForeground(Color.blue);
						
					
					} catch (SQLException e2) {e2.printStackTrace();}
					authorNameTF.setText("");
				
				}
			}
		}
		// �������� ������ "�������" �� �����
		class EditAuthorDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {
				if(idauthor>0) {
					String sql="update authtable set author=? where id=?";
				
					try {
						state=conn.prepareStatement(sql);
						state.setString(1, authorNameTF.getText());
						state.setInt(2, idauthor);
						state.execute();
						refreshAuthTable("AUTHTABLE", authorTable);
						refreshComboAuthor();
						authMessageL.setText("������� � ��������!");
						authMessageL.setForeground(Color.blue);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					authorNameTF.setText("");
				}
				
			}
		}
		// �������� ������ "��������" �� �����������
		class AddPublisherDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {
				if(!pubNameTF.getText().isEmpty()) {
					String sql="insert into pubtable(publisher) Values(?)";
					try {
						state=conn.prepareStatement(sql);
						state.setString(1, pubNameTF.getText());
						state.execute();
						refreshPubTable("PUBTABLE", pubTable);
						refreshComboPublisher();
					} catch (SQLException e1) {e1.printStackTrace();}
					pubMessageL.setText("������������� � �������!");
					pubMessageL.setForeground(Color.blue);
					pubNameTF.setText("");
				}
				else {
					pubMessageL.setText("���� �������� �����������!");
					pubMessageL.setForeground(Color.red);
				}
			}
		}
		// �������� ������ "���������" �� �����������
		class DelPublisherDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {
				if (idpub>0) {
					String sql="delete from pubtable where id=?";
					String checkIfBookExists = "select count(idpublisher) from booktable where idpublisher = "+idpub;
					
					try {
						
						state=conn.prepareStatement(checkIfBookExists);
						result=state.executeQuery();
						result.next();
						int count = Integer.parseInt(result.getObject(1).toString());
						
						if(count>0) 
						{
							pubMessageL.setText("���� ����������� �� ���� �� ���� ������!");
							pubMessageL.setForeground(Color.red);
							return;
						}
						state=conn.prepareStatement(sql);
						state.setInt(1, idpub);
						state.execute();
						refreshPubTable("PUBTABLE", pubTable);
						refreshComboPublisher();
						
					
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					pubMessageL.setText("������������� � ������!");
					pubMessageL.setForeground(Color.blue);
					pubNameTF.setText("");
				}
			}
		}
		// �������� ������ "�������" �� �����������
		class EditPublisherDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {
				if(idpub>0) {
					String sql="update set publisher=? where id=?";
				
					try {
						state=conn.prepareStatement(sql);
						state.setString(1, pubNameTF.getText());
						state.setInt(2, idpub);
						state.execute();
						refreshPubTable("PUBTABLE", pubTable);
						refreshComboPublisher();
					
					} catch (SQLException e1) {e1.printStackTrace();}
					pubMessageL.setText("������������� � ��������!");
					pubMessageL.setForeground(Color.blue);
					pubNameTF.setText("");
				}
				
			}
		}

		class MouseActionBookTable implements MouseListener{

			// �������� ���������� ����� ��� �� ��������� � ���������� ������
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row=bookTable.getSelectedRow();
				
				// ��������� �� ���������� id �� ������� ����� 		
				id=Integer.parseInt(bookTable.getValueAt(row, 0).toString());
				
				bookNameTF.setText(bookTable.getValueAt(row, 1).toString());
				bookDescrTF.setText(bookTable.getValueAt(row, 6).toString());
				bookQuantityTF.setText(bookTable.getValueAt(row, 7).toString());
				bookPriceTF.setText(bookTable.getValueAt(row, 8).toString());
				bookYearTF.setText(bookTable.getValueAt(row, 10).toString());
				
				// ��������� �� ��������� ����� � ���������� �� �����
				comboAuthor.setSelectedItem(bookTable.getValueAt(row, 2).toString());
				
				// ��������� �� ���������� id �� �����
				idauthor=Integer.parseInt(bookTable.getValueAt(row, 3).toString());
				
				// ��������� �� ��������� ����� � ���������� �� �����������
				comboPublisher.setSelectedItem(bookTable.getValueAt(row, 4).toString());
				
				// ��������� �� ���������� id �� �����������
				idpub=Integer.parseInt(bookTable.getValueAt(row, 5).toString());
			
				// ��������� �� ��������� ����� � ���������� �� 
				comboGenre.setSelectedItem(bookTable.getValueAt(row, 11).toString());
				
				// ��������� �� ���������� id �� �����������
				idgenre=Integer.parseInt(bookTable.getValueAt(row, 12).toString());
				
				 
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
		}

		class MouseActionAuthorTable implements MouseListener{

			// �������� ���������� ����� ��� �� ��������� � �������������
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=authorTable.getSelectedRow();
				idauthor=Integer.parseInt(authorTable.getValueAt(row, 0).toString());
				authorNameTF.setText(authorTable.getValueAt(row, 1).toString());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
		}

		class MouseActionPubTable implements MouseListener{
			
			// �������� ���������� ����� ��� �� ��������� � ������
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=pubTable.getSelectedRow();
				idpub=Integer.parseInt(pubTable.getValueAt(row, 0).toString());
				pubNameTF.setText(pubTable.getValueAt(row, 1).toString());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		
		//���� �� ���������� �� ������ ������� �� ���������
		class SearchDB implements ActionListener {
			public void actionPerformed (ActionEvent arg0) {				
				
				String price = srchBookPriceTF.getText();
				String author = comboSrchAuthor.getSelectedItem().toString();
				String query = "select booktable.id, name, authtable.author,booktable.idauthor, pubtable.publisher,booktable.idpublisher, descr, quant,price,datein,yearr,genretable.genre,booktable.idgenre from booktable,pubtable,authtable,genretable where booktable.idpublisher=pubtable.id and booktable.idauthor=authtable.id and booktable.idgenre=genretable.id";
				// ��������� � ��������, ������ ��� ������ �������� ���� � ��� ������ �����
				if(price.isEmpty() && author == "-") {
					srchMessageL.setText("���� �������� ����/�����!");
					srchMessageL.setForeground(Color.red);
					return;
				}
				// ��������� �� ������ �������� ���� � ������ �����
				else if(price.isEmpty() && author != "-") {
					srchMessageL.setText("��� �������� "+author);
					srchMessageL.setForeground(Color.blue);
					query+= " and authtable.author='"+ author+"'";	
				}
				// ��������� �� �������� �������� ����
				else if(!price.isEmpty()) {
					//��������� ���� �� �����
					try
					{
					  Double.parseDouble(price);
					}
					catch(NumberFormatException e)
					{
						srchMessageL.setText("���� �������� ���� ����� � ������ �� ���������� ����!");
						srchMessageL.setForeground(Color.red);
						return;
					}
					
					
					// ��������� �� ����� ��-������ �� 0 
					if(Double.parseDouble(price)>0 ) {
						String message = "��������� ���������� ���� "+price;
						query+= " and booktable.price<="+Double.parseDouble(price);
						// ��������� �� �����
						if(author != "-") {
							message += " � �������� "+author;
							query+= " and authtable.author='"+ author+"'";
						}
						srchMessageL.setText(message);
						srchMessageL.setForeground(Color.blue);
					}
					// ��������, ��� � ���������� ����� ��-����� ��� ����� �� 0
					else {
						srchMessageL.setText("���� �������� ����� ��-������ �� 0!");
						srchMessageL.setForeground(Color.red);
						return;
					}
						
				}
				
 				    
 				    
					try {
						state=conn.prepareStatement(query);
						result=state.executeQuery();
						srchTable.setModel(new MyTModel(result));
				
						srchTable.getColumnModel().getColumn(3).setMinWidth(0);
						srchTable.getColumnModel().getColumn(3).setMaxWidth(0);
						srchTable.getColumnModel().getColumn(3).setWidth(0);

						srchTable.getColumnModel().getColumn(5).setMinWidth(0);
						srchTable.getColumnModel().getColumn(5).setMaxWidth(0);
						srchTable.getColumnModel().getColumn(5).setWidth(0);
						
						srchTable.getColumnModel().getColumn(12).setMinWidth(0);
						srchTable.getColumnModel().getColumn(12).setMaxWidth(0);
						srchTable.getColumnModel().getColumn(12).setWidth(0);
						
			
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					srchBookPriceTF.setText("");
					comboSrchAuthor.setSelectedItem("-");
					}
				
			}

		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


