package les.ifoot.model.enums;

public enum DiadaSemana {
	SEGUNDA(0, "Segunda-feira"),
	TERÇA(1, "Terça-feira"),
	QUARTA(2, "Quarta-feira"),
	QUINTA(3, "Quinta-feira"),
	SEXTA(4, "Sexta-feira"),
	SÁBADO(5, "Sábado"),
	DOMINGO(6, "Domingo");

	private int cod;
	private String descricao;

	private DiadaSemana(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static DiadaSemana toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (DiadaSemana x : DiadaSemana.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
