package cl.api.youtube.demo.Services;

import cl.api.youtube.demo.models.Autos;
import cl.api.youtube.demo.repositories.IAutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutosService {
    private IAutosRepository autoRepo;
    @Autowired

    public AutosService(IAutosRepository autoRepo){
        this.autoRepo = autoRepo;
    }

    // Metodo para crear autos
    public void crearAuto(Autos autos) {
        autoRepo.save(autos);
    }

    //metodo para listar todos los autos en nuestra bd

    public List<Autos> listarAutos() {
        return autoRepo.findAll();
    }
    //metodo para buscar un auto por id especifico
    public Optional<Autos> buscarPorId(Long id){
    return autoRepo.findById(id);
    }

    //metodo para actualizar un auto

    public void actualizarAuto(Autos auto){
        autoRepo.save(auto);
    }

    //metodo para eliminar un auto
    public void eliminarAutoPorId(Long id) {
        autoRepo.deleteById(id);
    }

    //Metodo para buscar segun atributos propios de la clase

  public   List<Autos> buscarPorMarca(String marca){
        return autoRepo.findByMarca(marca);
    }

    public List<Autos> buscarPorModelo(String modelo){
        return autoRepo.findByModelo(modelo);
    }

  public List<Autos> buscarPorColor(String color){
        return autoRepo.findByColor(color);
    }

   public List<Autos> buscarPorAnio(Long anio){
        return autoRepo.findByAnio(anio);
    }
}
