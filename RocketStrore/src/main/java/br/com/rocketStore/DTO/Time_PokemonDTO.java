package br.com.rocketStore.DTO;

public class Time_PokemonDTO {
	
		private Long idTime;
	    private Long idProduto;
	    private Integer quantidade;    
	    
	    public Long getIdTime() {
			return idTime;
		}
		public void setIdTime(Long idTime) {
			this.idTime = idTime;
		}
		public Long getIdProduto() {
	        return idProduto;
	    }
	    public void setIdProduto(Long idProduto) {
	        this.idProduto = idProduto;
	    }
	    public Integer getQuantidade() {
	        return quantidade;
	    }
	    public void setQuantidade(Integer quantidade) {
	        this.quantidade = quantidade;
	    }
	}


