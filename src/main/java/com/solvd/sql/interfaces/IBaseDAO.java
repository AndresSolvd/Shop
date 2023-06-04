package com.solvd.sql.interfaces;

import java.util.List;

public interface IBaseDAO<Entity> {

    void saveEntity(Entity model);
    Entity getByID(int id);
    void updateEntity(Entity entity);
    void removeEntityById(Entity entity);
    List<Entity> getAll();

}
