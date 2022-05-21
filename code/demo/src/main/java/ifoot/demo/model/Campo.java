package ifoot.demo.model;

import java.util.Collection;

public class Campo extends ReservaGrupo {

	private Integer id;

	private String nomeCampo;

	private Float valorUnit;

	private Float valorMes;

	private Collection<Horario> campoHorario;

	private Espaco espaco;

}
