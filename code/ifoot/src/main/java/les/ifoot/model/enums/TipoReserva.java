package les.ifoot.model.enums;

public enum TipoReserva {
	SEMANA(0, "Semana"),
	MES(1, "Mês"),
	ANO(2, "Ano");

	private int cod;
	private String descricao;

	private TipoReserva(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoReserva toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoReserva x : TipoReserva.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
