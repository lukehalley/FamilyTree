package utils;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class Main extends JPanel {

	JList<String> list;

	DefaultListModel<String> model;

	public Main() {
		setLayout(new BorderLayout());

		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		JScrollPane pane = new JScrollPane(list);

		for (String key : Import.FamilyMap.keySet()) {
			model.addElement(key);
		}

		JTextArea personDetails = new JTextArea();
		personDetails.setText("Please select a person from the list on the left to view their family tree");

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					personDetails.setText(Import.FamilyMap.get(list.getSelectedValue()).toString());
				}
			}

		});

		add(pane, BorderLayout.WEST);
		add(personDetails, BorderLayout.CENTER);
	}

	public static void main(String s[]) {
		Import.InitialImport();
		Import.LinkParents();
		JFrame UI = new JFrame("Family Tree");
		UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI.setContentPane(new Main());
		UI.setSize(1000, 1000);
		UI.setVisible(true);
	}

}