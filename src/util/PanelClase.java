package util;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;

import mensajesError.HerenciaError;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;

import Interfaz.EditarClase;
import Interfaz.EliminarClase;
import Interfaz.Principal;

import java.awt.Font;
import java.awt.SystemColor;

public class PanelClase extends JPanel {
	private static final long serialVersionUID = 1L;

	int mouseX;
	int mouseY;
	private transient Principal pe;
	private Point top, bottom, left, right;
	private PanelClase claseSeleccionada;
	private JLabel lblNombreclase;
	private JPanel panelNombreClase;
	private JPanel panelAtributos;
	private JPanel panelMetodos;
	private JLabel labelSeleccionado;
	private Point flechaFinal;
	private boolean mover;


	/**
	 * Create the panel.
	 */



	public PanelClase(Principal p) {
		mover = true;
		
		setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		

		pe=p;
		setBackground(SystemColor.control);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		panelNombreClase = new JPanel();
		panelNombreClase.setBackground(SystemColor.textHighlightText);
		panelNombreClase.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelNombreClase, BorderLayout.NORTH);
		panelNombreClase.setLayout(new BorderLayout(0, 0));

		lblNombreclase = new JLabel("");
		lblNombreclase.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));


		
		lblNombreclase.setHorizontalAlignment(SwingConstants.CENTER);
		panelNombreClase.add(lblNombreclase);

		panelAtributos = new JPanel();
		panelAtributos.setBackground(SystemColor.control);
		panelAtributos.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelAtributos, BorderLayout.CENTER);
		panelAtributos.setLayout(new BoxLayout(panelAtributos, BoxLayout.Y_AXIS));

		panelMetodos = new JPanel();
		panelMetodos.setBackground(SystemColor.control);
		panelMetodos.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelMetodos, BorderLayout.SOUTH);
		panelMetodos.setLayout(new BoxLayout(panelMetodos, BoxLayout.Y_AXIS));
		
		accionesPanelClase();


	}
	public boolean isMover() {
		return mover;
	}
	public void setMover(boolean mover) {
		this.mover = mover;
	}
	public Principal getPe() {
		return pe;
	}
	public void setPe(Principal pe) {
		this.pe = pe;
	}


	public PanelClase getClaseSeleccionada() {
		return claseSeleccionada;
	}
	public void setClaseSeleccionada(PanelClase panelEliminar) {
		this.claseSeleccionada = panelEliminar;
	}
	public void setLblNombreclase(JLabel lblNombreclase) {
		this.lblNombreclase = lblNombreclase;
	}
	public JLabel getLblNombreclase() {
		return lblNombreclase;
	}
	public JPanel getPanel() {
		return panelNombreClase;
	}
	public void setPanel(JPanel panel) {
		this.panelNombreClase = panel;
	}
	public JPanel getPanelNombreClase() {
		return panelNombreClase;
	}
	public JPanel getPanelAtributos() {
		return panelAtributos;
	}
	public JPanel getPanelMetodos() {
		return panelMetodos;
	}
	public JLabel getLabelSeleccionado() {
		return labelSeleccionado;
	}
	public void setLabelSeleccionado(JLabel labelSeleccionado) {
		this.labelSeleccionado = labelSeleccionado;
	}

	public void setMidPoint(){
		top = new Point(this.getLocation().x + ((this.getPreferredSize().width+50) / 2), this.getLocation().y);
		bottom = new Point(this.getLocation().x + ((this.getPreferredSize().width+50) / 2), this.getLocation().y + this.getPreferredSize().height+50);
		left = new Point(this.getLocation().x , this.getLocation().y + ((this.getPreferredSize().height+50)/2));
		right = new Point(this.getLocation().x  + this.getPreferredSize().width+50, this.getLocation().y + ((this.getPreferredSize().height+50)/2));
	}

	private void flechaHerencia(PanelClase c1, PanelClase c2){
		
		if(c1.getLocation().y > c2.getLocation().y + c2.getPreferredSize().height+50){
			System.out.println("Clase dos esta mas arriba de la clase 1");
			pe.setFlechaInicio(c1.top);
			c2.flechaFinal = c2.bottom;
		}
		else if (c1.getLocation().y + c1.getPreferredSize().height+50 < c2.getLocation().y){
			System.out.println("Clase dos esta mas abajo de la clase 1");
			pe.setFlechaInicio(c1.bottom);
			c2.flechaFinal = c2.top;
		}
		else{
			if(c1.getLocation().x < c2.getLocation().x){
				System.out.println("Clase dos esta a la derecha de la clase 1");
				pe.setFlechaInicio(c1.right);
				c2.flechaFinal = c2.left;
			}
			else{
				System.out.println("Clase dos esta a la izquierda de la clase 1");
				pe.setFlechaInicio(c1.left);
				c2.flechaFinal = c2.right;	
			}

		}

	}
	
	public void accionesPanelClase(){
		setComponentPopupMenu(new MenuContextual(PanelClase.this));
		accionesLabels();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mover = true;
				pe.getPanelHerramDesp().setVisible(false);
				pe.getPanelArchivoDesp().setVisible(false);
				claseSeleccionada = (PanelClase) e.getComponent();
				if(pe.isEliminar()){					
					EliminarClase eli = new EliminarClase(PanelClase.this);
					eli.setVisible(true);
					pe.setEnabled(false);
					pe.setEliminar(false);
					pe.setEliminarPressed(false);
				}
				else if (pe.isHerencia()){
					mover = false;
					if(pe.isHerenciaClase1()){
						boolean x = true;
						String clasePadre = pe.getClaseSeleccionada1().getLblNombreclase().getText();
						String claseHija = lblNombreclase.getText();
						
						try {
							pe.getDiagrama().addHerencia(clasePadre, claseHija);
						} catch (Exception e1) {
							HerenciaError her = new HerenciaError(PanelClase.this, e1.getMessage());
							her.setVisible(true);
							pe.setEnabled(false);	
							x = false;
							mover = false;
						}
						if(x){
						pe.setPadreFlecha(lblNombreclase.getText());
						flechaHerencia(pe.getClaseSeleccionada1(), PanelClase.this);
						pe.getLienzo().addHerencia(pe.getFlechaInicio(), flechaFinal, pe.getPadreFlecha(), pe.getHijoFlecha());
						pe.setRelacionesPressed(false);
						pe.getMenuLienzo().getMntmCancelar().setVisible(false);
						pe.getMenuLienzo().getMntmEstablecerRelacin().setVisible(true);
						pe.setHerencia(false);
						pe.setHerenciaClase1(false);
						pe.getLienzo().repaint();
						pe.getLienzo().revalidate();
						}
					}
					else{
						pe.setFlechaInicio(new Point(getLocation().x, getLocation().y));
						pe.setHijoFlecha(lblNombreclase.getText());
						pe.setHerenciaClase1(true);
						pe.setClaseSeleccionada1(PanelClase.this);
					}	
				}
				else if (pe.isEditar()){				
					EditarClase edi = new EditarClase(PanelClase.this);
					setMover(false);
					edi.setVisible(true);
					pe.setEnabled(false);
					pe.setEditar(false);
					pe.setEditarPressed(false);
				
				}
				else{
					mouseX = e.getX();
					mouseY = e.getY();
				}

			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(!pe.isEliminar() && mover){
					int x = e.getXOnScreen()-pe.getLienzo().getLocationOnScreen().x;
					int y = e.getYOnScreen()-pe.getLienzo().getLocationOnScreen().y;
					if((x - mouseX)>0&&(y-mouseY>0)&&(x - mouseX)<2000-getWidth()&&
							(y - mouseY)<2000-getHeight())
						setLocation(x - mouseX, y-mouseY);
					
					
					setMidPoint();
					pe.getLienzo().buscarRelacionesHerencia(lblNombreclase.getText(),new Point(getLocation().x,getLocation().y));
					
					
					pe.getLienzo().repaint();
					pe.getLienzo().revalidate();
				}
			}
		});
	}
	
	private void accionesLabels(){	
		lblNombreclase.setComponentPopupMenu(new MenuContextualClase(PanelClase.this));	
		
		for (int i = 0; i < panelAtributos.getComponentCount(); i++) {
			if(panelAtributos.getComponent(i) instanceof LabelAtributo)
				((LabelAtributo) panelAtributos.getComponent(i)).setComponentPopupMenu(new MenuContextualAtributo(PanelClase.this,((LabelAtributo) panelAtributos.getComponent(i))));
		}
		
		for (int i = 0; i < panelMetodos.getComponentCount(); i++) {
			if(panelMetodos.getComponent(i) instanceof LabelMetodo)
				((LabelMetodo) panelMetodos.getComponent(i)).setComponentPopupMenu(new MenuContextualMetodo(PanelClase.this, ((LabelMetodo) panelMetodos.getComponent(i))));
		}
	}
}
