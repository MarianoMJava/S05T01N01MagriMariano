package cat.itacademy.barcelonactiva.Magri.Mariano.s05.t01.n01.controllers;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cat.itacademy.barcelonactiva.Magri.Mariano.s05.t01.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.Magri.Mariano.s05.t01.n01.service.SucursalService;
import cat.itacademy.barcelonactiva.Magri.Mariano.s05.t01.n01.sucursal.Sucursal;
@Controller
public class SucursalController {

//	http://localhost:9000/sucursal/add
//
//	http://localhost:9000/sucursal/update
//
//	http://localhost:9000/sucursal/delete/{id}
//
//	http://localhost:9000/sucursal/getOne/{id}
//
//	http://localhost:9000/sucursal/getAll

    @Autowired
    private SucursalService sucursalService;

    @GetMapping({ "/sucursal/add" })
    public String mostrarFormularioDeAñadirSucursal(Model modelo) {
        Sucursal sucursal = new Sucursal();
        modelo.addAttribute("sucursal", sucursal);
        return "nuevo_sucursal";
    }

    @PostMapping({ "/sucursal/save" })
    public String saveSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
        sucursalService.addSucursal(sucursal);
        return "redirect:/sucursal/getAll";
    }

    @GetMapping({ "/sucursal/update/{id}" })
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        model.addAttribute("Sucursal", sucursalService.getSucursalById(id));
        return "update";

    }

    @PostMapping({ "/sucursal/{id}" })
    public String actualizarSucursal(@PathVariable int id, @ModelAttribute("sucursal") Sucursal sucursal, Model model) {
        Sucursal sucursalE = sucursalService.getSucursalById(id);
        sucursalE.setNomSucursal(sucursal.getNomSucursal());
        sucursalE.setPaisSucursal(sucursal.getPaisSucursal());
        sucursalService.addSucursal(sucursalE);
        return "redirect:/sucursal/getAll";

    }

    @GetMapping({ "/sucursal/delete/{id}" })
    public String deleteSucursal(@PathVariable int id) {
        sucursalService.deleteSucursal(id);
        return "redirect:/sucursal/getAll";
    }

    @GetMapping({ "/sucursal/getAll" })
    public String listarSucursales(Model modelo) {
        List<Sucursal> sucursales = sucursalService.getAllSucursales();

        List<SucursalDTO> sucursalesDTO = new ArrayList<SucursalDTO>();
        for (Sucursal sucursal : sucursales) {
            sucursalesDTO.add(new SucursalDTO(sucursal));
        }
        Collections.sort(sucursalesDTO, (x, y) -> x.getPk_SucursalID().compareTo(y.getPk_SucursalID()));
        modelo.addAttribute("listaSucursales", sucursalesDTO);
        return "index";
    }

    @GetMapping({ "/sucursal/getOne/{id}" })
    public String getSucursal(@PathVariable int id, Model model) {
        model.addAttribute("Sucursal", sucursalService.getSucursalById(id));
        return "view";
    }

}