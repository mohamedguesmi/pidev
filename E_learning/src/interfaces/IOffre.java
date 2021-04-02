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
public interface IOffre<O> {
    void  insert(O o);

    void update(O o);

    void delete(Integer o);

    List<O> displayAll();

    O findById(int id);
}