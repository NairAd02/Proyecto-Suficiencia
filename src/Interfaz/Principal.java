package Interfaz;

import javax.swing.*;

import Clases.*;
import Logica.ManejoDirectorios;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.border.LineBorder;

import mensajesError.AlmenosDos;
import mensajesError.AlmenosUna;
import mensajesError.ClasesMismoName;
import util.MenuContextualLienzo;
import util.PanelClase;


public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane, panelLateral, subpanel1, subpanel2, subpanel3, subpanel4,
	panelSuperior, panelSalir,panelAyuda,panelAcerca,panelMenu,panelHerram,panelArchivo,
	panelHerramDesp,panelArchivoDesp,panelEstadísticas,panelChequear,panelZoom,panelNuevo,
	panelAbrir,panelGuardar;
	private JSeparator separator1, separator2, separator3,separator4,separator5,separator,
	separator_1,separator_2,separator_3,separator_4;
	private JLabel lblAddClase, lblAddClaseImg, lblAddRelacion, lblAddRelacionImg, lblEditarClase, lblEditarClaseImg,
	lblEliminarClase, lblEliminarClaseImg,lblSalir,labelAyuda,labelAyudaImg,lblArchivo,labelArchivoImg,
	lblHerramientas,lblHerramientasImg,labelAcerca,labelAcercaImg;
	private Lienzo lienzo;
	private Diagrama diagrama;
	private PanelClase panelClase;
	private JScrollPane scrollPane;
	private PantallaCompleta pant;
	private PanelInicio panelInicio;

	private boolean isHerenciaClase1;
	private boolean isHerenciaClase2;
	private boolean isEditar;
	private boolean isInsertar;
	private boolean isEliminar;
	private boolean isHerencia;
	private boolean isRelacionesPressed, isEditarPressed, isEliminarPressed;
	private boolean desplegadoArchivo = false;
	private boolean desplegadoHerram = false;

	private int mouseX;
	private int mouseY;
	private String nombreClase,radioBotonTipoClase;
	private JLabel labelNuevo;
	private JLabel labelAbrir;
	private JLabel lblGuardar;
	private JLabel labelEstadis;
	private JLabel labelChequear;
	private JLabel labelZoom;
	private Point flechaInicio;
	private String padreFlecha, hijoFlecha;
	private PanelClase claseSeleccionada1;
	private JPanel panelContenedor;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private MenuContextualLienzo menuLienzo;




	public PantallaCompleta getPant() {
		return pant;
	}


	public void setPant(PantallaCompleta pant) {
		this.pant = pant;
	}

	public PanelClase getClaseSeleccionada1() {
		return claseSeleccionada1;
	}


	public void setClaseSeleccionada1(PanelClase claseSeleccionada1) {
		this.claseSeleccionada1 = claseSeleccionada1;
	}


	public String getPadreFlecha() {
		return padreFlecha;
	}


	public void setPadreFlecha(String padreFlecha) {
		this.padreFlecha = padreFlecha;
	}


	public String getHijoFlecha() {
		return hijoFlecha;
	}


	public void setHijoFlecha(String hijoFlecha) {
		this.hijoFlecha = hijoFlecha;
	}


	public boolean isHerenciaClase1() {
		return isHerenciaClase1;
	}


	public boolean isHerenciaClase2() {
		return isHerenciaClase2;
	}



	public void setHerenciaClase2(boolean isHerenciaClase2) {
		this.isHerenciaClase2 = isHerenciaClase2;
	}



	public void setHerenciaClase1(boolean isHerenciaActivate) {
		this.isHerenciaClase1 = isHerenciaActivate;
	}


	public Point getFlechaInicio() {
		return flechaInicio;
	}


	public void setFlechaInicio(Point flechaInicio) {
		this.flechaInicio = flechaInicio;
	}


	public Lienzo getLienzo() {
		return lienzo;
	}



	public void setLienzo(Lienzo lienzo) {
		this.lienzo = lienzo;
	}



	public boolean isEditar() {
		return isEditar;
	}


	public void setEditar(boolean isEditar) {
		this.isEditar = isEditar;
	}


	public void setPanelClase(PanelClase panelClase) {
		this.panelClase = panelClase;
	}



	public String getRadioBotonTipoClase() {
		return radioBotonTipoClase;
	}



	public boolean isDesplegadoArchivo() {
		return desplegadoArchivo;
	}


	public void setDesplegadoArchivo(boolean desplegadoArchivo) {
		this.desplegadoArchivo = desplegadoArchivo;
	}


	public boolean isDesplegadoHerram() {
		return desplegadoHerram;
	}


	public void setDesplegadoHerram(boolean desplegadoHerram) {
		this.desplegadoHerram = desplegadoHerram;
	}


	public Diagrama getDiagrama() {
		return diagrama;
	}



	public void setDiagrama(Diagrama diagrama) {
		this.diagrama = diagrama;
	}



	public void setRadioBotonTipoClase(String radioBotonTiposClase) {
		this.radioBotonTipoClase = radioBotonTiposClase;
	}



	public String getNombreClase() {
		return nombreClase;
	}



	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}



	/**
	 * Create the frame.
	 */
	public Principal() {

		pant = new PantallaCompleta(Principal.this);
		pant.setVisible(false);
		panelInicio = new PanelInicio(Principal.this);
		panelInicio.setVisible(true);

		isInsertar=false;
		isEliminar=false;
		isHerencia=false;
		isHerenciaClase1=false;
		isHerenciaClase2=false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 700);
		setLocationRelativeTo(null);
		setUndecorated(true);


		scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {


			@Override
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				panelHerramDesp.setVisible(false);
				desplegadoHerram = false;
				panelArchivoDesp.setVisible(false);
				desplegadoArchivo = false;
				panelContenedor.repaint();
				panelContenedor.revalidate();

			}
		});

		scrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				panelHerramDesp.setVisible(false);
				desplegadoHerram = false;
				panelArchivoDesp.setVisible(false);
				desplegadoArchivo = false;
				panelContenedor.repaint();
				panelContenedor.revalidate();

			}
		});



		scrollPane.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				contentPane.repaint();
				contentPane.revalidate();


			}
		});
		scrollPane.setBounds(226, 100, 874, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 0, 1100, 700);
		contentPane.add(panelContenedor);
		panelContenedor.setLayout(null);


		panelHerramDesp = new JPanel();
		panelHerramDesp.setVisible(false);

		panelArchivoDesp = new JPanel();
		panelArchivoDesp.setVisible(false);
		panelArchivoDesp.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelArchivoDesp.setBackground(Color.WHITE);
		panelArchivoDesp.setBounds(226, 101, 220, 78);
		panelContenedor.add(panelArchivoDesp);
		panelArchivoDesp.setLayout(null);

		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(0, 25, 220, 1);
		panelArchivoDesp.add(separator_3);

		separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(0, 51, 220, 1);
		panelArchivoDesp.add(separator_4);

		panelNuevo = new JPanel();
		panelNuevo.setLayout(null);
		panelNuevo.setBackground(Color.WHITE);
		panelNuevo.setBounds(1, 0, 218, 25);
		panelNuevo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelNuevo.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelNuevo.setBackground(SystemColor.white);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				FrameNuevoDiagrama nuevoDiagrama = new FrameNuevoDiagrama(Principal.this);
				nuevoDiagrama.setVisible(true);
				setEnabled(false);
			}
		});
		panelArchivoDesp.add(panelNuevo);

		labelNuevo = new JLabel("Nuevo");
		labelNuevo.setFont(new Font("Dialog", Font.BOLD, 16));
		labelNuevo.setBounds(55, 1, 91, 22);
		panelNuevo.add(labelNuevo);

		panelAbrir = new JPanel();
		panelAbrir.setLayout(null);
		panelAbrir.setBackground(Color.WHITE);
		panelAbrir.setBounds(1, 26, 218, 25);
		panelAbrir.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelAbrir.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelAbrir.setBackground(SystemColor.white);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				DiagramasAbrir abrir = new DiagramasAbrir(Principal.this);
				abrir.setVisible(true);
				setEnabled(false);
			}
		});
		panelArchivoDesp.add(panelAbrir);

		labelAbrir = new JLabel("Abrir");
		labelAbrir.setFont(new Font("Dialog", Font.BOLD, 16));
		labelAbrir.setBounds(55, 1, 91, 22);
		panelAbrir.add(labelAbrir);

		panelGuardar = new JPanel();
		panelGuardar.setLayout(null);
		panelGuardar.setBackground(Color.WHITE);
		panelGuardar.setBounds(1, 52, 218, 25);
		panelGuardar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelGuardar.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelGuardar.setBackground(SystemColor.white);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(diagrama != null){

					try {		
						guardarDiagrama();
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					repaint();
					revalidate();
				}
			}
		});
		panelArchivoDesp.add(panelGuardar);

		lblGuardar = new JLabel("Guardar");
		lblGuardar.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGuardar.setBounds(55, 1, 91, 22);
		panelGuardar.add(lblGuardar);
		panelHerramDesp.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelHerramDesp.setBackground(Color.WHITE);
		panelHerramDesp.setBounds(445, 101, 220, 78);
		panelContenedor.add(panelHerramDesp);
		panelHerramDesp.setLayout(null);

		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(0, 25, 220, 1);
		panelHerramDesp.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(0, 51, 220, 1);
		panelHerramDesp.add(separator_2);

		panelEstadísticas = new JPanel();
		panelEstadísticas.setBackground(Color.WHITE);
		panelEstadísticas.setBounds(1, 0, 218, 25);
		panelEstadísticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Estadisticas estadis = new Estadisticas(Principal.this);
				estadis.setVisible(true);
				setEnabled(false);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelEstadísticas.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelEstadísticas.setBackground(SystemColor.white);
			}
		});
		panelHerramDesp.add(panelEstadísticas);
		panelEstadísticas.setLayout(null);

		labelEstadis = new JLabel("Estad\u00EDsticas");
		labelEstadis.setFont(new Font("Dialog", Font.BOLD, 16));
		labelEstadis.setBounds(55, 1, 106, 22);
		panelEstadísticas.add(labelEstadis);

		panelChequear = new JPanel();
		panelChequear.setBackground(Color.WHITE);
		panelChequear.setBounds(1, 26, 218, 25);
		panelChequear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelChequear.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelChequear.setBackground(SystemColor.white);
			}
		});
		panelHerramDesp.add(panelChequear);
		panelChequear.setLayout(null);

		labelChequear = new JLabel("Chequear");
		labelChequear.setFont(new Font("Dialog", Font.BOLD, 16));
		labelChequear.setBounds(55, 1, 106, 22);
		panelChequear.add(labelChequear);

		panelZoom = new JPanel();
		panelZoom.setBackground(Color.WHITE);
		panelZoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panelHerramDesp.setVisible(false);
				pant = new PantallaCompleta(Principal.this);
				pant.setVisible(true);
				pant.getContentPane().add(scrollPane,BorderLayout.CENTER);
				setVisible(false);
				setEnabled(false);
				repaint();
				revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelZoom.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelZoom.setBackground(SystemColor.white);
			}
		});
		panelZoom.setBounds(1, 52, 218, 25);
		panelHerramDesp.add(panelZoom);
		panelZoom.setLayout(null);

		labelZoom = new JLabel("Zoom Diagrama");
		labelZoom.setFont(new Font("Dialog", Font.BOLD, 16));
		labelZoom.setBounds(55, 1, 130, 22);
		panelZoom.add(labelZoom);

		panelLateral = new JPanel();
		panelLateral.setBackground(new Color(0,58,87));
		panelLateral.setBounds(0, 50, 227, 650);
		panelLateral.setBorder(null);
		panelContenedor.add(panelLateral);
		panelLateral.setLayout(null);

		subpanel1 = new JPanel();
		subpanel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(lblAddClase.isEnabled()){
					panelHerramDesp.setVisible(false);
					desplegadoHerram = false;
					panelArchivoDesp.setVisible(false);
					desplegadoArchivo = false;
					menuLienzo.getMntmCancelar().setVisible(false);
					menuLienzo.getMntmEstablecerRelacin().setVisible(true);
					lienzo.cancelarHerencia();
					lienzo.repaint();
					lienzo.revalidate();


					AgregarClase frame = new AgregarClase(Principal.this);
					frame.setVisible(true);
					setEnabled(false);
					inMovilizarClases();
					isEliminar = false;
					isEditar = false;
					isHerencia = false;
					isHerenciaClase1 = false;
					isHerenciaClase2 = false;
					lienzo.cancelarHerencia();
					lienzo.repaint();
					lienzo.revalidate();
				}



			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(lblAddClase.isEnabled())
					subpanel1.setBackground(new Color(0, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(lblAddClase.isEnabled())
					subpanel1.setBackground(new Color(0,58,87));
			}
		});
		subpanel1.setBounds(0, 0, 227, 160);
		subpanel1.setBackground(new Color(0,58,87));
		panelLateral.add(subpanel1);
		subpanel1.setLayout(null);

		lblAddClaseImg = new JLabel("");
		lblAddClaseImg.setEnabled(false);
		lblAddClaseImg.setBounds(34, 0, 142, 121);

		subpanel1.add(lblAddClaseImg);
		lblAddClaseImg.setIcon(new ImageIcon(Principal.class.getResource("/images/card_add.png")));

		lblAddClase = new JLabel("Agregar Clase");
		lblAddClase.setEnabled(false);
		lblAddClase.setBounds(44, 120, 137, 39);

		subpanel1.add(lblAddClase);
		lblAddClase.setForeground(Color.WHITE);
		lblAddClase.setFont(new Font("Dialog", Font.BOLD, 19));

		separator1 = new JSeparator();
		separator1.setBounds(0, 160, 227, 9);
		panelLateral.add(separator1);

		subpanel2 = new JPanel();
		subpanel2.setBounds(0, 162, 227, 170);
		subpanel2.setBackground(new Color(0,58,87));
		panelLateral.add(subpanel2);
		subpanel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lblAddRelacion.isEnabled()){
					isRelacionesPressed = true;
					isEliminarPressed = false;
					isEditarPressed = false;
					panelHerramDesp.setVisible(false);
					desplegadoHerram = false;
					panelArchivoDesp.setVisible(false);
					desplegadoArchivo = false;
					if(!isHerencia && lienzo.getComponentCount()>1){
						SeleccionClaseA sele = new SeleccionClaseA(Principal.this);
						sele.setVisible(true);
						setEnabled(false);
						isHerencia = true;
						isEditar = false;
						isInsertar = false;
						isEliminar = false;
						menuLienzo.getMntmCancelar().setVisible(true);
						menuLienzo.getMntmEstablecerRelacin().setVisible(false);

					}
					else if (isHerencia){
						isHerencia = false;
						isHerenciaClase1 = false;
						isHerenciaClase2 = false;
						menuLienzo.getMntmCancelar().setVisible(false);
						menuLienzo.getMntmEstablecerRelacin().setVisible(true);
						lienzo.cancelarHerencia();
						lienzo.repaint();
						lienzo.revalidate();
					}
					else if (lienzo.getComponentCount()<2){
						AlmenosDos dos = new AlmenosDos(Principal.this);
						dos.setVisible(true);
						setEnabled(false);
					}
				}

				//MensajeError2 frame = new MensajeError2(Principal.this);
				//frame.setVisible(true);
				//setEnabled(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(lblAddRelacion.isEnabled())
					subpanel2.setBackground(new Color(0, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(lblAddRelacion.isEnabled())
					subpanel2.setBackground(new Color(0,58,87));
			}
		});
		subpanel2.setLayout(null);

		lblAddRelacionImg = new JLabel("");
		lblAddRelacionImg.setEnabled(false);
		lblAddRelacionImg.setBounds(38, 7, 142, 121);

		subpanel2.add(lblAddRelacionImg);
		lblAddRelacionImg.setIcon(new ImageIcon(Principal.class.getResource("/images/card_tap_down.png")));

		lblAddRelacion = new JLabel("Establecer Relación");
		lblAddRelacion.setEnabled(false);
		lblAddRelacion.setBounds(21, 125, 196, 39);

		subpanel2.add(lblAddRelacion);
		lblAddRelacion.setForeground(Color.WHITE);
		lblAddRelacion.setFont(new Font("Dialog", Font.BOLD, 19));

		separator2 = new JSeparator();
		separator2.setBounds(0, 332, 227, 9);
		panelLateral.add(separator2);

		subpanel3 = new JPanel();
		subpanel3.setBackground(new Color(0,58,87));
		subpanel3.setBounds(0, 334, 227, 156);
		subpanel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(lblEditarClase.isEnabled()){
					isRelacionesPressed = false;
					isEliminarPressed = false;
					isEditarPressed = true;
					panelHerramDesp.setVisible(false);
					desplegadoHerram = false;
					panelArchivoDesp.setVisible(false);
					desplegadoArchivo = false;
					if(!isEditar && lienzo.getComponentCount() !=0){
						SeleccionClaseA sele = new SeleccionClaseA(Principal.this);
						sele.setVisible(true);
						setEnabled(false);
						isEditar = true;
						isEliminar = false;
						isInsertar = false;
						isHerencia = false;
						isHerenciaClase1 = false;
						isHerenciaClase2 = false;
						menuLienzo.getMntmCancelar().setVisible(false);
						menuLienzo.getMntmEstablecerRelacin().setVisible(true);
						lienzo.cancelarHerencia();
						lienzo.repaint();
						lienzo.revalidate();
					}
					else if (isEditar){

						isEditar = false;
					}
					else {
						AlmenosUna una = new AlmenosUna(Principal.this);
						una.setVisible(true);
						setEnabled(false);
					}
				}

				/*MensajeError1 frame = new MensajeError1(Principal.this);
				frame.setVisible(true);
				setEnabled(false);*/



			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(lblEditarClase.isEnabled())
					subpanel3.setBackground(new Color(0, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(lblEditarClase.isEnabled())
					subpanel3.setBackground(new Color(0,58,87));
			}
		});
		panelLateral.add(subpanel3);
		subpanel2.setLayout(null);

		lblEditarClase = new JLabel("   Editar Clase");
		lblEditarClase.setEnabled(false);
		lblEditarClase.setBounds(41, 123, 137, 25);
		subpanel3.setLayout(null);
		subpanel3.add(lblEditarClase);
		lblEditarClase.setForeground(Color.WHITE);
		lblEditarClase.setFont(new Font("Dialog", Font.BOLD, 19));

		lblEditarClaseImg = new JLabel("");
		lblEditarClaseImg.setEnabled(false);
		lblEditarClaseImg.setBounds(50, 5, 128, 117);
		subpanel3.add(lblEditarClaseImg);
		lblEditarClaseImg.setIcon(new ImageIcon(Principal.class.getResource("/images/notepad.png")));

		separator3 = new JSeparator();
		separator3.setBounds(0, 490, 227, 9);
		panelLateral.add(separator3);



		subpanel4 = new JPanel();
		subpanel4.setBounds(0, 492, 227, 159);
		subpanel4.setBackground(new Color(0,58,87));
		subpanel4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(lblEliminarClase.isEnabled()){
					isRelacionesPressed = false;
					isEliminarPressed = true;
					isEditarPressed = false;
					panelHerramDesp.setVisible(false);
					desplegadoHerram = false;
					panelArchivoDesp.setVisible(false);
					desplegadoArchivo = false;
					if(!isEliminar && lienzo.getComponentCount()!=0){
						SeleccionClaseA sele = new SeleccionClaseA(Principal.this);
						sele.setVisible(true);
						setEnabled(false);
						isEliminar=true;
						isInsertar=false;
						isEditar = false;
						isHerencia = false;
						isHerenciaClase1 = false;
						isHerenciaClase2 = false;
						menuLienzo.getMntmCancelar().setVisible(false);
						menuLienzo.getMntmEstablecerRelacin().setVisible(true);
						lienzo.cancelarHerencia();
						lienzo.repaint();
						lienzo.revalidate();

					}
					else if (isEliminar){

						isEliminar = false;
					}
					else {
						AlmenosUna una = new AlmenosUna(Principal.this);
						una.setVisible(true);
						setEnabled(false);
					}
				}

			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(lblEliminarClase.isEnabled())
					subpanel4.setBackground(new Color(0, 204, 204));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(lblEliminarClase.isEnabled())
					subpanel4.setBackground(new Color(0,58,87));
			}
		});
		panelLateral.add(subpanel4);
		subpanel4.setLayout(null);

		lblEliminarClaseImg = new JLabel("");
		lblEliminarClaseImg.setEnabled(false);
		lblEliminarClaseImg.setBounds(40, 4, 142, 121);
		subpanel4.add(lblEliminarClaseImg);
		lblEliminarClaseImg.setIcon(new ImageIcon(Principal.class.getResource("/images/card_remove.png")));

		lblEliminarClase = new JLabel("Eliminar Clase");
		lblEliminarClase.setEnabled(false);
		lblEliminarClase.setBounds(48, 118, 158, 39);
		subpanel4.add(lblEliminarClase);
		lblEliminarClase.setForeground(Color.WHITE);
		lblEliminarClase.setFont(new Font("Dialog", Font.BOLD, 19));

		panelSuperior = new JPanel();
		panelSuperior.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x= e.getXOnScreen();
				int y= e.getYOnScreen();

				setLocation(x - mouseX , y - mouseY );

			}
		});
		panelSuperior.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panelHerramDesp.setVisible(false);
				desplegadoHerram = false;
				panelArchivoDesp.setVisible(false);
				desplegadoArchivo = false;

				mouseX= e.getX();
				mouseY= e.getY();
			}
		});
		panelSuperior.setBackground(new Color(47, 79, 79));
		panelSuperior.setBorder(null);
		panelSuperior.setBounds(0, 0, 1100, 50);
		panelContenedor.add(panelSuperior);
		panelSuperior.setLayout(null);

		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 48, 1100, 2);
		panelSuperior.add(separator);

		panelSalir = new JPanel();
		panelSalir.setBounds(1050, 0, 50, 48);
		panelSuperior.add(panelSalir);
		panelSalir.setBackground(new Color(47, 79, 79));
		panelSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelHerramDesp.setVisible(false);
				desplegadoHerram = false;
				panelArchivoDesp.setVisible(false);
				desplegadoArchivo = false;
				if(ManejoDirectorios.comprobarEstadoDeGuardado(diagrama)){	
				ConfirmarSalida frame = new ConfirmarSalida(Principal.this);
				frame.setVisible(true);
				setEnabled(false);
				}
				else{
					FrameDecisor decisor = new FrameDecisor(Principal.this, null);
					decisor.setVisible(true);
					setEnabled(false);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelSalir.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelSalir.setBackground(new Color(47, 79, 79));
			}
		});
		panelSalir.setLayout(null);

		lblSalir = new JLabel();
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setBounds(0, 0, 50, 48);
		panelSalir.add(lblSalir);
		lblSalir.setIcon(new ImageIcon(Principal.class.getResource("/images/cross.png")));

		panelMenu = new JPanel();
		panelMenu.setBorder(null);
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(227, 50, 874, 50);
		panelContenedor.add(panelMenu);
		panelMenu.setLayout(null);

		panelArchivo = new JPanel();
		panelArchivo.setBackground(Color.WHITE);
		panelArchivo.setBounds(0, 0, 217, 50);
		panelMenu.add(panelArchivo);
		panelArchivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(desplegadoArchivo){
					panelArchivoDesp.setVisible(false);
					desplegadoArchivo = false;
				}
				else{
					isHerencia = false;
					isEditar = false;
					isEliminar = false;
					isRelacionesPressed = false;
					isEditarPressed = false;
					isEliminarPressed = false;
					isHerenciaClase1 = false;
					isHerenciaClase2 = false;
					menuLienzo.getMntmCancelar().setVisible(false);
					menuLienzo.getMntmEstablecerRelacin().setVisible(true);
					if(lienzo != null){
						lienzo.cancelarHerencia();
						lienzo.repaint();
						lienzo.revalidate();
					}
					panelArchivoDesp.setVisible(true);
					panelHerramDesp.setVisible(false);
					desplegadoArchivo = true;
					desplegadoHerram = false;
				}


			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelArchivo.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelArchivo.setBackground(SystemColor.white);
			}
		});
		panelArchivo.setLayout(null);

		lblArchivo = new JLabel("Archivo");
		lblArchivo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblArchivo.setBounds(63, 11, 126, 28);
		panelArchivo.add(lblArchivo);

		labelArchivoImg = new JLabel("");
		labelArchivoImg.setBounds(5, 0, 50, 50);
		panelArchivo.add(labelArchivoImg);
		labelArchivoImg.setIcon(new ImageIcon(Principal.class.getResource("/images/home.png")));

		separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(0, 48, 217, 2);
		panelArchivo.add(separator_6);

		panelHerram = new JPanel();
		panelHerram.setLayout(null);
		panelHerram.setBackground(Color.WHITE);
		panelHerram.setBounds(219, 0, 217, 50);
		panelHerram.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent arg0) {
				if(lblHerramientas.isEnabled()){
					if(desplegadoHerram){
						panelHerramDesp.setVisible(false);
						desplegadoHerram = false;
					}
					else{
						isHerencia = false;
						isEditar = false;
						isEliminar = false;
						isRelacionesPressed = false;
						isEditarPressed = false;
						isEliminarPressed = false;
						isHerenciaClase1 = false;
						isHerenciaClase2 = false;
						menuLienzo.getMntmCancelar().setVisible(false);
						menuLienzo.getMntmEstablecerRelacin().setVisible(true);
						if(lienzo != null){
							lienzo.cancelarHerencia();
							lienzo.repaint();
							lienzo.revalidate();
						}
						panelHerramDesp.setVisible(true);
						panelArchivoDesp.setVisible(false);
						desplegadoHerram = true;
						desplegadoArchivo = false;
					}
				}


			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(lblHerramientas.isEnabled())
					panelHerram.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				if(lblHerramientas.isEnabled())
					panelHerram.setBackground(SystemColor.white);
			}
		});
		panelMenu.add(panelHerram);

		lblHerramientas = new JLabel("Herramientas");
		lblHerramientas.setEnabled(false);
		lblHerramientas.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHerramientas.setBounds(63, 11, 126, 28);
		panelHerram.add(lblHerramientas);

		lblHerramientasImg = new JLabel("");
		lblHerramientasImg.setEnabled(false);
		lblHerramientasImg.setIcon(new ImageIcon(Principal.class.getResource("/images/wrench.png")));
		lblHerramientasImg.setBounds(5, 0, 50, 50);
		panelHerram.add(lblHerramientasImg);

		separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBounds(0, 48, 217, 2);
		panelHerram.add(separator_7);

		panelAyuda = new JPanel();
		panelAyuda.setLayout(null);
		panelAyuda.setBackground(Color.WHITE);
		panelAyuda.setBounds(438, 0, 217, 50);
		panelAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				isHerencia = false;
				isEditar = false;
				isEliminar = false;
				isRelacionesPressed = false;
				isEditarPressed = false;
				isEliminarPressed = false;
				isHerenciaClase1 = false;
				isHerenciaClase2 = false;
				menuLienzo.getMntmCancelar().setVisible(false);
				menuLienzo.getMntmEstablecerRelacin().setVisible(true);
				if(lienzo != null){
					lienzo.cancelarHerencia();
					lienzo.repaint();
					lienzo.revalidate();
				}
				panelHerramDesp.setVisible(false);
				desplegadoHerram = false;
				panelArchivoDesp.setVisible(false);
				desplegadoArchivo = false;
				Ayuda ayu = new Ayuda(Principal.this);
				setEnabled(false);
				ayu.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelAyuda.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelAyuda.setBackground(SystemColor.white);
			}
		});
		panelMenu.add(panelAyuda);

		labelAyuda = new JLabel("Ayuda");
		labelAyuda.setFont(new Font("Dialog", Font.BOLD, 16));
		labelAyuda.setBounds(63, 11, 126, 28);
		panelAyuda.add(labelAyuda);

		labelAyudaImg = new JLabel("");
		labelAyudaImg.setIcon(new ImageIcon(Principal.class.getResource("/images/question.png")));
		labelAyudaImg.setBounds(5, 0, 50, 50);
		panelAyuda.add(labelAyudaImg);

		separator_8 = new JSeparator();
		separator_8.setBackground(Color.BLACK);
		separator_8.setForeground(Color.BLACK);
		separator_8.setBounds(0, 48, 217, 2);
		panelAyuda.add(separator_8);

		panelAcerca = new JPanel();
		panelAcerca.setLayout(null);
		panelAcerca.setBackground(Color.WHITE);
		panelAcerca.setBounds(657, 0, 216, 50);
		panelAcerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				isHerencia = false;
				isEditar = false;
				isEliminar = false;
				isRelacionesPressed = false;
				isEditarPressed = false;
				isEliminarPressed = false;
				isHerenciaClase1 = false;
				isHerenciaClase2 = false;
				menuLienzo.getMntmCancelar().setVisible(false);
				menuLienzo.getMntmEstablecerRelacin().setVisible(true);
				if(lienzo != null){
					lienzo.cancelarHerencia();
					lienzo.repaint();
					lienzo.revalidate();
				}
				panelHerramDesp.setVisible(false);
				desplegadoHerram = false;
				panelArchivoDesp.setVisible(false);
				desplegadoArchivo = false;
				AcercaDe a = new AcercaDe(Principal.this);
				setEnabled(false);
				a.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelAcerca.setBackground(new Color(201,218,255));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelAcerca.setBackground(SystemColor.white);
			}
		});
		panelMenu.add(panelAcerca);

		labelAcerca = new JLabel("Acerca de");
		labelAcerca.setFont(new Font("Dialog", Font.BOLD, 16));
		labelAcerca.setBounds(63, 11, 126, 28);
		panelAcerca.add(labelAcerca);

		labelAcercaImg = new JLabel("");
		labelAcercaImg.setIcon(new ImageIcon(Principal.class.getResource("/images/information.png")));
		labelAcercaImg.setBounds(5, 0, 50, 50);
		panelAcerca.add(labelAcercaImg);

		separator_9 = new JSeparator();
		separator_9.setBackground(Color.BLACK);
		separator_9.setForeground(Color.BLACK);
		separator_9.setBounds(-1, 48, 215, 2);
		panelAcerca.add(separator_9);

		separator4 = new JSeparator();
		separator4.setForeground(Color.BLACK);
		separator4.setOrientation(SwingConstants.VERTICAL);
		separator4.setBackground(Color.BLACK);
		separator4.setBounds(217, 0, 2, 50);
		panelMenu.add(separator4);

		separator_10 = new JSeparator();
		separator_10.setBounds(655, 0, 2, 50);
		panelMenu.add(separator_10);
		separator_10.setOrientation(SwingConstants.VERTICAL);
		separator_10.setForeground(Color.BLACK);
		separator_10.setBackground(Color.BLACK);

		separator5 = new JSeparator();
		separator5.setForeground(Color.BLACK);
		separator5.setOrientation(SwingConstants.VERTICAL);
		separator5.setBackground(Color.BLACK);
		separator5.setBounds(436, 0, 2, 50);
		panelMenu.add(separator5);

		menuLienzo = new  MenuContextualLienzo(Principal.this);

		separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(0, 0, 2000, 1);
		panelContenedor.add(separator_5);


		scrollPane.setViewportView(panelInicio);
		panelContenedor.add(scrollPane);




	}

	public void repintarClase(PanelClase p){
		p.setSize(p.getPreferredSize().width+50,p.getPreferredSize().height+50);
		p.setMidPoint();
		//lienzo.repaint();
		//lienzo.revalidate();
	}

	public void inMovilizarClases() {
		Component[] panelClase =  lienzo.getComponents();

		for(int i = 0; i < panelClase.length; i++) {
			if(panelClase[i] instanceof PanelClase)
				((PanelClase)panelClase[i]).setMover(false);
		}
	}



	public boolean isInsertar() {
		return isInsertar;
	}



	public void setInsertar(boolean isInsertar) {
		this.isInsertar = isInsertar;
	}



	public PanelClase getPanelClase() {
		return panelClase;
	}

	public int getMouseX() {
		return mouseX;
	}



	public boolean isEliminar() {
		return isEliminar;
	}

	public void setEliminar(boolean isEliminar) {
		this.isEliminar = isEliminar;
	}


	public boolean isHerencia() {
		return isHerencia;
	}



	public void setHerencia(boolean isHerencia) {
		this.isHerencia = isHerencia;
	}



	public MenuContextualLienzo getMenuLienzo() {
		return menuLienzo;
	}


	public int getMouseY() {
		return mouseY;
	}


	public JPanel getPanelContenedor() {
		return panelContenedor;
	}


	public void setPanelContenedor(JPanel panelContenedor) {
		this.panelContenedor = panelContenedor;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	public JPanel getPanelHerramDesp() {
		return panelHerramDesp;
	}


	public JPanel getPanelArchivoDesp() {
		return panelArchivoDesp;
	}


	public boolean isRelacionesPressed() {
		return isRelacionesPressed;
	}


	public void setRelacionesPressed(boolean isRelacionesPressed) {
		this.isRelacionesPressed = isRelacionesPressed;
	}


	public boolean isEditarPressed() {
		return isEditarPressed;
	}


	public void setEditarPressed(boolean isEditarPressed) {
		this.isEditarPressed = isEditarPressed;
	}


	public boolean isEliminarPressed() {
		return isEliminarPressed;
	}


	public void setEliminarPressed(boolean isEliminarPressed) {
		this.isEliminarPressed = isEliminarPressed;
	}

	public void accionesLienzo(){
		lienzo.setBackground(SystemColor.inactiveCaptionBorder);
		lienzo.setPreferredSize(new Dimension(2000,2000));
		lienzo.setLayout(null);
		lienzo.setComponentPopupMenu(menuLienzo);
		lienzo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				boolean x=true;
				panelHerramDesp.setVisible(false);
				desplegadoHerram = false;
				panelArchivoDesp.setVisible(false);
				desplegadoArchivo = false;
				if(isInsertar){
					panelClase = new PanelClase(Principal.this);

					if(radioBotonTipoClase.equals("Concreta")){
						try {
							diagrama.addClase(new Concreta(nombreClase, e.getX(), e.getY()));
						} catch (Exception e1) {
							x=false;
							ClasesMismoName mismoName = new ClasesMismoName(Principal.this);
							mismoName.setVisible(true);
							setEnabled(false);
						}
					}
					else if(radioBotonTipoClase.equals("Abstracta")){
						try {
							diagrama.addClase(new Abstracta(nombreClase, e.getX(), e.getY()));
						} catch (Exception e1) {
							x=false;
							ClasesMismoName mismoName = new ClasesMismoName(Principal.this);
							mismoName.setVisible(true);
							setEnabled(false);
						}
					}

					if(x){
						panelClase.setVisible(true);
						if(radioBotonTipoClase.equals("Abstracta"))
							panelClase.getLblNombreclase().setFont(new Font("Segoe Script", Font.PLAIN, 16));
						panelClase.setTextLblNombreclase(nombreClase);
						panelClase.setBounds(e.getX(), e.getY(), panelClase.getPreferredSize().width+50, panelClase.getPreferredSize().height+50);
						panelClase.setMidPoint();
						lienzo.add(panelClase);

						lienzo.repaint();
						lienzo.revalidate();	
						panelClase.repaint();
						panelClase.revalidate();
					}
					lienzo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					isInsertar = false;
				}

			}
		});
		lienzo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(isInsertar)
					lienzo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				else if(isEliminar && lienzo.getComponentCount()!=0)
					lienzo.setCursor(new Cursor(Cursor.WAIT_CURSOR));
				else if(isHerencia){
					lienzo.setCursor(new Cursor(Cursor.TEXT_CURSOR));
					if(isHerenciaClase1){
						lienzo.addFlechaTemporal(flechaInicio, new Point(e.getX(),e.getY()));
					}

					lienzo.repaint();
					lienzo.revalidate();

				}
				else if(isEditar)
					lienzo.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
				else 
					lienzo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});
	}

	public void actualizarAccionesLienzo(){
		accionesLienzo();

		for (int i = 0; i < lienzo.getComponentCount(); i++) {
			if(lienzo.getComponent(i) instanceof PanelClase){
				((PanelClase)lienzo.getComponent(i)).accionesPanelClase();
				((PanelClase)lienzo.getComponent(i)).setPe(Principal.this);
			}

		}
	}

	public void habilitarPrograma(){
		lblAddClaseImg.setEnabled(true);
		lblAddClase.setEnabled(true);
		lblAddRelacion.setEnabled(true);
		lblAddRelacionImg.setEnabled(true);
		lblEditarClaseImg.setEnabled(true);
		lblEditarClase.setEnabled(true);
		lblEliminarClaseImg.setEnabled(true);
		lblEliminarClase.setEnabled(true);
		lblHerramientas.setEnabled(true);
		lblHerramientasImg.setEnabled(true);
	}

	public void guardarDiagrama() throws FileNotFoundException, IOException{
		ManejoDirectorios.guardarArchivo(diagrama);
	}
}
