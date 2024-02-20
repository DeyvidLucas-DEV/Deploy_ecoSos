package br.com.dbc.vemser.ecososapi.ecosos.entity;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoOcorrencia;
import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Entity(name= "OCORRENCIA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Ocorrencia {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OCORRENCIA")
  @SequenceGenerator(name = "SEQ_OCORRENCIA", sequenceName = "seq_ocorrencia", allocationSize = 1)
  @Column(name = "id_ocorrencia")
  private Integer idOcorrencia;

  @Column(name = "id_endereco", insertable = false, updatable = false)
  private Integer idEndereco;

  @Column(name = "id_usuario", insertable = false, updatable = false)
  private Integer idUsuario;

  @Column(name = "nome")
  private String nome;

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "gravidade")
  private TipoRisco gravidade;

  @Column(name = "descricao")
  private String descricao;

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "tipo")
  private TipoOcorrencia tipo;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
  private Usuario usuario;

  @OneToMany(mappedBy = "ocorrencia", cascade = CascadeType.ALL)
  private Set<Comentario> comentarios;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", nullable = false)
  private Endereco endereco;

  @Column(name = "status")
  private Character status;

  @Column(name = "criado_em")
  private Timestamp criadoEm;

  @Column(name = "atualizado_em")
  private Timestamp atualizadoEm;
}
