package les.ifoot.model.enums;

public enum TipoCampo {
	FUTSAL(0, "Futsal"),
	SOCIETY(1, "Society"),
	CAMPO(2, "Campo");

	private int cod;
	private String descricao;

	private TipoCampo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCampo toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoCampo x : TipoCampo.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
