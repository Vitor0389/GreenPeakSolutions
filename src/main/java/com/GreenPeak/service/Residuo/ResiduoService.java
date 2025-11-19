package com.GreenPeak.service.Residuo;


import com.GreenPeak.model.Residuo;
import com.GreenPeak.repository.ResiduoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResiduoService {

    private final ResiduoRepository repository;

    public ResiduoService(ResiduoRepository repository) {
        this.repository = repository;
    }

    public List<Residuo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Residuo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Residuo salvar(Residuo residuo) {
        return repository.save(residuo);
    }

    public Residuo atualizar(Long id, Residuo novosDados) {
        return repository.findById(id)
                .map(residuo -> {
                    residuo.setTipoResiduo(novosDados.getTipoResiduo());
                    residuo.setQuantidade(novosDados.getQuantidade());
                    residuo.setDataColeta(novosDados.getDataColeta());
                    return repository.save(residuo);
                })
                .orElseThrow(() -> new RuntimeException("Resíduo não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
