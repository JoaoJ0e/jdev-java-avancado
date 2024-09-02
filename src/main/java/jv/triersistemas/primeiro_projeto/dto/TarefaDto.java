package jv.triersistemas.primeiro_projeto.dto;

import java.time.LocalDate;

import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
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
		private Boolean completa;
		private Long categoriaId;
		private LocalDate dataCriacao;
		private LocalDate dataExpiracao;
		
		public TarefaDto(TarefaEntity entity) {
			this.id = entity.getId();
			this.titulo = entity.getTitulo();
			this.descricao = entity.getDescricao();
			this.completa= entity.getCompleta();
			this.categoriaId = entity.getCategoria().getId();
			this.dataCriacao = entity.getDataCriacao();
			this.dataExpiracao = entity.getDataExpiracao();
		}
}
