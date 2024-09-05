/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportes;

import java.util.List;

/**
 *
 * @author zibas
 */
public class ReporteSimplificacion {

	private List<String> leyes;
	private String conjuntoSimplificado;

	public ReporteSimplificacion(List<String> leyes, String conjuntoSimplificado) {
		this.leyes = leyes;
		this.conjuntoSimplificado = conjuntoSimplificado;
	}

	public List<String> getLeyes() {
		return leyes;
	}

	public String getConjuntoSimplificado() {
		return conjuntoSimplificado;
	}
}
