package p02MenuSorteos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import marco.ControladorMarco;
import utiles.AKIPanel;
import utiles.JPanelFondo;
import utiles.PanelPantalla;

public class PantallaMenuSorteos extends PanelPantalla implements MouseListener{
	private ControladorMenuSorteos c;
	private AKIPanel panel;
	private JPanelFondo panelSS= new JPanelFondo("MenuSorteoSolicitarSorteo.png");
	private JPanelFondo panelVS= new JPanelFondo("MenuSorteoVerSorteo.png");
	private JPanelFondo panelMS= new JPanelFondo("MenuSorteoMisSorteos.png");
	private JPanelFondo panelA= new JPanelFondo("MenuSorteoAyuda.png");
	protected JLabel lSS = new JLabel("Solicitar Sorteo");
	protected JLabel lVS = new JLabel("Ver Sorteos");
	protected JLabel lMS = new JLabel("Mis Sorteos");
	protected JLabel lA = new JLabel("Ayuda");

	public PantallaMenuSorteos(ControladorMarco controladorMarco) {
		super(controladorMarco);
		bSalir="Volver Atras";
		panel= new AKIPanel();
		panel.setBounds(0, 0, this.getWidth()+3, this.getHeight()+3);
		panel.setLayout(null);
		this.add(panel);
		
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();
			sms2="Sorteos";
		}else{
			sms1="Menu";
			sms2="Sorteos";
		}
		
		// TODO Auto-generated constructor stub
		
		panelSS.setBounds(45, 10, 100, 100);
		//this.add(panelSS);
		panel.add(panelSS);
		panelVS.setBounds(45, 115, 100, 100);
		//this.add(panelVS);
		panel.add(panelVS);
		panelMS.setBounds(45, 220, 100, 100);
		//this.add(panelMS);
		panel.add(panelMS);
		panelA.setBounds(45, 325, 100, 100);
		//this.add(panelA);
		panel.add(panelA);
		
		
		lSS.setForeground(new Color(0xBB00BB));
		lSS.setFont(new Font("Gabrielle", Font.BOLD, 26));
		lSS.setBounds(175, 40, 150, 41);
		panel.add(lSS);
		lSS.setOpaque(true);
		
		
		lVS.setForeground(new Color(0xBB00BB));
		lVS.setFont(new Font("Gabrielle", Font.BOLD, 26));
		lVS.setBounds(175, 145, 210, 41);
		panel.add(lVS);
		lVS.setOpaque(true);
		
		
		lMS.setForeground(new Color(0xBB00BB));
		lMS.setFont(new Font("Gabrielle", Font.BOLD, 26));
		lMS.setBounds(175, 250, 177, 41);
		panel.add(lMS);
		lMS.setOpaque(true);
		
		lA.setForeground(new Color(0xBB00BB));
		lA.setFont(new Font("Gabrielle", Font.BOLD, 26));
		lA.setBounds(175, 355, 176, 41);
		panel.add(lA);
		lA.setOpaque(true);
		
		panelSS.addMouseListener(this);
		panelVS.addMouseListener(this);
		panelMS.addMouseListener(this);
		panelA.addMouseListener(this);
		
		lSS.addMouseListener(this);
		lVS.addMouseListener(this);
		lMS.addMouseListener(this);
		lA.addMouseListener(this);
				
		c = new ControladorMenuSorteos(this);
	}
	
	protected void empaquetar(){
		this.setPreferredSize(new Dimension(PanelPantalla.anchoGrande, PanelPantalla.altoMax));
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(panelSS)||arg0.getSource().equals(lSS)){
			c.solicitarSorteo();			
		}else if(arg0.getSource().equals(panelVS)||arg0.getSource().equals(lVS)){
			c.verSorteos();			
		}else if(arg0.getSource().equals(panelMS)||arg0.getSource().equals(lMS)){
			c.misSorteos();			
		}else if(arg0.getSource().equals(panelA)||arg0.getSource().equals(lA)){
			c.ayuda();
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(panelSS)||arg0.getSource().equals(lSS)){
			c.sobreSolicitarSorteo();
		}else if(arg0.getSource().equals(panelVS)||arg0.getSource().equals(lVS)){
			c.sobreVerSorteo();
		}else if(arg0.getSource().equals(panelMS)||arg0.getSource().equals(lMS)){
			c.sobreMisSorteos();
		}else if(arg0.getSource().equals(panelA)||arg0.getSource().equals(lA)){
			c.sobreAyuda();
		}
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		c.relax();
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
