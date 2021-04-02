/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author amado
 */
public interface IFormation<F> {
    
    void  insert(F f);

    void update(F f);

    void delete(Integer f);

    List<F> displayAll();

    F findById(int id);
}
