package br.dev.jc.challenge.repository;

import br.dev.jc.challenge.model.BDChangerListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BDChangerListenerRepository extends JpaRepository<BDChangerListener, Integer> {

    List<BDChangerListener> findByProcessed(boolean processed);

    List<BDChangerListener> findByProcessedFalse();




}
