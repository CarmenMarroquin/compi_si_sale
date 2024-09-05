/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;

import analizadorCJ.*;
import analizadorCJ.graficas.DiagramaSet;
import com.google.gson.Gson;
import errores.Error_;
import interprete.expresiones.*;
import interprete.herramientas.Entorno;
import interprete.herramientas.Simbolo;
import interprete.herramientas.Tipo;
import interprete.lenguaje.Instruccion;
import interprete.sentencias.Opera;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import reportes.ReporteSimplificacion;

/**
 *
 * @author carme
 */
public class Interfaz extends javax.swing.JFrame {

	public static String nombre;
	public static String ruta;
	public ArrayList<Symbol> lista_tokens;
	public static String nombre_archivo;
	public Lexer analizadorLexico;

	/**
	 * Creates new form Interfaz
	 */
	public Interfaz() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        area_texto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        consola = new javax.swing.JTextArea();
        imagenPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrir_archivo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ejecutar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        area_texto.setColumns(20);
        area_texto.setRows(5);
        jScrollPane1.setViewportView(area_texto);

        consola.setColumns(20);
        consola.setRows(5);
        jScrollPane2.setViewportView(consola);

        imagenPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imagenPanel.setName("imagePanel"); // NOI18N
        imagenPanel.setOpaque(false);

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        abrir_archivo.setText("Abrir archivo");
        abrir_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir_archivoActionPerformed(evt);
            }
        });
        jMenu1.add(abrir_archivo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ejecutar");

        ejecutar.setText("Ejecuta");
        ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarActionPerformed(evt);
            }
        });
        jMenu2.add(ejecutar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Token");

        jMenuItem1.setText("Lista de token");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Errores");

        jMenuItem2.setText("Error Lexico");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setText("Error Sintactico");
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                    .addComponent(imagenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrir_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir_archivoActionPerformed
		// TODO add your handling code here:

		JFileChooser chooser = new JFileChooser();

		int option = chooser.showOpenDialog(null);

		if (option == JFileChooser.APPROVE_OPTION) {

			File archivo = chooser.getSelectedFile();

			this.ruta = archivo.getAbsolutePath();
			this.nombre = archivo.getName();

			try {
				BufferedReader lector = new BufferedReader(new FileReader(archivo));

				String contenido = "";

				String line;

				// Leer el contenido del archivo línea por línea
				while ((line = lector.readLine()) != null) {
					contenido += line + "\n";
				}

				// Cerrar el lector
				lector.close();

				// Imprimir el contenido del archivo
				System.out.println("Contenido del archivo:\n" + contenido);

				area_texto.setText(contenido);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Ningún archivo seleccionado");
		}

    }//GEN-LAST:event_abrir_archivoActionPerformed

    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed
		String texto = this.area_texto.getText();

		//lo mete en el analizador lexico
		Lexer analizadorLexico = new Lexer(new BufferedReader(new StringReader(texto)));
		// ArrayList <Symbol> tokens = new ArrayList<Symbol>();

		// tiene la lista de tokens
		this.lista_tokens = new ArrayList<Symbol>();
		Symbol simbolo = new Symbol(0);
		do {
			try {
				simbolo = analizadorLexico.next_token();
				this.lista_tokens.add(simbolo);

			} catch (IOException ex) {
				Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
			}

		} while (simbolo.value != null);

		//el analizador lexico se lo manda a el analizador sitactico
		analizadorLexico = new Lexer(new BufferedReader(new StringReader(texto)));

		//ejecuta el analizador
		Parser analizador_sintac = new Parser(analizadorLexico);
		try {
			analizador_sintac.parse();

		} catch (Exception ex) {
			System.out.println("Error al compilar");
			ex.printStackTrace();
		}

		// es para ver que entraba al boton
		System.out.println("se hizo clic en ejecutar" + texto);

		//ejecuta los analizadores si no tienen errores
		if (analizadorLexico.lex_errores.isEmpty()) {
			System.out.println("No se encontraron errores lexicos");
		} else {
			System.out.println("se encontraron errores lexicos");

		}

		// interpretar el archivo
		Entorno entorno = new Entorno();
		for (Instruccion instruccion : analizador_sintac.inst) {
			try {
				instruccion.ejecutar(entorno);
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		try {
			Simbolo temp = new Simbolo(0, 0, "PRINT", new Object(), entorno, Tipo.NATIVE);
			ArrayList<String> aImprimir = (ArrayList<String>) entorno.getSimbolo(temp).obj;
			this.consola.setText("RESULTADO");
			for (String linea : aImprimir) {
				this.consola.append("\n" + linea);
			}
		} catch (Exception e) {
		}

		int item = 1;
		Map<String, Object> reporte = new HashMap<>();
		// mostrar graficas guardar simplificacion
		this.imagenPanel.removeAll();
		this.imagenPanel.setLayout(new FlowLayout());
		for (Opera operacion : analizador_sintac.operaciones) {
			// Dibujar operaciones
			DiagramaSet diagrama = operacion.dibujar();
			BufferedImage imagen = diagrama.crearImagen(500, 500);

			ImageIcon icono = new ImageIcon(imagen);
			JLabel etiquetaImagen = new JLabel(icono);

			this.imagenPanel.add(etiquetaImagen);

			// Simplificar y guardar operaciones
			Expresion simplificado = operacion.simplificarExpresion();
			ReporteSimplificacion operacionExp = new ReporteSimplificacion(operacion.registro, simplificado.aNotacionPolaca());
			reporte.put(operacion.id, operacionExp);

			/*
			System.out.println("--------------------------------------------");
			System.out.println("Operacion Original: " + exp.aNotacionPolaca());
			Expresion simplificado = operacion.simplificarExpresion();
			System.out.println("Operacion Simplificada: " + simplificado.aNotacionPolaca());
			System.out.println("Pasos a seguir:");
			for (String paso : operacion.registro) {
				System.out.println(paso);
			}
			System.out.println("--------------------------------------------");
			 */

 /*
			  // this code was for saving the buffered image into a file
			  try{
				  String filepath = "/home/zibas/imagen.png";
				  diagrama.guardarImagen(imagen, filepath);
			  } catch(IOException e){
				  e.printStackTrace();
			  }
			 */
			item++;
		}

		this.imagenPanel.revalidate();
		this.imagenPanel.repaint();
		this.imagenPanel.updateUI();

		Gson gson = new Gson();
		String jsonReporte = gson.toJson(reporte);

		// Usar un JFileChooser para que el usuario elija la ubicación
		javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
		fileChooser.setDialogTitle("Guardar reporte de simplificación");
		int userSelection = fileChooser.showSaveDialog(null);

		if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
			java.io.File archivo = fileChooser.getSelectedFile();

			// Guardar el archivo
			try (FileWriter writer = new FileWriter(archivo)) {
				writer.write(jsonReporte);
				System.out.println("Reporte guardado en: " + archivo.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El usuario canceló la operación de guardado.");
		}

		// Hacer simplificacion
		// 1. hacer un bucle para las operacioens
		// 2. enviar la operacion a simplificar a una clase simplificadora
		// 3. el resultado de la clase debe ser un objeto json
		// 4. agregar el objeto json a un objeto json
		// 5. guardar el archivo json en alguna ruta
    }//GEN-LAST:event_ejecutarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
		// TODO add your handling code here:

		SwingUtilities.invokeLater(() -> {
			JFileChooser fileChooser = new JFileChooser();

			// Configura el tipo de archivo predeterminado
			fileChooser.setDialogTitle("Guardar Archivo HTML");
			fileChooser.setSelectedFile(new File("documento.html"));

			// Filtra para mostrar solo archivos con extensión .html
			fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
				@Override
				public boolean accept(File f) {
					return f.isDirectory() || f.getName().toLowerCase().endsWith(".html");
				}

				@Override
				public String getDescription() {
					return "Archivos HTML (*.html)";
				}
			});

			int userSelection = fileChooser.showSaveDialog(null);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();

				// Verifica si la extensión es .html, si no, agrégala
				if (!fileToSave.getAbsolutePath().endsWith(".html")) {
					fileToSave = new File(fileToSave.getAbsolutePath() + ".html");
				}

				try (FileWriter fileWriter = new FileWriter(fileToSave)) {
					// Escribe contenido de ejemplo en el archivo HTML
					String texto;
					texto = "<!DOCTYPE html>\n"
						+ "<html lang=\"es\">\n"
						+ "<head>\n"
						+ "    <meta charset=\"UTF-8\">\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
						+ "    <title>Tabla de Tokens</title>\n"
						+ "    <style>\n"
						+ "        table {\n"
						+ "            width: 50%;\n"
						+ "            border-collapse: collapse;\n"
						+ "            margin: 20px auto;\n"
						+ "            font-family: Arial, sans-serif;\n"
						+ "        }\n"
						+ "\n"
						+ "        th, td {\n"
						+ "            border: 1px solid #dddddd;\n"
						+ "            text-align: left;\n"
						+ "            padding: 8px;\n"
						+ "        }\n"
						+ "\n"
						+ "        th {\n"
						+ "            background-color: #f2f2f2;\n"
						+ "        }\n"
						+ "    </style>\n"
						+ "</head>\n"
						+ "<body>\n"
						+ "\n"
						+ "    <table>\n"
						+ "        <thead>\n"
						+ "            <tr>\n"
						+ "                <th>Número</th>\n"
						+ "                <th>Lexema</th>\n"
						+ "                <th>Tipo</th>\n"
						+ "                <th>Columna</th>\n"
						+ "                <th>Fila</th>\n"
						+ "            </tr>\n"
						+ "        </thead>\n"
						+ "        <tbody>";

					int contador = 0;
					for (Symbol token : lista_tokens) {
						contador++;
						texto += " <tr>\n"
							+ "                <td>" + contador + " </td>\n"
							+ "                <td>" + token + "</td>\n"
							+ "                <td>" + analizadorCJ.sym.terminalNames[token.sym] + "</td>\n"
							+ "                <td>" + token.left + "</td>\n"
							+ "                <td>" + token.right + "</td>\n"
							+ "            </tr>";
					}

					texto += "</tbody>\n"
						+ "    </table>\n"
						+ "\n"
						+ "</body>\n"
						+ "</html>";
					fileWriter.write(texto);
					JOptionPane.showMessageDialog(null, "Archivo guardado: " + fileToSave.getAbsolutePath());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
		// TODO add your handling code here:

		SwingUtilities.invokeLater(() -> {
			JFileChooser fileChooser = new JFileChooser();

			// Configura el tipo de archivo predeterminado
			fileChooser.setDialogTitle("Guardar Archivo HTML");
			fileChooser.setSelectedFile(new File("documento.html"));

			// Filtra para mostrar solo archivos con extensión .html
			fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
				@Override
				public boolean accept(File f) {
					return f.isDirectory() || f.getName().toLowerCase().endsWith(".html");
				}

				@Override
				public String getDescription() {
					return "Archivos HTML (*.html)";
				}
			});

			int userSelection = fileChooser.showSaveDialog(null);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();

				// Verifica si la extensión es .html, si no, agrégala
				if (!fileToSave.getAbsolutePath().endsWith(".html")) {
					fileToSave = new File(fileToSave.getAbsolutePath() + ".html");
				}

				try (FileWriter fileWriter = new FileWriter(fileToSave)) {
					// Escribe contenido de ejemplo en el archivo HTML
					String texto;
					texto = "<!DOCTYPE html>\n"
						+ "<html lang=\"es\">\n"
						+ "<head>\n"
						+ "    <meta charset=\"UTF-8\">\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
						+ "    <title>Tabla de Tokens</title>\n"
						+ "    <style>\n"
						+ "        table {\n"
						+ "            width: 50%;\n"
						+ "            border-collapse: collapse;\n"
						+ "            margin: 20px auto;\n"
						+ "            font-family: Arial, sans-serif;\n"
						+ "        }\n"
						+ "\n"
						+ "        th, td {\n"
						+ "            border: 1px solid #dddddd;\n"
						+ "            text-align: left;\n"
						+ "            padding: 8px;\n"
						+ "        }\n"
						+ "\n"
						+ "        th {\n"
						+ "            background-color: #f2f2f2;\n"
						+ "        }\n"
						+ "    </style>\n"
						+ "</head>\n"
						+ "<body>\n"
						+ "\n"
						+ "    <table>\n"
						+ "        <thead>\n"
						+ "            <tr>\n"
						+ "                <th>Número</th>\n"
						+ "                <th>Lexema</th>\n"
						+ "                <th>Tipo</th>\n"
						+ "                <th>Columna</th>\n"
						+ "                <th>Fila</th>\n"
						+ "            </tr>\n"
						+ "        </thead>\n"
						+ "        <tbody>";

					int contador = 0;
					for (Error_ error : analizadorLexico.lex_errores) {
						contador++;
						texto += " <tr>\n"
							+ "                <td>" + contador + " </td>\n"
							+ "                <td>" + error.getLexema() + "</td>\n"
							+ "                <td>" + error.getTipo() + "</td>\n"
							+ "                <td>" + error.getColumna() + "</td>\n"
							+ "                <td>" + error.getLinea() + "</td>\n"
							+ "            </tr>";
					}

					texto += "</tbody>\n"
						+ "    </table>\n"
						+ "\n"
						+ "</body>\n"
						+ "</html>";
					fileWriter.write(texto);
					JOptionPane.showMessageDialog(null, "Archivo guardado: " + fileToSave.getAbsolutePath());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
    }//GEN-LAST:event_jMenuItem2ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Interfaz().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir_archivo;
    private javax.swing.JTextArea area_texto;
    private javax.swing.JTextArea consola;
    private javax.swing.JMenuItem ejecutar;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
