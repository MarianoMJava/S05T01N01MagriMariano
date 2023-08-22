package cat.itacademy.barcelonactiva.Magri.Mariano.s05.t01.n01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.Magri.Mariano.s05.t01.n01.sucursal.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

}
