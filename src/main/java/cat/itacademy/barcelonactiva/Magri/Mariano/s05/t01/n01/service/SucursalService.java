package cat.itacademy.barcelonactiva.Magri.Mariano.s05.t01.n01.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cat.itacademy.barcelonactiva.Magri.Mariano.s05.t01.n01.repository.SucursalRepository;
import cat.itacademy.barcelonactiva.Magri.Mariano.s05.t01.n01.sucursal.Sucursal;

@Service

public class SucursalService {

    @Autowired
    SucursalRepository sucursalRespository;

    public List <Sucursal> getAllSucursales() {
        return sucursalRespository.findAll();
    }

    public void addSucursal (Sucursal sucursal) {
        sucursalRespository.save(sucursal);
    }

    public void deleteSucursal (int pk_SucursalID) {
        sucursalRespository.deleteById(pk_SucursalID);;
    }

    public Sucursal getSucursalById (int pk_SucursalID) {
        return sucursalRespository.findById(pk_SucursalID).get();
    }

    public boolean existsByIdSucursal (int id){
        return sucursalRespository.existsById(id);
    }

    public Optional<Sucursal> getSucursal (int idTorre){
        return  sucursalRespository.findById(idTorre);
    }


}