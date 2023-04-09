package Functions;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Server.connection;
import Server.viewcompform;
import Server.student;




public class filter {
	
	student std= new student();
	DefaultTableModel model = new DefaultTableModel();
	
  TableRowSorter<DefaultTableModel> tr=new TableRowSorter <DefaultTableModel> (model);
  
  JTable table = new JTable(model);
  
  
//  table.setRowSorter(tr);
  

  
  
}
