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
public interface IUser<U> {
        void  insert(U u);

    void update(U u);

    void delete(Integer u);

    List<U> displayAll();

    U findById(int id);
}
