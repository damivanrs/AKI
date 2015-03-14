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
	//private AKIPanel panel;
	private JPanelFondo panelSS= new JPanelFondo("MenuSorteoSolicitarSorteo.png");
	private JPanelFondo panelVS= new JPanelFondo("MenuSorteoVerSorteo.png");
	private JPanelFondo panelMS= new JPanelFondo("MenuSorteoMisSorteos.png");
	private JPanelFondo panelA= new JPanelFondo("MenuSorteoAyuda.png");
	protected JLabel lSS = new JLabel("Solicitar Sorteo");
	protected JLabel lVS = new JLabel("Ver Sorteos");
	protected JLabel lMS = new JLabel("Mis Sorteos");
	protected JLabel lA = new JLabel("Ayuda");
	protected AKIPanel pSS = new AKIPanel();
	protected AKIPanel pVS = new AKIPanel();
	protected AKIPanel pMS = new AKIPanel();
	protected AKIPanel pA = new AKIPanel();
	

	public PantallaMenuSorteos(ControladorMarco controladorMarco) {
		super(controladorMarco);
		bSalir="Volver Atras";
		/*
		 * panel= new AKIPanel();
		panel.setBounds(0, 0, this.getWidth()+3, this.getHeight()+3);
		panel.setLayout(null);
		this.add(panel);
		 */
		
		pSS.setBounds(10, 25, this.getWidth()-15, 100);
		pSS.setLayout(null);
		this.add(pSS);
		
		pVS.setBounds(10, 130, this.getWidth()-15, 100);
		pVS.setLayout(null);
		this.add(pVS);
		
		pMS.setBounds(10, 235, this.getWidth()-15, 100);
		pMS.setLayout(null);
		this.add(pMS);
		
		pA.setBounds(10, 340, this.getWidth()-15, 100);
		pA.setLayout(null);
		this.add(pA);
		
		
		if(this.getMarco().isConectado()){
			sms1=this.getMarco().getUsuario();
			sms2="Sorteos";
		}else{
			sms1="Menu";
			sms2="Sorteos";
		}
		
		// TODO Auto-generated constructor stub
		
		panelSS.setBounds(35, 12, 80, 80);
		//this.add(panelSS);
		//panel.add(panelSS);
		pSS.add(panelSS);
		panelVS.setBounds(35, 12, 80, 80);
		//this.add(panelVS);
		//panel.add(panelVS);
		pVS.add(panelVS);
		panelMS.setBounds(35, 12, 80, 80);
		//this.add(panelMS);
		//panel.add(panelMS);
		pMS.add(panelMS);
		panelA.setBounds(35, 12, 80, 80);
		//this.add(panelA);
		//panel.add(panelA);
		pA.add(panelA);
		
		
		lSS.setForeground(new Color(0xBB00BB));
		lSS.setFont(new Font("Gabrielle", Font.BOLD, 26));
		lSS.setBounds(175, 30, 150, 41);
		//panel.add(lSS);
		pSS.add(lSS);
		lSS.setOpaque(false);
		
		
		lVS.setForeground(new Color(0xBB00BB));
		lVS.setFont(new Font("Gabrielle", Font.BOLD, 26));
		lVS.setBounds(175, 30, 150, 41);
		//panel.add(lVS);
		pVS.add(lVS);
		lVS.setOpaque(false);
		
		
		lMS.setForeground(new Color(0xBB00BB));
		lMS.setFont(new Font("Gabrielle", Font.BOLD, 26));
		lMS.setBounds(175, 30, 177, 41);
		//panel.add(lMS);
		pMS.add(lMS);
		lMS.setOpaque(false);
		
		lA.setForeground(new Color(0xBB00BB));
		lA.setFont(new Font("Gabrielle", Font.BOLD, 26));
		lA.setBounds(175, 30, 176, 41);
		//panel.add(lA);
		pA.add(lA);
		lA.setOpaque(false);
		
		/*
		 * panelSS.addMouseListener(this);
		panelVS.addMouseListener(this);
		panelMS.addMouseListener(this);
		panelA.addMouseListener(this);
		
		lSS.addMouseListener(this);
		lVS.addMouseListener(this);
		lMS.addMouseListener(this);
		lA.addMouseListener(this);
		 * */
		pSS.addMouseListener(this);
		pVS.addMouseListener(this);
		pMS.addMouseListener(this);
		pA.addMouseListener(this);
				
		c = new ControladorMenuSorteos(this);
	}
	
	protected void empaquetar(){
		this.setPreferredSize(new Dimension(PanelPantalla.anchoGrande, PanelPantalla.altoMax));
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(panelSS)||arg0.getSource().equals(lSS)||arg0.getSource().equals(pSS)){
			c.solicitarSorteo();			
		}else if(arg0.getSource().equals(panelVS)||arg0.getSource().equals(lVS)||arg0.getSource().equals(pVS)){
			c.verSorteos();			
		}else if(arg0.getSource().equals(panelMS)||arg0.getSource().equals(lMS)||arg0.getSource().equals(pMS)){
			c.misSorteos();			
		}else if(arg0.getSource().equals(panelA)||arg0.getSource().equals(lA)||arg0.getSource().equals(pA)){
			c.ayuda();
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(pSS)){
			c.sobreSolicitarSorteo();
		}else if(arg0.getSource().equals(pVS)){
			c.sobreVerSorteo();
		}else if(arg0.getSource().equals(pMS)){
			c.sobreMisSorteos();
		}else if(arg0.getSource().equals(pA)){
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
