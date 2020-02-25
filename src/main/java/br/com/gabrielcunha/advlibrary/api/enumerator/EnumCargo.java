package br.com.gabrielcunha.advlibrary.api.enumerator;

import java.lang.reflect.Field;

import br.com.gabrielcunha.util.log.UtilLog;

public enum EnumCargo {
	

	FUNCIONARIO("Funcion�rio"),
	
	PESQUISA_FALHOU("ERROR");
	
	private String codigo;
	
	private EnumCargo(String codigo) {
		this.codigo = codigo;

		try {
			Field field = this.getClass().getSuperclass().getDeclaredField("name");
			field.setAccessible(true);
			field.set(this, codigo);
		} catch (Exception e) {
			UtilLog.getLog().error(e.getMessage(), e);
		}
	}

	public String getCodigo() {
		return codigo;
	}

}
