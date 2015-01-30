package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import marco.ControladorMarco;
import utiles.AKIPanel;
import utiles.PanelPantalla;

public class PantallaPrincipal extends PanelPantalla implements MouseListener{
	
	private ControladorPrincipal c;
	private AKIPanel panel;
	private ImagenBailona imgUsuario;
	private ImagenBailona imgSorteos;
	private ImagenBailona imgAyuda;
	protected JLabel lPerfil;
	protected JLabel lSorteos;
	protected JLabel lAyuda;
	
	public PantallaPrincipal(ControladorMarco controladorMarco) {
		super(controladorMarco);
		bSalir = "Salir";
		panel= new AKIPanel();
		panel.setBounds(0, 0, this.getWidth()+3, this.getHeight()+3);
		panel.setLayout(null);
		this.add(panel);
		if(this.getMarco().isConectado()){
			sms1 = this.getMarco().getUsuario();
			sms2 = "Principal";
		}else{
			sms1 = "Menu";
			sms2 = "Principal";
		}
		
		imgUsuario = new ImagenBailona("MenuPrincipalUsuarioTienda.png", 50, 50, 100, 100, this);
		panel.add(imgUsuario);
		imgSorteos = new ImagenBailona("MenuPrincipalSorteo.png", 50, 180, 100, 100, this);
		panel.add(imgSorteos);
		imgAyuda = new ImagenBailona("MenuPrincipalAyuda.png", 50, 310, 100, 100, this);
		panel.add(imgAyuda);
		
		new Thread(){
			
			public void run(){
				
				try {
					Thread.sleep(ImagenBailona.milisegundosPorMovimiento*ImagenBailona.movimientos);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lPerfil.setVisible(true);
				lSorteos.setVisible(true);
				lAyuda.setVisible(true);
			}
		}.start();
		
		lPerfil = new JLabel("Perfil");
		lPerfil.setForeground(new Color(0xBB00BB));
		lPerfil.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lPerfil.setBounds(170, 80, 150, 41);
		panel.add(lPerfil);
		lPerfil.setOpaque(true);
		lPerfil.setVisible(false);
		
		lSorteos = new JLabel("Sorteos");
		lSorteos.setForeground(new Color(0xBB00BB));
		lSorteos.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lSorteos.setBounds(170, 210, 210, 41);
		panel.add(lSorteos);
		lSorteos.setOpaque(true);
		lSorteos.setVisible(false);
		
		lAyuda = new JLabel("Ayuda");
		lAyuda.setForeground(new Color(0xBB00BB));
		lAyuda.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lAyuda.setBounds(170, 340, 177, 41);
		panel.add(lAyuda);
		lAyuda.setOpaque(true);
		lAyuda.setVisible(false);		
		
		imgUsuario.addMouseListener(this);
		imgSorteos.addMouseListener(this);
		imgAyuda.addMouseListener(this);
		
		lPerfil.addMouseListener(this);
		lSorteos.addMouseListener(this);
		lAyuda.addMouseListener(this);
		
		c = new ControladorPrincipal(this);
		
	}
	
	protected void empaquetar(){
		this.setPreferredSize(new Dimension(PanelPantalla.anchoGrande, PanelPantalla.altoMax));
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(imgUsuario) || e.getSource().equals(lPerfil)){
			c.miPerfil();
		} else if (e.getSource().equals(imgSorteos) || e.getSource().equals(lSorteos)){
			c.buscarSorteos();
		} else if (e.getSource().equals(imgAyuda) || e.getSource().equals(lAyuda)){
			c.ayuda();
		}		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(imgUsuario) || e.getSource().equals(lPerfil)){
			c.sobreMiPerfil();
		} else if (e.getSource().equals(imgSorteos) || e.getSource().equals(lSorteos)){
			c.sobreBuscarSorteos();
		} else if (e.getSource().equals(imgAyuda) || e.getSource().equals(lAyuda)){
			c.sobreMisSorteos();
		}
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		c.relax();
	};
	
}
