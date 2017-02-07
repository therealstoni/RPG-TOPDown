import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*-----------------------------------------------------------------------------
*              Hoehere Technische Bundeslehranstalt STEYR
*           Fachrichtung Elektronik und Technische Informatik
*----------------------------------------------------------------------------*/
/**
* Kurzbeschreibung
*  
* @author  : Michael Steinwendtner
* @date    : $LastChangedDate$
*
* @details
*   Detailbeschreibung 
*	
*
*
*/
 
/**
* \addtogroup modulname
* @{
*/

public class Temperatur {
	
	float temp_cel;
	float temp_fah;
	
	public Temperatur(int value) {
		temp_cel = value;
	}
	
	float GetTemp_cel(){
		return temp_cel;
	}
	float GetTemp_fah(){
		return temp_fah;
	}
	void SetTemp_cel(int value){
		this.temp_cel = value;
	}
	void SetTemp_fah(int value){
		this.temp_fah = value;
	}
	
	float convertcel_fah(){
		float value = 0;
		
		value = (float) (temp_cel * 1.8 + 32);
		
		temp_fah = value;
		return value;
	}
	float convertfah_cel(){
		float value = 0;
		
		value = (float) ((temp_fah - 32)/1.8);
		temp_cel = value;
		
		return value;
	}
	
}
class Temperatur_View extends JFrame{

	float temp_value = 0;

	JPanel temp_auswahl = new JPanel();
	JLabel temp;
	JRadioButton btcel = new JRadioButton("∞C");
	JRadioButton btfah = new JRadioButton("∞F");
	JButton btloadf = new JButton("Read from File");
	JButton btloadurl = new JButton("Read from URL");
	ButtonGroup group = new ButtonGroup();
	
	public Temperatur_View(ActionListener al,float cel) {
		this.setLayout(new GridLayout(5, 1));
		temp_auswahl.setLayout(new GridLayout(1, 2));
		
		this.temp_value = cel;
		temp = new JLabel(Float.toString(temp_value));
		
		btcel.setSelected(true);
		group.add(btcel);
		group.add(btfah);
		
		temp_auswahl.add(btcel);
		temp_auswahl.add(btfah);
		
		this.add(temp_auswahl);
		this.add(temp);
		this.add(btloadf);
		this.add(btloadurl);
		
		btcel.addActionListener(al);
		btfah.addActionListener(al);
		
		this.setVisible(true);
		this.setSize(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//damit sich das Program beendet wenn ich das Fenster schlieﬂen
	}
	public void setTemp_anz(String strval,float cel){
		
		temp_value = cel;
		temp.setText(strval);
		this.repaint();
	}
	
	
	
	void Temperatur_ausgabe(int cel,int fah){
		System.out.println(cel);
		System.out.println(fah);
	}
	
}

class Temperatur_Controller implements ActionListener{
	Temperatur_Model mod;
	Temperatur_View view;
	boolean datatype = false;
	
	public Temperatur_Controller() {
		 mod = new Temperatur_Model();
		 view = new Temperatur_View(this,mod.cel);
		
		
		//view.Temperatur_ausgabe(mod.cel, mod.fah);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub7
		if(datatype){
			view.setTemp_anz(Float.toString(mod.cel)+"∞C",mod.cel);
			datatype = !datatype;
		}else{
			view.setTemp_anz(Float.toString(mod.fah)+"∞F",mod.fah);
			datatype = !datatype;
		}
		
//		if(arg0.getSource().toString().compareTo("∞C")==0){
//			
//			view.setTemp_anz(Integer.toString(mod.cel)+"∞C",mod.cel);
//			
//		}else if(arg0.getSource().toString().compareTo("∞F")==0){
//			
//			view.setTemp_anz(Integer.toString(mod.fah)+"∞F",mod.fah);
//			
//		}
	}
}
class Temperatur_Model{
	
	float cel;
	float fah;
	
	public Temperatur_Model() {
		Temperatur temp;
		Random zufall = new Random();
		
		temp = new Temperatur(zufall.nextInt(100));
		
		temp.convertcel_fah();
		
		cel = temp.GetTemp_cel();
		fah = temp.GetTemp_fah();
		
//		System.out.println(temp.GetTemp_cel());
//		System.out.println(temp.GetTemp_fah());
	}
	
	public float readdata(){
		
		
		
		return 0;
	}
	
}


