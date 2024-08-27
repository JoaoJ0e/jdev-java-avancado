package jv.triersistemas.primeiro_projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarefaDto {		
		private Long id;
		private String titulo;
		private String descricao;
		private boolean isCompleta;
}
