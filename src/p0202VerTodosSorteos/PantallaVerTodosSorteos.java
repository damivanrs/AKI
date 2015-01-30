package p0202VerTodosSorteos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utiles.AKIPanel;
import utiles.BordeRedondeado;
import marco.ControladorMarco;

public class PantallaVerTodosSorteos extends utiles.PanelPantalla implements MouseListener {
	private ControladorVerTodosSorteos c;
	private int altomini=200;
	private JPanel panelSorteo1 = new JPanel();

	public PantallaVerTodosSorteos(ControladorMarco controladorMarco) {
		super(controladorMarco);
		// TODO Auto-generated constructor stub
		bSalir = "Volver Atras";
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();
			sms2="Todos los Sorteos";
		}else{
			sms1="Pantalla";
			sms2="Todos los Sorteos";
		}
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(new BordeRedondeado(new Color(0xBB00BB),1,5, new Color(0xffffff)));
		scroll.setBackground(Color.white);
		scroll.setBounds(0, 0, 390, 455);
		
		add(scroll);
		
		JPanel panelTodosSorteos = new JPanel();
		panelTodosSorteos.setBackground(Color.white);
		scroll.setViewportView(panelTodosSorteos);
		panelTodosSorteos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelTodosSorteos.add(panelSorteo1);
		panelSorteo1.setPreferredSize(new Dimension(((scroll.getWidth()-25)/2)-10, altomini));
		
		JPanel panelSorteo2 = new JPanel();
		panelTodosSorteos.add(panelSorteo2);
		panelSorteo2.setPreferredSize(new Dimension(((scroll.getWidth()-25)/2)-10, altomini));
		
		JPanel panelSorteo3 = new JPanel();
		panelTodosSorteos.add(panelSorteo3);
		panelSorteo3.setPreferredSize(new Dimension(((scroll.getWidth()-25)/2)-10, altomini));
		
		JPanel panelSorteo4 = new JPanel();
		panelTodosSorteos.add(panelSorteo4);
		panelSorteo4.setPreferredSize(new Dimension(((scroll.getWidth()-25)/2)-10, altomini));
		
		JPanel panelSorteo5 = new JPanel();
		panelTodosSorteos.add(panelSorteo5);
		panelSorteo5.setPreferredSize(new Dimension(((scroll.getWidth()-25)/2)-10, altomini));
		
		JPanel panelSorteo6 = new JPanel();
		panelTodosSorteos.add(panelSorteo6);
		panelSorteo6.setPreferredSize(new Dimension(((scroll.getWidth()-25)/2)-10, altomini));
		
		int i = panelTodosSorteos.getComponentCount();
		//panelTodosSorteos.setPreferredSize(new Dimension(scroll.getWidth()-25, scroll.getHeight()*2));
		panelTodosSorteos.setPreferredSize(new Dimension(scroll.getWidth()-30, altomini*((i+1)/2)));
		this.getMarco().reload();
		
		panelSorteo1.addMouseListener(this);
		
		c=new ControladorVerTodosSorteos(this);
		
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(panelSorteo1)){
			c.unirmeASorteo();
		}	
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
