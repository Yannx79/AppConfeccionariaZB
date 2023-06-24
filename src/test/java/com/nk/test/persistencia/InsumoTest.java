
package com.nk.test.persistencia;

import com.nk.models.bo.InsumoBO;
import com.nk.models.dao.InsumoDAO;
import com.nk.models.dto.InsumoDTO;
import java.util.List;

public class InsumoTest {

    public static void main(String[] args) {
        
        InsumoBO insumoBO = new InsumoBO();
        InsumoDAO insumoDAO = new InsumoDAO();
        
        insumoBO.setInsumoDAO(insumoDAO);
        
        insumoBO.registrar(new InsumoDTO()); //base de datos
        InsumoDTO insumoDTO = insumoBO.buscar(10);
        System.out.println(insumoDTO.toString());
        List<InsumoDTO> listInsumo = insumoBO.listar();
        listInsumo.forEach(System.out::println);
        insumoBO.actualizar(new InsumoDTO());
        insumoBO.eliminar(1);
        
    }
    
}
