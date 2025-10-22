package br.com.fiap.checkpoint5.repository;

import br.com.fiap.checkpoint5.model.Consulta;
import br.com.fiap.checkpoint5.model.StatusConsulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByStatusConsultaAndDataConsultaBetween(StatusConsulta status, LocalDateTime dataDe, LocalDateTime dataAte);

    List<Consulta> findByPacienteIdAndStatusConsultaAndDataConsultaBetween(
        Long pacienteId,
        StatusConsulta status,
        LocalDateTime dataDe,
        LocalDateTime dataAte
    );

    List<Consulta> findByProfissionalIdAndStatusConsultaAndDataConsultaBetween(
        Long profissionalId,
        StatusConsulta status,
        LocalDateTime dataDe,
        LocalDateTime dataAte
    );
    
    List<Consulta> findByStatusConsulta(StatusConsulta status);
    List<Consulta> findByDataConsultaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);


    List<Consulta> findByPacienteId(Long pacienteId);

    List<Consulta> findByProfissionalId(Long profissionalId);

    List<Consulta> findByProfissionalIdAndStatusConsultaAndDataConsultaBetween(
    Long profissionalId,
    String status,
    LocalDateTime dataInicio,
    LocalDateTime dataFim
);

}
